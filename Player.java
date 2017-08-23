/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Cedryk
 */
public class Player implements Comparable{
    private int id;
    private String playerName;
    private Map<Integer, ArrayList<Kill>> kills;
    private int nKills;
    private int punicao;

    public Player(int id, String playerName) {
        this.id = id;
        this.playerName = playerName;
        this.punicao = 0;
        this.nKills = 0;
        this.kills = new HashMap<>();
       
    }
    
    public void addKill(int meansOfDeathId, int deadPlayerId){
        ArrayList<Kill> killsAux;
        if(kills.containsKey(meansOfDeathId)){
            killsAux = kills.get(meansOfDeathId);
            killsAux.add(new Kill(meansOfDeathId, deadPlayerId));
        }
        else{
            killsAux = new ArrayList<>();
            killsAux.add(new Kill(meansOfDeathId, deadPlayerId));
            kills.put(meansOfDeathId, killsAux);
        }
        nKills++;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }    
    
    public void addPunicao(){
        this.punicao++;
    }

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getNumeroKills() {
        return (nKills-punicao);
    }

    public Map<Integer, ArrayList<Kill>> getKills() {
        return kills;
    }

    @Override
    public String toString() {
        return playerName + ": " + getNumeroKills();
    }

    @Override
    public int compareTo(Object o) {
        Player p2 = (Player) o;
        return -(this.getNumeroKills()- p2.getNumeroKills());
    }
}
