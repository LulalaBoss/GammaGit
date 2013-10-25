/**
 
 **/
 import java.io.*;
 
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
	   System.out.println("         4 - end");
	   
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
	 System.out.println("- City:" + newWorld.cities.get(0).name);
	 System.out.println("- * population: " + newWorld.cities.get(0).population);
	 System.out.println("- * satisfaction: " + newWorld.cities.get(0).satisfaction);
	 System.out.println("");
	 System.out.println("- User:");
	 System.out.println("- * money: " + newUser.money);
   }
   
   public void display()
   {
     System.out.println("\nResource: ");
	 for(int i=0;i<newWorld.cities.size();i++)
	 {
	   System.out.println("\n"+ newWorld.cities.get(i).name + ": ");
	   for(int k=0;k<newWorld.resources.size();k++)
	   {
	     System.out.println("    "+newWorld.resources.get(k).name + " - " + newWorld.storage.getCityResource(newWorld.cities.get(i),newWorld.resources.get(k)));
	   }
	 }
   }
   
   public void checkStash()
   {
     System.out.println("Stash");
   }
   
   public void end()
   {
     testOn = false;
   }
 
}