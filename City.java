/**
 
 **/
 //package GameLogic;
 import java.util.*;
 
 public class City
 {
   public int population;
   public ArrayList<Resource> resources;
   
   // Pair includes good and quantity 
   public ArrayList<Pair> goods;
   //public ProductionRule rule;
   public String name;
   public static final int SATISFACTION = 50;
   public int satisfaction;
     
   public City(Resource r, String n)
   {
     // set initial population to 1000
	 System.out.println("Initializing city...");
     population = 10000;	 
	 //rule = new ProductionRule(r.name);
	 resources = new ArrayList<Resource>();
	 resources.add(r);
	 
	 // create pair for goods
	 goods = new ArrayList<Pair>();
	 Pair p = new Pair<Resource,Integer>(r, new Integer(1));
	 goods.add(p);
	 
	 name = n;
	 satisfaction = SATISFACTION;
   }
   
   public void update()
   {
     System.out.println("Updating City...");
	 
	 // natural population rule
	 double tempPop = population * ( 0.00001 * satisfaction) + population;
	 population = (int) tempPop;	 
	 
	 // satisfactory score: based on the variety of goods available in this city
	 satisfaction = SATISFACTION + (1 - goods.size());
	 Resource temp = (Resource) goods.get(0).getKey();
	 System.out.println("Name of good:"+ temp.name + ", quantity: "+ goods.get(0).getValue());
   }
   
   public void production()
   {
     
   }
   
   public void editRule()
   {
   
   }
 
 }