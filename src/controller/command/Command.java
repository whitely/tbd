package controller.command;

public abstract class Command {
	protected Object[] params;
	private boolean ready;
	
	public void setParameters(Object[] params){
		this.params = params;
		if (params.length > 0){
			ready = true;
		}
		isPossible();
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
