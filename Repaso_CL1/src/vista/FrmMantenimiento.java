package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidad.Libros;
import mantenimiento.GestionLibrosDAO;
import utils.Validaciones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMantenimiento extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblAutor;
	private JLabel lblStock;
	private JTextField txtNombreLibro;
	private JTextField txtAutor;
	private JTextField txtStock;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblAutogenerable;
	private JButton btnNuevo;
	private JButton btnRegistrar;

	// instanciar un objeto

	GestionLibrosDAO gLib = new GestionLibrosDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimiento frame = new FrmMantenimiento();
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
	public FrmMantenimiento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Mantenimiento");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(0, 0, 483, 32);
		contentPane.add(lblNewLabel);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 53, 87, 14);
		contentPane.add(lblCodigo);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 89, 87, 14);
		contentPane.add(lblNombre);

		lblAutor = new JLabel("Autor");
		lblAutor.setBounds(10, 128, 46, 14);
		contentPane.add(lblAutor);

		lblStock = new JLabel("Stock");
		lblStock.setHorizontalAlignment(SwingConstants.LEFT);
		lblStock.setBounds(10, 168, 46, 14);
		contentPane.add(lblStock);

		txtNombreLibro = new JTextField();
		txtNombreLibro.setBounds(88, 86, 217, 20);
		contentPane.add(txtNombreLibro);
		txtNombreLibro.setColumns(10);

		txtAutor = new JTextField();
		txtAutor.setBounds(88, 125, 217, 20);
		contentPane.add(txtAutor);
		txtAutor.setColumns(10);

		txtStock = new JTextField();
		txtStock.setBounds(88, 165, 86, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 214, 46, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(88, 211, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		lblAutogenerable = new JLabel("Autogenerable");
		lblAutogenerable.setEnabled(false);
		lblAutogenerable.setBounds(88, 53, 86, 14);
		contentPane.add(lblAutogenerable);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(348, 85, 89, 23);
		contentPane.add(btnNuevo);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(348, 124, 89, 23);
		contentPane.add(btnRegistrar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}

	protected void actionPerformedBtnRegistrar(ActionEvent e) {

		resgistrarLibro();

	}

	private void resgistrarLibro() {
		// declarar variables

		String nomb, autor;
		int stock;
		double precio;

		// obtener los valores ingresados en la GUI

		nomb = getNombreLibro();
		autor = getAutor();
		stock = getStock();
		precio = getPrecio();
		// validar
		if (nomb == null || autor == null || stock == -1 || precio == -1) {
			return;
		} else {
			// crear un objeto de tipo libro

			Libros lib = new Libros();

			// setear --> asignar los datos ingresados por la GUI a los atributos privados

			lib.setNombre(nomb);
			lib.setAutor(autor);
			lib.setStock(stock);
			lib.setPrecio(precio);

			// llamar al proceso de registro

			int ok = gLib.registrarLibro(lib);

			// validar el resultado del proceso

			if (ok == 0) {
				mensajeError("Error en el Registro");
			} else
				mensajeExito("Registro Exitoso :D");
		}
	}

	private void mensajeExito(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema", 1);
	}

	private double getPrecio() {// completar validacion
		double pre = -1;
		if ((txtPrecio.getText().trim().length()) == -0) {
			mensajeError("Debes ingresar un Precio");
			txtPrecio.requestFocus();
			pre = -1;
		} else {
			try {
				pre = Double.parseDouble(txtPrecio.getText());
				if (pre <= 0) {
					mensajeError("Error al ingresar Precios, debe ser mayor cero");
					txtStock.setText("");
					txtStock.requestFocus();
					pre = -1;
				}
			} catch (NumberFormatException e) {
				mensajeError("Ingresar solo valores Numericos en precio");
				txtPrecio.requestFocus();
				txtPrecio.setText("");
				pre = -1;
			}
		}
		return pre;
	}

	private int getStock() {
		int Stock = -1;
		if (txtStock.getText().trim().length() == 0) {
			mensajeError("Ingresar el Stock");
			txtStock.requestFocus();
			Stock = -1;
		} else {
			try {
				Stock = Integer.parseInt(txtStock.getText());
				if (Stock <= 0) {
					mensajeError("Error al Stock, debe ser mayor cero");
					txtStock.setText("");
					txtStock.requestFocus();
					Stock = -1;
				}
			} catch (NumberFormatException e) {
				mensajeError("Ingresar solo valores Numericos al Stock");
				txtStock.setText("");
				txtStock.requestFocus();
				Stock = -1;
			}
		}
		return Stock;
	}

	private String getAutor() {

		String autor = null;// completar validacion
		if (txtAutor.getText().trim().length() == 0) {
			mensajeError("Ingresar el nombre del Autor");
			txtAutor.requestFocus();
			autor = null;
		} else if (txtAutor.getText().trim().matches(Validaciones.AUTOR) == false) {
			mensajeError("Error en el formato, ingresa de 5 a 15 letras");
			txtAutor.requestFocus();
			txtAutor.setText("");
			autor = null;
		} else {
			autor = txtAutor.getText().trim();
		}
		return autor;
	}

	private String getNombreLibro() {
		// validar solo 3 -15

		String nomb = null;
		if (txtNombreLibro.getText().trim().length() == 0) {
			mensajeError("Ingresar el nombre del libro");
			txtNombreLibro.requestFocus();
			nomb = null;
		} else if (txtNombreLibro.getText().trim().matches(Validaciones.NOMBRELIBRO) == false) {
			mensajeError("Error en el formato, ingresa de 5 a 15 letras");
			txtNombreLibro.requestFocus();
			txtNombreLibro.setText("");
			nomb = null;
		} else {
			nomb = txtNombreLibro.getText().trim();
		}
		return nomb;
	}

	private void mensajeError(String msj) {

		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);

	}
}
