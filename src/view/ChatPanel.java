package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.AddMessageCommand;
import net.Client;


/**
 * This class encapsulates the chat components. It writes out commands to the server in response to user input
 * 
 * @author Gabriel Kishi and Ben Whitely
 *
 */
public class ChatPanel extends JPanel{
	private static final long serialVersionUID = 7686336736079994065L;
	
	private JTextArea textArea; // chat log displayed here
	private JTextField textField; // field where user enters text
	
	private String clientName;
	private Client client;
	
	private class EnterListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String s = textField.getText();
			client.sendChat(s);
		}
	}
	
	/**
	 * Constructs a new ChatPanel for given username, using the given OutputStream
	 * 
	 * @param clientName	user name of client
	 * @param output		output stream to server
	 */
	public ChatPanel(){
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		/* Setup the GUI */
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(400, 600));
		
		// create gui components
		textField = new JTextField();
		JButton enterButton = new JButton("Send");
		
		textField.setPreferredSize(new Dimension(320, 40));
		enterButton.setPreferredSize(new Dimension(80, 40));
		
		// add button and field to a lower panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(textField);
		bottomPanel.add(enterButton);
		
		// add text area and lower panel
		this.add(new JScrollPane(textArea), BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		// create a listener for writing messages to server
		ActionListener listener = new EnterListener();
		
		// attach listener to field & button
		textField.addActionListener(listener);
		enterButton.addActionListener(listener);
	}
	
	public void registerClient(String clientName, Client client) {
		this.clientName = clientName;
		this.client = client;
	}
	
	/**
	 * Updates the chat log. Called by UpdateClientCommands
	 * 
	 * @param messages	the current chat log
	 */
	public void append(String message, String sender) {
		/*String s = "";
		textArea.setText(s);
		*/
		textArea.append(sender + ": " + message);
		textArea.setCaretPosition(textArea.getText().length());
		repaint();
	}
}
