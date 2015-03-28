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
	
	public abstract void execute();
	public abstract void undo();
}
