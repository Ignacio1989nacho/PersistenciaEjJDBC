package main.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected Connection conex = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    private final String USER = "root";
    private final String PASS = "root";
    private final String BBDDNOMBRE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    protected void conecBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlBBDD = "jdbc:mysql://localhost:3306/" + BBDDNOMBRE + "?useSSL=false";
            conex = DriverManager.getConnection(urlBBDD, USER, PASS);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("NO CONECTO A LA BBDD");
            throw e;
        }
    }

    protected void descBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conex != null) {
                conex.close();
            }
        } catch (Exception e) {
            System.out.println("NO DESCONECTO DE LA BBDD");
            throw e;
        }
    }

    protected void inUpDel(String sql) throws Exception {
        try {
            conecBase();
            sentencia = conex.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException e) {
//            conex.rollback();
//            el rollback me permite ir para atras para que no se ejecuten todo
//            lo que enviamos
//            SET autocommit = 1; true;
//            COMMIT;
           
            throw e;
        } finally {
            // SIEMPRE DESCONECTARSE DE LA BBDD.
            descBase();
        }
    }
    protected void consultaBBDD(String sql) throws Exception {
        try {
            conecBase();
            sentencia = conex.createStatement();
            resultado = sentencia.executeQuery(sql);         
        } catch (SQLException e) {
            
            throw e;
        }

    }

}
