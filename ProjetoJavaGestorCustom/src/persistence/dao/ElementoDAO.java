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
import business.model.Elemento;
import java.sql.Statement;

/**
 *
 * @author Fábio
 */
public class ElementoDAO {
    
    private Connection ligacao = null;
    private PreparedStatement pst = null;
    private ArrayListObservable<Elemento> lista;

    
    public ElementoDAO(Connection connection) throws Exception {
        this.ligacao = connection;
    }

    public Boolean guardar(Elemento e, Tabela t) throws Exception {
        if (e != null) {
            String nome = t.getNomeTabela(); 
            String stringSQL = "INSERT INTO " + nome + "(id, coluna1, coluna2, coluna3, coluna4, "
                    + "coluna5, coluna6, coluna7, coluna8, favorito) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            pst = ligacao.prepareStatement(stringSQL);
            pst.setInt(1, e.getNumero());
            pst.setString(2, e.getColuna1());
            pst.setString(3, e.getColuna2());
            pst.setString(4, e.getColuna3());
            pst.setString(5, e.getColuna4());
            pst.setString(6, e.getColuna5());
            pst.setString(7, e.getColuna6());
            pst.setString(8, e.getColuna7());
            pst.setString(9, e.getColuna8());
            pst.setBoolean(10, e.getFavorito());

            int resultado = pst.executeUpdate();

            return resultado > 0;
        }
        return false;
    }
    
    public Boolean update(Elemento e, Tabela t) throws Exception {
        int id = e.getNumero();
        String sql = "";
        String coluna = "";
        String nomeTable = t.getNomeTabela();
  
        for (int i = 1; i <= 8; i++) {
            coluna = Elemento.class.getDeclaredFields()[i].getName();//nome da coluna
            sql = "UPDATE " + nomeTable
                    + " SET " + coluna + " = ? "
                    + "WHERE id = " + id;

            pst = ligacao.prepareStatement(sql);
            pst.setString(1, e.retornarConteudoColuna(i));
            pst.executeUpdate();
        }
        return true;
    }
    
    //Listar elementos da table na base de dados
    public ArrayListObservable findAll(Tabela t) throws Exception {
        lista = new ArrayListObservable<>();
        String nome = t.getNomeTabela();
        Elemento e = null;
        String sql = "SELECT * FROM " + nome;

        try (Statement stmt = ligacao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                e = new Elemento(rs.getInt("id"), rs.getString("coluna1"), rs.getString("coluna2"),
                        rs.getString("coluna3"), rs.getString("coluna4"), rs.getString("coluna5"),
                        rs.getString("coluna6"), rs.getString("coluna7"), rs.getString("coluna8"),
                        rs.getBoolean("favorito"));
                lista.add(e);
            }
        }
        return lista;
    }
    
    //Igual ao findAll(), mas para a table "tabelasFavoritas"
    public ArrayListObservable findAllFavoritos(Tabela t) throws Exception {
        lista = new ArrayListObservable<>();
        String nome = t.getNomeTabela();
        Elemento e = null;
        String sql = "SELECT * FROM " + nome
                + " WHERE favorito = 1";

        try (Statement stmt = ligacao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                e = new Elemento(rs.getInt("id"), rs.getString("coluna1"), rs.getString("coluna2"),
                        rs.getString("coluna3"), rs.getString("coluna4"), rs.getString("coluna5"),
                        rs.getString("coluna6"), rs.getString("coluna7"), rs.getString("coluna8"),
                        rs.getBoolean("favorito"));
                lista.add(e);
            }
        }
        return lista;
    }
    
    public Boolean meterOuTirarFavorito(Elemento e, Tabela t) throws Exception {
        int id = e.getNumero();
        String nome = t.getNomeTabela();
        Boolean fav = e.getFavorito();
        String sql = "";

        if (fav == false) {
            sql = "UPDATE " + nome
                    + " SET favorito = 1 "
                    + "WHERE id = " + id;
        } else {
            sql = "UPDATE " + nome
                    + " SET favorito = 0 "
                    + "WHERE id = " + id;
        }

        try (PreparedStatement stmt = ligacao.prepareStatement(sql)) {
            stmt.executeUpdate();
            return true;
        }
    }
    
     public int obterIdMaisRecente(Tabela t) throws Exception {
        String nome = t.getNomeTabela();
        int ultimoId = 0;
        String sql = "SELECT * FROM " + nome;

        try (Statement stmt = ligacao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ultimoId = rs.getInt("id");
            }
        }
        return ultimoId;
    }
    
    public Boolean deleteRowById(Elemento e, Tabela t) throws Exception {
        if (e != null) {
            String nome = t.getNomeTabela();
            int id = e.getNumero();
            String sql = "DELETE FROM " + nome
                    + " WHERE id = ?";

            try (PreparedStatement stmt = ligacao.prepareStatement(sql)) {
                stmt.setObject(1, id);
                stmt.executeUpdate();
                return true;
            }
        }
        return false;
    }
}
