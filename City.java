/**
 
 **/
 //package GameLogic;
 
 
 public class City
 {
   public int population;
   public ProductionRule rule;
   public Storage storage;
   public String name;
   public int satisfaction;
     
   public City(String special, String n)
   {
     // set initial population to 1000
	 System.out.println("Initializing city...");
     population = 10000;
	 storage = new Storage(20,20);
	 rule = new ProductionRule(special);
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