package world;

import java.util.Observable;
import java.util.Stack;

import utils.ControllableMap;
import controller.Controllable;
import controller.command.Command;

public class World extends Observable {
	
	private Stack<Command> commandHistory;
	
	public World() {
		commandHistory = new Stack<Command>();
	}
	
	public void doCommand(Command todo) {
		todo.execute();
		commandHistory.push(todo);
	}
	
	public void undoLastCommand() {
		commandHistory.pop().undo();
	}
	
	public void addPerson(Controllable c) {
		ControllableMap.put(c);
		
		setChanged();
		notifyObservers();
	}
	
}
