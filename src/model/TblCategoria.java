package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_categoria database table.
 * 
 */
@Entity
@Table(name="tbl_categoria")
@NamedQuery(name="TblCategoria.findAll", query="SELECT t FROM TblCategoria t")
public class TblCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcategoria;

	private String descrip;

	//bi-directional many-to-one association to TblProducto
	@OneToMany(mappedBy="tblCategoria")
	private List<TblProducto> tblProductos;

	public TblCategoria() {
	}

	public int getIdcategoria() {
		return this.idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public List<TblProducto> getTblProductos() {
		return this.tblProductos;
	}

	public void setTblProductos(List<TblProducto> tblProductos) {
		this.tblProductos = tblProductos;
	}

	public TblProducto addTblProducto(TblProducto tblProducto) {
		getTblProductos().add(tblProducto);
		tblProducto.setTblCategoria(this);

		return tblProducto;
	}

	public TblProducto removeTblProducto(TblProducto tblProducto) {
		getTblProductos().remove(tblProducto);
		tblProducto.setTblCategoria(null);

		return tblProducto;
	}

}