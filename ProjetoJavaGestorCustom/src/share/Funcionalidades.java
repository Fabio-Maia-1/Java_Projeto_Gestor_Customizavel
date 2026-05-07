/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package share;

import java.util.ArrayList;
import presentation.ui.gui.TabelaViewer;
import presentation.ui.gui.starter;

/**
 *
 * @author Fábio
 */
public class Funcionalidades {
    
    //Funcionalidades para tratamento ou prevenção de excessões -------------------------
    
    public void verificarCaracteres(String texto) throws IntrudocaoCaracteresInvalidosException {
        //Falta as ' '. Verificar se o \\ funciona
        char[] listaDeCaracteresInvalidos = {'<','>','"','(',')','!','?',',','.',':',';','#','$','&','*','+','-','/','\\','=','@','%'};   
        String caracteres = "";
        ArrayList caracteresInvalidosNaPalavra = new ArrayList<>();
        boolean haInvalidos = false;
        
        for (char x : texto.toCharArray()){
            for (char y : listaDeCaracteresInvalidos){
                if (x == y && !caracteresInvalidosNaPalavra.contains(y)){
                    caracteresInvalidosNaPalavra.add(y);
                    haInvalidos = true;
                    caracteres += y;
                }
            }
        }
        if (haInvalidos){
            throw new IntrudocaoCaracteresInvalidosException("Introduziu caracteres inválidos: (" + caracteres + ")");
        }
    }
    
    
    public String corrigirEspacosNosNomes(String nome){
        String nomeCorrigido = "";
        
        for (char letra : nomeCorrigido.toCharArray()) {
            if( letra == ' '){
                nomeCorrigido += '_';
            }
            else{
                nomeCorrigido += letra;
            }
        }
        return nomeCorrigido;
    }
    
    
    //Funcionalidades partilhadas pelos forms --------------------------
    
    
    //Funcionalidades do starter ---------------------------------------
    
    
    //Funcionalidades do TabelaViewer ----------------------------------
    public void retornarPaginaPrincipal(TabelaViewer paginaAtual){
        new starter().setVisible(true);
        paginaAtual.dispose();  
    }    
}
