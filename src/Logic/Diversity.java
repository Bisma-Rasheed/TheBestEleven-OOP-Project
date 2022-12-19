/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Saad Communication
 */
public class Diversity extends playerdata{
    
    final int[] Pacers =new int[50]; //for total number of fast bowlers in a team
    final int[] Spinners=new int[50]; //for total number of spin bowlers in a team
    final double[] Diversity=new double[50]; //for diversity of 50 teams
    
    public void count(playerdata[][] array) //counts fast and spin bowlers in a team
    {
        for(int i=0;i<50;i++)
        {
            int sum=0,sum1=0;
        for(int j=0;j<11;j++)
        {  
        if( null == array[j][i].strdata[3])     //strdata[3]->Bowling Style
        {
        }
        else switch (array[j][i].strdata[3]) {
                case "Pace":
                    sum=sum+1;
                    this.Pacers[i]=sum;
                    break;
                case "Spin":
                    sum1=sum1+1;
                    this.Spinners[i]=sum1;
                    break;
                default:
            }
    }
        }
    }
    
    public void Diversity() //calculates diversity of 50 teams
    {
        for(int i=0;i<50;i++)
        {
            this.Diversity[i]=10*this.Pacers[i]*this.Spinners[i]; //Diversity=no.Of pacers*no. of spinners (in a team)
        }
    }
    
}
