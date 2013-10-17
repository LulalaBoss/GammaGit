/**
 
 **/
 //package GameLogic;
 
 import java.util.*;
 
 public class Storage
 {   
   private int [][] resourceMap;
   private int [][] distMap;
   private HashMap<String, Integer> cityDic;
   private HashMap<String, Integer> resourceDic;
   private int cityCur;
   private int resourceCur;   
   
   // Need a two way conversion map...
   // -----> use a Pair class!!!
   
   public Storage(ArrayList<City> clist, ArrayList<Resource> rlist)
   {
     cityCur = 0;
	 resourceCur = 0;
	 
     resourceMap = new int[clist.size()][rlist.size()];
	 distMap = new int [clist.size()][clist.size()];
	 
	 cityDic = new HashMap<String, Integer>();
	 resourceDic = new HashMap<String, Integer>();
	 
	 for(int i=0;i<clist.size();i++)
	 {
	   assignCity(clist.get(i).name);
	 }
	 
	 for(int i=0;i<rlist.size();i++)
	 {
	   assignResource(rlist.get(i).name);
	 }
	 
	 // assign each city its own available starting resource
	 for(int i=0;i<clist.size();i++)
	 {
	   resourceMap[getCity(clist.get(i).name)][getResource(clist.get(i).resources.get(0).name)] = 1;
	 }
	 
   }
   
   
   public void setCityDist(String city1, String city2, int dist)
   {
     distMap[getCity(city1)][getCity(city2)] = dist;
	 distMap[getCity(city2)][getCity(city1)] = dist;
   }
   
   public int getCityDist(String city1, String city2)
   {
     return distMap[getCity(city1)][getCity(city2)];
   }
   
   public int getCityResource(String city, String resource)
   {
	 return resourceMap[getCity(city)][getResource(resource)];
   }
   
   private int getCity(String city)
   {
     Integer v = cityDic.get(city);

	 return (int) v; 	 
   }
   
   private int getResource(String resource)
   {
     Integer v = resourceDic.get(resource);

	 return (int) v; 	 
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