/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.servicio;

import java.util.ArrayList;
import main.entidad.Fabricante;
import main.persistencia.FabricanteDAO;

public class FabricanteServicio {

    private FabricanteDAO dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDAO();
    }

    public void insertFabricante(Fabricante fabricante) throws Exception {
        dao.guardarFabricante(fabricante);
    }

    public ArrayList<Fabricante> allFabricante() throws Exception {
        return dao.buscarVariosFabricante();
    }
}
