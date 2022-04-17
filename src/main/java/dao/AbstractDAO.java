package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Client;

import javax.swing.table.DefaultTableModel;

/**
 * clasa care implementeaza metode pentru toate tipurile de obiecte folosite in proiect
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    protected final Class<T> type;

    /**
     * constructor
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * metoda care construieste un string ce va fii folosit ca un query pentru a face o modificare in baza de date
     * @param field
     * @return
     */
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * metoda care construieste un string ce va fii folosit ca un query pentru a face o modificare in baza de date
     * @return
     */
    private String createSelectAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append("schooldb." + type.getSimpleName());
        return sb.toString();
    }

    /**
     * metoda care ia o lista de obiecte, le ia numele ca string-uri, face conversia la numele getterelor corespunzatoare,
     * apoi adauga valorile respective intr-un vector
     * metoda creaza coloanele intr-un tabel in functie de cate field-uri avem
     * la final adauga valorile din vector pe linii
     * @param list
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public DefaultTableModel showInformation(List<T> list) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] numefileds = new String[type.getDeclaredFields().length];
        int k=0;
        DefaultTableModel tableModel = new DefaultTableModel();
        for (Field field : type.getDeclaredFields()) {
            numefileds[k] = "get" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1) ;
            //System.out.println(numefileds[k]);
            k++;
            field.setAccessible(true);
            tableModel.addColumn(field.getName());
            //System.out.println(field.getName());
        }
        for(int i=0;i<list.size();i++){
            Object[] vector = new Object[type.getDeclaredFields().length];
            for(int j = 0; j<type.getDeclaredFields().length;j++){
                Method m = type.getMethod(numefileds[j]);
                vector[j] = m.invoke(list.get(i));
            }
            tableModel.addRow(vector);
            /*for(int j =0; j<k;j++)
                System.out.println(vector[j]);*/
        }
        return tableModel;
        }

    /**
     * metoda care returneaza o lista cu toate valorile dintr-o tabela
     * @return
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAll();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * metoda care returneaza un obiect dintr-o tabela al carui id corespunde cu cel primit ca parametru
     * @param id
     * @return
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * metoda care creaza un obiect de tip t si pe care apoi il pune intr-o lista
     * @param resultSet
     * @return
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*public T insert(T t) {
        // TODO:
        return t;
    }

    public T update(T t) {
        // TODO:
        return t;
    }*/
}
