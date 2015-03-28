package world;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;

import units.RectTerrain;
import utils.ControllableMap;
import controller.Controllable;
import controller.command.Command;

public class World extends Observable {
	
	private static Stack<Command> commandHistory;
	private static Stack<Command> singleTurnCommandHistory;
	private int turnCounter;
	private ArrayList<RectTerrain> terrain;
	
	public World() {
		terrain = new ArrayList<RectTerrain>();
		commandHistory = new Stack<Command>();
		singleTurnCommandHistory = new Stack<Command>();
		turnCounter = 0;
	}
	
	public static void doCommand(Command todo) {
		todo.execute();
		commandHistory.push(todo);
		singleTurnCommandHistory.push(todo);
	}
	
	public void undoLastCommand() {
		commandHistory.pop().undo();
		singleTurnCommandHistory.pop().undo();
	}
	
	public void goToNextTurn(){
		turnCounter++;
		singleTurnCommandHistory.clear();
		
	}
	
	public ArrayList<RectTerrain> getTerrain(){
		return terrain;
	}
	
	public void addPerson(Controllable c) {
		ControllableMap.put(c);
		
		setChanged();
		notifyObservers();
	}
	
}
