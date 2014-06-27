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
  public GameMap gameMap;
  
  // hard coding update rule:
  //private double [] defaultResourcePrice;  

  public Market(Storage s, GameMap m)
  {
    this.resourceMap = s.resourceMap;
	this.distMap = s.distMap;
	this.degMap = s.degMap;
	this.cityDic = s.cityDic;
	this.resourceDic = s.resourceDic;
	this.gameMap = m;
	marketBoard = new double[resourceDic.size()][cityDic.size()];
	quantityBoard = new int[resourceDic.size()][cityDic.size()];
    
    // set default resource price
    for(int i=0;i<resourceDic.size();i++)
	{
	  double p = resourceDic.get(i).price;
	  for(int j=0;j<cityDic.size();j++)
	  {
		  // **Now set 1.1 * price each degree away from original city
		  marketBoard[i][j] = p + (p * (1 - gameMap.tileMap.get(cityDic.get(j).x).get(cityDic.get(j).y).resourceIndex[i]));         		  
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
  
    for(int i=0;i<resourceDic.size();i++)
	{
	  for(int j=0;j<cityDic.size();j++)
	  {
	      double p = marketBoard[i][j];
		  Tile t = gameMap.tileMap.get(cityDic.get(j).x).get(cityDic.get(j).y);
		  // updating price
		  marketBoard[i][j] = (p * (1 - (t.resourceIndex[i]) + t.resourceDemand[i]));         		  
	  }
	}	
	
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