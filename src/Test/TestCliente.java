package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import Dao.ClassCrudCliente;
import model.TblCliente;

public class TestCliente {

	public static void main(String[] args) {
		// realizamos el respectivo testeo....
		//instaciamos las respectivas clases...
		TblCliente clemp=new TblCliente();
		ClassCrudCliente crud=new ClassCrudCliente();
		clemp.setNombre("luis");
		clemp.setApellido("ramirez tasayco");
        clemp.setSexo("M");
        clemp.setEmail("jorgeluis2005@hotmail.com");
		//convertimos la fecha a java.sql.
				Date fecha=new Date();
				Date fechasql=new Date(fecha.getTime());
				clemp.setFechanac(fechasql);
				//crud.RegistrarCliente(clemp);
				
				
				List<TblCliente> listar=crud.ListadoCliente();
				
			//	SimpleDateFormat forma1 = new SimpleDateFormat("dd/MM/yyyy");

				
				//aplicamos un bucle...
				
				for(TblCliente lis:listar){
					
				     


					//imprimimos por pantalla
					/*System.out.println("codigo "+lis.getIdlcliente()+" nombre "+lis.getNombre()
					+" apellido "+lis.getApellido()+" sexo "+lis.getSexo()+
					" email "+lis.getEmail()+" fechana "+lis.getFechanac());*/
					
					System.out.println(" nombre "+lis.getNombre()
					+" apellido "+lis.getApellido()+" fechana "+lis.getFechanac());
				}

	}   //fin del metodo principal....

}    //fin de la clase principal...
