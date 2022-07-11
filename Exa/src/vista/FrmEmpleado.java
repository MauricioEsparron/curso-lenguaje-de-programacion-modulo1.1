package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import entidad.Empleado;
import mantenimiento.GestionEmpleadoDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmEmpleado extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tblEmpleado;
	private JScrollPane scrollPane;
	DefaultTableModel model = new DefaultTableModel();
	private JLabel lblCodigoEmpleado;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblNumeroHijos;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtNumeroHijos;
	private JPanel PanelFormulario;
	private JButton BtnNuevo;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JLabel lblSueldo;
	private JTextField txtSueldo;
	private JLabel lblNewLabel;
	private JTextField txtDistrito;
	private JPanel PanelBotones;

	GestionEmpleadoDAO gEmpleado = new GestionEmpleadoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEmpleado frame = new FrmEmpleado();
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
	public FrmEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 370, 642, 240);
		contentPane.add(scrollPane);

		tblEmpleado = new JTable();
		tblEmpleado.setFillsViewportHeight(true);
		tblEmpleado.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		scrollPane.setViewportView(tblEmpleado);

		model.addColumn("Código");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Dni");
		model.addColumn("Num Hijos");
		model.addColumn("Sueldo");
		model.addColumn("cod Distrito");

		tblEmpleado.setModel(model);

		PanelFormulario = new JPanel();
		PanelFormulario.setForeground(new Color(255, 255, 240));
		PanelFormulario.setBackground(new Color(128, 128, 128));
		PanelFormulario.setBounds(10, 74, 297, 259);
		contentPane.add(PanelFormulario);
		PanelFormulario.setLayout(null);

		lblCodigoEmpleado = new JLabel("Código :");
		lblCodigoEmpleado.setForeground(new Color(255, 255, 240));
		lblCodigoEmpleado.setBounds(34, 56, 83, 14);
		PanelFormulario.add(lblCodigoEmpleado);

		lblNombre = new JLabel("Nombre :");
		lblNombre.setForeground(new Color(255, 255, 240));
		lblNombre.setBounds(34, 81, 83, 14);
		PanelFormulario.add(lblNombre);

		lblApellido = new JLabel("Apellido :");
		lblApellido.setForeground(new Color(255, 255, 240));
		lblApellido.setBounds(34, 106, 83, 14);
		PanelFormulario.add(lblApellido);

		lblDni = new JLabel("Dni :");
		lblDni.setForeground(new Color(255, 255, 240));
		lblDni.setBounds(34, 131, 83, 14);
		PanelFormulario.add(lblDni);

		lblNumeroHijos = new JLabel("Núm Hijos :");
		lblNumeroHijos.setForeground(new Color(255, 255, 240));
		lblNumeroHijos.setBounds(34, 156, 83, 14);
		PanelFormulario.add(lblNumeroHijos);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(127, 53, 86, 20);
		PanelFormulario.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(127, 78, 128, 20);
		PanelFormulario.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(127, 103, 128, 20);
		PanelFormulario.add(txtApellido);
		txtApellido.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(127, 128, 86, 20);
		PanelFormulario.add(txtDni);
		txtDni.setColumns(10);

		txtNumeroHijos = new JTextField();
		txtNumeroHijos.setBounds(127, 153, 86, 20);
		PanelFormulario.add(txtNumeroHijos);
		txtNumeroHijos.setColumns(10);

		lblSueldo = new JLabel("Sueldo :");
		lblSueldo.setForeground(new Color(255, 255, 240));
		lblSueldo.setBounds(34, 181, 83, 14);
		PanelFormulario.add(lblSueldo);

		txtSueldo = new JTextField();
		txtSueldo.setBounds(127, 178, 86, 20);
		PanelFormulario.add(txtSueldo);
		txtSueldo.setColumns(10);

		lblNewLabel = new JLabel("Cod Distrito :");
		lblNewLabel.setForeground(new Color(255, 255, 240));
		lblNewLabel.setBounds(34, 206, 83, 14);
		PanelFormulario.add(lblNewLabel);

		txtDistrito = new JTextField();
		txtDistrito.setBounds(127, 203, 86, 20);
		PanelFormulario.add(txtDistrito);
		txtDistrito.setColumns(10);

		PanelBotones = new JPanel();
		PanelBotones.setBackground(new Color(128, 128, 128));
		PanelBotones.setBounds(394, 99, 240, 108);
		contentPane.add(PanelBotones);
		PanelBotones.setLayout(null);

		BtnNuevo = new JButton("Nuevo");
		BtnNuevo.setBounds(24, 26, 89, 23);
		PanelBotones.add(BtnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(125, 26, 89, 23);
		PanelBotones.add(btnGuardar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(24, 60, 89, 23);
		PanelBotones.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(125, 60, 89, 23);
		PanelBotones.add(btnEliminar);
		btnEliminar.addActionListener(this);
		btnActualizar.addActionListener(this);
		btnGuardar.addActionListener(this);
		BtnNuevo.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == BtnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtNumeroHijos.setText("");
		txtSueldo.setText("");
		txtCodigo.setText("");
		txtNombre.requestFocus();
	}

	protected void actionPerformedBtnGuardar(ActionEvent e) {
		registrar();
	}

	private void registrar() {

		int codigo;
		String nombre;
		String apellido;
		int dni;
		int numHijos;
		double sueldo;
		int codDistrito;

		codigo = getCodigo();
		nombre = getNombre();
		apellido = getApellido();
		dni = getDni();
		numHijos = getNumeroHijos();
		sueldo = getSueldo();
		codDistrito = getCodigoDistrito();

		if (nombre == null || apellido == null || dni == -1 || numHijos == -1 || sueldo == -1 || codDistrito == -1) {
			return;
		} else {
			Empleado e = new Empleado();

			e.setNombre(nombre);
			e.setApellido(apellido);
			e.setDni(dni);
			e.setNumHijos(numHijos);
			e.setSueldo(sueldo);
			e.setCodDistrito(codDistrito);

			int res = gEmpleado.registrar(e);
			if (res == 0) {
				mensajeError("Error en el Registro");
			} else {
				mensajeExitos("Registro Exitoso");
			}
		}

	}

	private void mensajeExitos(String string) {

	}

	private void mensajeError(String string) {

	}

	private int getCodigoDistrito() {
		return 0;
	}

	private double getSueldo() {
		return 0;
	}

	private int getNumeroHijos() {
		return 0;
	}

	private int getDni() {
		return 0;
	}

	private String getApellido() {
		return null;
	}

	private String getNombre() {
		return null;
	}

	private int getCodigo() {
		return 0;
	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
	}
}
