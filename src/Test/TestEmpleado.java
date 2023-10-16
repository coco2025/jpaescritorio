package Test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TblAuto;
import model.TblEmpleado;
import model.TblTipoemp;

public class TestEmpleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   // establecer conexión  --> con la unidad de persistencia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("BDJPA");
		// manejador de entidades --> según la fábrica
		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> "registro/actualización/eliminación" --> transacción
		em.getTransaction().begin();
		TblTipoemp tipo=new TblTipoemp();
		TblEmpleado emp=new TblEmpleado();
		
		
		//***************registrar
		
	/*	tipo.setDescrip("solo sabados");
		emp.setNombre("georgina");
		emp.setApellido("ronaldo");
		emp.setEmail("ronaldo@gmail.com");
		emp.setSexo("f");
		Date fecha=new Date();
		Date fechasql=new Date(fecha.getTime());
		emp.setFechanac(fechasql);
		emp.setTblTipoemp(tipo);
		em.persist(emp);
		//em.merge(emp);
		System.out.println("Dato Registrado");
		em.getTransaction().commit();
		em.close();
*/
		
		//**********************actualizar
	/*	tipo.setIdtipoemp(6);
		tipo.setDescrip("solo sabados");
		emp.setIdempleado(5);
		emp.setNombre("georgina");
		emp.setApellido("ronaldo ronaldo");
		emp.setEmail("ronaldoronaldo@gmail.com");
		emp.setSexo("f");
		Date fecha=new Date();
		Date fechasql=new Date(fecha.getTime());
		emp.setFechanac(fechasql);
		emp.setTblTipoemp(tipo);
		//em.persist(emp);
		em.merge(emp);
		System.out.println("Dato Registrado");
		em.getTransaction().commit();
		em.close();		*/
	/*	TblEmpleado buscar=em.find(TblEmpleado.class,1);
		System.out.println(" codigo tipo "+buscar.getTblTipoemp().getIdtipoemp()+
				" descripcion "+buscar.getTblTipoemp().getDescrip()+" nombre "+
				buscar.getNombre()+" apellido "+buscar.getApellido()+" fechanac "+buscar.getFechanac());
		*/
		List<TblEmpleado> lstempleados = 
				em.createQuery("select e from TblEmpleado e",TblEmpleado.class).getResultList();
		for(TblEmpleado bus:lstempleados){
		System.out.println(" codigo tipo "+bus.getTblTipoemp().getIdtipoemp()+
				" descripcion "+bus.getTblTipoemp().getDescrip()+" nombre "+
				bus.getNombre()+" apellido "+bus.getApellido()+" fechanac "+bus.getFechanac());
		
		}

	}  //fin del metodo principal...

}    //fin de la clase...
