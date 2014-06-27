/**
 
 **/
 //package GameLogic;
 import java.io.*;
 import java.util.*;
 
 public class GameMap implements Serializable
 {
   public HashMap<String,Tile> tilesDict;
   public ArrayList<ArrayList<Tile>> tileMap;
   
   public GameMap(ArrayList<Tile> tiles)
   {
     tilesDict = new HashMap<String,Tile>();
     for(int i=0;i<tiles.size();i++)
	 {
       tilesDict.put(tiles.get(i).name, tiles.get(i));
	 }
	 
	 tileMap = new ArrayList<ArrayList<Tile>>();
   }
   
   public void setMap()
	{
	  System.out.println("Setting Map...");
	  try{
	    BufferedReader br = new BufferedReader(new FileReader("Map.txt"));
		String line = br.readLine();
		String[] size = line.split(",");
		int row = Integer.parseInt(size[0]);
		int col = Integer.parseInt(size[1]);
		
		for(int i=0;i<row;i++)
		{
		  line = br.readLine();
		  String[] temp = line.split(",");
		  ArrayList<Tile> tempList = new ArrayList<Tile>();
		  for(int j=0;j<col;j++)
		  {
		    switch(temp[j])
			{
			  case "1":
			    tempList.add(tilesDict.get("GRASSLAND"));
				break;
			  case "2":
			    tempList.add(tilesDict.get("FOREST"));
				break;
			  case "3":
			    tempList.add(tilesDict.get("PLAIN"));
				break;
			  case "4":
			    tempList.add(tilesDict.get("SEA"));
				break;
			  case "5":
			    tempList.add(tilesDict.get("HILL"));
				break;
			  case "6":
			    tempList.add(tilesDict.get("LAKE"));
				break;		  
			}
		  }
		  tileMap.add(tempList);
		}
		
		System.out.println("Finished setting map. Map size: " + tileMap.size() + " X " + tileMap.get(0).size());
	  }
      catch(Exception e){}
	  
	}
	
	public void update()
	{
	  for(int i=0;i<tileMap.size();i++)
	  {
	    for(int j=0;j<tileMap.get(i).size();j++)
		{
		  tileMap.get(i).get(j).update();
		}
	  }
	}
   
 }