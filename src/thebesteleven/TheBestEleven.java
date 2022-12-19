/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebesteleven;

import Logic.Dexterity;
import Logic.Diversity;
import Logic.Partnership;
import Logic.RBW;
import Logic.SelectTeam;
import Logic.overallTalent;
import Logic.playerdata;
import Logic.selectionCriteria;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.FileReader;
import model.names;

/**
 *
 * @author hk_th
 */
public class TheBestEleven extends Application {
    
        static playerdata[][] Teams = new playerdata[11][50];   //Matrix of 11*50 for 50 Teams containing 11 players each
        public static playerdata[] Players=new playerdata[70];       //Array of 50 players to store data of 50 players from files
        public static playerdata Cricketer = new playerdata(); //obeject of type playerdata declared for writing purpose
        
       
        public static void main(String[] args) throws IOException {
            
            names n=new names(); //object of name type to store names of players read from files to be passed into observable list later
            algorithmImplementation(); //calls the function thst implements the algorithm
            launch(args);        
        
        }
        
        public static void algorithmImplementation() throws IOException
        {
           
        int totalTeams=50,noOfplayers=11;   //noOfplayers-->Number of players in each team
        
        for(int i=0;i<totalTeams;i++)
        {
            for(int j=0;j<noOfplayers;j++)
            {
                Teams[j][i]=new playerdata();  //to initialize a 2D array of object type
            }
        }
        
        int totalPlayers=70; //to store total number of players to be displayed, initially taken as 100 to intialize the array of Players
        for(int i=0;i<totalPlayers;i++)
        {
            Players[i]=new playerdata();   //to intialize 1D array of object type
        }
        
        FileReader Files=new FileReader();  //object of file type for reading files of 50 player
        totalPlayers = Files.noOfIterations(); //stores total number of players read from file
        Files.readFiles(Players, totalPlayers);  //Reads files from the provided path and store them in array of Players
        SelectTeam generateTeams=new SelectTeam();
        generateTeams.TeamsCreation(Players, Teams); /*generates Teams of 11 player each of diff. combinations
                                                       from array of 50 players */
        
        Dexterity dexterityOfteams=new Dexterity();
        dexterityOfteams.count(Teams);
        dexterityOfteams.Dexterity();     //calculates dexterity of 50 teams 
        
        Diversity diversityOfteams=new Diversity();
        diversityOfteams.count(Teams);
        diversityOfteams.Diversity();     //calculates diversity of 50 teams
        
        Partnership partnershipOfteams=new Partnership();
        partnershipOfteams.partnership(Teams);   //calculates total partnerships of 50 teams
        
        RBW rbwOfteams=new RBW();
        rbwOfteams.Mean(Teams);
        rbwOfteams.RBWTeam();         //calculates running between the wickets of 50 teams  
        
        overallTalent overallTalentofTeams=new overallTalent();
        overallTalentofTeams.setRating(Teams);  //sets rating of each player according to his bowling talent
        overallTalentofTeams.overallTalent(Teams);  //calculates overall talent of each player of all the 50 teams
        overallTalentofTeams.overallTalentTeam(Teams);  //calculates overall talent of each team 
        overallTalentofTeams.Penalty(Teams);   /*if a team doesn't have min. 4 bowlers, 5 batsmen and atleast 1 wicket keeper
                                                 then it deducts 100 points from the overall talent of the team */
        
        selectionCriteria bestTeamselection = new playerdata();
        bestTeamselection.TeamFitness(overallTalentofTeams, dexterityOfteams, rbwOfteams, diversityOfteams, partnershipOfteams);
        bestTeamselection.Selection();  //checks which team has the highest fitness value
        bestTeamselection.BestTeam();   //returns the index number of best team which has the highest fitness value
        bestTeamselection.TeamDisplay(Teams, bestTeamselection);   /*displays the players of the best team generated including
                                                               statistics of each player*/
        }
    
    static Stage stg;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("The BEST ELEVEN");
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        
        Scene scene = new Scene(root);
        TheBestEleven.stg=stage;
        stg.setScene(scene);
        stg.getIcons().add(new Image("/files/icon.png"));
        stg.show();
        
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    
    
}
