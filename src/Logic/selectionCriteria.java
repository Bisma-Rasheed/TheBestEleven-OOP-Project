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
public class selectionCriteria {
    
    double[] TeamFitness=new double[50];  //to store team fitness of 50 teams
    int[] count=new int[50];   //to check which team is the greatest of all out of 50 teams
    public int BestTeamNumber; //stores the team index of the team having highest fitness value
    final String[] Stats={"Name","Category","Partnership With","Bowling Style","Bowling Side","Batting Side",
                         "Run Outs","Best Partnership","Age","Bowling Talent","Batting Talent","Fielding",
                         "Flexibility","Keeping Talent"};
    
    public void TeamFitness(overallTalent O,Dexterity d, RBW r, Diversity di, Partnership p)
    {
        for(int i=0;i<50;i++)
        {
            this.TeamFitness[i]=O.OverallTalentTeam[i]+d.Dexterity[i]+r.RBW[i]+di.Diversity[i]+p.Partnership[i];
            /*Fitness = Overall Talent of team + Dexterity + Running b/w wickets+ Diversity + Partnership */
        }
    }
    
    public void Selection()  //checks which team has highest fitness value
    {
        for(int i=0;i<50;i++)
        {
            for(int j=i+1;j<50;j++)
            {
                if(this.TeamFitness[i]<TeamFitness[j])
                {
                    count[i]=-1;    /*Selection Sort used, checks which team has the highest fitness value
                    if the current team's(i) fitness value is less than fitness value of atleast one team or more then
                    it assigns -1 to that teams count so in the end we know the team whose count !=-1 has the 
                    greatest fitness value*/
                    break;
                }
            }
        }
        
        
    }
    
    public void BestTeam() //stores the index number of the best team
    {
        int temp=0;
        for(int i=0;i<50;i++)
        {
            if(count[i]!=-1)  //checks which team's count !=-1 and stores the index number of that team for later use
            {
                temp=temp+i;
                break;
            }
        }
        
        this.BestTeamNumber=temp;
        
    }
    
    public void sortingOfteam(playerdata[][] array, selectionCriteria s)  //Selection sort algorithm used
    {
        playerdata temp=new playerdata();
        for(int i=0;i<11;i++)
        {
            for(int j=i+1;j<11;j++)
            {
                if(array[j][s.BestTeamNumber].floatdata[1]<array[i][s.BestTeamNumber].floatdata[1])
                {
                    System.arraycopy(array[i][s.BestTeamNumber].strdata, 0, temp.strdata, 0, 6);
                    System.arraycopy(array[i][s.BestTeamNumber].intdata, 0, temp.intdata, 0, 3);
                    System.arraycopy(array[i][s.BestTeamNumber].floatdata, 0, temp.floatdata, 0, 5);
                    
                    System.arraycopy(array[j][s.BestTeamNumber].strdata, 0, array[i][s.BestTeamNumber].strdata, 0, 6);
                    System.arraycopy(array[j][s.BestTeamNumber].intdata, 0, array[i][s.BestTeamNumber].intdata, 0, 3);
                    System.arraycopy(array[j][s.BestTeamNumber].floatdata, 0, array[i][s.BestTeamNumber].floatdata, 0, 5);
                    
                    System.arraycopy(temp.strdata, 0, array[j][s.BestTeamNumber].strdata, 0, 6);
                    System.arraycopy(temp.intdata, 0, array[j][s.BestTeamNumber].intdata, 0, 3);
                    System.arraycopy(temp.floatdata, 0, array[j][s.BestTeamNumber].floatdata, 0, 5);
                    
                }
            }
        }
    }
    
    /**
     *
     * @param array
     * @param s */
    public void TeamDisplay(playerdata[][] array, selectionCriteria s)
   {
       
   }
    
}
