package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_empleado database table.
 * 
 */
@Entity
@Table(name="tbl_empleado")
@NamedQuery(name="TblEmpleado.findAll", query="SELECT t FROM TblEmpleado t")
public class TblEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idempleado;

	private String apellido;

	private String email;

	@Temporal(TemporalType.DATE)
	private Date fechanac;

	private String nombre;

	private String sexo;

	//bi-directional many-to-one association to TblTipoemp
	@ManyToOne(optional=false,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="idtipoemp")
	private TblTipoemp tblTipoemp;

	public TblEmpleado() {
	}

	public int getIdempleado() {
		return this.idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechanac() {
		return this.fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public TblTipoemp getTblTipoemp() {
		return this.tblTipoemp;
	}

	public void setTblTipoemp(TblTipoemp tblTipoemp) {
		this.tblTipoemp = tblTipoemp;
	}

}