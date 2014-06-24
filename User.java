/**
 
 **/
 //package GameLogic;
 import java.io.*;
 import java.util.*;
 
 public class User implements Serializable
 {
   public double money;
   public int location;
   public ArrayList<Resource> cargo;
 
   public User()
   {
     System.out.println("Initializing user...");
	 // set initial money to 1000
	 money = 1000;
	 
	 cargo = new ArrayList<Resource>();
	 
	 // set default player location
	 location = 0;
   }
   
   public void update()
   {
     System.out.println("Updating user...");
   }     
 
 }