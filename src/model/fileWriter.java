/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import Logic.playerdata;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Roshaan
 */
public class fileWriter{
    static public void noOfIterations(int number) throws IOException{
        File path = new File("src\\files\\PlayersFiles\\iterations.txt");
        FileWriter write = new FileWriter(path);
        BufferedWriter writer = new BufferedWriter(write);
        writer.write(number + "");
        writer.close();
    }
    static public void createPlayerFile(playerdata player, int playerNumber) throws IOException{
        File path = new File("src\\files\\PlayersFiles\\"+playerNumber+".txt");
        FileWriter write = new FileWriter(path);
        BufferedWriter writer = new BufferedWriter(write);
        for (int i = 0; i < 6; i++) {
            writer.write(player.strdata[i]);
            writer.newLine();
        }
        for (int i = 0; i < 3; i++) {
            writer.write(player.intdata[i] + "");
            writer.newLine();
        }
        for (int i = 0; i < 5; i++) {
            writer.write(String.valueOf(player.floatdata[0]));
            writer.newLine();
        }
        for (int i = 0; i < 24; i++) {
            writer.write(player.strdata2[i]);
            writer.newLine();
        }
        writer.close();
    }
}