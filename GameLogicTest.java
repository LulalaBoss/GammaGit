/**
 
 **/
 import java.io.*;
 import java.util.*;
 
 public class GameLogicTest
 {
 
   private boolean testOn;
   private World newWorld; 
   private User newUser;
   
   public GameLogicTest()
   {
     System.out.println("Initializing...");
	 testOn = true;
	 newWorld = new World();
	 newUser = new User();
   }
   
   public static void main(String [ ] args)
   {
     GameLogicTest test = new GameLogicTest();	 
	 test.run();
   }
   
   public void run()
   {
	 
	 String command = null;
	 
     // While loop - issue command to proceed  
	 while(testOn)
	 {
	   System.out.println("\nCommand: 0 - check status");
	   System.out.println("         1 - map");
	   System.out.println("         2 - end turn");
	   System.out.println("         3 - display resource/city");
	   System.out.println("         4 - quest");
	   System.out.println("         5 - action");
	   System.out.println("         6 - end");
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	   try 
	   {
         command = br.readLine();
       }
	   catch(IOException ioe)
	   {
         System.out.println("IO error");
         System.exit(1);
       }
	   
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
	     end();
	   }
	   
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
   
   public void endTurn()
   {
     newUser.update();
	 newWorld.update();
   }
      
   public void checkStatus()
   {    
     System.out.println("========== Status ==========");
	 System.out.println("-Time Elapsed: " + newWorld.time);
	 System.out.println("- User:");
	 System.out.println("- * money: " + newUser.money);
	 System.out.println("- * current locale: " + newWorld.cities.get(newUser.location).name);
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
	 System.out.println("--- 3. inspect cargo");
	 System.out.println("--- 4. nothing");
	 
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
	   inspectCargo();
	 }
	 else if(command1.equals("4")){}

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
	 newUser.location = Integer.parseInt(input);
	 newWorld.time = newWorld.time + 1; /*** TODO: update time should equal the distance between two cities */
   }
   
   public void purchase()
   {
     String input = null;
	 int resourceId = 0;
	 int quantity = 0;
     System.out.println("What would you like to purchase? ");
	 for(int i=0;i<newWorld.cities.get(newUser.location).goods.size();i++)
	 {
	   Resource r = newWorld.cities.get(newUser.location).goods.get(i);
	   System.out.println( " - "+ r.name + " - id: " + r.id);
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
	 
	 for(int i=0;i<quantity;i++)
	 {
	   newUser.cargo.add(newWorld.resources.get(resourceId));
	 }
   }
   
   public void inspectCargo()
   {
     for(int i=0;i<newUser.cargo.size();i++)
	 {
       System.out.println( (i+1) + ". " + newUser.cargo.get(i).name);
	 }
   }
   
   public void end()
   {
     testOn = false;
   }
 
}