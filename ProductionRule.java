/**

 **/
 //package GameLogic;
 
 import java.util.*;
 
 public class ProductionRule extends Rule
 {
   private Resource specialized;
 
   public ProductionRule(String special)
   {
     Name = special;
	 specialized = new Resource(special);
	 System.out.println("NO");
   }  
   
 
 }