package world;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;

import units.EnvObject;
import units.Subject;
import units.Terrain;
import utils.ControllableMap;
import utils.MapLoader;
import controller.command.Command;

public class World extends Observable {
	
	public static final String OBJECT_FILE = "assets/core.xml";
	
	private static Stack<Command> commandHistory;
	private static Stack<Command> singleTurnCommandHistory;
	private int turnCounter;
	private static ArrayList<Terrain> terrain;
	private static ArrayList<EnvObject> envObjects;
	private static ArrayList<Subject> subjects;
	
	public World() throws IOException {
		String mapFile = "maps/desert_arena.xml";
		terrain = MapLoader.getTerrain(OBJECT_FILE, mapFile);
		envObjects = MapLoader.getEnvironmentObjects(OBJECT_FILE, mapFile);
		subjects = MapLoader.getSubjects(OBJECT_FILE, mapFile);
		commandHistory = new Stack<Command>();
		singleTurnCommandHistory = new Stack<Command>();
		turnCounter = 0;
	}
	
	public static void doCommand(Command todo) {
		todo.execute();
		singleTurnCommandHistory.push(todo);
	}
	
	public void undoLastCommand() {
		singleTurnCommandHistory.pop().undo();
	}
	
	public void goToNextTurn(){
		turnCounter++;
		while (singleTurnCommandHistory.size() > 0)
			commandHistory.push(singleTurnCommandHistory.get(0));
	}
	
	public static ArrayList<Terrain> getTerrain(){
		return terrain;
	}
	
	public void addPerson(Subject c) {
		ControllableMap.put(c);
		subjects.add(c);
		
		setChanged();
		notifyObservers();
	}

	public void setEnvObjects(ArrayList<EnvObject> objects) {
		envObjects = objects;
	}

	public static ArrayList<EnvObject> getEnvObjects() {
		return envObjects;
	}
	
	public static ArrayList<Subject> getSubjects() {
		return subjects;
	}
	
}
