/**

 **/
 //package GameLogic;
 
 import java.util.*;
 
 public class ProductionRule implements Serializable extends Rule
 {
   private Resource specialized;
 
   public ProductionRule(String special)
   {
     Name = special;
	 specialized = new Resource(special, 0);
	 System.out.println("NO");
   }  
   
 
 }