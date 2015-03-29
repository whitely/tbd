package test;

import java.util.ArrayList;
import java.util.HashMap;

import units.EnvObject;
import units.Terrain;
import xml.XMLLoad;

public class XMLTest {
	public static void main(String[] args) throws Exception
	{
		final String objectFile = "objects/core.xml";
		final String mapFile = "maps/desertarenaxmltbd.xml";
		
		HashMap<String, Terrain> terrainObjects = XMLLoad.loadTerrainTypes(objectFile);
		HashMap<String, EnvObject> envObjects = XMLLoad.loadObjectTypes(objectFile);
		
		ArrayList<Terrain> terrains = XMLLoad.loadTerrain(mapFile, terrainObjects);
		ArrayList<EnvObject> objects = XMLLoad.loadObjects(mapFile, envObjects);
		
		for(int i = 0; i < terrains.size(); i++)
		{
			Terrain terrain = terrains.get(i);
			System.out.println("Regeneration Rate: " + terrain.getRegenerationRate());
			System.out.println("Speed Multiplier: " + terrain.getSpeedMultiplier());
			System.out.println("Damage Subject: " + terrain.getDamageSubject());
			System.out.println("Asset Path: " + terrain.getAssetPath());
			System.out.println(terrain.getLocation().x + " - " + terrain.getLocation().y);
			System.out.println("Width: " + terrain.getWidth());
			System.out.println("Height: " + terrain.getHeight());
			System.out.println();
		}
		
		System.out.println();
		System.out.println("----");
		System.out.println();
		
		for(int i = 0; i < objects.size(); i++)
		{
			EnvObject object = objects.get(i);
			System.out.println("Regeneration Rate: " + object.getRegenerationRate());
			System.out.println("Speed Multiplier: " + object.getSpeedMultiplier());
			System.out.println("Damage Subject: " + object.getDamageSubject());
			System.out.println("Asset Path: " + object.getAssetPath());
			System.out.println(object.getLocation().x + " - " + object.getLocation().y);
			System.out.println("Width: " + object.getWidth());
			System.out.println("Height: " + object.getHeight());
			System.out.println();
		}
	}
}
