
package ClassesDeApoio_ApagarDepois;

/**
 *
 * @author ruiboticas
 * @version 1.0
 * @date 2026-04-23
 * 
 */

import ClassesDeApoio_ApagarDepois.Annotations.Column;
import ClassesDeApoio_ApagarDepois.Annotations.GeneratedValue;
import ClassesDeApoio_ApagarDepois.Annotations.Id;
import ClassesDeApoio_ApagarDepois.Annotations.Table;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenericDAO<T> {

    private final Connection connection;
    private final Class<T> clazz;
    private final String tableName;

    public GenericDAO(Connection connection, Class<T> clazz) {
        this.connection = connection;
        this.clazz = clazz;
        this.tableName = getTableName();
    }

    public void insert(T entity) throws Exception {
        List<Field> fields = getInsertableFields();

        StringBuilder columns = new StringBuilder();
        StringBuilder placeholders = new StringBuilder();

        for (int i = 0; i < fields.size(); i++) {
            columns.append(getColumnName(fields.get(i)));
            placeholders.append("?");

            if (i < fields.size() - 1) {
                columns.append(", ");
                placeholders.append(", ");
            }
        }

        String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + placeholders + ")";

        Field idField = getIdField();
        boolean generated = isGenerated(idField);

        if (generated) {
            try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                fillStatementWithFields(stmt, fields, entity);
                stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        Object generatedId = rs.getObject(1);
                        setFieldValue(entity, idField, generatedId);
                    }
                }
            }
        } else {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                fillStatementWithFields(stmt, fields, entity);
                stmt.executeUpdate();
            }
        }
    }

    public void update(T entity) throws Exception {
        Field idField = getIdField();
        Object idValue = getFieldValue(entity, idField);

        if (idValue == null) {
            throw new Exception("Não é possível atualizar: o ID está a null.");
        }

        List<Field> updatableFields = getUpdatableFields();

        StringBuilder setClause = new StringBuilder();

        for (int i = 0; i < updatableFields.size(); i++) {
            setClause.append(getColumnName(updatableFields.get(i))).append(" = ?");
            if (i < updatableFields.size() - 1) {
                setClause.append(", ");
            }
        }

        String sql = "UPDATE " + tableName +
                     " SET " + setClause +
                     " WHERE " + getColumnName(idField) + " = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            for (int i = 0; i < updatableFields.size(); i++) {
                Object value = getFieldValue(entity, updatableFields.get(i));
                stmt.setObject(i + 1, value);
            }

            stmt.setObject(updatableFields.size() + 1, idValue);
            stmt.executeUpdate();
        }
    }

    public void deleteById(Object id) throws Exception {
        Field idField = getIdField();

        String sql = "DELETE FROM " + tableName +
                     " WHERE " + getColumnName(idField) + " = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }
    }

    public T findById(Object id) throws Exception {
        Field idField = getIdField();

        String sql = "SELECT * FROM " + tableName +
                     " WHERE " + getColumnName(idField) + " = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setObject(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEntity(rs);
                }
            }
        }

        return null;
    }

    public List<T> findAll() throws Exception {
        List<T> list = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(mapResultSetToEntity(rs));
            }
        }

        return list;
    }

    public List<T> findByField(String fieldName, Object value) throws Exception {
        List<T> list = new ArrayList<>();

        Field field = getFieldByName(fieldName);
        String columnName = getColumnName(field);

        String sql = "SELECT * FROM " + tableName + " WHERE " + columnName + " = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setObject(1, value);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToEntity(rs));
                }
            }
        }

        return list;
    }

    public boolean existsById(Object id) throws Exception {
        Field idField = getIdField();

        String sql = "SELECT 1 FROM " + tableName +
                     " WHERE " + getColumnName(idField) + " = ? LIMIT 1";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setObject(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    public long count() throws Exception {
        String sql = "SELECT COUNT(*) FROM " + tableName;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getLong(1);
            }
        }

        return 0;
    }

    private T mapResultSetToEntity(ResultSet rs) throws Exception {
        T entity = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            String columnName = getColumnName(field);
            Object value = rs.getObject(columnName);
            setFieldValue(entity, field, value);
        }

        return entity;
    }

    private void fillStatementWithFields(PreparedStatement stmt, List<Field> fields, T entity) throws Exception {
        for (int i = 0; i < fields.size(); i++) {
            Object value = getFieldValue(entity, fields.get(i));
            stmt.setObject(i + 1, value);
        }
    }

    private String getTableName() {
        if (clazz.isAnnotationPresent(Table.class)) {
            return clazz.getAnnotation(Table.class).name();
        }
        return clazz.getSimpleName();
    }

    private String getColumnName(Field field) {
        if (field.isAnnotationPresent(Column.class)) {
            return field.getAnnotation(Column.class).name();
        }
        return field.getName();
    }

    private Field getIdField() throws Exception {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                return field;
            }
        }

        throw new Exception("A classe " + clazz.getSimpleName() + " não tem campo com @Id.");
    }

    private Field getFieldByName(String fieldName) throws Exception {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new Exception("O campo '" + fieldName + "' não existe na classe " + clazz.getSimpleName() + ".");
        }
    }

    private boolean isGenerated(Field field) {
        return field.isAnnotationPresent(GeneratedValue.class);
    }

    private List<Field> getInsertableFields() throws Exception {
        List<Field> fields = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class) && field.isAnnotationPresent(GeneratedValue.class)) {
                continue;
            }
            fields.add(field);
        }

        if (fields.isEmpty()) {
            throw new Exception("Não existem campos para inserir.");
        }

        return fields;
    }

    private List<Field> getUpdatableFields() {
        List<Field> fields = new ArrayList<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (!field.isAnnotationPresent(Id.class)) {
                fields.add(field);
            }
        }

        return fields;
    }

    private Object getFieldValue(T entity, Field field) throws Exception {
        field.setAccessible(true);
        return field.get(entity);
    }

    private void setFieldValue(T entity, Field field, Object value) throws Exception {
        field.setAccessible(true);

        if (value == null) {
            field.set(entity, null);
            return;
        }

        Class<?> fieldType = field.getType();

        if (fieldType == Integer.class || fieldType == int.class) {
            field.set(entity, ((Number) value).intValue());
        } else if (fieldType == Long.class || fieldType == long.class) {
            field.set(entity, ((Number) value).longValue());
        } else if (fieldType == Double.class || fieldType == double.class) {
            field.set(entity, ((Number) value).doubleValue());
        } else if (fieldType == Float.class || fieldType == float.class) {
            field.set(entity, ((Number) value).floatValue());
        } else if (fieldType == String.class) {
            field.set(entity, value.toString());
        } else if (fieldType == Boolean.class || fieldType == boolean.class) {
            field.set(entity, value);
        } else {
            field.set(entity, value);
        }
    }
}