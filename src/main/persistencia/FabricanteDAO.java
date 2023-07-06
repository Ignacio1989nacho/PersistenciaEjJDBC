/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.persistencia;

import java.util.ArrayList;
import main.entidad.Fabricante;

/**
 *
 * @author Usuario
 */
public class FabricanteDAO extends DAO {
      public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Indica un usuario");
            }
            String sql = "INSERT INTO fabricante "
                    + "VALUES(" + null + ",'" + fabricante.getNombre()+ "');";
            inUpDel(sql);
            
        } catch (Exception e) {
            descBase();
            throw e;
        }finally {
            // SIEMPRE DESCONECTARSE DE LA BBDD.
            descBase();
        }
    }
      public void modFabricante(String nombre) throws Exception {
        try {
            if (nombre.equals("")) {
                throw new Exception("Indica el nombre del fabricante");
            }
            String sql = "UPDATE fabricante SET "
                    + "WHERE nombre = '" + nombre + "');";
            inUpDel(sql);

        } catch (Exception e) {
            descBase();
            throw e;
        }finally {
            // SIEMPRE DESCONECTARSE DE LA BBDD.
            descBase();
        }
    }

    public void delFabricante(String nombre) throws Exception {
        try {
            String sql = "DELETE FROM fabricante WHERE nombre = '" + nombre + "'";
            inUpDel(sql);
        } catch (Exception e) {
            descBase();
            throw e;
        }finally {
            // SIEMPRE DESCONECTARSE DE LA BBDD.
            descBase();
        }
    }

    public Fabricante buscarFabricante() throws Exception {
        try {
            
            String sql = "SELECT * FROM fabricante ORDER BY precio asc LIMIT 1;"; //+ " WHERE nombre LIKE '" + nombre + "%';";
            consultaBBDD(sql);
            Fabricante pd = null;
            while (resultado.next()) {
                pd = new Fabricante();
                pd.setCodigo(resultado.getInt(1));
                pd.setNombre(resultado.getString(2));

            }

            descBase();

            return pd;
        } catch (Exception e) {
            descBase();
            throw e;
        }finally {
            // SIEMPRE DESCONECTARSE DE LA BBDD.
            descBase();
        }

    }

    public ArrayList<Fabricante> buscarVariosFabricante() throws Exception {

        try {          
            String sql = "SELECT * FROM Fabricante";
            consultaBBDD(sql);
            Fabricante pd = null;
            ArrayList<Fabricante> fabricante = new ArrayList();
            while (resultado.next()) {
                pd = new Fabricante();
                pd.setCodigo(resultado.getInt(1));
                pd.setNombre(resultado.getString(2));
                fabricante.add(pd);
            }
            descBase();
            return fabricante;
        } catch (Exception e) {
            descBase();
            throw e;
        }finally {
            // SIEMPRE DESCONECTARSE DE LA BBDD.
            descBase();
        }

    }

 
    
}
