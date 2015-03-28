package controller.command;

public abstract class Command {
	private Object[] params;
	private boolean ready;
	
	public void setParameters(Object[] params){
		this.params = params;
		if (params.length > 0){
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
	
	public abstract void executeCommand(Object[] params);
	public abstract void undoCommand(Object[] params);
}
