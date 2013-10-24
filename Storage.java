/**
 
 **/
 //package GameLogic;
 
 import java.util.*;
 
 class Pair<K,V>
 {
   private K key;
   private V value;

   public Pair(K key, V value)
   {
     this.key = key;
	 this.value = value;
   }

   public K getKey()
   {
     return key;
   }
   
   public V getValue()
   {
     return value;
   }
   
 }
 
 public class Storage
 {   
   private int [][] resourceMap;
   private int [][] distMap;
   public int [][] degMap;
   private ArrayList<City> cityDic;
   private ArrayList<Resource> resourceDic;
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
	 degMap = new int [clist.size()][clist.size()];
	 
	 cityDic = clist;
	 resourceDic = rlist;
	 	 
	 // assign each city its own available starting resource
	 for(int i=0;i<clist.size();i++)
	 {
	   resourceMap[getCity(cityDic.get(i))][getResource(cityDic.get(i).resources.get(0))] = 1;
	 }
	 
   }
   
   // **implement degree traversal algorithm here to obtain all available resources to all city 
   public void setCityDegree()
   {
     // Need to implement breadth-first search here
     for(int i=0;i<degMap.length;i++)
	 {
	   for(int j=0;j<degMap[i].length;j++)
	   {
	     degMap[i][j] = getDeg(i,j);
	     degMap[j][i] = degMap[i][j];
	   }
	 }	 
   }
   
   public int getDeg(int i, int j)
   {     
     LinkedList<Integer> queue = new LinkedList<Integer>();
	 // <City, degree>
	 Hashtable<Integer, Integer> set = new Hashtable<Integer, Integer>();
	 int deg = 0;
	 int cur = i;
	 
	 queue.add(i);
	 set.put(i,deg);
	 while(queue.size() > 0)
	 {
	   for(int k=0;k<distMap.length;k++)
	   {
	     if(distMap[cur][k]!=0)
	     {
		   queue.add(k);
		   set.put(k,set.get(cur)+1);
		 }
	   }
	   if(queue.contains(j))
	   {
	     queue.clear();
	   }
	   else
	   {
	     cur = queue.poll();
	   }
	 }
	 
	 return set.get(j);
   }
   
   public void setCityDist(City city1, City city2, int dist)
   {
     distMap[getCity(city1)][getCity(city2)] = dist;
	 distMap[getCity(city2)][getCity(city1)] = dist;
	 // set degree
	 degMap[getCity(city1)][getCity(city2)] = 1;
	 degMap[getCity(city2)][getCity(city1)] = 1;
   }
   
   public int getCityDist(City city1, City city2)
   {
     return distMap[getCity(city1)][getCity(city2)];
   }
   
   public int getCityResource(City city, Resource resource)
   {
	 return resourceMap[getCity(city)][getResource(resource)];
   }
   
   private int getCity(City city)
   {
     Integer v = cityDic.indexOf(city);

	 return (int) v; 	 
   }
   
   private int getResource(Resource resource)
   {
     Integer v = resourceDic.indexOf(resource);

	 return (int) v; 	 
   }
   

   
   
   

 }