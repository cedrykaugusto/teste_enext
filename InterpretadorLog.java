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
    private final BufferedReader in;
    private  ArrayList<Game> games;
    private StringTokenizer st;
    private StringTokenizer stPlayerName;
    private final String delimiter = " :";
    private Game gameAtual;

    public InterpretadorLog(BufferedReader in) {
        this.in = in;
        games = new ArrayList<>();
    }
    
    public void start(){
        int killerId;
        int deadPlaeyrId;
        int meansOfDeathId;
        try {
            String line = in.readLine();
            String token = "";
            while(line != null){
                st = new StringTokenizer(line, delimiter);
                while(st.hasMoreTokens()){
                    token = st.nextToken();
                    //iniciar game
                    if(token.equals("InitGame")){
                        if(gameAtual != null){
                            games.add(gameAtual);
                            //System.out.println(gameAtual.toString()+ "\n");
                            gameAtual = new Game();
                        }
                        else{
                            gameAtual = new Game();
                        }                        
                        break;
                    }
                    //finalizar game
                    else if(token.equals("ShutdownGame")){
                        games.add(gameAtual);
                        //System.out.println(gameAtual.toString()+ "\n");
                        gameAtual = null;
                        break;
                    }
                    //add jogador
                    else if(token.equals("ClientUserinfoChanged")){
                        int playerId = Integer.parseInt(st.nextToken());
                        String playerName = "";
                        stPlayerName = new StringTokenizer(line, "\\");
                        stPlayerName.nextToken();
                        playerName = stPlayerName.nextToken();
                        if(!gameAtual.getPlayers().containsKey(playerId)){
                            gameAtual.addPlayers(playerId, playerName);                           
                        }
                        else{
                            if(!gameAtual.getPlayers().get(playerId).getPlayerName().equals(playerName)){
                                gameAtual.getPlayers().get(playerId).setPlayerName(playerName);
                            }
                        }
                         break;
                    }
                    //add kill
                    else if(token.equals("Kill")){
                        killerId = Integer.parseInt(st.nextToken());
                        deadPlaeyrId = Integer.parseInt(st.nextToken());
                        meansOfDeathId = Integer.parseInt(st.nextToken());
                        if(killerId != 1022){
                            gameAtual.addKillToPlayer(killerId, meansOfDeathId, deadPlaeyrId);
                        }
                        else{
                            gameAtual.addKillToWorld(meansOfDeathId, deadPlaeyrId);
                        }                        
                        break;                    
                    }
                }
                line = in.readLine();
            }
        } 
        catch (IOException ex) {
            Logger.getLogger(InterpretadorLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
