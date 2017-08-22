/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cedryk
 */
public class Game {
    private static int contId = 0;
    private int id;
    private int totalKills;
    private Map<String, Player> players;
    private ArrayList<Kill> killsWorld;

    public Game() {
       //atualiza id e incrementa contador
       id = contId++;
       players = new HashMap<>();
       killsWorld = new ArrayList<>();
    }
    
    public void addPlayers(int id, String player){
        if(!players.containsKey(player)){
            players.put(player, new Player(id, player));
        }
    }
    
    public void addKillToWorld(String deadPlayer, String motivo){
        killsWorld.add(new Kill(deadPlayer, motivo));
        totalKills++;
    }
    
    public void addTotalKills(){
        totalKills++;
    }

    public int getId() {
        return id;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public ArrayList<Kill> getKillsWorld() {
        return killsWorld;
    }    
}
