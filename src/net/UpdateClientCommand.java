package net;

import java.util.List;

import controller.command.Command;

public class UpdateClientCommand extends Command implements Sendable {
	private static final long serialVersionUID = 4222014184904080846L;
	private Handler h;
	
	@Override
	public boolean isPossible() {
		return true;
	}

	@Override
	protected void executeCommand(Object[] params) {
		Object o = params[0];
		List<String> messages = null;
		if (o instanceof List<?>)
			messages = (List<String>)o;
		
		for (String s : messages) {
			h.addMessage((String)s, (String)params[1], (String)params[2]);
		}
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
