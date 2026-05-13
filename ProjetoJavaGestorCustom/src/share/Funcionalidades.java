/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package share;

import java.util.ArrayList;

/**
 *
 * @author Fábio
 */
public class Funcionalidades {

    /**
     * Recebe um String e compara cada um dos seus caracteres a uma lista de caracteres inválidos para o nome de uma table numa
     * base de dados. Caso seja encontrado algum caracter inválido, manda a exceção "IntrudocaoCaracteresInvalidosException".
     * @param texto
     * @throws IntrudocaoCaracteresInvalidosException
     */
    public void verificarCaracteres(String texto) throws IntrudocaoCaracteresInvalidosException {
        char[] listaDeCaracteresInvalidos = {'<','>','"','(',')','!','?',',','.',':',';','#','$','&','*','+','-','/','\\','=','@','%','\''};   
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
    
    /**
     * Recebe um String e compara o seu primeiro caracter a uma lista com todos os números que podem ser representados
     * no formato char. Caso a comparação tenha resultado positivo, manda a exceção "verificarSeNomeComecaComNumero".
     * @param texto
     * @throws NomeComecaComNumeroExeption
     */
    public void verificarSeNomeComecaComNumero(String texto) throws NomeComecaComNumeroExeption{
        char[] listaDeNumeros = {'0','1','2','3','4','5','6','7','8','9'};
        for (char numero : listaDeNumeros){
             if (texto.charAt(0) == numero){
                 throw new NomeComecaComNumeroExeption("O nome de uma tabela não deve começar com um número");
             }
        }       
    }
    
    /**
     * Recebe um String e devolve um String idêntico, mas com todos os espaços substituídos por '_'
     * @param nome
     * @return
     * @throws NomeDaTabelaEstaVazioExeption
     */
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
}
