/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.InterpretadorLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Arquivo;

/**
 *
 * @author Cedryk
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Arquivo arquivo = new Arquivo();
        InterpretadorLog il;
        try {
            BufferedReader in = arquivo.lerArquivo();
            if(in != null){
                il = new InterpretadorLog(in);
                il.start();                
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }    
}
