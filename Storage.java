/**
 
 **/
 //package GameLogic;
 
 import java.util.*;
 
 public class Storage
 {   
   private int [][] map;
   private HashMap<String, Integer> cityDic;
   private HashMap<String, Integer> resourceDic;
   private int cityCur;
   private int resourceCur;   
   
   public Storage(int resource, int city)
   {
     map = new int[city][resource];
	 cityDic = new HashMap<String, Integer>();
	 resourceDic = new HashMap<String, Integer>();
	 cityCur = 0;
	 resourceCur = 0;
   }
   
   public int getValue(String city, String resource)
   {
	 return map[getCity(city)][getResource(resource)];
   }
   
   private int getCity(String city)
   {
     Integer v = cityDic.get(city);
	 if(v != null)
	 {
	   return (int) v; 
	 }
	 else
	 {
	   return assignCity(city);
	 }
   }
   
   private int getResource(String resource)
   {
     Integer v = resourceDic.get(resource);
	 if(v != null)
	 {
	   return (int) v; 
	 }
	 else
	 {
	   return assignResource(resource);
	 }
   
   }
   
   private int assignCity(String name)
   {
     cityDic.put(name, cityCur);
	 cityCur++;
     return cityDic.get(name);
   }
   
   private int assignResource(String name)
   {
     resourceDic.put(name, resourceCur);
	 resourceCur++;
     return resourceDic.get(name);
   }
   
   

 }