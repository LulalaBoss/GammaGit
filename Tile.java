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
   public double[] resourceIndex;
   public double[] resourceDemand;
    
   
   public Tile(String name, double[] list)
   {
     this.name = name;

	 resourceIndex = new double[list.length];
	 for(int i=0;i<list.length;i++)
	 {
	   resourceIndex[i] = list[i];
	 }
	 
	 resourceDemand = new double[list.length];
	 
   }
   
   public void update()
   {
     for(int i=0;i<resourceIndex.length;i++)
	 {
	   resourceDemand[i] = (0.01 * ( 0.9 - resourceIndex[i] ));
	 }
   }
   
 }