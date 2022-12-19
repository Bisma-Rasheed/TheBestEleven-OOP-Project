/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Logic.playerdata;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static thebesteleven.TheBestEleven.Players;
import static model.names.names;

/**
 *
 * @author Saad Communication
 */
public class FileReader {
  
    public int noOfIterations() throws FileNotFoundException, IOException{
        int totalPlayers=0;
        File file = new File("src\\files\\PlayersFiles\\iterations.txt");
        java.io.FileReader fileReader = new java.io.FileReader(file);  //stores path of the file in fileReader
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            totalPlayers = Integer.parseInt(bufferedReader.readLine());
        }
        return totalPlayers;
    }
    public void readFiles(playerdata[] array, int totalPlayers) throws FileNotFoundException, IOException{
          for (int i=0;i<totalPlayers;i++){
          try{
                File file = new File("src\\files\\PlayersFiles\\"+i+".txt");
                java.io.FileReader fileReader = new java.io.FileReader(file);  //stores path of the file in fileReader
              try (BufferedReader bufferedReader = new BufferedReader(fileReader) /*stores the whole file read from the path
              in buffered reader*/ ) {
                  for(int j=0;j<6;j++)
                  {
                      array[i].strdata[j]=bufferedReader.readLine();  //stores string data
                  }
                  for(int j=0;j<3;j++)
                  {
                      array[i].intdata[j]=Integer.parseInt(bufferedReader.readLine());//reads string data and stores integer data
                  }
                  for(int j=0;j<5;j++)
                  {
                      array[i].floatdata[j]=Double.parseDouble(bufferedReader.readLine());//reads string data and stores floatdata
                  }
                  for(int j=0;j<24;j++)
                  {
                      array[i].strdata2[j]=bufferedReader.readLine();  //stores string data
                  }
              }
               
            }
            
            catch (java.io.IOException e)  {
            System.out.println("Error: "+e);   
            }        
        }
          for(int i=0;i<totalPlayers;i++)
          {
              names[i]=Players[i].strdata[0];  //stores names of all players in the array names.
          }
          
          
    }
 
}