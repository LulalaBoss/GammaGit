/**
 
 **/
 //package GameLogic;

 
 public class Resource extends Commodity
 {
   /** Parameters:
    **   lci: low class index
	**   mci: middle class index
	**   hci: high class index
    **/
   public Resource(String s, int lci, int mci, int hci, double p)
   {
     name = s; 
     price = p;
     lowClassIndex = lci;
     midClassIndex = mci;
     hiClassIndex = hci;	 
   }
   
 }