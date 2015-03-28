package xml;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import units.EnvObject;
import units.Terrain;

public class XMLLoad {
	public static HashMap<String, Terrain> loadTerrainTypes(String filename) throws Exception
	{
		HashMap<String, Terrain> types = new HashMap<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(ClassLoader.getSystemResourceAsStream(filename));
		
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		
		for(int i = 0; i < nodeList.getLength(); i++)
		{
			Node node = nodeList.item(i);
			Terrain terrain;
			String id;
			if(node instanceof Element)
			{
				if(node.getNodeName().equals("terrain"))
				{
					terrain = new Terrain();
					id = node.getAttributes().getNamedItem("id").getNodeValue();
					
					NodeList children = node.getChildNodes();
					for(int j = 0; j < children.getLength(); j++)
					{
						Node child = children.item(j);
						
						if(child instanceof Element)
						{
							String content = child.getLastChild().getTextContent().trim();
							switch(child.getNodeName())
							{
							case "regenerationRate":
								terrain.setRegenerationRate(Integer.parseInt(content));
								break;
							case "projectilePassability":
								terrain.setProjectilePassability(Boolean.parseBoolean(content));
								break;
							case "speedMultiplier":
								terrain.setSpeedMultiplier(Double.parseDouble(content));
								break;
							case "damageSubject":
								terrain.setDamageSubject(Integer.parseInt(content));
								break;
							case "assetPath":
								terrain.setAssetPath(content);
								break;
							case "health":
								terrain.setHealth(Integer.parseInt(content));
								break;
							}
						}
					}
					
					types.put(id, terrain);
				}
			}
		}
		
		return types;
	}
	
	public static HashMap<String, EnvObject> loadObjectTypes(String filename) throws Exception
	{
		HashMap<String, EnvObject> types = new HashMap<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(ClassLoader.getSystemResourceAsStream(filename));
		
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		
		for(int i = 0; i < nodeList.getLength(); i++)
		{
			Node node = nodeList.item(i);
			EnvObject object;
			String id;
			if(node instanceof Element)
			{
				if(node.getNodeName().equals("envObject"))
				{
					id = node.getAttributes().getNamedItem("id").getNodeValue();
					object = new EnvObject();
					
					NodeList children = node.getChildNodes();
					for(int j = 0; j < children.getLength(); j++)
					{
						Node child = children.item(j);
						
						if(child instanceof Element)
						{
							String content = child.getLastChild().getTextContent().trim();
							switch(child.getNodeName())
							{
							case "regenerationRate":
								object.setRegenerationRate(Integer.parseInt(content));
								break;
							case "projectilePassability":
								object.setProjectilePassability(Boolean.parseBoolean(content));
								break;
							case "speedMultiplier":
								object.setSpeedMultiplier(Double.parseDouble(content));
								break;
							case "damageSubject":
								object.setDamageSubject(Integer.parseInt(content));
								break;
							case "assetPath":
								object.setAssetPath(content);
								break;
							case "health":
								object.setHealth(Integer.parseInt(content));
								break;
							case "width":
								object.setWidth(Integer.parseInt(content));
								break;
							case "height":
								object.setHeight(Integer.parseInt(content));
								break;
							}
						}
					}
					
					types.put(id, object);
				}
			}
		}
		
		return types;
	}
	
	public static ArrayList<Terrain> loadTerrain(String filename, HashMap<String, Terrain> types) throws Exception
	{
		ArrayList<Terrain> list = new ArrayList<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(ClassLoader.getSystemResourceAsStream(filename));
		
		NodeList catList = document.getDocumentElement().getChildNodes();
		
		for(int i = 0; i < catList.getLength(); i++)
		{
			Node category = catList.item(i);
			if(category instanceof Element && category.getNodeName().equals("terrain"))
			{
				NodeList nodeList = category.getChildNodes();
				for(int j = 0; j < nodeList.getLength(); j++)
				{
					Terrain terrain;
					Node node = nodeList.item(j);
					int x = 0;
					int y = 0;
					
					if(node instanceof Element)
					{
						terrain = new Terrain();
						
						//Get terrain type values
						Terrain type = types.get(node.getNodeName());
						terrain.setRegenerationRate(type.getRegenerationRate());
						terrain.setProjectilePassability(type.getProjectilePassability());
						terrain.setSpeedMultiplier(type.getSpeedMultiplier());
						terrain.setDamageSubject(type.getDamageSubject());
						terrain.setAssetPath(type.getAssetPath());
						terrain.setHealth(type.getHealth());
						
						NodeList children = node.getChildNodes();
						for(int k = 0; k < children.getLength(); k++)
						{
							Node child = children.item(k);
							
							if(child instanceof Element)
							{
								String content = child.getLastChild().getTextContent().trim();
								switch(child.getNodeName())
								{
								case "x":
									x = Integer.parseInt(content);
									break;
								case "y":
									y = Integer.parseInt(content);
									break;
								case "width":
									terrain.setWidth(Integer.parseInt(content));
									break;
								case "height":
									terrain.setHeight(Integer.parseInt(content));
									break;
								case "regenerationRate":
									terrain.setRegenerationRate(Integer.parseInt(content));
									break;
								case "projectilePassability":
									terrain.setProjectilePassability(Boolean.parseBoolean(content));
									break;
								case "speedMultiplier":
									terrain.setSpeedMultiplier(Double.parseDouble(content));
									break;
								case "damageSubject":
									terrain.setDamageSubject(Integer.parseInt(content));
									break;
								case "assetPath":
									terrain.setAssetPath(content);
									break;
								case "health":
									terrain.setHealth(Integer.parseInt(content));
									break;
								}
							}
						}
						
						Point point = new Point(x, y);
						terrain.setLocation(point);
						
						list.add(terrain);
					}
				}
			}
		}
		
		return list;
	}
	
	public static ArrayList<EnvObject> loadObjects(String filename, HashMap<String, EnvObject> types) throws Exception
	{
		ArrayList<EnvObject> list = new ArrayList<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(ClassLoader.getSystemResourceAsStream(filename));
		
		NodeList catList = document.getDocumentElement().getChildNodes();
		
		for(int i = 0; i < catList.getLength(); i++)
		{
			Node category = catList.item(i);
			if(category instanceof Element && category.getNodeName().equals("objects"))
			{
				NodeList nodeList = category.getChildNodes();
				for(int j = 0; j < nodeList.getLength(); j++)
				{
					EnvObject object;
					Node node = nodeList.item(j);
					int x = 0;
					int y = 0;
					
					if(node instanceof Element)
					{
						object = new EnvObject();
						
						//Get object type values
						EnvObject type = types.get(node.getNodeName());
						object.setRegenerationRate(type.getRegenerationRate());
						object.setProjectilePassability(type.getProjectilePassability());
						object.setSpeedMultiplier(type.getSpeedMultiplier());
						object.setDamageSubject(type.getDamageSubject());
						object.setAssetPath(type.getAssetPath());
						object.setHealth(type.getHealth());
						
						NodeList children = node.getChildNodes();
						for(int k = 0; k < children.getLength(); k++)
						{
							Node child = children.item(k);
							
							if(child instanceof Element)
							{
								String content = child.getLastChild().getTextContent().trim();
								switch(child.getNodeName())
								{
								case "x":
									x = Integer.parseInt(content);
									break;
								case "y":
									y = Integer.parseInt(content);
									break;
								case "width":
									object.setWidth(Integer.parseInt(content));
									break;
								case "height":
									object.setHeight(Integer.parseInt(content));
									break;
								case "regenerationRate":
									object.setRegenerationRate(Integer.parseInt(content));
									break;
								case "projectilePassability":
									object.setProjectilePassability(Boolean.parseBoolean(content));
									break;
								case "speedMultiplier":
									object.setSpeedMultiplier(Double.parseDouble(content));
									break;
								case "damageSubject":
									object.setDamageSubject(Integer.parseInt(content));
									break;
								case "assetPath":
									object.setAssetPath(content);
									break;
								case "health":
									object.setHealth(Integer.parseInt(content));
									break;
								}
							}
						}
						
						Point point = new Point(x, y);
						object.setLocation(point);
						
						list.add(object);
					}
				}
			}
		}
		
		return list;
	}
}
