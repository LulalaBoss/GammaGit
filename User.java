/**
 
 **/
 //package GameLogic;
 import java.util.*;
 
 public class User
 {
   public int money;
   public ArrayList<Pair> transaction;
 
   public User()
   {
     System.out.println("Initializing user...");
	 // set initial money to 1000
	 money = 1000;
	 
	 transaction = new ArrayList<Pair>();
   }
   
   public void update()
   {
     System.out.println("Updating user...");
   }
 
 }