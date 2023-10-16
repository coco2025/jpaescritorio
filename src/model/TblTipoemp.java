package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_tipoemp database table.
 * 
 */
@Entity
@Table(name="tbl_tipoemp")
@NamedQuery(name="TblTipoemp.findAll", query="SELECT t FROM TblTipoemp t")
public class TblTipoemp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtipoemp;

	private String descrip;

	//bi-directional many-to-one association to TblEmpleado
	@OneToMany(mappedBy="tblTipoemp")
	private List<TblEmpleado> tblEmpleados;

	public TblTipoemp() {
	}

	public int getIdtipoemp() {
		return this.idtipoemp;
	}

	public void setIdtipoemp(int idtipoemp) {
		this.idtipoemp = idtipoemp;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public List<TblEmpleado> getTblEmpleados() {
		return this.tblEmpleados;
	}

	public void setTblEmpleados(List<TblEmpleado> tblEmpleados) {
		this.tblEmpleados = tblEmpleados;
	}

	public TblEmpleado addTblEmpleado(TblEmpleado tblEmpleado) {
		getTblEmpleados().add(tblEmpleado);
		tblEmpleado.setTblTipoemp(this);

		return tblEmpleado;
	}

	public TblEmpleado removeTblEmpleado(TblEmpleado tblEmpleado) {
		getTblEmpleados().remove(tblEmpleado);
		tblEmpleado.setTblTipoemp(null);

		return tblEmpleado;
	}

}