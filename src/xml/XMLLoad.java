package xml;

import java.awt.Point;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import affinity.AffinityStrategy;
import affinity.NullStrategy;
import affinity.NumericStrategy;
import units.EnvObject;
import units.Subject;
import units.Terrain;

public class XMLLoad {
	public static HashMap<String, Terrain> loadTerrainTypes(String filename) throws Exception
	{
		HashMap<String, Terrain> types = new HashMap<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new FileInputStream(filename));
		
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
		Document document = builder.parse(new FileInputStream(filename));
		
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
							case "h":
								object.setHeight(Integer.parseInt(content));
								break;
							case "w":
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
	
	public static HashMap<String, Subject> loadSubjectTypes(String filename) throws Exception
	{
		HashMap<String, Subject> types = new HashMap<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new FileInputStream(filename));
		
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		
		for(int i = 0; i < nodeList.getLength(); i++)
		{
			Node node = nodeList.item(i);
			Subject subject;
			String id;
			if(node instanceof Element)
			{
				if(node.getNodeName().equals("subject"))
				{
					subject = new Subject();
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
							case "grace":
								subject.setGrace(Integer.parseInt(content));
								break;
							case "intelligence":
								subject.setIntelligence(Integer.parseInt(content));
								break;
							case "strength":
								subject.setStrength(Integer.parseInt(content));
								break;
							case "traitPoints":
								subject.setTraitPoints(Integer.parseInt(content));
								break;
							case "assetPath":
								subject.setAssetPath(content);
								break;
							case "volume":
								subject.setVolume(Double.parseDouble(content));
								break;
							case "mass":
								subject.setMass(Double.parseDouble(content));
								break;
							case "name":
								subject.setName(content);
								break;
							case "height":
								subject.setHeight(Integer.parseInt(content));
								break;
							case "width":
								subject.setWidth(Integer.parseInt(content));
								break;
							case "health":
								subject.setHealth(Integer.parseInt(content));
								break;
							}
						}
					}
					
					types.put(id, subject);
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
		Document document = builder.parse(new FileInputStream(filename));
		
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
								case "w":
									terrain.setWidth(Integer.parseInt(content));
									break;
								case "h":
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
		Document document = builder.parse(new FileInputStream(filename));
		
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
						object.setWidth(type.getWidth());
						object.setHeight(type.getHeight());
						
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
								case "w":
									object.setWidth(Integer.parseInt(content));
									break;
								case "h":
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
	
	public static ArrayList<Subject> loadSubjects(String filename, HashMap<String, Subject> types) throws Exception
	{
		ArrayList<Subject> list = new ArrayList<Subject>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new FileInputStream(filename));
		
		NodeList catList = document.getDocumentElement().getChildNodes();
		
		for(int i = 0; i < catList.getLength(); i++)
		{
			Node category = catList.item(i);
			if(category instanceof Element && category.getNodeName().equals("subjects"))
			{
				NodeList nodeList = category.getChildNodes();
				for(int j = 0; j < nodeList.getLength(); j++)
				{
					Subject subject;
					Node node = nodeList.item(j);
					int x = 0;
					int y = 0;
					
					if(node instanceof Element)
					{
						subject = new Subject();
						
						//Get terrain type values
						Subject type = types.get(node.getNodeName());
						subject.setGrace(type.getGrace());
						subject.setIntelligence(type.getIntelligence());
						subject.setStrength(type.getStrength());
						subject.setTraitPoints(type.getTraitPoints());
						subject.setAssetPath(type.getAssetPath());
						subject.setVolume(type.getVolume());
						subject.setMass(type.getMass());
						subject.setName(type.getName());
						subject.setHeight(type.getHeight());
						subject.setWidth(type.getWidth());
						subject.setHealth(type.getHealth());
						
						NodeList children = node.getChildNodes();
						for(int k = 0; k < children.getLength(); k++)
						{
							Node child = children.item(k);
							
							if(child instanceof Element)
							{
								String content = child.getLastChild().getTextContent().trim();
								switch(child.getNodeName())
								{
								case "grace":
									subject.setGrace(Integer.parseInt(content));
									break;
								case "intelligence":
									subject.setIntelligence(Integer.parseInt(content));
									break;
								case "strength":
									subject.setStrength(Integer.parseInt(content));
									break;
								case "traitPoints":
									subject.setTraitPoints(Integer.parseInt(content));
									break;
								case "assetPath":
									subject.setAssetPath(content);
									break;
								case "volume":
									subject.setVolume(Double.parseDouble(content));
									break;
								case "mass":
									subject.setMass(Double.parseDouble(content));
									break;
								case "name":
									subject.setName(content);
									break;
								case "h":
									subject.setHeight(Integer.parseInt(content));
									break;
								case "w":
									subject.setWidth(Integer.parseInt(content));
									break;
								case "health":
									subject.setHealth(Integer.parseInt(content));
									break;
								case "x":
									x = Integer.parseInt(content);
									break;
								case "y":
									y = Integer.parseInt(content);
									break;
								case "affinity":
									if(Integer.parseInt(content)<20 &&Integer.parseInt(content)>=0){
										subject.setAffinityStrat(new NumericStrategy(Integer.parseInt(content)));
									}
									else if(content == "random") {
										subject.setAffinityStrat(new NumericStrategy());
									} else{
										subject.setAffinityStrat(new NullStrategy());
									}
								}
							}
						}
						
						Point point = new Point(x, y);
						subject.setLocation(point);
						
						list.add(subject);
					}
				}
			}
		}
		
		return list;
	}
}
