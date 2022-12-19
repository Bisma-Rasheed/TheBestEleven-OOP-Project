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
public class Partnership {
    
    int[] Partnership=new int[50];
    
    public void partnership(playerdata[][] array) //calculates total partnership of a team
    {
        for(int i=0;i<50;i++)
        {
            int sum=0;
            for(int j=0;j<10;j++)
            {
                if(array[j][i].strdata[2].equals(array[j+1][i].strdata[0])) //strdata[2]->Partnershipwith strdata[0]->playername
                {
                    sum=sum+array[j][i].intdata[1];  //intdata[1]-> BestPartnership
                    this.Partnership[i]=sum;
                }
            }
            
        }
        
    }
    
}
