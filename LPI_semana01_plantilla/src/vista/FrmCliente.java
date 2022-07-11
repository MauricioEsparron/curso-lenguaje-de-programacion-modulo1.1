package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import validaciones.Validaciones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmCliente extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCodigo;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JTextField txtCodigo;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JButton btnNuevo;
	private JButton btnGuardar;

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

	/**
	 * Create the frame.
	 */
	public FrmCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Mantenimiento de Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(22, 11, 201, 14);
		contentPane.add(lblNewLabel);

		lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(22, 36, 59, 14);
		contentPane.add(lblCodigo);

		lblDni = new JLabel("Dni:");
		lblDni.setBounds(22, 71, 59, 14);
		contentPane.add(lblDni);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 103, 59, 14);
		contentPane.add(lblNombre);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(22, 139, 59, 14);
		contentPane.add(lblApellido);

		lblTelefono = new JLabel("tel\u00E9fono:");
		lblTelefono.setBounds(23, 176, 59, 14);
		contentPane.add(lblTelefono);

		lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(22, 213, 59, 14);
		contentPane.add(lblCorreo);

		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(this);
		txtCodigo.setBounds(91, 36, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtDni = new JTextField();
		txtDni.addKeyListener(this);
		txtDni.setBounds(91, 68, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setBounds(91, 100, 142, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.addKeyListener(this);
		txtApellido.setBounds(91, 136, 142, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(this);
		txtTelefono.setBounds(91, 173, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(this);
		txtCorreo.setBounds(91, 210, 142, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(377, 36, 89, 23);
		contentPane.add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(377, 71, 89, 23);
		contentPane.add(btnGuardar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {

	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		ingresar();

	}

	void ingresar() {
		String cod, nomb, ape, correo;
		int dni, telefono;

		cod = leerCodigo();
		dni = leerDni();
		nomb = leerNombre();
		ape = leerApellido();
		telefono = leerTelefono();
		correo = leerCorreo();

		if (cod == null || dni == -1 || nomb == null || ape == null || telefono == -1) {

			// mostrar ventna de error
			return;
		} else {
			// mostrar datos en la tabla

		}

	}

	private String leerCodigo() {
		String cod = null;
		if (txtCodigo.getText().trim().length() == 0) {// validamos que no este vacio
			mensajeError("Ingresar el código del producto");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
			txtCodigo.setBackground(Color.RED);
			cod = null;
		} else if (txtCodigo.getText().trim().matches(Validaciones.CODIGO_PRODUCTO)) {// realizamos la validacion
			cod = txtCodigo.getText();
		} else {
			mensajeError("Formato del código no válido. Ejem P0001 ó p0001");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
			txtCodigo.setBackground(Color.RED);
			cod = null;
		}
		return cod;
	}

	private int leerDni() {
		int dni = -1;
		if (txtDni.getText().trim().length() == 0) {
			mensajeError("Ingresa el número de Dni");
			txtDni.setText("");
			txtDni.requestFocus();
			txtDni.setBackground(Color.RED);
			dni = -1;
		} else if (txtDni.getText().trim().matches(Validaciones.DNI)) {
			dni = Integer.parseInt(txtDni.getText());
		} else {
			mensajeError("Ingreso de dats no válido. debe contener 8 caracteres");
			txtDni.setText("");
			txtDni.requestFocus();
			txtDni.setBackground(Color.RED);
			dni = -1;
		}
		return dni;
	}

	private String leerNombre() {
		String nomb = null;
		if (txtNombre.getText().trim().length() == 0) {
			mensajeError("Debes ingresar un nombre para poder continuar");
			txtNombre.setText("");
			txtNombre.requestFocus();
			txtNombre.setBackground(Color.RED);
			nomb = null;
		} else if (txtNombre.getText().trim().matches(Validaciones.NOMBRE)) {// relizamos la validación
			nomb = txtNombre.getText();
		} else {
			mensajeError("Debes ingresar un nombre que contenga de 3 a 15 caracteres");
			txtNombre.setText("");
			txtNombre.requestFocus();
			txtNombre.setBackground(Color.RED);
			nomb = null;
		}

		return nomb;
	}

	private String leerApellido() {
		String ape = null;
		if (txtApellido.getText().trim().length() == 0) {
			mensajeError("Debes ingresar un nombre para poder continuar");
			txtApellido.setText("");
			txtApellido.requestFocus();
			txtApellido.setBackground(Color.RED);
			ape = null;
		} else if (txtApellido.getText().trim().matches(Validaciones.APELLIDO)) {// relizamos la validación
			ape = txtApellido.getText();
		} else {
			mensajeError("Debes ingresar un nombre que contenga de 3 a 15 caracteres");
			txtApellido.setText("");
			txtApellido.requestFocus();
			txtApellido.setBackground(Color.RED);
			ape = null;
		}

		return ape;
	}

	private int leerTelefono() {
		int telefono = -1;
		if (txtTelefono.getText().trim().length() == 0) {
			mensajeError("Ingresa el número de teléfono");
			txtTelefono.setText("");
			txtTelefono.requestFocus();
			txtTelefono.setBackground(Color.RED);
			telefono = -1;
		} else if (txtTelefono.getText().trim().matches(Validaciones.TELEFONO)) {
			telefono = Integer.parseInt(txtTelefono.getText());
		} else {
			mensajeError("Ingreso de dats no válido. debe contener 9 caracteres");
			txtTelefono.setText("");
			txtTelefono.requestFocus();
			txtTelefono.setBackground(Color.RED);
			telefono = -1;
		}
		return telefono;
	}

	private String leerCorreo() {
		String correo = null;
		if (txtCorreo.getText().trim().length() == 0) {
			mensajeError("Debes ingresar un cooreo para poder continuar");
			txtCorreo.setText("");
			txtCorreo.requestFocus();
			txtCorreo.setBackground(Color.RED);
			correo = null;
		} else if (txtCorreo.getText().trim().matches(Validaciones.CORREO)) {// relizamos la validación
			correo = txtCorreo.getText();
		} else {
			mensajeError("Debes ingresar un correo que contenga el sigiente formato: user@gmail.com");
			txtCorreo.setText("");
			txtCorreo.requestFocus();
			txtCorreo.setBackground(Color.RED);
			correo = null;
		}

		return correo;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error!!!", 0);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txtCorreo) {
			keyPressedTxtCorreo(e);
		}
		if (e.getSource() == txtTelefono) {
			keyPressedTxtTelefono(e);
		}
		if (e.getSource() == txtApellido) {
			keyPressedTxtApellido(e);
		}
		if (e.getSource() == txtNombre) {
			keyPressedTxtNombre(e);
		}
		if (e.getSource() == txtDni) {
			keyPressedTxtDni(e);
		}
		if (e.getSource() == txtCodigo) {
			keyPressedTxtCodigo(e);
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyPressedTxtCodigo(KeyEvent e) {
		// al presionar sobre txtProdcuto el color del fondo cambiara a blanco
		txtCodigo.setBackground(Color.WHITE);
	}

	protected void keyPressedTxtDni(KeyEvent e) {
		// al presionar sobre txtDni el color del fondo cambiara a blanco
		txtDni.setBackground(Color.WHITE);
	}

	protected void keyPressedTxtNombre(KeyEvent e) {
		// al presionar sobre txtNombre el color del fondo cambiara a blanco
		txtNombre.setBackground(Color.WHITE);
	}

	protected void keyPressedTxtApellido(KeyEvent e) {
		// al presionar sobre txtApellido el color del fondo cambiara a blanco
		txtApellido.setBackground(Color.WHITE);
	}

	protected void keyPressedTxtTelefono(KeyEvent e) {
		// al presionar sobre txtTelefono el color del fondo cambiara a blanco
		txtTelefono.setBackground(Color.WHITE);
	}

	protected void keyPressedTxtCorreo(KeyEvent e) {
		// al presionar sobre txtCorreo el color del fondo cambiara a blanco
		txtCorreo.setBackground(Color.WHITE);
	}
}
