/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package share;

import java.util.ArrayList;
import presentation.ui.gui.DlgEditTabela;
import presentation.ui.gui.TabelaViewer;
import presentation.ui.gui.starter;

/**
 *
 * @author Fábio
 */
public class Funcionalidades { //pesquisar pop-up menu
    
    //Funcionalidades para tratamento ou prevenção de excessões -------------------------
    
    //Impede a tentativa de criação de uma table com caracteres inválidos no seu nome.
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
    
    
    public String corrigirEspacosNosNomes(String nome) throws NomeDaTabelaEstaVazioExeption{
        String nomeCorrigido = "";
        
        for (char letra : nome.toCharArray()) {
            if( letra == ' '){
                nomeCorrigido += '_';
            }
            else{
                nomeCorrigido += letra;
            }
        }
        if (nome == null || nome.isBlank()){
            throw new NomeDaTabelaEstaVazioExeption("Não pode deixar o nome da tabela vazio");
        }
        return nomeCorrigido;
    }
    
    //Metodos especificos a uma determinada classe devem estar nessa classe
    //Funcionalidades Extra ---------------------------------------------------------------
    
}
