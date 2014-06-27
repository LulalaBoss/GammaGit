/**
 
 **/
 import java.io.*;
 import java.util.*;
 
 public class GameLogicTest
 {
 
   private boolean testOn;
   private World newWorld; 
   
   public GameLogicTest()
   {
     System.out.println("Initializing...");
	 testOn = true;
	 newWorld = new World();
   }
   
   public static void main(String [ ] args)
   {
     GameLogicTest test = new GameLogicTest();	 
	 test.run();
   }
   
   public void run()
   {
	 try{
	   String command = null;
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	   System.out.println("Would you like to load last saved game? y/n");	
	   
	   command = br.readLine();
	   
	   // if yes, load all objects from files
	   if(command.equals("y"))
	   {
	     newWorld = load();
	   }
	   
       // While loop - issue command to proceed  
	   while(testOn)
	   {
	     System.out.println("\nCommand: 0 - check status");
	     System.out.println("         1 - map");
	     System.out.println("         2 - end turn");
	     System.out.println("         3 - display resource/city");
	     System.out.println("         4 - quest");
	     System.out.println("         5 - action");
	     System.out.println("         6 - save progress");
	     System.out.println("         7 - end");
	   	    	   
         command = br.readLine();	   
	   
	     if(command.equals("0"))
	     {
	       checkStatus();
	     }
	     else if(command.equals("1"))
	     {
	       //checkStash();
		   map();
	     }
	     else if(command.equals("2"))
	     {
	       endTurn();
	     }
	     else if(command.equals("3"))
	     {
	       display();
	     }
	     else if(command.equals("4"))
	     {
	       showQuestList();
	     }
	     else if(command.equals("5"))
	     {
	       action(); 
	     }
	     else if(command.equals("6"))
	     {
	       save();
	     }
	     else if(command.equals("7"))
	     {
	       end();
	     }
	   
	   }
	 }
	 catch(IOException ioe)
	 {
       System.out.println("IO error");
       System.exit(1);
     }
	 
   }
   
   public void map()
   {
     System.out.println("Map:");
	 for(int i=0;i<newWorld.cities.size();i++)
	 {
	   for(int j=0;j<newWorld.cities.size();j++)
	   {
	     System.out.println(newWorld.cities.get(i).name + " : " + newWorld.cities.get(j).name + " - " + newWorld.storage.getDegMap(i,j));
	   }
	 } 
   }
   
   public void save()
   {
     String worldFile = "C:\\Users\\alvin\\Desktop\\Local\\GameLogic\\world.obj";
	 try
	 {
	   FileOutputStream fileOut = new FileOutputStream(worldFile);
	   ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	   objectOut.writeObject(newWorld);
	   objectOut.close();
	 }
	 catch(Exception e){ e.printStackTrace();}
	 
	 System.out.println("Game saved successfully.");
   }
   
   public World load()
   {
     World world = new World();
     try
	 {
	   String worldFile = "C:\\Users\\alvin\\Desktop\\Local\\GameLogic\\world.obj";
	   FileInputStream fileIn = new FileInputStream(worldFile);
	   ObjectInputStream objectIn = new ObjectInputStream(fileIn);
	   world = (World) objectIn.readObject();
	   objectIn.close();
	 }
	 catch(Exception e){ e.printStackTrace();}
	 
	 System.out.println("Game loaded successfully.");
	 
	 return world;
   }
   
   public void endTurn()
   {
	 newWorld.update();
   }
      
   public void checkStatus()
   {    
     System.out.println("========== Status ==========");
	 System.out.println("-Time Elapsed: " + newWorld.time);
	 System.out.println("- User:");
	 System.out.println("- * money: " + newWorld.user.money);
	 System.out.println("- * current locale: " + newWorld.cities.get(newWorld.user.location).name);
	 System.out.println("");
	 for(int i=0;i<newWorld.cities.size();i++){
	   System.out.println("- City:" + newWorld.cities.get(i).name);
	   System.out.println("- * population: " + newWorld.cities.get(i).population);
	   System.out.println("- * satisfaction: " + newWorld.cities.get(i).satisfaction);
	   System.out.println("- Available Goods:");
	   for(int j=0;j<newWorld.cities.get(i).goods.size();j++)
	   {
	     //System.out.println("-  * " + ((Resource)newWorld.cities.get(i).goods.get(j).getKey()).name + " : " + newWorld.cities.get(i).goods.get(j).getValue());
	   }
	   System.out.println("");
     }
   }
   
   public void display()
   {
     System.out.println("\nResource: ");
	 for(int i=0;i<newWorld.cities.size();i++)
	 {
	   System.out.println("\n"+ newWorld.cities.get(i).name + ": ");
	   for(int k=0;k<newWorld.resources.size();k++)
	   {
	     System.out.println("    "+newWorld.resources.get(k).name + " - " 
		   + newWorld.storage.getCityResource(newWorld.cities.get(i),newWorld.resources.get(k)) 
		   + " : " + newWorld.market.getMarketPrice(newWorld.cities.get(i),newWorld.resources.get(k)));
	   }
	 }
   }
   
   public void checkStash()
   {
     System.out.println("Stash");
   }
   
   public void showQuestList()
   {
     ArrayList<String> list = newWorld.questEngine.generate();
	 for(int i=0;i<list.size();i++)
	 {
	   System.out.println(list.get(i));
	 }
   }
   
   public void action()
   {
     System.out.println("What would you like to do? ");
	 System.out.println("--- 1. travel");
	 System.out.println("--- 2. purchase goods");
	 System.out.println("--- 3. sell goods");
	 System.out.println("--- 4. inspect cargo");
	 System.out.println("--- 5. nothing");
	 
	 BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	 String command1 = null;
	   
	 try 
	 {
       command1 = br1.readLine();
     }
	 catch(IOException ioe)
	 {
       System.out.println("IO error");
       System.exit(1);
     }
	   
	 if(command1.equals("1"))
	 {
	   travel();
	 }
	 else if(command1.equals("2"))
	 {
       purchase();
	 }
	 else if(command1.equals("3"))
	 {
	   sell();
	 }
	 else if(command1.equals("4"))
	 {
	   inspectCargo();
	 }
	 else if(command1.equals("5")){}

   }
   
   public void sell()
   {
     String input = null;
     System.out.println("What would you like to sell? ");
	 for(int i=0;i<newWorld.user.cargo.size();i++)
	 {
	   Resource r = newWorld.user.cargo.get(i);
	   double price = newWorld.market.getMarketPrice(newWorld.cities.get(newWorld.user.location),newWorld.resources.get(r.id));
	   System.out.println( i + ". " + r.name + ": price here is $" + price);
	 }
	 
	 BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));   
	 try 
	 {
       input = br2.readLine();
     }
	 catch(IOException ioe)
	 {
       System.out.println("IO error");
       System.exit(1);
     }
	 
	 newWorld.sell(Integer.parseInt(input));
   }
   
   public void travel()
   {
     String input = null;
     System.out.println("Where would you like to go? ");
	 for(int i=0;i<newWorld.cities.size();i++)
	 {
	   System.out.println( i + " - " + newWorld.cities.get(i).name);
	 }
	 
	 BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));   
	 try 
	 {
       input = br2.readLine();
     }
	 catch(IOException ioe)
	 {
       System.out.println("IO error");
       System.exit(1);
     }
	 
	 // travel and update turn count
	 newWorld.user.location = Integer.parseInt(input);
	 endTurn(); /*** TODO: update time should equal the distance between two cities */
   }
   
   public void purchase()
   {
     String input = null;
	 int resourceId = 0;
	 int quantity = 0;
     System.out.println("What would you like to purchase? ");
	 for(int i=0;i<newWorld.cities.get(newWorld.user.location).goods.size();i++)
	 {
	   Resource r = newWorld.cities.get(newWorld.user.location).goods.get(i);
	   double price = newWorld.market.getMarketPrice(newWorld.cities.get(newWorld.user.location),r);
	   System.out.println( " - "+ r.name + " - id: " + r.id + " $" + price);
	 }
	 
	 BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));   
	 try 
	 {
       input = br2.readLine();
	   resourceId = Integer.parseInt(input);
	   System.out.println("How many?");
	   input = br2.readLine();
	   quantity = Integer.parseInt(input);
     }
	 catch(IOException ioe)
	 {
       System.out.println("IO error");
       System.exit(1);
     }
	 
	 if(newWorld.purchase(resourceId, quantity))
	 {
	   System.out.println("Purchase successful!");
	 }
	 else
	 {
	   System.out.println("Sorry you do not have enough money for that!");
	 }
	 
   }
   
   public void inspectCargo()
   {
     for(int i=0;i<newWorld.user.cargo.size();i++)
	 {
       System.out.println( (i+1) + ". " + newWorld.user.cargo.get(i).name);
	 }
   }
   
   public void end()
   {
     testOn = false;
   }
 
}