/**
 
 **/
 //package GameLogic;
 
 
 public abstract class Commodity implements Serializable
 {
   String name;
   double price;
   int lowClassIndex;
   int midClassIndex;
   int hiClassIndex;
   
   // status of commodity; true = available, vise versa.  
   boolean active;
 }