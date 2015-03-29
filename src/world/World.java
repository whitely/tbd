package world;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;

import units.EnvObject;
import units.Terrain;
import utils.ControllableMap;
import utils.TerrainLoader;
import controller.Controllable;
import controller.command.Command;

public class World extends Observable {
	
	public static final String OBJECT_FILE = "assets/core.xml";
	
	private static Stack<Command> commandHistory;
	private static Stack<Command> singleTurnCommandHistory;
	private int turnCounter;
	private static ArrayList<Terrain> terrain;
	private static ArrayList<EnvObject> envObjects;
	
	public World() throws IOException {
		String mapFile = "maps/desertarenaxmltbd.xml";
		terrain = TerrainLoader.getTerrain(OBJECT_FILE, mapFile);
		envObjects = TerrainLoader.getEnvironmentObjects(OBJECT_FILE, mapFile);
		
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
