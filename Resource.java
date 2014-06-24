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
   public int id;
   public double price;
   public int lowClassIndex;
   public int midClassIndex;
   public int hiClassIndex;
   
   // tag indicates whether this is an essential resource for city or not
   public boolean isEssential;
   
   // status of commodity; true = available, vise versa.  
   public boolean active;
   
   public Resource(String s, String id, int lci, int mci, int hci, double p, boolean ie)
   {
     name = s;
     this.id = Integer.parseInt(id);	 
     price = p;
     lowClassIndex = lci;
     midClassIndex = mci;
     hiClassIndex = hci;
     isEssential = ie;	 
   }
   
 }