/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.service;

import persistence.dao.TabelaDAO;
import business.model.Tabela;
import java.sql.Connection;
import business.model.ArrayListObservable;

/**
 * Classe de serviço para todas as operações DAO para gestão de tabelas.
 * @author Fábio
 */
public class TabelaService {
    
    private TabelaDAO tabelaDAO;

    public TabelaService(Connection connection) throws Exception {
        this.tabelaDAO = new TabelaDAO(connection);
    }
    
    public Boolean guardar(Tabela t) throws Exception {
        return tabelaDAO.guardar(t);
    }
    
    public ArrayListObservable fillAll() throws Exception{
        return tabelaDAO.findAll();
    }
    
    public ArrayListObservable fillAllFavoritos() throws Exception{
        return tabelaDAO.findAllFavoritos();
    }
    
    public Boolean meterOuTirarFavorito(Tabela t) throws Exception{
        return tabelaDAO.meterOuTirarFavorito(t);
    }
    
    public int getUltimoId() throws Exception{
        return tabelaDAO.obterIdMaisRecente();
    }
    
    public Boolean apagarRow(Tabela t) throws Exception{
        return tabelaDAO.deleteRowById(t);
    }
    
    public Boolean criarTabelaSQL(Tabela t) throws Exception{
        return tabelaDAO.criarNovaTabelaSQL(t);
    }
    
    public Boolean apagarTabelaSQL(Tabela t) throws Exception{
        return tabelaDAO.apagarTabela(t);
    }
    
    public Boolean atualizarRow(Tabela t) throws Exception{
        return tabelaDAO.update(t);
    }
    
    public Boolean atualizarNomeTable(Tabela tVelha, Tabela tNova) throws Exception{
        return tabelaDAO.updateTableName(tVelha, tNova);
    }
    
}
