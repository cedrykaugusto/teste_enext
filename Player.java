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
public class Player {
    private int id;
    private String nome;
    private Map<String, ArrayList<Kill>> kills;
    private int punicao;

    public Player(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.punicao = 0;
        this.kills = new HashMap<>();
       
    }
    
    public void addKill(String deadPlayer, String motivo){
        ArrayList<Kill> killsAux;
        if(kills.containsKey(motivo)){
            killsAux = kills.get(motivo);
        }
        else{
            killsAux = new ArrayList<>();
            killsAux.add(new Kill(deadPlayer, motivo));            
        }
    }
    
    public void addPunicao(){
        this.punicao++;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroKills() {
        return kills.size()-punicao;
    }

    public Map<String, ArrayList<Kill>> getKills() {
        return kills;
    }        
}
