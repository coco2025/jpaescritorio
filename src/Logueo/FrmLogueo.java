package Logueo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.TblAuto;
import model.TblUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLogueo extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogueo frame = new FrmLogueo();
					frame.setVisible(true);
					//centrar el formulario
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogueo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(5, 5, 424, 251);
		contentPane.add(label);
		
		JLabel lblUsuario = new JLabel("usuario");
		lblUsuario.setBounds(91, 59, 46, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(157, 56, 157, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(75, 100, 46, 14);
		contentPane.add(lblPassword);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(157, 97, 157, 20);
		contentPane.add(txtClave);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnAcceder.setBounds(192, 147, 89, 23);
		contentPane.add(btnAcceder);
	}    //fin del constructor...
	
	void ingresar() {
		// leer los campos del frm
		String usuario = leerUsuario();
		String clave = leerClave();
		
		// obtener un Usuario seg n los campos del usuario y clave
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("BDJPA");
		EntityManager em = fabrica.createEntityManager();
		// Usuario u = em.find(Usuario.class, 60); 
		// .find().. solo busca usando el ID -> devuelve un obj o null
		// crear consulta -> select * from tb_xxxx where usr_usua = ? and cla_usua = ?
		
		Query consulta = 
		   //em.createNativeQuery("select * from TblAuto where marca = ? and modelo = ?",TblAuto.class);
			em.createQuery("select u from TblUsuario u where u.usuario = :x and u.password = :y", TblAuto.class);
		consulta.setParameter("x",usuario);
		consulta.setParameter("y",clave);
		//consulta.setParameter(2, usuario);
		//consulta.setParameter(3, clave);
		
		TblUsuario u;
		try {
			u = (TblUsuario) consulta.getSingleResult();
			// si el usuario existe, muestra el mensaje de bienvenida
			aviso("Bienvenido " + u.getUsuario(), "Aviso del Sistema", JOptionPane.INFORMATION_MESSAGE);
			
			//instancia de clase frmprincipal
			//FrmPrincipal prin=new FrmPrincipal();
			FrmMenu prin=new FrmMenu();
			//maximizamos el formulario
			prin.setExtendedState(MAXIMIZED_BOTH);
			//mostramos el formulario
			prin.setVisible(true);

		} catch (Exception e) {
			u = null;
			// sino muestra mensaje de error
			aviso("Usuario o clave incorrecto", "Error en ingreso", JOptionPane.ERROR_MESSAGE);
		}
	}   //fin del metod ingresar...
	
	void aviso(String msg, String tit, int icono) {
		JOptionPane.showMessageDialog(this, msg, tit, icono);
	}
	
	private String leerClave() {
		// pendiente las validaciones !!!!
		return String.valueOf(txtClave.getPassword());
	}

	private String leerUsuario() {
		// pendiente las validaciones !!!!
		return txtUsuario.getText();
	}

	
	
}
