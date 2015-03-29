package world;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;

import units.EnvObject;
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
	private static ArrayList<EnvObject> envObjects;
	
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
	}
	
	public void undoLastCommand() {
		commandHistory.pop().undo();
		singleTurnCommandHistory.pop().undo();
	}
	
	public void goToNextTurn(){
		turnCounter++;
		singleTurnCommandHistory.clear();
		
	}
	
	public static ArrayList<Terrain> getTerrain(){
		return terrain;
	}
	
	public void setTerrain(ArrayList<Terrain> terrain){
		this.terrain = terrain;
	}
	
	public void addPerson(Controllable c) {
		ControllableMap.put(c);
		
		setChanged();
		notifyObservers();
	}

	public void setEnvObjects(ArrayList<EnvObject> objects) {
		envObjects = objects;
	}

	public static ArrayList<EnvObject> getEnvObjects() {
		return envObjects;
	}
	
}
