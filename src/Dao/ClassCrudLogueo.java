package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import Interfaces.Iclienteable;
import Interfaces.Iusuarioable;
import Logueo.FrmMenu;
import model.TblAuto;
import model.TblUsuario;

public class ClassCrudLogueo implements Iusuarioable{

	@Override
	public void Logueo(String x, String y) {
		// obtener un Usuario seg n los campos del usuario y clave
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("BDJPA");
				EntityManager em = fabrica.createEntityManager();
				// Usuario u = em.find(Usuario.class, 60); 
				// .find().. solo busca usando el ID -> devuelve un obj o null
				// crear consulta -> select * from tb_xxxx where usr_usua = ? and cla_usua = ?
				
				Query consulta = 
				   //em.createNativeQuery("select * from TblAuto where marca = ? and modelo = ?",TblAuto.class);
			    em.createQuery("select u from TblUsuario u where u.usuario = :x and u.password = :y", TblAuto.class);
				consulta.setParameter("x",x);
				consulta.setParameter("y",y);
				//consulta.setParameter(2, usuario);
				//consulta.setParameter(3, clave);
				
				TblUsuario u;
				try {
					u = (TblUsuario) consulta.getSingleResult();
					// si el usuario existe, muestra el mensaje de bienvenida
					//aviso("Bienvenido " + u.getUsuario(), "Aviso del Sistema", JOptionPane.INFORMATION_MESSAGE);
					
					//instancia de clase frmprincipal
					//FrmPrincipal prin=new FrmPrincipal();
					//FrmMenu prin=new FrmMenu();
					//maximizamos el formulario
				//	prin.setExtendedState(MAXIMIZED_BOTH);
					//mostramos el formulario
				//	prin.setVisible(true);

				} catch (Exception e) {
					u = null;
					// sino muestra mensaje de error
				//	aviso("Usuario o clave incorrecto", "Error en ingreso", JOptionPane.ERROR_MESSAGE);
				}
		
	}



}