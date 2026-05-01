
package business.model;

import business.service.Funcionalidades;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.Field;
import javax.swing.table.AbstractTableModel;


//Adicionar ao construtor da classse onde a jtable está a ser adicionada
        //ArrayListBasedTableModel TableModel = new ArrayListBasedTableModel(Class.class, colecao);
        //tabela.setModel(TableModel);

/**
    @author ruiboticas
    @version 2.0
    @param <T>
 */
public class ArrayListBasedTableModel<T> extends AbstractTableModel {

    private ArrayListObservable<T> dataSource;
    private Class<T> CLASS_TYPE;
    
    private Tabela tabela; //Para contruir as colunas corretamente

    public ArrayListBasedTableModel(Class<T> CLASS_TYPE, ArrayListObservable<T> dataSource, Tabela tabela) {
        this.setDataSource(CLASS_TYPE, dataSource);
        this.tabela = tabela; //receber tabela para ajudar com a constução
    }
    
    public final void setDataSource(Class<T> CLASS_TYPE, ArrayListObservable<T> dataSource){
        this.CLASS_TYPE = CLASS_TYPE;
        this.dataSource = (dataSource == null) ? new ArrayListObservable<>() : dataSource;

        this.dataSource.addPropertyChangeListener((PropertyChangeEvent evt) -> {
            fireTableDataChanged();
        });
    }

    @Override
    public int getRowCount() {
        return dataSource.size();
    }

    @Override
    public int getColumnCount() {
        //Colunas que o utilizador intruduziu + o nº do elemento
        return (tabela.getNumColunas()) + 1;
    }

    @Override
    public String getColumnName(int column) {
        String name = "";
        switch (column) {
            case 0:
                name = "Nº";
                break;
            case 1:
                name = tabela.getColuna1();
                break;
            case 2:
                name = tabela.getColuna2();
                break;
            case 3:
                name = tabela.getColuna3();
                break;
            case 4:
                name = tabela.getColuna4();
                break;
            case 5:
                name = tabela.getColuna5();
                break;
            case 6:
                name = tabela.getColuna6();
                break;
            case 7:
                name = tabela.getColuna7();
                break;
            case 8:
                name = tabela.getColuna8();
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return CLASS_TYPE.getDeclaredFields()[columnIndex].getType();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T elemento = dataSource.get(rowIndex);
        
        Field field = elemento.getClass().getDeclaredFields()[columnIndex];
        field.setAccessible(true);        
        
        try {
            return field.get(elemento);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            System.getLogger(ArrayListBasedTableModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }finally{
            field.setAccessible(true);                    
        }
        
        return null;
    }
}