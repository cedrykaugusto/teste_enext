/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Cedryk
 */
public class Game {
    private static int contId = 0;
    private int id;
    private int totalKills;
    private Map<Integer, Player> players;
    
    //Map<meansOfDeath, deadPlayerId>
    private Map<Integer, Integer> killsWorld;

    public Game() {
       //atualiza id e incrementa contador
       id = contId++;
       players = new HashMap<>();
       killsWorld = new HashMap<>();
    }
    
    public void addPlayers(int playerId, String playerName){
        if(!players.containsKey(playerId)){
            players.put(playerId, new Player(playerId, playerName));
        }
    }
    
    public void addKillToWorld( int meansOfDeathId, int deadPlayerId){
        killsWorld.put(meansOfDeathId, deadPlayerId);
        players.get(deadPlayerId).addPunicao();
        totalKills++;
    }
    
    public void addKillToPlayer(int killerId, int meansOfDeathId, int deadPlayerId){
        players.get(killerId).addKill(meansOfDeathId, deadPlayerId);
        totalKills++;
    }
    
    public int getId() {
        return id;
    }

    public int getTotalKills() {
        return totalKills;
    }

    public Map<Integer, Player> getPlayers() {
        return players;
    }

    public Map<Integer, Integer> getKillsWorld() {
        return killsWorld;
    }

    @Override
    public String toString() {
        String output = "";
        output += "Game " + id + "{\n" + "    totalKills: " + totalKills + "\n" + "    players: [";
        Iterator it;
        //percorrer para encontrar nomes dos jogadores
        it = players.keySet().iterator();
        if(it.hasNext()) output += players.get(it.next()).getPlayerName();
        while(it.hasNext()){
            output += ", " + players.get(it.next()).getPlayerName();
        }
        output += "]\n";
        output += "    Kills: {\n";
        //percorrer para encontrar mortes por jogador
        it = players.keySet().iterator();
        if(it.hasNext()) output += "        " + players.get(it.next()).toString();
        while(it.hasNext()){
            output += ",\n        " + players.get(it.next()).toString();
        }
        output += "\n    }\n}";
        return output;
    }
    
    
}
