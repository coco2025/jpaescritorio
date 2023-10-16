package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Interfaces.Iclienteable;
import model.TblCliente;

public class ClassCrudCliente implements Iclienteable {

	@Override
	public void RegistrarCliente(TblCliente cli) {
		// TODO Auto-generated method stub
				 // establecer conexión  --> con la unidad de persistencia
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("BDJPA");
				// manejador de entidades --> según la fábrica
				EntityManager em = fabrica.createEntityManager();
				// proceso -> "registro/actualización/eliminación" --> transacción
				em.getTransaction().begin();
						//registramos datos
				em.persist(cli);
			    em.getTransaction().commit();
			    em.close();
				

		
	}

	@Override
	public void ActualizarCliente(TblCliente cli) {
		// TODO Auto-generated method stub
		 // establecer conexión  --> con la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("BDJPA");
		// manejador de entidades --> según la fábrica
		EntityManager em = fabrica.createEntityManager();
		// proceso -> "registro/actualización/eliminación" --> transacción
		em.getTransaction().begin();
				//actulizamos datos
		em.merge(cli);
	    em.getTransaction().commit();
	    em.close();
		
	}

	@Override
	public void EliminarCliente(TblCliente cli) {
		//establecemos la conexion con la unidad de persistencia...
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDJPA");
		//gestionar entidades como registrar,actualizar,eliminar,etc....
		EntityManager emanager=conex.createEntityManager();
		//iniciamos la transaccion....
		emanager.getTransaction().begin();	
		//recuperamos el codigo a eliminar..
		TblCliente elim=emanager.merge(cli);
		emanager.remove(elim);
		System.out.println("dato eliminado de la bd");
		//comfirmamos 
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		
	}

	@Override
	public List<TblCliente> ListadoCliente() {
		  //establecemos la conexion con la unidad de persistencia...
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDJPA");
		//gestionar entidades como registrar,actualizar,eliminar,etc....
		EntityManager emanager=conex.createEntityManager();
		//iniciamos la transaccion....
		emanager.getTransaction().begin();
		
		List<TblCliente> listado=emanager.createQuery("select e  from TblCliente e",TblCliente.class).getResultList();
		//comfirmamos
		emanager.getTransaction().commit();
		
		//cerramos
		emanager.close();
		
		return listado;
	}

	@Override
	public TblCliente BuscarClientexcod(TblCliente cli) {
		 //establecemos la conexion con la unidad de persistencia...
		EntityManagerFactory conex=Persistence.createEntityManagerFactory("BDJPA");
		//gestionar entidades como registrar,actualizar,eliminar,etc....
		EntityManager emanager=conex.createEntityManager();
		//iniciamos la transaccion....
		emanager.getTransaction().begin();			
		TblCliente buscar=emanager.find(TblCliente.class,cli.getIdlcliente());		
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
	    return buscar;
	}

}
