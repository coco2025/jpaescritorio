package Logueo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	JDesktopPane escritorio = new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setTitle("software de INVENTARIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.CYAN);
		setJMenuBar(menuBar);
		
		JMenu mnSistema = new JMenu("Sistema");
		mnSistema.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/ajustes.png")));
		menuBar.add(mnSistema);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnSistema.add(mntmSalir);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/clientes.png")));
		menuBar.add(mnClientes);
		
		JMenuItem mntmCrud = new JMenuItem("Registrar");
		mntmCrud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instanciar la clase frmempleado...
				FrmCliente emp=new FrmCliente();
				escritorio.add(emp);
				//mostramos el formulario internaframe frmempleado
				emp.setVisible(true);

				
				
			}  //fin del metodo actionperformed...
		});
		mnClientes.add(mntmCrud);
		
		JMenuItem mntmRegistrar = new JMenuItem("Actualizar");
		mnClientes.add(mntmRegistrar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mnClientes.add(mntmEliminar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mnClientes.add(mntmListar);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mnClientes.add(mntmBuscar);
		
		JMenu mnProductos = new JMenu("Productos");
		mnProductos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/Imagenes/productos.png")));
		menuBar.add(mnProductos);
		
		JMenu mnProveedores = new JMenu("Proveedores");
		menuBar.add(mnProveedores);
		
		JMenu mnAutos = new JMenu("Autos");
		menuBar.add(mnAutos);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		escritorio.setForeground(Color.BLACK);
		escritorio.setBackground(Color.BLACK);
		escritorio.setBounds(422, 172, -415, -172);
		contentPane.add(escritorio);
	}
}
