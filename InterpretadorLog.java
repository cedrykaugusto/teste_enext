/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Game;

/**
 *
 * @author Cedryk
 */
public class InterpretadorLog {
    private BufferedReader in;
    private  ArrayList<Game> games;
    private StringTokenizer st;
    private String delimiter = " \\";

    public InterpretadorLog(BufferedReader in) {
        this.in = in;
        games = new ArrayList<>();
    }
    
    public void start(){
        try {
            String line = in.readLine();
            String token = "";
            while(line != null){
                st = new StringTokenizer(line, delimiter);
                while(st.hasMoreTokens()){
                    System.out.println("stop");
                    token = st.nextToken();
                }
                line = in.readLine();
            }            
            
        } catch (IOException ex) {
            Logger.getLogger(InterpretadorLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
