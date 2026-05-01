
package ClassesDeApoio_ApagarDepois;

import business.model.*;
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

    public ArrayListBasedTableModel(Class<T> CLASS_TYPE, ArrayListObservable<T> dataSource) {
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
        return CLASS_TYPE.getDeclaredFields().length;
    }

    @Override
    public String getColumnName(int column) {
        return CLASS_TYPE.getDeclaredFields()[column].getName().toUpperCase();
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