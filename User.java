/**
   This class is called "User" for now; it is actually "Guild"
 **/
 //package GameLogic;
 import java.io.*;
 import java.util.*;
 
 public class User implements Serializable
 {
   public double money;
   public int localeX;
   public int localeY;
   public int location;
   public ArrayList<Resource> cargo;
   public ArrayList<Merchant> merchant;
 
   public User()
   {
     System.out.println("Initializing user...");
	 // set initial money to 1000
	 money = 1000;
	 
	 cargo = new ArrayList<Resource>();
	 merchant = new ArrayList<Merchant>();
	 
		 
	 // set default player location
	 localeX = 1;
	 localeY = 2;
	 location = 0;
   } 
   
   public void update()
   {
     System.out.println("Updating Guild...");
	 
	 /* maintenance cost */
	 money = money - (merchant.size() * 10);
   }     
 
 }