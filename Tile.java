/**
 
 **/
 //package GameLogic;
 import java.io.*;
 import java.util.*;
 
 public class Tile implements Serializable
 {
   public String name;
   
   // resources index for this Tile
   public int woodIndex;
   public int fishIndex;
   public int copperIndex;
   public int woolIndex;
   public int crabIndex;
   public int goldIndex;
   public int fruitIndex;
   
   
   public Tile(String name, int wood, int fish, int copper, int wool, int crab, int gold, int fruit)
   {
     this.name = name;
	 woodIndex = wood;
	 fishIndex = fish;
	 copperIndex = copper;
	 woolIndex = wool;
	 crabIndex = crab;
	 goldIndex = gold;
	 fruitIndex = fruit;
   }
   
 }