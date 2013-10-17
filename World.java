/**
 
 **/
 //package GameLogic;
 
 import java.util.*;
 
 public class World
 {
   public ArrayList<City> cities;
   public ArrayList<Resource> resources;
   public Storage storage;
   
   public int time;   
 
   public World()
   {
     System.out.println("Initializing world...");
	 cities = new ArrayList<City>();
	 resources = new ArrayList<Resource>();
	 
	 // temporary city creation; to be removed later
	 Resource resource = new Resource("Wood");
	 resources.add(resource);	 
	 City temp = new City(resource, "Redwood City"); 
	 cities.add(temp);
	 	 
	 resource = new Resource("Fish");
	 resources.add(resource);
	 temp = new City(resource, "Santa Cruz");
	 cities.add(temp);
	 
	 resource = new Resource("Copper");
	 resources.add(resource);
	 temp = new City(resource, "Coppermine");
	 cities.add(temp);
	 
	 resource = new Resource("Wool");
	 resources.add(resource);
	 temp = new City(resource, "La Jolla");
	 cities.add(temp);

	 
	 storage = new Storage(cities,resources);
     
	 // set distances between cities
     storage.setCityDist("Santa Cruz", "Redwood City", 1);
     storage.setCityDist("Redwood City", "La Jolla", 1);	
     storage.setCityDist("Redwood City", "Coppermine", 1);		 
	 	 
	 // initializaing time; progress by month
	 time = 0;
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