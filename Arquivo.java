/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;

/**
 *
 * @author Cedryk
 */
public class Arquivo {   
    private String nome;
    private String caminho;
    private BufferedReader in;
    private StringTokenizer st;
         
    public Arquivo() {
        nome = null;
        caminho = null;
        in = null;
        st = null;
    }
    
    //#ler arquivo
    public BufferedReader lerArquivo() throws IOException {
        JFileChooser fc = new JFileChooser(""); 
        fc.showOpenDialog(null);
        caminho = fc.getSelectedFile().getAbsolutePath();
        nome = fc.getSelectedFile().getName();
        in = new BufferedReader(new FileReader(caminho));
        return in;
    }

    public String getNome() {
        return nome;
    }      
    
    //retornar caminho do arquivo
    public String getCaminho() {
        return caminho;
    }
}
