package Logueo;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.TblCliente;

import javax.swing.JComboBox;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import Dao.ClassCrudCliente;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class FrmCliente extends JInternalFrame {
	private JTextField textFieldNOMBRE;
	private JTextField textFieldAPELLIDO;
	private JTextField textFieldEmail;
	private JDateChooser fechanacim;
	private JComboBox comboBoxSEXO;
	ClassCrudCliente cliente=new ClassCrudCliente();
	private JTable tableSalida;
	DefaultTableModel model=new DefaultTableModel();
	private JScrollPane scrollPane;
	int filaseleccionada=0;
	private JTextField textFieldCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/*
	void registrar(TblCliente cli){
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

	}   //fin del metodo registrar....*/
	/**
	 * Create the frame.
	 */
	public FrmCliente() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 657, 436);
		getContentPane().setLayout(null);
		
		JLabel lblRegistrarEmpleado = new JLabel("Gestionar  Cliente");
		lblRegistrarEmpleado.setForeground(Color.BLUE);
		lblRegistrarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegistrarEmpleado.setBounds(114, 28, 193, 14);
		getContentPane().add(lblRegistrarEmpleado);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(75, 93, 46, 14);
		getContentPane().add(lblNombre);
		
		textFieldNOMBRE = new JTextField();
		textFieldNOMBRE.setBounds(166, 90, 86, 20);
		getContentPane().add(textFieldNOMBRE);
		textFieldNOMBRE.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(75, 118, 46, 28);
		getContentPane().add(lblApellido);
		
		textFieldAPELLIDO = new JTextField();
		textFieldAPELLIDO.setBounds(166, 121, 86, 20);
		getContentPane().add(textFieldAPELLIDO);
		textFieldAPELLIDO.setColumns(10);
		
		JLabel lblSexo_1 = new JLabel("Sexo");
		lblSexo_1.setBounds(75, 157, 46, 14);
		getContentPane().add(lblSexo_1);
		
		comboBoxSEXO = new JComboBox();
		comboBoxSEXO.setModel(new DefaultComboBoxModel(new String[] {"selecciones sexo", "F", "M"}));
		comboBoxSEXO.setBounds(166, 154, 86, 20);
		getContentPane().add(comboBoxSEXO);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(52, 188, 79, 14);
		getContentPane().add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(166, 185, 86, 20);
		getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmCliente.class.getResource("/Imagenes/save.png")));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//recuperamos valores del formulario
				//String codigo=textFieldCODIGO.getText();
				String nombre=textFieldNOMBRE.getText();
				String apellido=textFieldAPELLIDO.getText();
				String sexo=comboBoxSEXO.getSelectedItem().toString();
				String email=textFieldEmail.getText();
				String fechanac=LeerFecha();
				
				
				//String fechanacim=LeerFecha();
				//instaciamos las respectivas clases...
				TblCliente clemp=new TblCliente();
				clemp.setNombre(nombre);
				clemp.setApellido(apellido);
                clemp.setSexo(sexo);
                clemp.setEmail(email);
                try {
					clemp.setFechanac(Fecha_Actual(fechanac));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                   ////*****************otra forma para registrar fechas...
				  //hacemos una respectivos formateos
                /*
	               SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");    
	               Date fecha;
	               try {
					fecha=sdf.parse(fechanac);
					Date fechasql=new Date(fecha.getTime());
		            clemp.setFechanac(fechasql);
					
				} catch (ParseException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}*/
				
				
				
               
              //  registrar(clemp);
	            cliente.RegistrarCliente(clemp);
                limpiar();
                MostrarListadoEmpleados();
                //hacemos una respectivos formateos
             /*  SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");    
               Date fecha;
               try {
				fecha=sdf.parse(fechanacim);
				Date fechasql=new Date(fecha.getTime());
	            clemp.setFechanac(fechasql);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
               //=new Date();
               */
                
                //instanciamos la clase  classcrudempleado y guardamos a la base de datos
               // ClassCrudEmpleado crud=new ClassCrudEmpleado();
                //crud.GuardarEmpleado(clemp);
                
				//creamos un array de tipo Object...
				/*Object[] datos=new Object[5];
				datos[0]=codigo;
				datos[1]=nombre;
				datos[2]=apellido;
				datos[3]=sexo;
				datos[4]=fechanacim;
				//enviamos el array hacia el objeto modelo
				//generamos las respectivas filas...
				modelo.addRow(datos);*/
                
                //invocamos al metodo listado de empleados
                
               // MostrarListadoEmpleados();
                //invocamos al metodo limpiar
				//limpiar();
				
			}    //fin del metodo registrar....
		});
		btnRegistrar.setBounds(322, 45, 140, 42);
		getContentPane().add(btnRegistrar);
		
		JLabel lblFecha = new JLabel("FechaNac.");
		lblFecha.setBounds(45, 216, 86, 14);
		getContentPane().add(lblFecha);
		
		fechanacim = new JDateChooser();
		fechanacim.setDateFormatString("dd-MM-yyyy");
		fechanacim.setBounds(157, 210, 130, 20);
		getContentPane().add(fechanacim);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 279, 579, 116);
		getContentPane().add(scrollPane);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(75, 68, 46, 14);
		getContentPane().add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(166, 59, 86, 20);
		getContentPane().add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(FrmCliente.class.getResource("/Imagenes/edit.png")));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//recuperamos valores del formulario
				//String codigo=textFieldCODIGO.getText();
				int codi=Integer.parseInt(textFieldCodigo.getText());
				String nombre=textFieldNOMBRE.getText();
				String apellido=textFieldAPELLIDO.getText();
				String sexo=comboBoxSEXO.getSelectedItem().toString();
				String email=textFieldEmail.getText();
				
				
				//System.out.println("fecha desde actualizar "+fechanac);
				//String fechanacim=LeerFecha();
				//instaciamos las respectivas clases...
				TblCliente clemp=new TblCliente();
				clemp.setIdlcliente(codi);
				clemp.setNombre(nombre);
				clemp.setApellido(apellido);
                clemp.setSexo(sexo);
                clemp.setEmail(email);
                String fechanac=LeerFecha();
					
			
				
				  //hacemos una respectivos formateos
                
	               SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");    
	               Date fecha;
	               try {
					fecha=sdf.parse(fechanac);
					Date fechasql=new Date(fecha.getTime());
		            clemp.setFechanac(fechasql);
					
				} catch (ParseException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				//invocamos el metodo leer fecha...
				
				
               // clemp.setFechanac(fechanac);
              //  registrar(clemp);
	            cliente.ActualizarCliente(clemp);
                limpiar();
                MostrarListadoEmpleados();
              
				
			}    //fin del metodo  ...
		});
		btnActualizar.setBounds(322, 101, 140, 45);
		getContentPane().add(btnActualizar);
		
		//tableSalida = new JTable();
		//tableSalida.setBounds(40,40,40,40);
		//scrollPane.setViewportView(tableSalida);
		
		MostrarListadoEmpleados();
	    textFieldCodigo.setEnabled(false);
	    
	    JButton btnEliminar = new JButton("Eliminar");
	    btnEliminar.setIcon(new ImageIcon(FrmCliente.class.getResource("/Imagenes/delete.png")));
	    btnEliminar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		//recuperamos valores del formulario
				//String codigo=textFieldCODIGO.getText();
				int codi=Integer.parseInt(textFieldCodigo.getText());
				//instaciamos las respectivas clases...
				TblCliente clemp=new TblCliente();
				  if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿desea continuar?",
					        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				  {
					    clemp.setIdlcliente(codi);
						cliente.EliminarCliente(clemp);
		                limpiar();
		                MostrarListadoEmpleados();
			    		
					 
					    }   //fin del if
				
	    		
	    	}   //fin del metodo eliminar...
	    });
	    btnEliminar.setBounds(332, 165, 130, 37);
	    getContentPane().add(btnEliminar);
	    
	    JButton btnFiltrar = new JButton("Filtrar");
	    btnFiltrar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		//String codigo=textFieldCODIGO.getText();
				int codi=Integer.parseInt(textFieldCodigo.getText());
				//instaciamos las respectivas clases...
				TblCliente clemp=new TblCliente();
				clemp.setIdlcliente(codi);
				cliente.BuscarClientexcod(clemp);
                limpiar();
                MostrarListadoEmpleados();
	    		
	    	}    //fin del metodo buscar...
	    });
	    btnFiltrar.setBounds(342, 212, 89, 23);
	    getContentPane().add(btnFiltrar);
	    
	    
	   

	}      //fin del constructor...
	
	
	
	
	
	
	
	
		
	// creamos el metodo mostrar listado de empleados...

	public void MostrarListadoEmpleados() {
		// tableSALIDA = new JTable();
		tableSalida = new JTable();
		tableSalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				filaseleccionada = tableSalida.getSelectedRow();

				// aplicamos una condicion
				if (filaseleccionada != -1) {
					// asignamos valores del tableSalida a los campos
					// textfield,etc....
					textFieldCodigo.setText(tableSalida.getValueAt(filaseleccionada, 0).toString());
					textFieldNOMBRE.setText(tableSalida.getValueAt(filaseleccionada, 1).toString());
					textFieldAPELLIDO.setText(tableSalida.getValueAt(filaseleccionada, 2).toString());
					comboBoxSEXO.setSelectedItem(tableSalida.getValueAt(filaseleccionada, 3).toString());
					textFieldEmail.setText(tableSalida.getValueAt(filaseleccionada, 4).toString());
					// String
					// fecha=tableSalida.getValueAt(filaseleccionada,5).toString();
					
					int cod = (int) tableSalida.getValueAt(filaseleccionada, 0);
			
				
					try {
						fechanacim.setDate(Fecha_Actual(QueryfechaActual(cod).getSingleResult().toString()));
					} catch (ParseException e1) {
					
						e1.printStackTrace();
					}   //fin del catch....
                      
				}

			} // fin del metodo void mouse....
		});
		model = new DefaultTableModel();
		// agregamos las columnas para la visualizar los datos el empleado
		model.setColumnIdentifiers(
				new Object[] { "Codigo", "Nombre", "Apellido", "Sexo", "Email", "Fecha de Nacimiento" });

		// instanciamos las respectivas clases...
		TblCliente clemp = new TblCliente();
		ClassCrudCliente crud = new ClassCrudCliente();
		List<TblCliente> listarempl = crud.ListadoCliente();
		// QueryfechaActual(cod).getSingleResult().toString())
		// aplicamos un bucle
		for (TblCliente listar : listarempl) {
			model.addRow(
					new Object[] { listar.getIdlcliente(), listar.getNombre(), listar.getApellido(), listar.getSexo(),
							listar.getEmail(), QueryfechaActual(listar.getIdlcliente()).getSingleResult().toString() });
		} // fin del bucle for....
			// vinculamos los objetos modelo con tablesalida mediante el metodo
			// setmodel....
		tableSalida.setModel(model);
		// vinculamos el objeto tablesalida con scrollpane para poder
		// visualizarlo..
		scrollPane.setViewportView(tableSalida);
	} // fin del metodo mostrar empleados...
		
	public Date Fecha_Actual(String fecha) throws ParseException {
		Date fecha2;
		SimpleDateFormat formatotxt = new SimpleDateFormat("yyyy-MM-dd");
		fecha2 = formatotxt.parse(fecha);
		return fecha2;
	} // fin del metodo...
	
	public Query QueryfechaActual(int cod) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDJPA");
		Query q = null;
		EntityManager em = emf.createEntityManager();
		String cons = "select fechanac from tbl_cliente where idlcliente=?";
		q = em.createNativeQuery(cons).setParameter(1, cod);
		return q;
	} // fin del metodo...
		
	// creamos el metodo leer fecha()...
	public String LeerFecha() {
		// instanciamos la clase simpledateformat...
		// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// retornamos la fecha
		return sdf.format(fechanacim.getDate());
	} // fin del metodo leer fecha...
		
	// creamos un metodo limpiar()
	public void limpiar() {
		textFieldCodigo.setText("");
		textFieldEmail.setText("");
		textFieldNOMBRE.setText("");
		textFieldAPELLIDO.setText("");
		comboBoxSEXO.setSelectedIndex(0);
		fechanacim.setCalendar(null);
	} // fin del metodo limpiar....	
}   //fin de la clase
