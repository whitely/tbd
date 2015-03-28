package net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import controller.command.Command;

/**
 * This class is the server side. The server communicates with clients, 
 * sends and receives commands, and holds the chat log
 * 
 * @author Gabriel Kishi and Ben Whitely
 */
public class Server implements Handler {
	private ServerSocket socket; // the server socket
	
	private List<String> messages;	// the chat log
	private HashMap<String, ObjectOutputStream> outputs; // map of all connected users' output streams
	
	/**
	 *	This thread reads and executes commands sent by a client
	 */
	private class ClientHandler implements Runnable{
		private ObjectInputStream input; // the input stream from the client
		
		public ClientHandler(ObjectInputStream input){
			this.input = input;
		}
		
		public void run() {
			try{
				while(true){
					// read a command from the client, execute on the server
					Command command = (Command)input.readObject();
					System.out.println("Got command " + command);
					if (command instanceof Sendable)
						((Sendable) command).setHandler(Server.this);
					command.execute();
					
					// terminate if client is disconnecting
					if (command instanceof DisconnectCommand){
						input.close();
						return;
					}
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 *	This thread listens for and sets up connections to new clients
	 */
	private class ClientAccepter implements Runnable{
		public void run() {
			try{
				while(true){
					// accept a new client, get output & input streams
					Socket s = socket.accept();
					ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(s.getInputStream());
					
					// read the client's name
					String clientName = (String)input.readObject();
					
					// map client name to output stream
					outputs.put(clientName, output);
					
					// spawn a thread to handle communication with this client
					new Thread(new ClientHandler(input)).start();
					
					// add a notification message to the chat log
					addMessage(clientName + " connected");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public Server(){
		this.messages = new ArrayList<String>(); // create the chat log
		this.outputs = new HashMap<String, ObjectOutputStream>(); // setup the map
		
		try{
			// start a new server on port 9001
			socket = new ServerSocket(9001);
			System.out.println("Server started on port 9001");
			
			// spawn a client accepter thread
			new Thread(new ClientAccepter()).start();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds a message to the chat log. Called by an AddMessageCommand.
	 * 
	 * @param message	message to add
	 */
	public void addMessage(String message){
		messages.add(message);
		updateClients();
	}

	/**
	 * Writes an UpdateClientCommand to every connected user.
	 */
	public void updateClients() {
		// make an UpdateClientCommmand, write to all connected users
		UpdateClientCommand update = new UpdateClientCommand();
		update.setParameters(new Object[]{messages, "everyone", "who knows"});
		try{
			for (ObjectOutputStream out : outputs.values())
				out.writeObject(update);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new Server();
	}

	/**
	 * Disconnects a given user from the server gracefully
	 * @param clientName	user to disconnect
	 */
	public void disconnect(String clientName) {
		try{
			outputs.get(clientName).close(); // close output stream
			outputs.remove(clientName); // remove from map
			
			// add notification message
			addMessage(clientName + " disconnected");
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void addMessage(String msg, String sender, String recipient) {
		System.err.println("Server received message from " + sender + " sent to " + recipient + ". Message: " + msg);
		messages.add(msg);
	}
}
