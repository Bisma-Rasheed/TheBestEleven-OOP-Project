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
public class playerdata extends selectionCriteria{
    
    /**
     *
     */
  double Rating;   //rating of a player based on his bowling talent
  double OverallTalent;   //overall Talent of a player
  public int[] intdata = new int[3];    //stands for Run Outs, Best Partnership, Age
  public double[] floatdata = new double[5];   /*stands for Bowling Talent, Batting Talent,
                                                 Fielding, Flexibility, Keepinh talent*/
  
  
  public String[] strdata=new String[6];  //stands for Name,Category,partnership with, bowling style,bowling side,batting side
  public String[] strdata2 = new String[24];//player stats
  public static String[] playerNames = new String[11]; //array for the names of selected players
  
  
    public playerdata()   //null constructor for class playerdata
    {
        this.strdata[0]="Shahid Afridi";
        this.strdata[1]="Batsman";
        this.strdata[2]="Nasir Jamshed";
        this.strdata[3]="-";
        this.strdata[4]="-";
        this.strdata[5]="Right";
        this.intdata[0]=5;
        this.intdata[1]=213;
        this.intdata[2]=28;
        this.floatdata[0]=0f;
        this.floatdata[1]=7.8;
        this.floatdata[2]=4.5;
        this.floatdata[3]=6.7;
        this.floatdata[4]=0;
    }
    
    @Override //overrides method TeamDisplay of its super class selectionCriteria
    public void TeamDisplay(playerdata[][] array, selectionCriteria s) //displays best team along with its player's stats
   {
       sortingOfteam(array,s);  /*sorts the team according to batting talent
                                  i.e. player with highest batting talent is placed on top and so on*/
       int count=1;
       System.out.println("\n\nThe Best Team According to Best Team Fitness Generated For You Is : ");
       int j=0;
       for(int i=10;i>=0;i--)
       {
           System.out.println("\n"+count+". "+array[i][s.BestTeamNumber].strdata[0]);
           playerNames[j] =  array[i][s.BestTeamNumber].strdata[0]; /*saves player names in reverse order so that
                                                                 player with highest batting talent is on top and so on */
           j++;
           count++;
       }
       System.out.println("\nPlayer Stats Of Each Player In The Team : \n");
       for(int i=10;i>=0;i--)
       {
           for(int k=0;k<6;k++)
           {
               System.out.println(this.Stats[k+0]+" : "+array[i][s.BestTeamNumber].strdata[k]);
           }
           for(int k=0;k<3;k++)
           {
               System.out.println(this.Stats[k+6]+" : "+array[i][s.BestTeamNumber].intdata[k]);
           }
           for(int k=0;k<5;k++)
           {
               System.out.println(this.Stats[k+9]+" : "+array[i][s.BestTeamNumber].floatdata[k]);
           }
           System.out.println("\n");
       }
   }
    
    @Override
    public String toString()
    {
        return "Name : "+this.strdata[0]+"\nCategory : "+this.strdata[1]+"\nPartnership With : "+this.strdata[2]+"\nBest Partnership : "+this.intdata[1];
        
    }
    
}
    