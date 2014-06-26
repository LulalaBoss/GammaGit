/**
 
 **/
 //package GameLogic;
 import java.io.*;
 import java.util.*;
 
 public class World implements Serializable
 {
   public ArrayList<City> cities;
   public ArrayList<Resource> resources;
   public Storage storage;
   public Market market;
   public QuestEngine questEngine;
   public MarketBoard board;
   public User user;
   
   public int time;   
     
   public World()
   {
     System.out.println("Initializing world...");
	 cities = new ArrayList<City>();
	 resources = new ArrayList<Resource>();
	 user = new User();
	 
	 // read resource_list file
     try 
     {
	   BufferedReader br = new BufferedReader(new FileReader("resource_list.txt"));
       String line = br.readLine();
	   while (line != null)
	   {
            String[] s = line.split(",");
			Resource resource = new Resource(s[0], s[1], Double.parseDouble(s[5]), Boolean.valueOf(s[6]));
			resources.add(resource);
            line = br.readLine();
        }
		br.close();
     }catch(Exception e)
	 {
	   System.out.println(e.getMessage());
	 }
	 
     try 
     {
	   BufferedReader br1 = new BufferedReader(new FileReader("city_list.txt"));
       String line1 = br1.readLine();
	   int i = 0;
	   while (line1 != null)
	   {	        
			City temp = new City(resources.get(i), line1);
			cities.add(temp);
            line1 = br1.readLine();
			i++;
        }
		br1.close();
     }catch(Exception e1)
	 {
	   System.out.println(e1.getMessage());
     }
	 System.out.println(cities.size());
	 System.out.println(resources.size());
	 
	 
	 storage = new Storage(cities,resources);
	 
     
	 // set distances between cities
     storage.setCityDist(cities.get(1), cities.get(0), 1);
     storage.setCityDist(cities.get(0), cities.get(2), 1);	
     storage.setCityDist(cities.get(0), cities.get(3), 1);		

	 storage.setCityDist(cities.get(1), cities.get(3), 1);
	 storage.setCityDist(cities.get(1), cities.get(4), 1);
	 
	 storage.setCityDist(cities.get(4), cities.get(5), 1);
	 storage.setCityDist(cities.get(3), cities.get(5), 1);
	 
	 storage.setCityDist(cities.get(0), cities.get(6), 1);
	 
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
	 
	 // updating user
	 user.update();
	 
	 // update total time elapsed
	 time++;
	 
   }
   
   public boolean purchase(int resourceId, int quantity)
   {
     boolean purchaseSuccessful = false;
     double moneyDue = quantity * market.getMarketPrice(cities.get(user.location), resources.get(resourceId));
	 
	 if(moneyDue < user.money)
	 {
	   user.money = user.money - moneyDue;
	   for(int i=0;i<quantity;i++)
	   {
	     user.cargo.add(resources.get(resourceId));
	   }
	   
	   purchaseSuccessful = true;
	 }
	 
	 return purchaseSuccessful;
   }
   
   public void sell(int cargoId)
   {
     user.money = user.money + market.getMarketPrice(cities.get(user.location), resources.get(user.cargo.get(cargoId).id));
	 user.cargo.remove(cargoId);	 
   }

   
 
 }