package Test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TblAuto;

public class TestAuto {

	public static void main(String[] args) {
		         // establecer conexión  --> con la unidad de persistencia
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("BDJPA");
				// manejador de entidades --> según la fábrica
				EntityManager em = fabrica.createEntityManager();
				
				// proceso -> "registro/actualización/eliminación" --> transacción
				em.getTransaction().begin();
				/*TblAuto auto=new TblAuto();
				auto.setMarca("kia");
				auto.setModelo("rio");
				auto.setColor("rojo");
				auto.setPrecio(15000);
				auto.setMoto("1.2");
				//em.remove(elim);
				//registramos datos
				em.persist(auto);
			    em.getTransaction().commit();
			    em.close();*/
			    
			    TblAuto auto2=new TblAuto();
			    auto2.setIdauto(2);
				auto2.setMarca("mercedes benz");
				auto2.setModelo("f11");
				auto2.setColor("azul");
				auto2.setPrecio(18000);
				auto2.setMoto("1.2");
				//em.remove(elim);
				//registramos datos
				//em.persist(auto2);
				//em.merge(auto2);
				//eliminar.....
			    /*TblAuto elim=new TblAuto();
				    elim.setIdauto(2);
				    TblAuto del=em.merge(elim);
				em.remove(del);*/
				
				//buscar.....
			/*	TblAuto bus = em.find(TblAuto.class,3);
				
				if (bus == null) {
					System.out.println("registro no existe!!!");
				} else {
					System.out.println("registro encontrado");
					System.out.println(bus.getIdauto()+" "+bus.getMarca()+" "+ bus.getColor());
				}
				*/
				
				//buscar y eliminar....
          /* TblAuto buseli = em.find(TblAuto.class,3);
				
				if (buseli == null) {
					System.out.println("registro no existe!!!");
				} else {
					System.out.println("registro encontrado y eliminado");
					em.remove(buseli);
				}
				*/
				
				//************************consultas
				// proceso
				// select * from tb_xxx  --> List
				// createNamedQuery("")  --> llamar a una consulta asignando por un nombre
				// createNativeQuery("") --> utilizar sentencias SQL nativas  --> TypedQuery
				// createQuery("") --> utilizar sentencias JPQL -> SQL + JPA  -->
				//                                      select * from tb_xxx 
				List<TblAuto> lstUsuarios = 
						em.createQuery("select u from TblAuto u",TblAuto.class).getResultList();
				
				System.out.println("Listado");
				for (TblAuto u : lstUsuarios) {
					System.out.println(u.getIdauto()+" "+u.getMarca()+" "+u.getModelo());
				}

				
				
				
			    em.getTransaction().commit();
			    em.close();


	}    //fin del metodo principal....

}     //fin de la clase auto...
