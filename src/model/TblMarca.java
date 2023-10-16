package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_marca database table.
 * 
 */
@Entity
@Table(name="tbl_marca")
@NamedQuery(name="TblMarca.findAll", query="SELECT t FROM TblMarca t")
public class TblMarca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmarca;

	private String descri;

	public TblMarca() {
	}

	public int getIdmarca() {
		return this.idmarca;
	}

	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
	}

	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

}