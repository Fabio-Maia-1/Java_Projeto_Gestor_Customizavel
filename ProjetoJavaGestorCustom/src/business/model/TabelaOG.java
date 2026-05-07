/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;

/**
 *
 * @author Fábio
 */
public class TabelaOG{

    private int numero;
    private String nome;
    private String descricao;
    
    private int numColunas;
    private String coluna1;
    private String coluna2;
    private String coluna3;
    private String coluna4;
    private String coluna5;
    private String coluna6;
    private String coluna7;
    private String coluna8;
    
    
    public TabelaOG(Integer numero, String nomeTabela, String descricao, Integer numColunas, String coluna1, String coluna2, String coluna3, String coluna4, String coluna5, String coluna6, String coluna7, String coluna8) {
        this.numero = numero;
        this.nome = nomeTabela;
        this.descricao = descricao;
        this.numColunas = numColunas;
        this.coluna1 = coluna1;
        this.coluna2 = coluna2;
        this.coluna3 = coluna3;
        this.coluna4 = coluna4;
        this.coluna5 = coluna5;
        this.coluna6 = coluna6;
        this.coluna7 = coluna7;
        this.coluna8 = coluna8;
    }
    
    public String retornarConteudoColuna(int i){
        switch (i) {
            case 1:
                return this.nome;
            case 2:
                return this.descricao;
            case 4:
                return this.coluna1;
            case 5:
                return this.coluna2;
            case 6:
                return this.coluna3;
            case 7:
                return this.coluna4;
            case 8:
                return this.coluna5;
            case 9:
                return this.coluna6;
            case 10:
                return this.coluna7;
            case 11:
                return this.coluna8;
            default:
                return null;
        }
    }
    

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNomeTabela() {
        return nome;
    }

    public void setNomeTabela(String nomeTabela) {
        this.nome = nomeTabela;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNumColunas() {
        return numColunas;
    }

    public void setNumColunas(Integer numColunas) {
        this.numColunas = numColunas;
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
