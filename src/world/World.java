package world;

import java.util.Stack;

import controller.command.Command;

public class World {
	
	private Stack<Command> commandHistory;
	
	public World() {
		commandHistory = new Stack<Command>();
	}
	
	public void doCommand(Command todo) {
		todo.execute();
		commandHistory.push(todo);
	}
	
	public void undoLastCommand() {
		
	}
	
}
