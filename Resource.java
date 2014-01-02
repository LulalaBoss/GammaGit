/**
 
 **/
 //package GameLogic;

 
 public class Resource
 {
   /** Parameters:
    **   lci: low class index
	**   mci: middle class index
	**   hci: high class index
    **/
   
   public String name;
   public double price;
   public int lowClassIndex;
   public int midClassIndex;
   public int hiClassIndex;
   
   // status of commodity; true = available, vise versa.  
   public boolean active;
   
   public Resource(String s, int lci, int mci, int hci, double p)
   {
     name = s; 
     price = p;
     lowClassIndex = lci;
     midClassIndex = mci;
     hiClassIndex = hci;	 
   }
   
 }