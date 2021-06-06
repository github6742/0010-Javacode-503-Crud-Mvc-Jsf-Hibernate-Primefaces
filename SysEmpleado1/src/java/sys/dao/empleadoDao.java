/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Tbempleado;

/**
 *
 * @author sgrsm
 */
public interface empleadoDao {
    // metodo para mostras listado de empleados
    public List<Tbempleado> mostrarEmpleados();
    
    //
    public void nuevoEmpleado(Tbempleado tbempleado);
}
