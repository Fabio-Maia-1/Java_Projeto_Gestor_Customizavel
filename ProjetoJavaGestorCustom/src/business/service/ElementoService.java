/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.service;

import business.model.ArrayListObservable;
import business.model.Elemento;
import business.model.Tabela;
import java.sql.Connection;
import persistence.dao.ElementoDAO;

/**
 * Classe de serviço para todas as operações DAO para gestão de elementos em tabelas.
 * @author Fábio
 */
public class ElementoService {
    
    private ElementoDAO elementoDAO;

    public ElementoService(Connection connection) throws Exception {
        this.elementoDAO = new ElementoDAO(connection);
    }
    
    public Boolean guardar(Elemento e, Tabela t) throws Exception {
        return elementoDAO.guardar(e, t);
    }
    
    public Boolean atualizar(Elemento e, Tabela t) throws Exception{
        return elementoDAO.update(e, t);
    }
    
    public ArrayListObservable fillAll(Tabela t) throws Exception{
        return elementoDAO.findAll(t);
    }
    
        public ArrayListObservable fillAllFavoritos(Tabela t) throws Exception{
        return elementoDAO.findAllFavoritos(t);
    }
    
    public Boolean meterOuTirarFavorito(Elemento e, Tabela t) throws Exception{
        return elementoDAO.meterOuTirarFavorito(e, t);
    }
    
    public int getUltimoId(Tabela t) throws Exception{
        return elementoDAO.obterIdMaisRecente(t);
    }
    
    public Boolean apagarRow(Elemento e, Tabela t) throws Exception{
        return elementoDAO.deleteRowById(e, t);
    }
}
