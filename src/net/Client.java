package net;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import controller.command.Command;

/**
 * The client side. This class displays the current chat log and
 * sends AddMessageCommands to the server.
 * 
 * @author Gabriel Kishi and Ben Whitely
 */
public class Client implements Handler {
	public static String PORT = "9001";
	public static String HOST = "localhost";
	
	private String clientName; // user name of the client
		
	private Socket server; // connection to server
	private ObjectOutputStream out; // output stream
	private ObjectInputStream in; // input stream

	/**
	 * This class reads and executes commands sent from the server
	 * 
	 * @author Gabriel Kishi
	 *
	 */
	private class ServerHandler implements Runnable{
		public void run() {
			try{
				while(true){
					// read a command from server and execute it
					Command c = (Command)in.readObject();
					if (c instanceof Sendable)
						((Sendable) c).setHandler(Client.this);
					c.execute();
				}
			}
			catch(SocketException e){
				return; // "gracefully" terminate after disconnect
			}
			catch (EOFException e) {
				return; // "gracefully" terminate
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public Client(){
		// ask the user for a host, port, and user name
		String host = Client.HOST;
		String port = Client.PORT;
		clientName = JOptionPane.showInputDialog("User name:");
		
		if (host == null || port == null || clientName == null)
			return;
		
		try{
			// Open a connection to the server
			server = new Socket(host, Integer.parseInt(port));
			out = new ObjectOutputStream(server.getOutputStream());
			in = new ObjectInputStream(server.getInputStream());
			
			// write out the name of this client
			out.writeObject(clientName);
			
			// start a thread for handling server events
			new Thread(new ServerHandler()).start();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void sendCommand(Command c) {
		try {
			out.writeObject(c);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Client c = new Client();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			String s = scan.nextLine();
			if (s.equals(":q")) {
				DisconnectCommand dc = new DisconnectCommand();
				dc.setParameters(new Object[]{c.clientName});
				c.sendCommand(dc);
				break;
			} else {
				AddMessageCommand ac = new AddMessageCommand();
				ac.setParameters(new Object[]{s, c.clientName, "everyone"});
				c.sendCommand(ac);
			}
		}
		
		try {
			c.out.close();
			c.in.close();
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addMessage(String msg, String sender, String recipient) {
		System.err.println("Client received message from " + sender + " sent to " + recipient + ". Message: " + msg);
	}
}
