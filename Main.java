/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.InterpretadorLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Arquivo;
import model.Game;

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
        InterpretadorLog il = null;
         Iterator it = null;
        int op = -1;
        int gameId = -1;
        Game g1 = null;
        String output = "";
        try {
            BufferedReader in = arquivo.lerArquivo();
            if(in != null){
                il = new InterpretadorLog(in);
                il.start();                
            }
            while(op != 0){
                System.out.println("-----RELATÓRIOS-----");
                System.out.println("1 - Relatório geral dos jogos");
                System.out.println("2 - Relatório de mortes agrupado pela causa e por partida");
                System.out.println("3 - Ranking de jogadores");
                System.out.println("0 - Quit");
                System.out.print("opção: ");
                Scanner ler = new Scanner(System.in);

                try{
                    op = ler.nextInt();
                    System.out.println();
                    switch(op){
                        case 1:
                            System.out.println(il.getGames().toString()+"\n");
                        break;
                        case 2:
                            it = il.getGames().iterator();
                            while(it.hasNext()){
                                g1 = (Game) it.next();
                                output += g1.reportDeathByMeans() + "\n";
                            } 
                            System.out.println(output);                          
                        break;
                        case 3:                            
                            it = il.getGames().iterator();
                            while(it.hasNext()){
                                g1 = (Game) it.next();
                                output += g1.ranking()+"\n";
                            } 
                            System.out.println(output);  
                        break;
                    }
                }
                catch(Exception e){
                    System.out.println("\n\n\nENTRADA INVÁLIDA!!!\n\n\n");

                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }    
}
