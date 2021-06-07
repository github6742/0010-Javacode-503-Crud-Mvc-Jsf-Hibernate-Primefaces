/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.model.Tbdepartamento;
import sys.model.Tbempleado;
import sys.model.Tbmunicipio;
import sys.model.Tbpais;
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
        System.out.println("nuevoEmpleado-0010-");
        try {
            sesion.beginTransaction();
            System.out.println("nuevoEmpleado-0020-");
            sesion.save(tbempleado);
            System.out.println("nuevoEmpleado-0030-");
            sesion.getTransaction().commit();
            System.out.println("nuevoEmpleado-0040-");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("nuevoEmpleado-0050-");
            sesion.getTransaction().rollback();
            System.out.println("nuevoEmpleado-0060-");
        } finally {
            System.out.println("nuevoEmpleado-0070-");
            if (sesion != null){
            System.out.println("nuevoEmpleado-0080-");
                sesion.close();
            }
        }
            System.out.println("nuevoEmpleado-0090-");
        
    }

    @Override
    public List<Tbpais> listarPaises() {
        
        List<Tbpais> listarPaises = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sesion.beginTransaction();
        
        String hql = "FROM Tbpais";
        
        try {
            listarPaises = sesion.createQuery(hql).list();
            transaction.commit();
            sesion.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        
        return listarPaises;
    }

    @Override
    public List<Tbdepartamento> listarDepartamentos(Tbempleado empleado) {
        
        List<Tbdepartamento> listarDeptos = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sesion.beginTransaction();
        
        String hql = "FROM Tbdepartamento WHERE idPais ='"+empleado.getTbpais().getIdPais()+"'";
        
        try {
            listarDeptos = sesion.createQuery(hql).list();
            transaction.commit();
            sesion.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        
        return listarDeptos;
    }

    @Override
    public List<Tbmunicipio> listarMunicipios(Tbempleado empleado) {
        
        List<Tbmunicipio> listarMunicipios = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sesion.beginTransaction();
        
        String hql = "FROM Tbmunicipio WHERE idDepartamento ='"+empleado.getTbdepartamento().getIdDepartamento()+"'";
        
        try {
            listarMunicipios = sesion.createQuery(hql).list();
            transaction.commit();
            sesion.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        
        return listarMunicipios;
    }

    @Override
    public void modificarEmpleado(Tbempleado tbempleado) {
       
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        System.out.println("modificarEmpleado-0010-");
        try {
            sesion.beginTransaction();
            System.out.println("modificarEmpleado-0020-");
            sesion.update(tbempleado);
            System.out.println("modificarEmpleado-0030-");
            sesion.getTransaction().commit();
            System.out.println("modificarEmpleado-0040-");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("modificarEmpleado-0050-");
            sesion.getTransaction().rollback();
            System.out.println("modificarEmpleado-0060-");
        } finally {
            System.out.println("modificarEmpleado-0070-");
            if (sesion != null){
            System.out.println("modificarEmpleado-0080-");
                sesion.close();
            }
        }
            System.out.println("modificarEmpleado-0090-");
        
    }

    @Override
    public void eliminarEmpleado(Tbempleado tbempleado) {
        
       
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        System.out.println("deleteEmpleado-0010-");
        try {
            sesion.beginTransaction();
            System.out.println("deleteEmpleado-0020-");
            sesion.delete(tbempleado);
            System.out.println("deleteEmpleado-0030-");
            sesion.getTransaction().commit();
            System.out.println("deleteEmpleado-0040-");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("deleteEmpleado-0050-");
            sesion.getTransaction().rollback();
            System.out.println("deleteEmpleado-0060-");
        } finally {
            System.out.println("deleteEmpleado-0070-");
            if (sesion != null){
            System.out.println("deleteEmpleado-0080-");
                sesion.close();
            }
        }
            System.out.println("deleteEmpleado-0090-");
    }

    
}
