/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesDeApoio_ApagarDepois;

import share.NomeDaTabelaEstaVazioExeption;
import share.Funcionalidades;

/**
 *
 * @author formando
 */
public class NewClass {
    public static void main(String[] args) {
        String nome = "dwwe dsd";
        
        Funcionalidades f = new Funcionalidades();
        
        try {
            String novoNome = f.corrigirEspacosNosNomes(nome);
            System.out.println(novoNome);
        } catch (NomeDaTabelaEstaVazioExeption e) {
        }
        
        System.out.println(nome);
    }
    
  
}
