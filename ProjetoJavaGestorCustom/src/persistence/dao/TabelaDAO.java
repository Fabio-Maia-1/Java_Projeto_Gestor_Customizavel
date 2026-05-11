/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence.dao;

import business.model.ArrayListObservable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import business.model.Tabela;
import java.sql.Statement;

/**
 *
 * @author Fábio
 */
public class TabelaDAO {
    
    private Connection ligacao = null;
    private PreparedStatement pst = null;
    private ArrayListObservable<Tabela> lista;

    
    public TabelaDAO(Connection connection) throws Exception {
        this.ligacao = connection;
    }
    
    //Adicionar elemento à base de dados
    public Boolean guardar(Tabela t) throws Exception {
        if (t != null) {
            String stringSQL = "INSERT INTO tabelas(id, nome, descricao, numColunas, coluna1, coluna2, "
                    + "coluna3, coluna4, coluna5, coluna6, coluna7, coluna8, favorito) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            pst = ligacao.prepareStatement(stringSQL);
            pst.setInt(1, t.getNumero());
            pst.setString(2, t.getNomeTabela());
            pst.setString(3, t.getDescricao());
            pst.setInt(4, t.getNumColunas());
            pst.setString(5, t.getColuna1());
            pst.setString(6, t.getColuna2());
            pst.setString(7, t.getColuna3());
            pst.setString(8, t.getColuna4());
            pst.setString(9, t.getColuna5());
            pst.setString(10, t.getColuna6());
            pst.setString(11, t.getColuna7());
            pst.setString(12, t.getColuna8());
            pst.setBoolean(13, t.getFavorito());

            int resultado = pst.executeUpdate();

            return resultado > 0;
        }
        return false;
    }
    
    public Boolean update(Tabela t) throws Exception {
        int id = t.getNumero();
        String sql = "";
        String coluna = "";
  
        for (int i = 1; i <= 11; i++) {
            if (i == 3) {//skip numColunas
                continue;
            }
            coluna = Tabela.class.getDeclaredFields()[i].getName();//nome da coluna
            sql = "UPDATE tabelas "
                    + "SET " + coluna + " = ? "
                    + "WHERE id = " + id;

            pst = ligacao.prepareStatement(sql);
            pst.setString(1, t.retornarConteudoColuna(i));
            pst.executeUpdate();
        }
        return true;
    }
    
    public Boolean updateTableName(Tabela tAntiga, Tabela tNova) throws Exception {
        String nomeAntigo = tAntiga.getNomeTabela();
        String nomeNovo = tNova.getNomeTabela();

        if (!nomeAntigo.matches(nomeNovo)) {
            String sql = "rename table " + nomeAntigo + " to " + nomeNovo;

            try (PreparedStatement stmt = ligacao.prepareStatement(sql)) {
                stmt.executeUpdate();
                return true;
            }
        } 
        return false;
    }
    
    //Listar elementos da table na base de dados
    public ArrayListObservable findAll() throws Exception {
        lista = new ArrayListObservable<>();
        Tabela t = null;
        String sql = "SELECT * FROM tabelas";

        try (Statement stmt = ligacao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                t = new Tabela(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getInt("numColunas"),
                rs.getString("coluna1"), rs.getString("coluna2"), rs.getString("coluna3"), rs.getString("coluna4"),
                rs.getString("coluna5"), rs.getString("coluna6"), rs.getString("coluna7"), rs.getString("coluna8"),
                rs.getBoolean("favorito"));
                lista.add(t);
            }
        }
        return lista;
    }
    
    //Igual ao findAll(), mas para a table "tabelasFavoritas"
    public ArrayListObservable findAllFavoritos() throws Exception {
        lista = new ArrayListObservable<>();
        Tabela t = null;
        String sql = "SELECT * FROM tabelas "
                + "WHERE favorito = 1";

        try (Statement stmt = ligacao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                t = new Tabela(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getInt("numColunas"),
                rs.getString("coluna1"), rs.getString("coluna2"), rs.getString("coluna3"), rs.getString("coluna4"),
                rs.getString("coluna5"), rs.getString("coluna6"), rs.getString("coluna7"), rs.getString("coluna8"),
                rs.getBoolean("favorito"));
                lista.add(t);
            }
        }
        return lista;
    }
    
    public Boolean meterOuTirarFavorito(Tabela t) throws Exception {
        int id = t.getNumero();
        Boolean fav = t.getFavorito();
        String sql = "";

        if (fav == false) {
            sql = "UPDATE tabelas "
                    + "SET favorito = 1 "
                    + "WHERE id = " + id;
        } else {
            sql = "UPDATE tabelas "
                    + "SET favorito = 0 "
                    + "WHERE id = " + id;
        }

        try (PreparedStatement stmt = ligacao.prepareStatement(sql)) {
            stmt.executeUpdate();
            return true;
        }
    }
    
    public int obterIdMaisRecente() throws Exception {
        int ultimoId = 0;
        String sql = "SELECT * FROM tabelas";

        try (Statement stmt = ligacao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ultimoId = rs.getInt("id");
            }
        }
        return ultimoId;
    }
    
    public Boolean deleteRowById(Tabela t) throws Exception {
        if (t != null) {
            int id = t.getNumero();
            String sql = "DELETE FROM tabelas"
                    + " WHERE id = ?";

            try (PreparedStatement stmt = ligacao.prepareStatement(sql)) {
                stmt.setObject(1, id);
                stmt.executeUpdate();
                return true;
            }
        }
        return false;
    }
    
        public Boolean criarNovaTabelaSQL(Tabela t)throws Exception{
        if (t != null) {
            String nome = t.getNomeTabela();
            String stringSQL = "create table " + nome + "(id int primary key, coluna1 varchar(100), " +
            "coluna2 varchar(100), coluna3 varchar(100), coluna4 varchar(100), coluna5 varchar(100), " +
            "coluna6 varchar(100), coluna7 varchar(100), coluna8 varchar(100), favorito bool)";
 
            pst = ligacao.prepareStatement(stringSQL);
            int resultado = pst.executeUpdate();

            return resultado > 0;
        }
        return false;
    }
    
    public Boolean apagarTabela(Tabela t)throws Exception{
        if (t != null) {
            String nome = t.getNomeTabela();
            String sql = "DROP TABLE " + nome;
            
            try (PreparedStatement stmt = ligacao.prepareStatement(sql)) {
                stmt.executeUpdate();
                return true;
            }
        }
        return false;
    }
}
