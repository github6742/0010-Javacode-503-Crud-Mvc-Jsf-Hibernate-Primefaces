/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.model.Tbempleado;
import sys.util.HibernateUtil;

/**
 *
 * @author sgrsm
 */
public class empleadoDaoImpl implements empleadoDao{

    @Override
    public List<Tbempleado> mostrarEmpleados() {
        List<Tbempleado> listarEmpleados = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sesion.beginTransaction();
        
        String hql = "FROM Tbempleado as e inner join fetch e.tbpais left join fetch e.tbdepartamento left join fetch e.tbmunicipio";
        
        try {
            listarEmpleados = sesion.createQuery(hql).list();
            transaction.commit();
            sesion.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        
        return listarEmpleados;
    }

    @Override
    public void nuevoEmpleado(Tbempleado tbempleado) {
       
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
        try {
            sesion.beginTransaction();
            sesion.save(this);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null){
                sesion.close();
            }
        }
        
    }
    
}
