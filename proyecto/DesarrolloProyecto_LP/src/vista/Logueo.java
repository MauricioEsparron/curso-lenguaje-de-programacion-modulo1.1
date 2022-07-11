package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloTiempo;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class Logueo extends JFrame implements WindowListener, ActionListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	public static Logueo frame;
	private JButton btnAceptar;
	private JLabel lblTexto;
	public static JLabel lblTiempo;
	private JLabel lblCandadoCerrado;
	private JLabel lblCandadoAbierto;
	private JLabel lblImagen;
	private JLabel lblTexto2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Logueo();
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
	public Logueo() {
		setType(Type.UTILITY);
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Logueo.class.getResource("/img/7142978_vent_among us_steam_icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTexto2 = new JLabel("INICIO DE SESIÓN");
		lblTexto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto2.setForeground(Color.WHITE);
		lblTexto2.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
		lblTexto2.setBounds(345, 181, 247, 42);
		contentPane.add(lblTexto2);

		JLabel lblUsuario = new JLabel("Cod Cliente:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(24, 193, 111, 20);
		contentPane.add(lblUsuario);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(Logueo.class.getResource("/img/Paisaje.jpg")));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBackground(Color.WHITE);
		lblImagen.setBounds(316, 0, 307, 576);
		contentPane.add(lblImagen);

		JLabel lblClave = new JLabel("Num Tarjeta:");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClave.setBounds(24, 254, 111, 20);
		contentPane.add(lblClave);

		txtUsuario = new JTextField();
		txtUsuario.setForeground(new Color(169, 169, 169));
		txtUsuario.setText("1");
		txtUsuario.setToolTipText("");
		txtUsuario.setBounds(145, 194, 130, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtClave = new JPasswordField();
		txtClave.setBounds(145, 256, 130, 20);
		contentPane.add(txtClave);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setForeground(Color.BLUE);
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(32, 404, 103, 35);
		contentPane.add(btnAceptar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setForeground(new Color(255, 0, 0));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(194, 404, 96, 35);
		contentPane.add(btnSalir);

		lblTexto = new JLabel("Esta ventana se cerrara en ");
		lblTexto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTexto.setBounds(65, 551, 170, 14);
		contentPane.add(lblTexto);

		lblTiempo = new JLabel("20s");
		lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTiempo.setBounds(229, 551, 46, 14);
		contentPane.add(lblTiempo);

		lblCandadoCerrado = new JLabel("");
		lblCandadoCerrado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCandadoCerrado.setIcon(
				new ImageIcon(Logueo.class.getResource("/img/5402395_encryption_lock_password_security_key_icon.png")));
		lblCandadoCerrado.setVisible(true);
		lblCandadoCerrado.setBounds(92, 47, 114, 97);
		contentPane.add(lblCandadoCerrado);

		lblCandadoAbierto = new JLabel("");
		lblCandadoAbierto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCandadoAbierto.setIcon(
				new ImageIcon(Logueo.class.getResource("/img/5402433_access_decrypt_open_unlock_lock_icon.png")));
		lblCandadoAbierto.setVisible(false);
		lblCandadoAbierto.setBounds(92, 47, 114, 97);
		contentPane.add(lblCandadoAbierto);
	}

	private void iniciarConteo() {
		HiloTiempo h = new HiloTiempo();
		h.start();

	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}

	protected void windowOpenedThis(WindowEvent e) {
		iniciarConteo();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {

		Frmprincipal p = new Frmprincipal();
		p.setVisible(true);
		p.setLocationRelativeTo(this);
		this.dispose();
		lblCandadoCerrado.setVisible(false);
		lblCandadoAbierto.setVisible(true);

	}
}
