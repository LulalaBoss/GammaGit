/**
 
 **/
 //package GameLogic;
 import java.io.*;
 import java.util.*;
 
 public class Tile implements Serializable
 {
   public String name;
   public City city;
   
   // resources index for this Tile
   public double woodIndex;
   public double fishIndex;
   public double copperIndex;
   public double  woolIndex;
   public double  crabIndex;
   public double  goldIndex;
   public double  fruitIndex;
   
   
   public Tile(String name, double wood, double fish, double copper, double wool, double crab, double gold, double fruit)
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