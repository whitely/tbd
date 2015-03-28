package net;

import controller.command.Command;

public class AddMessageCommand extends Command implements Sendable {
	public static final long serialVersionUID = 8394654307009158284L;
	private Handler h;
	
	@Override
	public boolean isPossible() {
		return true;
	}

	@Override
	protected void executeCommand(Object[] params) {
		Object o = params[0];
		Object s = params[1];
		Object r = params[2];
		if (o instanceof String && s instanceof String && r instanceof String)
			h.addMessage((String)o, (String)s, (String)r);
		else
			throw new IllegalArgumentException("Params[0] to chat command must be a String, but was" + o);
	}

	@Override
	protected void undoCommand(Object[] params) {
		System.err.println("Attempted to undo a chat command.");
		
	}

	@Override
	public void setHandler(Handler h) {
		this.h = h;
	}

}
