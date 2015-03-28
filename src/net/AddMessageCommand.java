package net;

import controller.command.Command;

public class AddMessageCommand extends Command {
	public static final long serialVersionUID = 8394654307009158284L;
	private String message = ""; // message from client
	
	/**
	 * Creates an AddMessageCommand with the given message
	 * 
	 * @param message	message to add to log
	 */
	
	public void execute() {
		// add message to server's chat log
		
	}

	@Override
	public boolean isPossible() {
		return true;
	}

	@Override
	protected void executeCommand(Object[] params) {
		Object o = params[0];
		Object r = params[1];
		if (o instanceof String && r instanceof )
			message = (String)o;
		else
			throw new IllegalArgumentException("Params[0] to chat command must be a String, but was" + o);
		
		
	}

	@Override
	protected void undoCommand(Object[] params) {
		System.err.println("Attempted to undo a chat command.");
		
	}

}
