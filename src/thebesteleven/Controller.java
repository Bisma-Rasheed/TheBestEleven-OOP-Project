/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebesteleven;


import java.io.IOException;
import java.net.URL;
import javafx.scene.layout.AnchorPane;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.ProgressIndicator;
import model.FileReader;
import static thebesteleven.TheBestEleven.stg;
import static Logic.playerdata.playerNames;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import static model.names.names;
import model.fileWriter;
import static thebesteleven.TheBestEleven.Players;
import static thebesteleven.TheBestEleven.Cricketer;
import static thebesteleven.TheBestEleven.algorithmImplementation;

/**
 * FXML Controller class
 *
 * @author hk_th
 */
public class Controller implements Initializable {
    @FXML
   private Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    
    @FXML
   private ImageView img1,img2,img3,img4,img5;
    
     @FXML
     private ListView<String> lst1,lst2;
   ObservableList<String> lst = FXCollections.observableArrayList(names);
   ObservableList<String> lst3 = FXCollections.observableArrayList(playerNames);
   
     @FXML
   AnchorPane ap1,ap2;
     
     @FXML
   ProgressIndicator pg1;
     
     
   
           
     
    
     /**
     * initializes the controller class.
     * @param url
     * @param resource
     */
    @Override
    public void initialize(URL url, ResourceBundle resource) {
        
        // TODO
        
        
       
    }    
    //------------------------------Home------------------------------//
    
     
    @FXML
    private void exitApp() {
        System.exit(0);
    }
    
   @FXML
    private void mouseEnter1()
    {
        img1.setScaleX(1.2);
        img1.setScaleZ(1.2);
        img1.setScaleY(1.2);
        l1.setText("Add");
        l2.setText("Player");
       fade(l1);
       fade(l2);

      }
    @FXML
    private void mouseEnter2()
    {   
        img2.setScaleX(1.2);
        img2.setScaleZ(1.2);
        img2.setScaleY(1.2);
       l3.setText("Browse");
        l4.setText("Player");
        fade(l3);
       fade(l4);
      
    }
     @FXML
    private void mouseEnter3()
    {
        img3.setScaleX(1.2);
        img3.setScaleZ(1.2);
        img3.setScaleY(1.2);
        l5.setText("Generate");
        l6.setText("Team");
        fade(l5);
       fade(l6);
    }
     @FXML
    private void mouseEnter4()
    {  
        
       img4.setScaleX(1.4);
       img4.setScaleY(1.4);
       img4.setScaleZ(1.4);
       l7.setText("Exit");
       fade(l7);
      }
     
    @FXML
    private void mouseExit1()
    {
        img1.setScaleX(1);
        img1.setScaleZ(1);
        img1.setScaleY(1);
        l1.setText("");
        l2.setText("");
        
    }
    @FXML
     private void mouseExit2()
    {   
        img2.setScaleX(1);
        img2.setScaleZ(1);
        img2.setScaleY(1);
         l3.setText("");
        l4.setText("");
    }
    
    
    @FXML
     private void mouseExit3()
    {
        img3.setScaleX(1);
        img3.setScaleZ(1);
        img3.setScaleY(1);
        l5.setText("");
        l6.setText("");
    } 
     @FXML
    private void mouseExit4()
    {   img4.setScaleX(1);
        img4.setScaleZ(1);
        img4.setScaleY(1);
       
        l7.setText("");
    }
   
     @FXML
      private void mouseClick1() throws IOException
         {
            stg.hide();
            Parent root = FXMLLoader.load(getClass().getResource("AddPlayer.fxml"));
       
        Scene scene = new Scene(root);
             
        stg.setScene(scene);
        stg.show();
        
         }
      
              //----------------------Add Player-----------------------------//
      
      
    @FXML
    TextField t26,t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,t40,t41,t42,t43,t44,t45,t46,t47,t48;
    @FXML
    ChoiceBox cb1,cb2,cb3;
    @FXML
    CheckBox chkb1;
    
    @FXML    
    ObservableList<String> batStyle= FXCollections.observableArrayList("Left-hand bat","Right-hand bat");
    ObservableList<String> bowlStyle= FXCollections.observableArrayList("Right-Arm Medium","Right-Arm Fast Medium","Legbreak","Off-Spin","Right-Arm Offbreak","Left-Arm Offbreak","Left-Arm Fast");
    ObservableList<String> playStyle= FXCollections.observableArrayList("Batsman","Bowler","All-Rounder");
    
    
     @FXML
    public void battingStyle(){
        
         cb1.setValue("");
         cb1.setItems(playStyle);
         cb2.setValue("");
         cb2.setItems(batStyle);
         cb3.setValue("");
        cb3.setItems(bowlStyle);
     }
    
      
     
      @FXML
    private void checkBoxSet()
    { if (cb1.getSelectionModel().getSelectedItem()=="Bowler")
     {
        chkb1.setDisable(true);
     }
     if(chkb1.isSelected())
     {
     
         l1.setVisible(false);
         l2.setVisible(false);
         l3.setVisible(false);
         l4.setVisible(false);
         l5.setVisible(false);
         l6.setVisible(false);
         l7.setVisible(false);
         l9.setVisible(false);
         l10.setVisible(false);
         l12.setVisible(true);
         t38.setVisible(false);
         t39.setVisible(false);
         t40.setVisible(false);
         t41.setVisible(false);
         t42.setVisible(false);
         t43.setVisible(false);
         t44.setVisible(false);
         t45.setVisible(false);
         t46.setVisible(false);
         t47.setVisible(true);
     }
     else
     {
     
         l1.setVisible(true);
         l2.setVisible(true);
         l3.setVisible(true);
         l4.setVisible(true);
         l5.setVisible(true);
         l6.setVisible(true);
         l7.setVisible(true);
         l9.setVisible(true);
         l10.setVisible(true);
         l12.setVisible(false);
         t38.setVisible(true);
         t39.setVisible(true);
         t40.setVisible(true);
         t41.setVisible(true);
         t42.setVisible(true);
         t43.setVisible(true);
         t44.setVisible(true);
         t45.setVisible(true);
         t46.setVisible(true);
         t47.setVisible(false);
     }
    
    }
      @FXML
    private void calculateBattingAverage()
    {
        float battingAverage = Integer.parseInt(t31.getText())/Integer.parseInt(t29.getText());
        t33.setText(""+battingAverage);
    }
    
    @FXML
    private void calculateBattingStrikeRate()
    {
       float battingStrikeRate = (Integer.parseInt(t31.getText()) / Integer.parseInt(t28.getText())) * 100;
       t34.setText(""+battingStrikeRate);
    }
    
    @FXML
    private void calculateBowlingAverage()
    {
       float bowlingAverage = Integer.parseInt(t39.getText()) / Integer.parseInt(t38.getText());
       t41.setText(""+bowlingAverage);
    }
    
    @FXML
    private void calculateEconomy()
    {
       float bowlingEconomy = (Integer.parseInt(t39.getText()) / Integer.parseInt(t38.getText())) / 6;
       t42.setText(""+bowlingEconomy);
    }
    
    @FXML
    private void calculateBowlingStrikeRate()
    {
       float bowlingStrikeRate = Integer.parseInt(t38.getText()) / Integer.parseInt(t40.getText());
       t45.setText(""+bowlingStrikeRate);
    }
    
    @FXML
    private void addPlayer() throws IOException
    {
        l13.setText("Player Added..");
         FileReader reader = new FileReader();
         int noOfPlayers;
         noOfPlayers= reader.noOfIterations();
                Cricketer.strdata[0]=t26.getText();
                Cricketer.strdata[1]="Bowler";
                Cricketer.strdata[2] = "Nasir Jamshed";
                Cricketer.strdata[3]="Spin";
                Cricketer.strdata[4] = "Left";
                Cricketer.strdata[5]="Right";
                Cricketer.intdata[0] = 11;
                Cricketer.intdata[1] = 124;
                Cricketer.intdata[2]=25;
                for(int i=0;i<5;i++)
                {
                  Cricketer.floatdata[i] = 9.7;
                }
                Cricketer.strdata2[0]=t27.getText();
                Cricketer.strdata2[1]=(String) cb1.getSelectionModel().getSelectedItem();
                Cricketer.strdata2[2]=(String) cb2.getSelectionModel().getSelectedItem();
                Cricketer.strdata2[3]=(String) cb3.getSelectionModel().getSelectedItem();
                Cricketer.strdata2[4]=t29.getText();
                Cricketer.strdata2[5]=t30.getText();
                Cricketer.strdata2[6]=t31.getText();
                Cricketer.strdata2[7]=t32.getText();
                Cricketer.strdata2[8]=t33.getText();
                Cricketer.strdata2[9]=t28.getText();
                Cricketer.strdata2[10]=t34.getText();
                Cricketer.strdata2[11]=t35.getText();
                Cricketer.strdata2[12]=t35.getText();
                Cricketer.strdata2[13]=t36.getText();
                Cricketer.strdata2[14]=t37.getText();
                Cricketer.strdata2[15]=t38.getText();
                Cricketer.strdata2[16]=t39.getText();
                Cricketer.strdata2[17]=t40.getText();
                Cricketer.strdata2[18]=t43.getText();
                Cricketer.strdata2[19]=t44.getText();
                Cricketer.strdata2[20]=t41.getText();
                Cricketer.strdata2[21]=t42.getText();
                Cricketer.strdata2[22]=t45.getText();
                Cricketer.strdata2[23]=t46.getText();
                
                
                fileWriter.createPlayerFile(Cricketer, noOfPlayers);
                noOfPlayers++;
                fileWriter.noOfIterations(noOfPlayers);
                algorithmImplementation();
                
                
    }
      @FXML
    private void addButtonEnter()
    {
      l11.setScaleX(1.4);
      l11.setScaleY(1.4);
      l11.setScaleZ(1.4);
   
    }
    
      @FXML
    private void addButtonExit()
    {
    l11.setScaleX(1);
    l11.setScaleY(1);
    l11.setScaleZ(1);
    l13.setText("");
    }
     
      @FXML
    private void mouseenter5()
    {  
        
       img5.setScaleX(1.5);
       img5.setScaleY(1.5);
       img5.setScaleZ(1.5);
       l8.setText("Back");
       fade(l8);
      }
     @FXML
    private void mouseexit5()
    {   img5.setScaleX(1);
        img5.setScaleZ(1);
        img5.setScaleY(1);
        l8.setText("");
    }
    
    
      @FXML
      private void mouseclick2(  ) throws IOException
         {
            stg.hide();
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
       
        Scene scene = new Scene(root);
        
        stg.setScene(scene);
        stg.show();
         }
      
    
     
          //----------------------Browse Player-----------------------------//

   
      @FXML
    TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,
             t18,t19,t20,t21,t22,t23,t24,t25;
      
    
    @FXML
    ImageView img6; 
    
    @FXML
      private void clickBrowsePlayer(  ) throws IOException
         { 
            stg.hide();
           
            Parent root = FXMLLoader.load(getClass().getResource("BrowsePlayer.fxml"));
       
        Scene scene = new Scene(root);
        
        stg.setScene(scene);
        
        
        stg.show();
        
         
         }
      
    @FXML
         private void listv() throws IOException{            
       lst1.setItems(lst);
         }
     
     //-------------Profile View------------//
         @FXML
        private void profileView() throws IOException
     {
          ap1.setVisible(true);
          String item = lst1.getSelectionModel().getSelectedItem();
            
          FileReader Files=new FileReader();
        int totalPlayers=0;
        totalPlayers = Files.noOfIterations();
        for(int i=0;i<totalPlayers;i++)
        {
            
          if(item.equals(Players[i].strdata[0]))
        {
           
           t1.setText(Players[i].strdata[0]);
           t2.setText(Players[i].strdata2[0]);
           t3.setText(Players[i].strdata2[1]);
           t4.setText(Players[i].strdata2[2]);
           t5.setText(Players[i].strdata2[3]);
           t6.setText(Players[i].strdata2[4]);
           t7.setText(Players[i].strdata2[5]);
           t8.setText(Players[i].strdata2[6]);
           t9.setText(Players[i].strdata2[7]);
           t10.setText(Players[i].strdata2[8]);
           t11.setText(Players[i].strdata2[9]);
           t12.setText(Players[i].strdata2[10]);
           t13.setText(Players[i].strdata2[11]);
           t14.setText(Players[i].strdata2[12]);
           t15.setText(Players[i].strdata2[13]);
           t16.setText(Players[i].strdata2[14]);
           t17.setText(Players[i].strdata2[15]);
           t18.setText(Players[i].strdata2[16]);
           t19.setText(Players[i].strdata2[17]);
           t20.setText(Players[i].strdata2[18]);
           t21.setText(Players[i].strdata2[19]);
           t22.setText(Players[i].strdata2[20]);
           t23.setText(Players[i].strdata2[21]);
           t24.setText(Players[i].strdata2[22]);
           t25.setText(Players[i].strdata2[23]);
           Image player=new Image("/files/PlayersPics/"+Players[i].strdata[0]+".png");
           img6.setImage(player);
           img6.setVisible(true);
           } 
        }
     }
     
         
     @FXML
        private void profileClear(){
             
           t1.setText("");
           t2.setText("");
           t3.setText("");
           t4.setText("");
           t5.setText("");
           t6.setText("");
           t7.setText("");
           t8.setText("");
           t9.setText("");
           t10.setText("");
           t11.setText("");
           t12.setText("");
           t13.setText("");
           t14.setText("");
           t15.setText("");
           t16.setText("");
           t17.setText("");
           t18.setText("");
           t19.setText("");
           t20.setText("");
           t21.setText("");
           t22.setText("");
           t23.setText("");
           t24.setText("");
           t25.setText("");
           img6.setVisible(false);
              
     }
          
     

         //----------------------Generate Team-----------------------------//

       
      @FXML
      private void clickGenerateTeam(  ) throws IOException
         {
            stg.hide();
            Parent root = FXMLLoader.load(getClass().getResource("GenerateTeam.fxml"));
       
        Scene scene = new Scene(root);
        
        stg.setScene(scene);
        stg.show();
         }
      @FXML
      private void progressEnd()
      {
      pg1.setVisible(false);
      l10.setText("Completed.. Click to view team");
      }
      @FXML
      private void teamView()
      {
          l9.setVisible(true);
      ap2.setVisible(true);
      lst2.setItems(lst3);
      lst2.setVisible(true);
      l10.setVisible(false);
      
      }
      @FXML
        private void profileView1() throws IOException
     {
          // ap2.setVisible(true);
         algorithmImplementation();
          
            String item = lst2.getSelectionModel().getSelectedItem(); 
            
        for(int i=0;i<50;i++)
        {
            
          if(item.equals(Players[i].strdata[0]))
        {
           ap2.setVisible(true);
           
           t1.setText(Players[i].strdata[0]);
           t2.setText(Players[i].strdata2[0]);
           t3.setText(Players[i].strdata2[1]);
           t4.setText(Players[i].strdata2[2]);
           t5.setText(Players[i].strdata2[3]);
           t6.setText(Players[i].strdata2[4]);
           t7.setText(Players[i].strdata2[5]);
           t8.setText(Players[i].strdata2[6]);
           t9.setText(Players[i].strdata2[7]);
           t10.setText(Players[i].strdata2[8]);
           t11.setText(Players[i].strdata2[9]);
           t12.setText(Players[i].strdata2[10]);
           t13.setText(Players[i].strdata2[11]);
           t14.setText(Players[i].strdata2[12]);
           t15.setText(Players[i].strdata2[13]);
           t16.setText(Players[i].strdata2[14]);
           t17.setText(Players[i].strdata2[15]);
           t18.setText(Players[i].strdata2[16]);
           t19.setText(Players[i].strdata2[17]);
           t20.setText(Players[i].strdata2[18]);
           t21.setText(Players[i].strdata2[19]);
           t22.setText(Players[i].strdata2[20]);
           t23.setText(Players[i].strdata2[21]);
           t24.setText(Players[i].strdata2[22]);
           t25.setText(Players[i].strdata2[23]);
           Image player=new Image("/files/PlayersPics/"+Players[i].strdata[0]+".png");
           img6.setImage(player);
           img6.setVisible(true);
           } 
        }
     }
                     //----------Functions-------------//
    
     static void fade(Label x)
        {FadeTransition ft = new FadeTransition(Duration.millis(1000), x);
        
ft.setFromValue(1.0);
ft.setToValue(0.1);
ft.setCycleCount(Timeline.INDEFINITE);
ft.setAutoReverse(true);
ft.play();}
     
     
      
}
