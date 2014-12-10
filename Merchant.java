import java.io.*;
import java.util.*;

public class Merchant implements Serializable
{
  private String name;
  public int localeX;
  public int localeY;
  public int location;
  
  public ArrayList<City> knowledgeCity;
  public ArrayList<Resource> knowledgeCommodity;
  
  public ArrayList<Resource> cargo;
  
  public Merchant(String n, int x, int y, int loc, ArrayList<City> city, ArrayList<Resource> commodity)
  {
    name = n;
	localeX = x;
	localeY = y;
	location = loc;
	knowledgeCity = city;
	knowledgeCommodity = commodity;
	
	cargo = new ArrayList<Resource>();
  }
  
  public String getName(){ return name; }

}