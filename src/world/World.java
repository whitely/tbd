package world;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;

import units.Locatable;
import units.Unit;
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
		//begin code for testing drawing panel
		terrain.add(new Terrain(new Point(2,2),5));
		commandHistory = new Stack<Command>();
		singleTurnCommandHistory = new Stack<Command>();
		turnCounter = 0;
	}
	
	public static void doCommand(Command todo) {
		todo.execute();
		commandHistory.push(todo);
		singleTurnCommandHistory.push(todo);
		
		for(Object objA : todo.getParameters()){
			for(Controllable contB : ControllableMap.getVals()) {
				Locatable a = (Locatable)objA;
				Locatable b = (Locatable)contB;
				checkCollision(a,b);
			}
		}
		
	}
	
	public void undoLastCommand() {
		commandHistory.pop().undo();
		singleTurnCommandHistory.pop().undo();
	}
	
	public static void checkCollision(Locatable a, Locatable b) {
		// TODO
	}
	
	public static void checkInside(Point a, Point b) {
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
