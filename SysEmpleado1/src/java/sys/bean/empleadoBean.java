package sys.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import sys.dao.empleadoDao;
import sys.dao.empleadoDaoImpl;
import sys.model.Tbdepartamento;
import sys.model.Tbempleado;
import sys.model.Tbmunicipio;
import sys.model.Tbpais;

@ManagedBean
@SessionScoped
public class empleadoBean implements Serializable {

    private List<Tbempleado> listar;
    private Tbempleado empleado;
    private List<SelectItem> listPaises;
    private List<SelectItem> listDepartamentos;
    private List<SelectItem> listMunicipios;

    public empleadoBean() {
        empleado = new Tbempleado();
    }

    public Tbempleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Tbempleado empleado) {
        this.empleado = empleado;
    }

    public List<Tbempleado> getListar() {
        if (listar == null) {
            try {
                empleadoDao eDao = new empleadoDaoImpl();
                listar = eDao.mostrarEmpleados();
            } catch (Exception e) {
                System.out.println("Error al listar los empluados: " + e);
            }
        }
        return listar;
    }

    public void preparNuevoEmpleado(ActionEvent actionEvent) {
        empleado = new Tbempleado();
    }

    public void nuevoEmpleado() {
        empleadoDao eDao = new empleadoDaoImpl();
        eDao.nuevoEmpleado(empleado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Correcto",
                "El registro se guardo satisfactorimante"));

    }

    public void modificarEmpleado() {
        empleadoDao eDao = new empleadoDaoImpl();
        eDao.modificarEmpleado(empleado);
        empleado = new Tbempleado();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Correcto",
                "El registro se modifico satisfactorimante"));
    }

    public void eliminarEmpleado() {
        empleadoDao eDao = new empleadoDaoImpl();
        eDao.eliminarEmpleado(empleado);
        empleado = new Tbempleado();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Correcto",
                "El registro se elimino satisfactorimante"));
    }

    public List<SelectItem> getListPaises() {
        this.listPaises = new ArrayList<SelectItem>();
        empleadoDao eDao = new empleadoDaoImpl();
        List<Tbpais> p = eDao.listarPaises();
        listPaises.clear();

        for (Tbpais pais : p) {
            SelectItem paisItem = new SelectItem(pais.getIdPais(), pais.getNombrePais());
            this.listPaises.add(paisItem);
        }

        return listPaises;
    }

    public List<SelectItem> getListDepartamentos() {
        this.listDepartamentos = new ArrayList<SelectItem>();
        empleadoDao eDao = new empleadoDaoImpl();
        List<Tbdepartamento> d = eDao.listarDepartamentos(this.empleado);
        listDepartamentos.clear();

        for (Tbdepartamento depto : d) {
            SelectItem deptoItem = new SelectItem(depto.getIdDepartamento(), depto.getNombreDepartamento());
            this.listDepartamentos.add(deptoItem);
        }

        return listDepartamentos;
    }

    public List<SelectItem> getListMunicipios() {
        this.listMunicipios = new ArrayList<SelectItem>();
        empleadoDao eDao = new empleadoDaoImpl();
        List<Tbmunicipio> m = eDao.listarMunicipios(this.empleado);
        listMunicipios.clear();

        for (Tbmunicipio mun : m) {
            SelectItem munItem = new SelectItem(mun.getIdMunicipio(), mun.getNombreMunicipio());
            this.listMunicipios.add(munItem);
        }

        return listMunicipios;
    }

    public void cancelar() {
        empleado = new Tbempleado();
    }

}
