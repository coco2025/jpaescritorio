package Interfaces;

import java.util.List;

import model.TblCliente;

public interface Iclienteable {

	//creamos los respectivos metodos...
		public void RegistrarCliente(TblCliente cli);
		public void ActualizarCliente(TblCliente cli);
		public void EliminarCliente(TblCliente cli);
		public List<TblCliente> ListadoCliente();
		public TblCliente BuscarClientexcod(TblCliente cli);
	
	
	
}   //fin de la interfaz...
