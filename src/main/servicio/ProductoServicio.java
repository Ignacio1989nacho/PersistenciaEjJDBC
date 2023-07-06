/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.servicio;

import java.util.ArrayList;
import java.util.Scanner;
import main.entidad.Fabricante;
import main.entidad.Producto;
import main.persistencia.ProductoDAO;

/**
 *
 * @author Usuario
 */
public class ProductoServicio {

    private ProductoDAO dao;

    public ProductoServicio() {
        this.dao = new ProductoDAO();
    }

    public ArrayList<Producto> allProducto() throws Exception {
        return dao.buscarVariosProducto();
    }

    public ArrayList<Producto> allPortatil() throws Exception {
        return dao.buscarPortatilProducto();
    }

    public Producto produc() throws Exception {
        return dao.buscarProducto();
    }

    public void modProd(Producto producto, String colum) throws Exception {
        dao.modProducto(producto, colum);
    }

    public void menuModProduc(ArrayList<Producto> p, ArrayList<Fabricante> f, FabricanteServicio fs) throws Exception {
        Scanner Leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresa el codigo del producto a modificar: ");
        int opcion = Leer.nextInt();
        Producto prod = p.get(opcion - 1);
        System.out.println("Que deseas modificar: ");
        System.out.println("1 - Nombre\n2 - Precio\n3 - Codigo fabricante: ");
        int opcion2 = Leer.nextInt();
        switch (opcion2) {
            case 1:
                System.out.println("Ingresa el nuevo nombre: ");
                prod.setNombre(Leer.next());
                modProd(prod, "nombre");
                break;
            case 2:
                System.out.println("Ingresa el nuevo precio: ");
                prod.setPrecio(Leer.nextDouble());
                modProd(prod, "precio");
                break;
            case 3:
                f = fs.allFabricante();
                for (Fabricante fabricante1 : f) {
                    System.out.println(fabricante1);
                }
                System.out.println("Ingresa el nuevo codigo del fabricante: ");
                prod.setCodigoFabricante(Leer.nextInt());
                modProd(prod, "codigoFabricante");
                break;
            default:
                System.out.println("Escoge una opcion valida...");
        }

    }
}
