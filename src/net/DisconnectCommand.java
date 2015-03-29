package net;

import controller.command.Command;

public class DisconnectCommand extends Command implements Sendable {
	private static final long serialVersionUID = -8557424886231888586L;
	private Handler h;
	
	@Override
	public void setHandler(Handler h) {
		this.h = h;
	}

	@Override
	public boolean isPossible() {
		return true;
	}

	@Override
	protected void executeCommand(Object[] params) {
		if (params[0] instanceof String)
			((Server)h).disconnect((String)params[0]);
		throw new IllegalArgumentException("Didn't pass name as first arg to disconnect! Size: " + params.length + "; params[0]: " + params[0]);
	}

	@Override
	protected void undoCommand(Object[] params) {
		System.err.println("Tried to undo chat command!");
	}

}
