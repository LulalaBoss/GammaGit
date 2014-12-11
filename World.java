/**
 
 **/
 //package GameLogic;
 import java.io.*;
 import java.util.*;
 
 public class World implements Serializable
 {
   public ArrayList<City> cities;
   public ArrayList<Resource> resources;
   public ArrayList<Tile> tiles;
   public ArrayList<Merchant> merchants;
   public Storage storage;
   public Market market;
   public QuestEngine questEngine;
   public MarketBoard board;
   public User user;
   public GameMap gameMap;
   
   public int time;   
     
   public World()
   {
     System.out.println("Initializing world...");
	 cities = new ArrayList<City>();
	 resources = new ArrayList<Resource>();
	 tiles = new ArrayList<Tile>();
	 merchants = new ArrayList<Merchant>();
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
	 
	 // read city_list file
     try 
     {
	   BufferedReader br1 = new BufferedReader(new FileReader("city_list.txt"));
       String line1 = br1.readLine();	   
	   int i = 0;
	   while (line1 != null)
	   {
            String[] array = line1.split(",");	   
			City temp = new City(resources.get(i), array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]));
			cities.add(temp);
            line1 = br1.readLine();
			i++;
        }
		br1.close();
     }catch(Exception e1)
	 {
	   System.out.println(e1.getMessage());
     }
	 
	 // read tile_list file
	 try 
     {
	   BufferedReader br2 = new BufferedReader(new FileReader("tile_list.txt"));
       String line2 = br2.readLine();
	   while (line2 != null)
	   {	        
	        String[] s = line2.split(",");
			double[] l = new double[s.length-1];
			for(int i=0;i<s.length-1;i++)
			{
			  l[i] = Double.parseDouble(s[i+1]);
			}
			Tile temp = new Tile(s[0], l);
			tiles.add(temp);
            line2 = br2.readLine();
        }
		br2.close();
		
     }catch(Exception e2)
	 {
	   System.out.println("ERROR!! " + e2.getMessage());
     }
	 
	 // read merchant_list file
	 try 
     {
	   BufferedReader br3 = new BufferedReader(new FileReader("merchant_list.txt"));
       String line3 = br3.readLine();
	   while (line3 != null)
	   {	        
	        String[] s = line3.split(",");
			Merchant temp = new Merchant(s[0],Integer.parseInt(s[1]),Integer.parseInt(s[2]));
			merchants.add(temp);
            line3 = br3.readLine();
        }
		br3.close();
		
     }catch(Exception e3)
	 {
	   System.out.println("ERROR!! " + e3.getMessage());
     }
	 	 
	 System.out.println("city size: " + cities.size());
	 System.out.println("resource size: " + resources.size());
	 System.out.println("tile size: " + tiles.size());
	 System.out.println("merchant size: " + merchants.size());
	 
	 storage = new Storage(cities,resources);
	 gameMap = new GameMap(tiles);
	 
	 // set map
	 gameMap.setMap();
	 // set cities on map
	 for(int i=0;i<cities.size();i++)
	 {
	   gameMap.tileMap.get(cities.get(i).x).get(cities.get(i).y).city = cities.get(i);
	 }
	 
     
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
	 market = new Market(storage, gameMap);
	 	 
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
	 
	 // update GameMap first
	 gameMap.update();
	 
	 // updating market
	 market.update();
	 
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