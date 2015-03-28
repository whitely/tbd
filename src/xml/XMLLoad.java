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
import units.RectTerrain;

public class XMLLoad {
	public static HashMap<String, RectTerrain> loadTerrainTypes(String filename) throws Exception
	{
		HashMap<String, RectTerrain> types = new HashMap<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(ClassLoader.getSystemResourceAsStream(filename));
		
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		
		for(int i = 0; i < nodeList.getLength(); i++)
		{
			Node node = nodeList.item(i);
			RectTerrain terrain;
			String id;
			if(node instanceof Element)
			{
				if(node.getNodeName().equals("rectTerrain"))
				{
					id = node.getAttributes().getNamedItem("id").getNodeValue();
					terrain = new RectTerrain();
					
					NodeList children = node.getChildNodes();
					for(int j = 0; j < children.getLength(); j++)
					{
						Node child = children.item(j);
						
						if(child instanceof Element)
						{
							String content = child.getLastChild().getTextContent().trim();
							switch(child.getNodeName())
							{
							case "damageAmt":
								terrain.setDamageAmt(Integer.parseInt(content));
								break;
							case "speed":
								terrain.setSpeed(Integer.parseInt(content));
								break;
							case "graphics":
								terrain.setGraphics(content);
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
			RectTerrain terrain;
			String id;
			if(node instanceof Element)
			{
				if(node.getNodeName().equals("envObject"))
				{
					id = node.getAttributes().getNamedItem("id").getNodeValue();
					terrain = new RectTerrain();
					
					NodeList children = node.getChildNodes();
					for(int j = 0; j < children.getLength(); j++)
					{
						Node child = children.item(j);
						
						if(child instanceof Element)
						{
							String content = child.getLastChild().getTextContent().trim();
							switch(child.getNodeName())
							{
							case "r":
								terrain.setr(Integer.parseInt(content));
								break;
							case "graphics":
								terrain.setGraphics(content);
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
	
	public static ArrayList<RectTerrain> loadTerrain(String filename, HashMap<String, RectTerrain> types) throws Exception
	{
		ArrayList<RectTerrain> list = new ArrayList<>();
		
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
					RectTerrain terrain;
					Node node = nodeList.item(j);
					int x = 0;
					int y = 0;
					
					if(node instanceof Element)
					{
						terrain = new RectTerrain();
						
						//Get terrain type values
						RectTerrain type = types.get(node.getNodeName());
						terrain.setDamageAmt(type.getDamageAmt());
						terrain.setSpeed(type.getSpeed());
						terrain.setGraphics(type.getGraphics());
						
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
	
	public static ArrayList<EnvObject> loadObjects(String filename, HashMap<String, RectTerrain> types) throws Exception
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
						object = new RectTerrain();
						
						//Get object type values
						EnvObject type = types.get(node.getNodeName());
						object.setr(type.getr());
						object.setGraphics(type.getGraphics());
						
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
