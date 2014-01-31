 import java.io.*;
 import java.util.*;
 
 public class MarketBoard
 {
   public double[][] priceBoard;
   public int[][] quantityBoard;
 
   public MarketBoard(int resourceNum, int cityNum)
   {
     priceBoard = new double[cityNum][resourceNum];
	 quantityBoard = new int[cityNum][resourceNum];
   }
   
 }