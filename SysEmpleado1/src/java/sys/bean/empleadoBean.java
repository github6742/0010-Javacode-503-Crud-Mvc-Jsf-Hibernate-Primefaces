package sys.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sys.dao.empleadoDao;
import sys.dao.empleadoDaoImpl;
import sys.model.Tbempleado;

@ManagedBean
@SessionScoped        
public class empleadoBean implements Serializable{
        
    private List<Tbempleado> listar;
    private Tbempleado empleado;    
    
    public empleadoBean(){
        
    }

    public Tbempleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Tbempleado empleado) {
        this.empleado = empleado;
    }

    public List<Tbempleado> getListar() {
        empleadoDao eDao = new empleadoDaoImpl();
        listar = eDao.mostrarEmpleados();        
        return listar;
    }
    
    public void nuevoEmpleado(){
        empleadoDao eDao = new empleadoDaoImpl();
        eDao.nuevoEmpleado(empleado);
        empleado = new Tbempleado();
    }
    
}
