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
	 
	 resource = new Resource("Crab");
	 resources.add(resource);
	 temp = new City(resource, "New Port");
	 cities.add(temp);

	 
	 storage = new Storage(cities,resources);
     
	 // set distances between cities
     storage.setCityDist(cities.get(1), cities.get(0), 1);
     storage.setCityDist(cities.get(0), cities.get(2), 1);	
     storage.setCityDist(cities.get(0), cities.get(3), 1);		

	 storage.setCityDist(cities.get(1), cities.get(3), 1);
	 storage.setCityDist(cities.get(1), cities.get(4), 1);
	 
     storage.setCityDegree();	 
	 	 
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