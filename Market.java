import java.io.*;
import java.util.*;

public class Market implements Serializable
{
  private int [][] quantityBoard;
  private double [][] marketBoard;
  private int [][] resourceMap;
  private int [][] distMap;
  private int [][] degMap;
  private ArrayList<City> cityDic;
  private ArrayList<Resource> resourceDic;
  
  // hard coding update rule:
  //private double [] defaultResourcePrice;  

  public Market(Storage s)
  {
    this.resourceMap = s.resourceMap;
	this.distMap = s.distMap;
	this.degMap = s.degMap;
	this.cityDic = s.cityDic;
	this.resourceDic = s.resourceDic;
	marketBoard = new double[resourceDic.size()][cityDic.size()];
	quantityBoard = new int[resourceDic.size()][cityDic.size()];
    
    // set default resource price
    for(int i=0;i<resourceMap.length;i++)
	{
	  double p = resourceDic.get(i).price;
	  for(int j=0;j<resourceMap[i].length;j++)
	  {
	    if(resourceMap[i][j]==0)
		{
		  marketBoard[i][j] = p; 
		}
		else
		{
		  // **Now set 1.1 * price each degree away from original city
		  marketBoard[i][j] = p + p * 0.1 * resourceMap[i][j];
		}
	  }
	}	
  }
  
  public int getGoodQuantity(City city, Resource resource)
  {
    return quantityBoard[getResource(resource)][getCity(city)];
  }
  
  public double getMarketPrice(City city, Resource resource)
  {
    return marketBoard[getResource(resource)][getCity(city)];
  }
  
  public void update()
  {
    
  }
  
  private int getCity(City city)
  {
    Integer v = cityDic.indexOf(city);

	return (int) v; 	 
  }
   
  private int getResource(Resource resource)
  {
    Integer v = resourceDic.indexOf(resource);

	return (int) v; 	 
  }
  
}