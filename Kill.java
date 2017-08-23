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
    private int deadPlayerId;
    private int meansOfDeathId;

    public Kill(int meansOfDeathId, int deadPlayerId) {
        this.meansOfDeathId = meansOfDeathId;
        this.deadPlayerId = deadPlayerId;
    }

    public int getDeadPlayerId() {
        return deadPlayerId;
    }

    public int getMeansOfDeathId() {
        return meansOfDeathId;
    }    
}
