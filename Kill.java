/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Cedryk
 */
public class Kill {
    //causas de morte
    private String deadPlayer;
    private String motivo;

    public Kill(String deadPlayer, String motivo) {
        this.deadPlayer = deadPlayer;
        this.motivo = motivo;
    }

    public String getDeadPlayer() {
        return deadPlayer;
    }

    public String getMotivo() {
        return motivo;
    }    
}
