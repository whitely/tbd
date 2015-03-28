package controller.command;

import java.io.Serializable;

public abstract class Command implements Serializable {
	private static final long serialVersionUID = 1967575202274367770L;
	protected Object[] params;
	private boolean ready;
	
	public void setParameters(Object[] params){
		this.params = params;
		if (params.length > 0 && isPossible()){
			ready = true;
		}
		
	}
	
	public void execute(){
		if (ready){
			executeCommand(params);
		}
	}
	
	public void undo(){
		if (ready){
			undoCommand(params);
		}
	}
	
	public abstract boolean isPossible();
	
	protected abstract void executeCommand(Object[] params);
	protected abstract void undoCommand(Object[] params);
}
