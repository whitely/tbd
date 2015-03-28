package world;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;

import units.Locatable;
import units.RectTerrain;
import units.Terrain;
import utils.ControllableMap;
import controller.Controllable;
import controller.command.Command;

public class World extends Observable {
	
	private static Stack<Command> commandHistory;
	private static Stack<Command> singleTurnCommandHistory;
	private int turnCounter;
	private static ArrayList<Terrain> terrain;
	
	public World() {
		terrain = new ArrayList<Terrain>();
		commandHistory = new Stack<Command>();
		singleTurnCommandHistory = new Stack<Command>();
		turnCounter = 0;
	}
	
	public static void doCommand(Command todo) {
		todo.execute();
		commandHistory.push(todo);
		singleTurnCommandHistory.push(todo);
		// iterate through all Locatables used
		// TODO
	}
	
	public void undoLastCommand() {
		commandHistory.pop().undo();
		singleTurnCommandHistory.pop().undo();
	}
	
	public void checkCollision(Locatable a, Locatable b) {
		// TODO
	}
	
	public void checkInside(Point a, Point b) {
		// TODO
	}
	
	public void goToNextTurn(){
		turnCounter++;
		singleTurnCommandHistory.clear();
		
	}
	
	public static ArrayList<Terrain> getTerrain(){
		return terrain;
	}
	
	public void addPerson(Controllable c) {
		ControllableMap.put(c);
		
		setChanged();
		notifyObservers();
	}
	
}
