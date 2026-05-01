/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;

import java.util.Objects;

/**
 *
 * @author Fábio
 */
public class Elemento {
    private Integer numero;
    
    private String coluna1;
    private String coluna2;
    private String coluna3;
    private String coluna4;
    private String coluna5;
    private String coluna6;
    private String coluna7;
    private String coluna8;

    
    public Elemento(Integer numero, String coluna1, String coluna2, String coluna3, String coluna4, String coluna5, String coluna6, String coluna7, String coluna8) {
        this.numero = numero;
        this.coluna1 = coluna1;
        this.coluna2 = coluna2;
        this.coluna3 = coluna3;
        this.coluna4 = coluna4;
        this.coluna5 = coluna5;
        this.coluna6 = coluna6;
        this.coluna7 = coluna7;
        this.coluna8 = coluna8;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.numero);
        hash = 53 * hash + Objects.hashCode(this.coluna1);
        hash = 53 * hash + Objects.hashCode(this.coluna2);
        hash = 53 * hash + Objects.hashCode(this.coluna3);
        hash = 53 * hash + Objects.hashCode(this.coluna4);
        hash = 53 * hash + Objects.hashCode(this.coluna5);
        hash = 53 * hash + Objects.hashCode(this.coluna6);
        hash = 53 * hash + Objects.hashCode(this.coluna7);
        hash = 53 * hash + Objects.hashCode(this.coluna8);
        return hash;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getColuna1() {
        return coluna1;
    }

    public void setColuna1(String coluna1) {
        this.coluna1 = coluna1;
    }

    public String getColuna2() {
        return coluna2;
    }

    public void setColuna2(String coluna2) {
        this.coluna2 = coluna2;
    }

    public String getColuna3() {
        return coluna3;
    }

    public void setColuna3(String coluna3) {
        this.coluna3 = coluna3;
    }

    public String getColuna4() {
        return coluna4;
    }

    public void setColuna4(String coluna4) {
        this.coluna4 = coluna4;
    }

    public String getColuna5() {
        return coluna5;
    }

    public void setColuna5(String coluna5) {
        this.coluna5 = coluna5;
    }

    public String getColuna6() {
        return coluna6;
    }

    public void setColuna6(String coluna6) {
        this.coluna6 = coluna6;
    }

    public String getColuna7() {
        return coluna7;
    }

    public void setColuna7(String coluna7) {
        this.coluna7 = coluna7;
    }

    public String getColuna8() {
        return coluna8;
    }

    public void setColuna8(String coluna8) {
        this.coluna8 = coluna8;
    }
    
    
}
