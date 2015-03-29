package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import units.EnvObject;
import units.Subject;
import units.Terrain;
import xml.XMLLoad;

public class MapLoader {
	
	private static ArrayList<Terrain> _terrain;
	private static ArrayList<EnvObject> _objects;
	private static ArrayList<Subject> _subjects;
	private static String _objectFile, _mapFile;
	
	public static ArrayList<Terrain> getTerrain(String objectFile, String mapFile) throws IOException {
		if (!check(objectFile, mapFile));
			generate(objectFile, mapFile);
		
		return _terrain;
	}
	
	public static ArrayList<EnvObject> getEnvironmentObjects(String objectFile, String mapFile) throws IOException {
		if (!check(objectFile, mapFile));
			generate(objectFile, mapFile);
	
		return _objects;
	}
	
	public static ArrayList<Subject> getSubjects(String objectFile, String mapFile) throws IOException {
		if (!check(objectFile, mapFile));
			generate(objectFile, mapFile);
	
		return _subjects;
	}
	
	private static boolean check(String objectFile, String mapFile) throws NullPointerException {
		if (objectFile == null || mapFile == null)
			throw new NullPointerException("TerrainLoader was passed a null input for a filename");
		
		return objectFile.equals(MapLoader._objectFile) && mapFile.equals(MapLoader._mapFile);
	}
	
	private static void generate(String objectFile, String mapFile) throws IOException {
		try {
			HashMap<String, Terrain> terrainObjects = XMLLoad.loadTerrainTypes(objectFile);
			HashMap<String, EnvObject> envObjects = XMLLoad.loadObjectTypes(objectFile);
			HashMap<String, Subject> subjectObjects = XMLLoad.loadSubjectTypes(objectFile);
			
			_terrain = XMLLoad.loadTerrain(mapFile, terrainObjects);
			_objects = XMLLoad.loadObjects(mapFile, envObjects);
			_subjects = XMLLoad.loadSubjects(mapFile, subjectObjects);
		} catch (IOException ioEx) {
			System.err.println("Check the file exists and is readable.");
			ioEx.printStackTrace();
		} catch (Exception ex) {
			System.err.println("It looks like the file exists and is readable, but something serious went wrong.");
			ex.printStackTrace();
			throw new IOException("Ensure the XML file is in a valid format.");
		}
	}
	
}
