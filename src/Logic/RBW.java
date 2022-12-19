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
public class RBW{
    
    double[] Mean=new double[50];  //Mean Runouts of a team
    int[] RunoutsT=new int[50];   //sum of the runouts of all the players in a team (for 50 teams)
    double[] Summation = new double[50]; //summation of the runouts of a team(formula) (for 50 teams)
    double[] RBW=new double[50]; //running between the wickets of 50 teams
    
    public void Mean(playerdata[][] array) //calculates mean runouts of a team
    {
        for(int i=0;i<50;i++)
        {
         int sum=0;   
        for(int j=0;j<11;j++)
        {
            sum = sum+array[j][i].intdata[0];  //intdata[0]->RunOuts
            this.RunoutsT[i]=sum;
            this.Mean[i]= sum/11;
        }
        
        }
        
        for(int i=0;i<50;i++)
        {
            double sum=0;
            for(int j=0;j<11;j++)
            {
              sum=sum+((this.Mean[i]-this.RunoutsT[i])*array[j][i].intdata[0]);
              /* summation= summation(Mean runouts of team-total runouts of team)*runouts of each player) */
              this.Summation[i]=sum;
            }
        }
    }
        
        public void RBWTeam() //calculates running between the wickets of 50 teams
        {
            for(int i=0;i<50;i++)
            {
               this.RBW[i]=100-this.Summation[i];
            }
        }
    
}
