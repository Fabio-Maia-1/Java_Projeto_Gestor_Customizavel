/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package share;

/**
 *
 * @author Fábio
 */
public class NomeComecaComNumeroExeption extends Exception{
    
    /**
     * Creates a new instance of <code>OperacaoStockInvalidaException</code>
     * without detail message.
     */
    public NomeComecaComNumeroExeption() {
    }

    /**
     * Constructs an instance of <code>OperacaoStockInvalidaException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public NomeComecaComNumeroExeption(String msg) {
        super(msg);
    }
}
