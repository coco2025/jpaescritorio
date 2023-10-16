package TestCrudAuto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import model.TblAuto;

public class TestAuto {

	public static void main(String[] args) {
		// establecer conexión  --> con la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("BDJPA");
		// manejador de entidades --> según la fábrica
		EntityManager em = fabrica.createEntityManager();
		// proceso -> "registro/actualización/eliminación" --> transacción
		em.getTransaction().begin();
		//aplicamos un switch...
	  String accion=JOptionPane.showInputDialog("Ingrese Accion");
	  TblAuto auto=new TblAuto();
	   switch(accion){
	   case "Registrar":
		    auto.setMarca("Hyundai");
			auto.setModelo("elantra");
			auto.setColor("azul marino");
			auto.setPrecio(17000);
			auto.setMoto("1.2");
			//em.remove(elim);
			//registramos datos
			em.persist(auto);
			System.out.println("Datos registrado en BD");
			em.getTransaction().commit();
			em.close();

			break;
	   case  "Actualizar":
		    auto.setIdauto(7);
		    auto.setMarca("subaru");
			auto.setModelo("deportivo");
			auto.setColor("rojo oscuro");
			auto.setPrecio(17000);
			auto.setMoto("1.2");
			//em.remove(elim);
			//actualizamos datos
			em.merge(auto);
			System.out.println("Datos actualizados en BD");
			em.getTransaction().commit();
			em.close();  
			break;
	   case "Eliminar":
		   auto.setIdauto(7);
		   TblAuto elim=em.merge(auto);
		   em.remove(elim);
		   System.out.println("Datos eliminados en BD");
		   em.getTransaction().commit();
		   em.close();
		   break;		
	   case  "Buscar":
		   TblAuto bus = em.find(TblAuto.class,6);
			
			if (bus == null) {
				System.out.println("registro NO existe!!!");
			} else {
				System.out.println("registro encontrado");
				System.out.println("codigo "+bus.getIdauto()+" marca "+bus.getMarca()+" color "+ bus.getColor());
			}
			break;
	   case  "EliminarII":
		   TblAuto eli = em.find(TblAuto.class,5);
			
			if (eli == null) {
				System.out.println("registro no existe!!!");
			} else {
				System.out.println("registro encontrado y eliminado");
				em.remove(eli);
				em.getTransaction().commit();
				em.close();
			}
			System.out.println("Dato eliminado de la segunda forma");
			break;	
	   case "Listar":
		   List<TblAuto> lstUsuarios = 
			em.createQuery("select u from TblAuto u",TblAuto.class).getResultList();	
	System.out.println("Listado");
	for (TblAuto u : lstUsuarios) {
		System.out.println(u.getIdauto()+" "+u.getMarca()+" "+u.getModelo());
	}	
   em.getTransaction().commit();
   em.close();	   
			break;
	   case "Consultar":
		   
		   String marca =JOptionPane.showInputDialog("Ingrese la Marca");
		   String modelo =JOptionPane.showInputDialog("Ingrese el modelo");
			
		   /*Query consulta = 
		   em.createQuery("select a from tb_auto where marca = ? and modelo = ?", TblAuto.class);
  */
		   Query consulta=em.createQuery("select u from TblAuto u where u.marca = :x and u.modelo = :y",TblAuto.class);
				//   .setParameter("x",marca)
				  // .setParameter("y",modelo);
		
			consulta.setParameter("x",marca);
			consulta.setParameter("y",modelo);
			
			try{
			TblAuto cons=(TblAuto) consulta.getSingleResult();	
	      
			System.out.println(cons.getIdauto()+" "+cons.getMarca()+" "+cons.getModelo()+" "+cons.getColor());
			
			}catch(Exception ex){
				
				System.out.println("Registro no encontrado");
			}	
			em.getTransaction().commit();
			em.close();
			break;
			
	 default:
		 System.out.println("accion no encontrada");
		 break;
		}   //fin del switch...

	}    //fin del metodo principal....

}   //fin de la clase....
