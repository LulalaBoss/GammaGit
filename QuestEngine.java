 import java.util.*;

 public class QuestEngine
 {
   private Storage storage;
 
   public QuestEngine(Storage s)
   {
     System.out.println("initializing quest engine");
     storage = s;
   }
 
   public ArrayList<String> generate()
   {
     ArrayList<String> list = new ArrayList<String>();
	 list.add("test string");
     return list;
   }
 } 