/**
 
 **/
 //package GameLogic;
 
 import java.util.*;
 
 public class World
 {
   public ArrayList<City> cities;
   public ArrayList<Resource> resources;
   public Storage storage;
   public Market market;
   public QuestEngine questEngine;
   
   public int time;   
 
   public World()
   {
     System.out.println("Initializing world...");
	 cities = new ArrayList<City>();
	 resources = new ArrayList<Resource>();
	 
	 // temporary city creation; to be removed later
	 Resource resource = new Resource("Wood", 18.0);
	 resources.add(resource);	 
	 City temp = new City(resource, "Redwood City"); 
	 cities.add(temp);
	 	 
	 resource = new Resource("Fish", 1.0);
	 resources.add(resource);
	 temp = new City(resource, "Santa Cruz");
	 cities.add(temp);
	 
	 resource = new Resource("Copper", 50.0);
	 resources.add(resource);
	 temp = new City(resource, "Coppermine");
	 cities.add(temp);
	 
	 resource = new Resource("Wool", 5.0);
	 resources.add(resource);
	 temp = new City(resource, "La Jolla");
	 cities.add(temp);
	 
	 resource = new Resource("Crab", 25.0);
	 resources.add(resource);
	 temp = new City(resource, "New Port");
	 cities.add(temp);
	 	 
	 resource = new Resource("Gold", 100.0);
	 resources.add(resource);
	 temp = new City(resource, "San Jose");
	 cities.add(temp);

	 
	 storage = new Storage(cities,resources);
     
	 // set distances between cities
     storage.setCityDist(cities.get(1), cities.get(0), 1);
     storage.setCityDist(cities.get(0), cities.get(2), 1);	
     storage.setCityDist(cities.get(0), cities.get(3), 1);		

	 storage.setCityDist(cities.get(1), cities.get(3), 1);
	 storage.setCityDist(cities.get(1), cities.get(4), 1);
	 
	 storage.setCityDist(cities.get(4), cities.get(5), 1);
	 storage.setCityDist(cities.get(3), cities.get(5), 1);
	 
     storage.setCityDegree();
     storage.setResourceMap();	 
	 
	 // initialize market board
	 market = new Market(storage);
	 	 
	 // initializing time; progress by month
	 time = 0;
	 
	 // initializing quest engine
	 questEngine = new QuestEngine(storage);
   }
   
   public void update()
   {
     System.out.println("Updating world...");
	 
	 // updating cities
	 for(int i=0;i<cities.size();i++)
	 {
	   cities.get(i).update();
	 }
	 
	 // update total time elapsed
	 time++;
	 
   }

   
 
 }