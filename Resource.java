/**
 
 **/
 //package GameLogic;
import java.io.*;
 
 public class Resource implements Serializable
 {
   /** Parameters:
    **   lci: low class index
	**   mci: middle class index
	**   hci: high class index
    **/
   
   public String name;
   public int id;
   public double price;
   
   // tag indicates whether this is an essential resource for city or not
   public boolean isEssential;
   
   // status of commodity; true = available, vise versa.  
   public boolean active;
   
   public Resource(String s, String id, double p, boolean ie)
   {
     name = s;
     this.id = Integer.parseInt(id);	 
     price = p;
     isEssential = ie;	 
   }
   
 }