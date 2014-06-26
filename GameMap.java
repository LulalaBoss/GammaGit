/**
 
 **/
 //package GameLogic;
 import java.io.*;
 import java.util.*;
 
 public class GameMap implements Serializable
 {
   public HashMap<String,Tile> tiles;
   
   public GameMap(ArrayList<Tile> tiles)
   {
     for(int i=0;i<tiles.size();i++)
	 {
       this.tiles.put(tiles.get(i).name, tiles.get(i));
	 }
   }
   
 }