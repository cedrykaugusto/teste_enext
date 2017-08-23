/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
    //suicidios
    private Map<Integer, Integer> autoKill;
    //comparator to tree

    public Game() {
       //atualiza id e incrementa contador
       id = contId++;
       players = new HashMap<>();
       killsWorld = new HashMap<>();
       autoKill = new HashMap<>();
    }
    
    public void addPlayers(int playerId, String playerName){
        if(!players.containsKey(playerId)){
            players.put(playerId, new Player(playerId, playerName));
        }
    }
    
    public void addKillToWorld( int meansOfDeathId, int deadPlayerId){
        if(killsWorld.containsKey(meansOfDeathId)){
            killsWorld.put(meansOfDeathId, killsWorld.get(meansOfDeathId) + 1);
        }
        else{
            killsWorld.put(meansOfDeathId, 1);
        }
        players.get(deadPlayerId).addPunicao();
        totalKills++;
    }
    
    public void addKillToPlayer(int killerId, int meansOfDeathId, int deadPlayerId){
        if(killerId == deadPlayerId){
            if(autoKill.containsKey(meansOfDeathId)){
                autoKill.put(meansOfDeathId, autoKill.get(meansOfDeathId) + 1);
            }
            else{
                autoKill.put(meansOfDeathId, 1);
            }
            players.get(killerId).addPunicao();
        }
        else{
            players.get(killerId).addKill(meansOfDeathId, deadPlayerId);           
        }
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
    
    public String ranking(){
        String output = "\nRANKING GAME "+ id+ "\n";
        Player p1;
        List<Player> playersAux = new ArrayList<>();
        Iterator it = players.keySet().iterator();
        while(it.hasNext()){
            playersAux.add(players.get(it.next()));
        }
        Collections.sort(playersAux);
        it = playersAux.iterator();
        while(it.hasNext()){
            p1 = (Player) it.next();
            output += p1.toString()+"\n";
        }
        return output;
    }
    
    public String reportDeathByMeans(){        
        Player p1;
        int killIndex;
        int qtdeDeath = 0;
        Map<Integer, Integer> deathByMeans = new HashMap<>();
        Iterator itPlayers = players.keySet().iterator();
        Iterator itKills;
        //verificando kills dos players
        while(itPlayers.hasNext()){
            p1 = players.get(itPlayers.next());
            itKills = p1.getKills().keySet().iterator();
            while(itKills.hasNext()){
                killIndex = (int) itKills.next();
                //se causa ja esta no hashmap, apenas adiciona a quantidade de kills desse jogador
                if(deathByMeans.containsKey(killIndex)){                    
                    deathByMeans.put(killIndex, (deathByMeans.get(killIndex) + p1.getKills().size()));
                }
                //se não esta no hashmap, cria registro inicial
                else{
                    deathByMeans.put(killIndex, p1.getKills().get(killIndex).size());
                }
            }
        }
        //verificando kills do <world>        
        itKills = killsWorld.keySet().iterator();
        while(itKills.hasNext()){
            killIndex = (int) itKills.next();
            //se causa ja esta no hashmap, apenas adiciona a quantidade de kills desse jogador
            if(deathByMeans.containsKey(killIndex)){                    
                deathByMeans.put(killIndex, (deathByMeans.get(killIndex) + killsWorld.get(killIndex)));
            }
            //se não esta no hashmap, cria registro inicial
            else{
                deathByMeans.put(killIndex, killsWorld.get(killIndex));
            }
        }
        //verificando suicidios
        itKills = autoKill.keySet().iterator();
        while(itKills.hasNext()){
            killIndex = (int) itKills.next();
            //se causa ja esta no hashmap, apenas adiciona a quantidade de kills desse jogador
            if(deathByMeans.containsKey(killIndex)){                    
                deathByMeans.put(killIndex, (deathByMeans.get(killIndex) + autoKill.get(killIndex)));
            }
            //se não esta no hashmap, cria registro inicial
            else{
                deathByMeans.put(killIndex, autoKill.get(killIndex));
            }
        }
        //gerando saida
        String output = "\nMORTES GAME "+ id+ " AGRUPADAS POR CAUSA{\n";
        //reaproveitando o iterator
        itKills = deathByMeans.keySet().iterator();
        while(itKills.hasNext()){
            killIndex = (int) itKills.next();
            qtdeDeath = deathByMeans.get(killIndex);            
            output += "    " + MeansOfDeath.getMean(killIndex) + ": " + String.valueOf(qtdeDeath) + "\n";
        }
        output += "}";
        return output;
    }

    @Override
    public String toString() {
        String output = "";
        output += "\nGame " + id + "{\n" + "    totalKills: " + totalKills + "\n" + "    players: [";
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
