/**
 
 **/
 //package GameLogic;
 import java.io.*;
 import java.util.*;
 
 public class City implements Serializable
 {
   public int population;
   public ArrayList<Resource> resources;
   
   // list of goods available in this city
   public ArrayList<Resource> goods;
   
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
	 goods = new ArrayList<Resource>();
	 goods.add(r);
	 
	 name = n;
	 satisfaction = SATISFACTION;
   }
   
   public void update()
   {
     System.out.println("Updating City...");
	 
	 // natural population rule
	 double tempPop = population * ( 0.000001 * satisfaction) + population;
	 population = (int) tempPop;	 
	 
	 // satisfactory score: based on the variety of goods available in this city
	 satisfaction = SATISFACTION + (1 - goods.size());
	 //Resource temp = (Resource) goods.get(0).getKey();
	 
	 // produce resource from this city
	 production();
   }
   
   public void production()
   {
     for(int i=0;i<resources.size();i++)
	 {
	   Resource cur = resources.get(i);
	   for(int j=0;j<goods.size();j++)
	   {
         /*	   
	     if(cur.name == ((Resource)goods.get(j).getKey()).name)
		 {
		   int value = goods.get(j).getValue(); 
		   // set producing unit to 10 for now
		   goods.get(j).updateValue(value + 10);		   
		 }
		 */
	   }
	 }    
   }
   
   public void popConsumption()
   {
    
   }
   
   public void editRule()
   {
   
   }
 
 }