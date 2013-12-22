/**
 
 **/
 //package GameLogic;
 import java.util.*;
 
 public class City
 {
   public int population;
   public ArrayList<Resource> resources;
   //public ProductionRule rule;
   public String name;
   public int satisfaction;
     
   public City(Resource r, String n)
   {
     // set initial population to 1000
	 System.out.println("Initializing city...");
     population = 10000;	 
	 //rule = new ProductionRule(r.name);
	 resources = new ArrayList<Resource>();
	 resources.add(r);
	 name = n;
	 satisfaction = 50;
   }
   
   public void update()
   {
     System.out.println("Updating City...");
	 
	 // natural population rule
	 double tempPop = population * 0.00056 + population;
	 population = (int) tempPop;
	 
	 // moving rate 
	 tempPop = population * (satisfaction - 50) * 0.0001 + population;
	 
   }
   
   public void production()
   {
     
   }
   
   public void editRule()
   {
   
   }
 
 }