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
public class Dexterity {
        
     double[] Dexterity=new double[50]; //for dexterity of 50 teams
     int[] LeftHanded=new int[50]; //for number of left handed batsmen and bowlers in a team
     int[] RightHanded=new int[50]; //for number of right handed batsmen and bowlers in a team
     int[] Ambidextrous=new int[50]; //for those players who bat from one side and bowl from other

    public void count(playerdata[][] array) //counts number of lefthanded, righthanded and ambidextrous players
    {
        for(int i=0;i<50;i++)
        {
            int sum=0,sum1=0,sum2=0;
            for(int j=0;j<11;j++)
            {
        if(!"Left".equals(array[j][i].strdata[4]) || !"Left".equals(array[j][i].strdata[5])) /*strdata[4]->Bowling side
                                                                                             strdata[5]->Batting Side*/
            if ("Right".equals(array[j][i].strdata[4]) && "Right".equals(array[j][i].strdata[5]))
            {
                sum=sum+1;
                this.RightHanded[i]=sum;
            }
            else
            {
                sum1=sum1+1;
                this.Ambidextrous[i]=sum;
                
            }
        else {
            sum2=sum2+1;
            this.LeftHanded[i]=sum;
                }
    }
        }
    }
  
    /**
     *
     */
    public void Dexterity() //calculates dexterity of 50 teams
    {
        for(int i=0;i<50;i++)
        {
            for(int j=0;j<11;j++)
            {
                this.Dexterity[i]= (this.LeftHanded[i]*this.RightHanded[i]*3)+(this.Ambidextrous[i]*2);
                /* Dexterity=(no. of lefthanded players*no. of righthanded players*3)+(no. of ambidextrous players*2) */
            }
    }
}
    
}
