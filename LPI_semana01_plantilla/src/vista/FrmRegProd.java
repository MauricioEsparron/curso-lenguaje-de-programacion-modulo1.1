package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Producto;
import validaciones.Validaciones;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmRegProd extends JFrame implements KeyListener {
	private JTextField txtCodigo;
	private JTextField txtProducto;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JComboBox cboTipo;
	private JTable tblProductos;

	// instancia un objeto par establecer la estructura de la tabla
	DefaultTableModel model = new DefaultTableModel();
	private JLabel lblErrorPrecio;
	private JLabel lblErrorCantidad;
	private JLabel lblErrorProducto;
	private JLabel lblErrorCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegProd frame = new FrmRegProd();
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
	public FrmRegProd() {
//		setClosable(true);
//		setMaximizable(true);
//		setIconifiable(true);
		setBounds(100, 100, 506, 350);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(30, 45, 75, 14);
		getContentPane().add(label);

		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(this);
		txtCodigo.setText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(88, 42, 86, 20);
		getContentPane().add(txtCodigo);

		JLabel label_1 = new JLabel("Producto:");
		label_1.setBounds(30, 73, 75, 14);
		getContentPane().add(label_1);

		txtProducto = new JTextField();
		txtProducto.addKeyListener(this);
		txtProducto.setText("");
		txtProducto.setColumns(10);
		txtProducto.setBounds(88, 70, 86, 20);
		getContentPane().add(txtProducto);

		JLabel label_2 = new JLabel("Tipo:");
		label_2.setBounds(30, 98, 53, 14);
		getContentPane().add(label_2);

		cboTipo = new JComboBox();
		cboTipo.setBounds(88, 94, 123, 20);
		cboTipo.setModel(new DefaultComboBoxModel(new String[] { "Seleccione tipo", "Pastillas", "Jarabe", "Otros" }));
		getContentPane().add(cboTipo);

		JLabel label_3 = new JLabel("Cantidad:");
		label_3.setBounds(30, 122, 60, 14);
		getContentPane().add(label_3);

		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(this);
		txtCantidad.setText("");
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(88, 119, 53, 20);
		getContentPane().add(txtCantidad);

		JLabel label_4 = new JLabel("Precio:");
		label_4.setBounds(178, 122, 46, 14);
		getContentPane().add(label_4);

		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(this);
		txtPrecio.setText("");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(220, 119, 60, 20);
		getContentPane().add(txtPrecio);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(FrmRegProd.class.getResource("/img/370092_add_plus_create_new_icon.png")));
		btnNuevo.setBounds(338, 24, 116, 34);
		getContentPane().add(btnNuevo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(
				new ImageIcon(FrmRegProd.class.getResource("/img/7351060_bookmark_favorite_star_save_icon.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnGuardar.setBounds(338, 73, 116, 34);
		getContentPane().add(btnGuardar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(
				FrmRegProd.class.getResource("/img/1976055_edit_edit document_edit file_edited_editing_icon.png")));
		btnEditar.setBounds(338, 124, 116, 34);
		getContentPane().add(btnEditar);

		JLabel lblMantenimientoDeProductos = new JLabel("Mantenimiento de Productos");
		lblMantenimientoDeProductos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMantenimientoDeProductos.setBounds(21, 13, 224, 20);
		getContentPane().add(lblMantenimientoDeProductos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 169, 470, 140);
		getContentPane().add(scrollPane);

		tblProductos = new JTable();
		scrollPane.setViewportView(tblProductos);
		tblProductos.setFillsViewportHeight(true);

		// determinar las columnas de mi tabla
		model.addColumn("Código");
		model.addColumn("Producto");
		model.addColumn("Cantidad");
		model.addColumn("Precio");
		// asignar modelo a la tabla
		tblProductos.setModel(model);

		lblErrorPrecio = new JLabel("*");
		lblErrorPrecio.setForeground(Color.RED);
		lblErrorPrecio.setBounds(290, 122, 38, 14);
		getContentPane().add(lblErrorPrecio);
		// precio
		lblErrorPrecio.setVisible(false);

		lblErrorCantidad = new JLabel("*");
		lblErrorCantidad.setForeground(Color.RED);
		lblErrorCantidad.setBounds(144, 122, 26, 14);
		getContentPane().add(lblErrorCantidad);
		// cantidad
		lblErrorCantidad.setVisible(false);

		lblErrorProducto = new JLabel("*");
		lblErrorProducto.setForeground(Color.RED);
		lblErrorProducto.setBounds(184, 73, 46, 14);
		getContentPane().add(lblErrorProducto);
		// producto
		lblErrorProducto.setVisible(false);

		lblErrorCodigo = new JLabel("*");
		lblErrorCodigo.setForeground(Color.RED);
		lblErrorCodigo.setBounds(178, 45, 46, 14);
		getContentPane().add(lblErrorCodigo);
		// codigo
		lblErrorCodigo.setVisible(false);
	}

	void ingresar() {
		String cod, prod;
		int cant;
		double pre;
		int tipo;

		cod = leerCodigo();
		prod = leerProducto();
		cant = leerCantidad();
		pre = leerPrecio();
		tipo = leerTipo();

		if (prod == null || tipo == 0 || cant == -1 || pre == -1 || cod == null) {
			// mostrar ventana de error
			return;

		} else {
			// mostrar dato en la tabla

			Object fila[] = { cod, prod, cant, pre };
			model.addRow(fila);

		}

	}

	private String leerCodigo() {
		// Formato d código P0001 / p0001
		String cod = null;
		if (txtCodigo.getText().trim().length() == 0) {// validamos que no este vacío
			mensajeError("Ingresar el código del producto porfavor");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
			cod = null;
		} else if (txtCodigo.getText().trim().matches(Validaciones.CODIGO_PRODUCTO)) {// realizamos la validacion
			cod = txtCodigo.getText();
		} else {
			mensajeError("Formato del código no válido. Ejem P0001 ó p0001");
			txtCodigo.setText("");
			txtCodigo.requestFocus();
			txtCodigo.setBackground(Color.RED);
			lblErrorCodigo.setVisible(true);
			cod = null;
		}
		return cod;
	}

	String leerProducto() {
		// validar ingresar caracteres 3 - 15
		String prod = null;
		if (txtProducto.getText().trim().length() == 0) {// validamos que no este vacío
			mensajeError("Ingresa el nombre del Producto");
			txtProducto.setText("");
			txtProducto.requestFocus();
			txtCantidad.setBackground(Color.RED);
			lblErrorCantidad.setVisible(true);
			prod = null;
		} else if (txtProducto.getText().trim().matches(Validaciones.TEXTO)) {// realizamos la validacion
			prod = txtProducto.getText();
		} else {
			mensajeError("Formato del producto no válido. debe contener de 3 a 15 caracteres");
			txtProducto.setText("");
			txtProducto.requestFocus();
			txtProducto.setBackground(Color.RED);
			lblErrorProducto.setVisible(true);
			prod = null;
		}
		return prod;
	}

	int leerTipo() {
		int tipo;
		tipo = cboTipo.getSelectedIndex();
		if (tipo == 0) {
			mensajeError("Seleccionar el tipo de producto");
		}
		return tipo;
	}

	int leerCantidad() {
		int cant = -1;
		if (txtCantidad.getText().trim().length() == 0) {// verifica si la caja de texto está vacía
			mensajeError("Ingresa una cantidad");
			txtCantidad.setText("");
			txtCantidad.requestFocus();
			txtCantidad.setBackground(Color.RED);
			lblErrorCantidad.setVisible(true);
		} else {
			try {
				cant = Integer.parseInt(txtCantidad.getText());
				if (cant <= 0) {
					mensajeError("Ingresar una cantidad mayor a 0");
					txtCantidad.setText("");
					txtCantidad.requestFocus();
					txtCantidad.setBackground(Color.RED);
					lblErrorCantidad.setVisible(true);
					cant = -1;

				}
			} catch (NumberFormatException e) {
				mensajeError("Ingresar valores númericos");
				txtCantidad.setText("");
				txtCantidad.requestFocus();
				txtCantidad.setBackground(Color.RED);
				lblErrorCantidad.setVisible(true);
			}
		}
		return cant;
	}

	double leerPrecio() {
		double pre = -1;
		if (txtPrecio.getText().trim().length() == 0) {// validamos que no este vacío
			mensajeError("Ingresa el precio del Producto");
			txtPrecio.setText("");
			txtPrecio.requestFocus();
			txtPrecio.setBackground(Color.RED);
			lblErrorPrecio.setVisible(true);
		} else {
			try {
				pre = Double.parseDouble(txtPrecio.getText());
				if (pre <= 0) {
					mensajeError("Ingresar precio mayor a 0");
					txtPrecio.setText("");
					txtPrecio.requestFocus();
					txtPrecio.setBackground(Color.RED);
					lblErrorPrecio.setVisible(true);
					pre = -1;
				}
			} catch (NumberFormatException e) {
				mensajeError("Ingresar valores númericos");
				txtPrecio.setText("");
				txtPrecio.requestFocus();
				txtPrecio.setBackground(Color.RED);
				lblErrorPrecio.setVisible(true);

			}
		}
		return pre;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error!!!", 0);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtCodigo) {
			keyReleasedTxtCodigo(e);
		}
		if (e.getSource() == txtProducto) {
			keyReleasedTxtProducto(e);
		}
		if (e.getSource() == txtCantidad) {
			keyReleasedTxtCantidad(e);
		}
		if (e.getSource() == txtPrecio) {
			keyReleasedTxtPrecio(e);
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	protected void keyReleasedTxtPrecio(KeyEvent e) {
		// al presionar sobre txtPrecio el color del fondo cambiara a blanco
		txtPrecio.setBackground(Color.WHITE);
	}

	protected void keyReleasedTxtCantidad(KeyEvent e) {
		// al presionar sobre txtCantidad el color del fondo cambiara a blanco
		txtCantidad.setBackground(Color.WHITE);

	}

	protected void keyReleasedTxtProducto(KeyEvent e) {
		// al presionar sobre txtProdcuto el color del fondo cambiara a blanco
		txtProducto.setBackground(Color.WHITE);
	}

	protected void keyReleasedTxtCodigo(KeyEvent e) {
		// al presionar sobre txtProdcuto el color del fondo cambiara a blanco
		txtCodigo.setBackground(Color.WHITE);
	}
}
