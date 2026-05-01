
package business.model;

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
public class TabelaTableModel<T> extends AbstractTableModel {

    private ArrayListObservable<T> dataSource;
    private Class<T> CLASS_TYPE;

    public TabelaTableModel(Class<T> CLASS_TYPE, ArrayListObservable<T> dataSource) {
        this.setDataSource(CLASS_TYPE, dataSource);
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
        //return CLASS_TYPE.getDeclaredFields().length;
        return 3;
    }
    
    @Override
    public String getColumnName(int column) {
        String name = "";
        switch (column) {
            case 0:
                name = "Nº";
                break;
            case 1:
                name = "NOME";
                break;
            case 2:
                name = "DESCRIÇÃO";
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Tabela.class.getDeclaredFields()[columnIndex].getType();
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T elemento = dataSource.get(rowIndex);
        
        Field field = elemento.getClass().getDeclaredFields()[columnIndex];
        field.setAccessible(true);        
        
        try {
            return field.get(elemento);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            System.getLogger(TabelaTableModel.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }finally{
            field.setAccessible(true);                    
        }
        
        return null;
    }
}