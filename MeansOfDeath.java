/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cedryk
 */
public class MeansOfDeath {
    private static final Map<Integer, String> MEANS_OF_DEATH = new HashMap<>();
    
    static{
        MEANS_OF_DEATH.put(0 , "MOD_UNKNOWN");
        MEANS_OF_DEATH.put(1 , "MOD_SHOTGUN");
        MEANS_OF_DEATH.put(2 , "MOD_GAUNTLET");
        MEANS_OF_DEATH.put(3 , "MOD_MACHINEGUN");
        MEANS_OF_DEATH.put(4 , "MOD_GRENADE");
        MEANS_OF_DEATH.put(5  , "MOD_GRENADE_SPLASH");
        MEANS_OF_DEATH.put(6  , "MOD_ROCKET");
        MEANS_OF_DEATH.put(7  , "MOD_ROCKET_SPLASH");
        MEANS_OF_DEATH.put(8  , "MOD_PLASMA");
        MEANS_OF_DEATH.put(9  , "MOD_PLASMA_SPLASH");
        MEANS_OF_DEATH.put(10  , "MOD_RAILGUN");
        MEANS_OF_DEATH.put(11  , "MOD_LIGHTNING");
        MEANS_OF_DEATH.put(12  , "MOD_BFG");
        MEANS_OF_DEATH.put(13  , "MOD_BFG_SPLASH");
        MEANS_OF_DEATH.put(14  , "MOD_WATER");
        MEANS_OF_DEATH.put(15  , "MOD_SLIME");
        MEANS_OF_DEATH.put(16  , "MOD_LAVA");
        MEANS_OF_DEATH.put(17  , "MOD_CRUSH");
        MEANS_OF_DEATH.put(18  , "MOD_TELEFRAG");
        MEANS_OF_DEATH.put(19  , "MOD_FALLING");
        MEANS_OF_DEATH.put(20  , "MOD_SUICIDE");
        MEANS_OF_DEATH.put(21  , "MOD_TARGET_LASER");
        MEANS_OF_DEATH.put(22  , "MOD_TRIGGER_HURT");
        MEANS_OF_DEATH.put(23  , "MOD_NAIL");
        MEANS_OF_DEATH.put(24  , "MOD_CHAINGUN");
        MEANS_OF_DEATH.put(25  , "MOD_PROXIMITY_MINE");
        MEANS_OF_DEATH.put(26  , "MOD_KAMIKAZE");
        MEANS_OF_DEATH.put(27  , "MOD_JUICED");
        MEANS_OF_DEATH.put(28  , "MOD_GRAPPLE");
    }
    
    public static String getMean(int meanId){
        return MEANS_OF_DEATH.get(meanId);
    }
    
}
