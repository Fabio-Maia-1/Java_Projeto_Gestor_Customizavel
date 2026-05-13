/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.model;


/**
 * Classe modelo para tabelas. Herda da classe Elemento
 * @author Fábio
 */
public class Tabela extends Elemento{

    private Integer numero; //necessário para exibir tabela corretamente com o table model
    private String nome;
    private String descricao;

    private int numColunas;

    public Tabela(Integer numero, String nomeTabela, String descricao, Integer numColunas, String coluna1, String coluna2, String coluna3, String coluna4, String coluna5, String coluna6, String coluna7, String coluna8, Boolean favorito) {
        super(numero, coluna1, coluna2, coluna3, coluna4, coluna5, coluna6, coluna7, coluna8, favorito);
        this.numero = numero;
        this.nome = nomeTabela;
        this.descricao = descricao;
        this.numColunas = numColunas;
    }

    /**
     * Recebe um index e retorna o contiudo da propriedade associada a esse index.
     * Este metodo é usado no TabelaDAO.
     * @param i
     * @return 
     */
    @Override
    public String retornarConteudoColuna(int i) {
        switch (i) {
            case 1:
                return this.nome;
            case 2:
                return this.descricao;
            case 4:
                return super.getColuna1();
            case 5:
                return super.getColuna2();
            case 6:
                return super.getColuna3();
            case 7:
                return super.getColuna4();
            case 8:
                return super.getColuna5();
            case 9:
                return super.getColuna6();
            case 10:
                return super.getColuna7();
            case 11:
                return super.getColuna8();
            default:
                return null;
        }
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

}
