package sys.model;
// Generated 05/06/2021 23:13:07 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tbmunicipio generated by hbm2java
 */
@Entity
@Table(name="tbmunicipio"
    ,catalog="bdempleado"
)
public class Tbmunicipio  implements java.io.Serializable {


     private Integer idMunicipio;
     private Tbdepartamento tbdepartamento;
     private String nombreMunicipio;
     private Set tbempleados = new HashSet(0);

    public Tbmunicipio() {
    }

	
    public Tbmunicipio(Tbdepartamento tbdepartamento, String nombreMunicipio) {
        this.tbdepartamento = tbdepartamento;
        this.nombreMunicipio = nombreMunicipio;
    }
    public Tbmunicipio(Tbdepartamento tbdepartamento, String nombreMunicipio, Set tbempleados) {
       this.tbdepartamento = tbdepartamento;
       this.nombreMunicipio = nombreMunicipio;
       this.tbempleados = tbempleados;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idMunicipio", unique=true, nullable=false)
    public Integer getIdMunicipio() {
        return this.idMunicipio;
    }
    
    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idDepartamento", nullable=false)
    public Tbdepartamento getTbdepartamento() {
        return this.tbdepartamento;
    }
    
    public void setTbdepartamento(Tbdepartamento tbdepartamento) {
        this.tbdepartamento = tbdepartamento;
    }

    
    @Column(name="nombreMunicipio", nullable=false, length=50)
    public String getNombreMunicipio() {
        return this.nombreMunicipio;
    }
    
    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tbmunicipio")
    public Set getTbempleados() {
        return this.tbempleados;
    }
    
    public void setTbempleados(Set tbempleados) {
        this.tbempleados = tbempleados;
    }




}


