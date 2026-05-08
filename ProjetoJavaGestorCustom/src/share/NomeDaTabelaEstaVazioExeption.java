/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package share;

/**
 *
 * @author formando
 */
public class NomeDaTabelaEstaVazioExeption extends Exception{
    
    /**
     * Creates a new instance of <code>OperacaoStockInvalidaException</code>
     * without detail message.
     */
    public NomeDaTabelaEstaVazioExeption() {
    }

    /**
     * Constructs an instance of <code>OperacaoStockInvalidaException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public NomeDaTabelaEstaVazioExeption(String msg) {
        super(msg);
    }
}
