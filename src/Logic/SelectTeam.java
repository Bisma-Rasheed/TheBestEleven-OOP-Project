/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import java.util.Random;

/**
 *
 * @author Saad Communication
 */
public class SelectTeam extends playerdata{
    int[] h={0,0,0,0,0,0,0,0,0,0,0};
    int k=0;
    Random select=new Random();  //randomly selects a number
    public void TeamsCreation(playerdata[] players,playerdata[][] array) //randomly creates 50 teams
    {   
        for(int j=0;j<50;j++)
        {
            for(int i=0;i<11;i++)
            {
                if(this.h[i]!=this.k)
                {
                    this.k=select.nextInt(50);
                    for(int s=0;s<11;s++)
                    {
                      if(this.h[s]==this.k)
                      {
                           repeat();
                      }
                    } 
                }
                
                else
                {
                    repeat();
                }
                
                System.arraycopy(players[this.k].strdata, 0, array[i][j].strdata, 0, 6);
                System.arraycopy(players[this.k].intdata, 0, array[i][j].intdata, 0, 3);
                System.arraycopy(players[this.k].floatdata, 0, array[i][j].floatdata, 0, 5);
                this.h[i]=this.k;
                }
            }
    }
    
    public void repeat() //prevents repeatition of players in a team
    {
        this.k=select.nextInt(50);
        for(int i=0;i<11;i++)
        {
        if(this.h[i]==this.k)
        {
            repeat();   //Recursion occurs if the same random number as the previous one is selected
        }
        }
    }
    }