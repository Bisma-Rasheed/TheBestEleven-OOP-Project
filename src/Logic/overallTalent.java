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
public class overallTalent extends playerdata{
    
    double[] OverallTalentTeam=new double[50];
    int[] numberofBowlers = new int[50]; //number of bowlers in a team (for 50 teams)
    int[] numberofBatsman = new int[50]; //number of batsman in a team (for 50 teams)
    int[] numberofKeepers = new int[50]; //number of wicket keepers in a team (for 50 teams)
    
    public void setRating(playerdata[][] array)  /*sets rating of each player based on his bowling talent
                                                   if bowling talent is greater than 5 then rating is 10 otherwise it is 2 */
    {
        for(int i=0;i<50;i++)
        {
            for(int j=0;j<11;j++)
            {
               
        if(array[j][i].floatdata[0]>5) //floatdata[0]->Bowling Talent
        {
            array[j][i].Rating=10;  //Rating of a player according to his bowling talent
        }
        else
        {
            array[j][i].Rating=2;
        }
    }
        }
    }
    public void overallTalent(playerdata[][] array) //calculates overall talent of each player using formula
    {
        for(int i=0;i<50;i++)
        {
            for(int j=0;j<11;j++)
            {
        array[j][i].OverallTalent= 50-array[j][i].intdata[2]+array[j][i].Rating*array[j][i].floatdata[0]+10*array[j][i].floatdata[1]+5*array[j][i].floatdata[2]+3*array[j][i].floatdata[4]+2*array[j][i].floatdata[3];
        /*Overall Talent of player=50-Age+Rating*Bowling Talent+10*Batting Talent+5*Fielding+3*Keeping Talent+2*Flexibility  */
    }
        }
    }
    
    public void overallTalentTeam(playerdata[][] array) //calculates overall talent of 50 teams
    {
        for(int i=0;i<50;i++)
        {
            double sum=0;
            int k=1;
            for(int j=0;j<11;j++)
            {
                sum=sum+(array[j][i].OverallTalent)*k;
                this.OverallTalentTeam[i]=sum;  //OverallTalent of team=(sum of overall talent of all players)player number(1 to 11)
                k++;
            }
    }
    
    
}
    public void Penalty(playerdata[][] array)
    {
        for(int i=0;i<50;i++)
        {
            int sum=0,sum1=0,sum2=0;
            for(int j=0;j<11;j++)
            {
                
                if("Bowler".equals(array[j][i].strdata[1]))  //strdata[1]->playing role
                {
                    sum=sum+1;
                    this.numberofBowlers[i]= sum; //calculates number of bowlers in a team (for 50 teams)
                }
                else if("Batsman".equals(array[j][i].strdata[1]) || "AllRounder".equals(array[j][i].strdata[1]))
                {
                    sum1=sum1+1;
                    this.numberofBatsman[i]=sum1;  //calculates number of batsmen in a team (for 50 teams)
                }
                else if("Wicket Keeper".equals(array[j][i].strdata[1]))
                {
                    sum2=sum2+1;
                    this.numberofKeepers[i]=sum2;  //calculates number of wicket keepers in a team (for 50 teams)
                }
            }
        }
        
        //Penalty Calculation
        for(int i=0;i<50;i++)
        {
            if(this.numberofBowlers[i]<4 && this.numberofBatsman[i]<5 && (this.numberofKeepers[i]!=1 || this.numberofKeepers[i]>1))
            {
                this.OverallTalentTeam[i]=this.OverallTalentTeam[i]-100;  //Penalty = 100 - Overall Talent of Team (for 50 teams)
            }
        }
    }
    
}
