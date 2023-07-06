package main.persistencia;

import java.util.ArrayList;
import main.entidad.Producto;
import main.persistencia.DAO;

public final class ProductoDAO extends DAO {

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Indica un usuario");
            }
            String sql = "INSERT INTO Producto (nombre,precio)"
                    + "VALUES('" + producto.getNombre() + "','" + producto.getPrecio() + "');";
            inUpDel(sql);

        } catch (Exception e) {
            descBase();
            throw e;
        }finally {
            // SIEMPRE DESCONECTARSE DE LA BBDD.
            descBase();
        }
    }

    public void modProducto(Producto producto,String column) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Indica el producto");
            }
            String sql = "";
            switch(column){
                case "nombre":
                    sql = "UPDATE  producto SET "
                    + column +" = '" + producto.getNombre() + "' WHERE codigo = " + producto.getCodigo() + ";";
                    break;
                case "precio":
                    sql = "UPDATE  producto SET "
                    + column +" = '" + producto.getPrecio() + "' WHERE codigo = " + producto.getCodigo() + ";";
                    break;
                case "codigo":
                    sql = "UPDATE  producto SET "
                    + column +" = '" + producto.getCodigoFabricante() + "' WHERE codigo = " + producto.getCodigo() + ";";
                    break;
            }
            inUpDel(sql);
        } catch (Exception e) {
            descBase();
            throw e;
        }finally {
            // SIEMPRE DESCONECTARSE DE LA BBDD.
            descBase();
        }
    }

    public void delProducto(String nombre) throws Exception {
        try {
            String sql = "DELETE FROM producto WHERE nombre = '" + nombre + "'";
            inUpDel(sql);
        } catch (Exception e) {
            descBase();
            throw e;
        }finally {
            // SIEMPRE DESCONECTARSE DE LA BBDD.
            descBase();
        }
    }

    public Producto buscarProducto() throws Exception {
        try {           
            String sql = "SELECT * FROM producto ORDER BY precio asc LIMIT 1;"; //+ " WHERE nombre LIKE '" + nombre + "%';";
            consultaBBDD(sql);
            Producto pd = null;
            while (resultado.next()) {
                pd = new Producto();
                pd.setCodigo(resultado.getInt(1));
                pd.setNombre(resultado.getString(2));
                pd.setPrecio(resultado.getDouble(3));
                pd.setCodigoFabricante(resultado.getInt(4));
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

    public ArrayList<Producto> buscarVariosProducto() throws Exception {
        try {          
            String sql = "SELECT * FROM Producto";
            consultaBBDD(sql);
            Producto pd = null;
            ArrayList<Producto> producto = new ArrayList();
            while (resultado.next()) {
                pd = new Producto();
                pd.setCodigo(resultado.getInt(1));
                pd.setNombre(resultado.getString(2));
                pd.setPrecio(resultado.getDouble(3));
                pd.setCodigoFabricante(resultado.getInt(4));
                producto.add(pd);
            }
            descBase();
            return producto;
        } catch (Exception e) {
            descBase();
            throw e;
        }finally {
            // SIEMPRE DESCONECTARSE DE LA BBDD.
            descBase();
        }
    }

    public ArrayList<Producto> buscarPortatilProducto() throws Exception {
        try {     
            String sql = "SELECT * FROM Producto WHERE nombre LIKE '%Portatíl%'";
            consultaBBDD(sql);
            Producto pd = null;
            ArrayList<Producto> producto = new ArrayList();
            while (resultado.next()) {
                pd = new Producto();
                pd.setCodigo(resultado.getInt(1));
                pd.setNombre(resultado.getString(2));
                pd.setPrecio(resultado.getDouble(3));
                pd.setCodigoFabricante(resultado.getInt(4));
                producto.add(pd);
            }
            descBase();
            return producto;
        } catch (Exception e) {
            descBase();
            throw e;
        }finally {
            // SIEMPRE DESCONECTARSE DE LA BBDD.
            descBase();
        }
    }
}
