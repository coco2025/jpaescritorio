package Logueo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrmMenu extends JFrame {

	private JPanel contentPane;
	private JDesktopPane escritorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenu frame = new FrmMenu();
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
	public FrmMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSistema = new JMenu("SISTEMA");
		mnSistema.setIcon(new ImageIcon(FrmMenu.class.getResource("/Imagenes/sistem.png")));
		menuBar.add(mnSistema);
		
		JMenu mnOperaciones = new JMenu("OPERACIONES");
		mnOperaciones.setIcon(new ImageIcon(FrmMenu.class.getResource("/Imagenes/ajustes.png")));
		menuBar.add(mnOperaciones);
		
		JMenuItem mntmCrud = new JMenuItem("CRUD");
		mntmCrud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//instanciar la clase frmempleado...
				FrmCliente emp=new FrmCliente();
				escritorio.add(emp);
				//mostramos el formulario internaframe frmempleado
				emp.setVisible(true);

				
				
			}   //FIN DE ACTION PERFORMED...
		});
		mnOperaciones.add(mntmCrud);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		escritorio = new JDesktopPane();
		contentPane.add(escritorio, BorderLayout.CENTER);
	}

}
