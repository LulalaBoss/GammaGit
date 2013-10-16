/**
 
 **/
 //package GameLogic;
 
 import java.util.*;
 
 public class World
 {
   public ArrayList<City> cities;

   public int time;   
 
   public World()
   {
     System.out.println("Initializing world...");
	 cities = new ArrayList<City>();
	 
	 // temporary city creation; to be removed later
	 City temp = new City("Wood", "City 1"); 
	 cities.add(temp);
	 
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