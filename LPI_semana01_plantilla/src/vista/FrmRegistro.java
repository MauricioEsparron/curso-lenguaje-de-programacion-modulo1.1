package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmRegistro extends JFrame {

	private JPanel contentPane;
	private JTable tbUsuario;
	private JScrollPane scrollPane;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblUsuario;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JLabel lblClave;
	private JTextField txtClave;
	private JDateChooser dateChooser;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnConsultar;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JComboBox cboTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistro frame = new FrmRegistro();
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
	public FrmRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 408, 257);
		contentPane.add(scrollPane);

		lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(428, 79, 63, 14);
		contentPane.add(lblCodigo);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(428, 110, 63, 14);
		contentPane.add(lblNombre);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(428, 145, 63, 14);
		contentPane.add(lblApellido);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(428, 181, 63, 14);
		contentPane.add(lblUsuario);

		DefaultTableModel model = new DefaultTableModel();

		tbUsuario = new JTable();
		tbUsuario.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbUsuario);
		// asignar el objeton "model" a la tabla "tbusuario"
		tbUsuario.setModel(model);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(501, 76, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(501, 107, 127, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(501, 142, 127, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(501, 178, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblClave = new JLabel(" Clave:");
		lblClave.setBounds(428, 214, 46, 14);
		contentPane.add(lblClave);
		
		txtClave = new JTextField();
		txtClave.setBounds(501, 211, 86, 20);
		contentPane.add(txtClave);
		txtClave.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(500, 242, 128, 20);
		contentPane.add(dateChooser);
		
		lblNewLabel = new JLabel("Fec Nacim:");
		lblNewLabel.setBounds(428, 248, 63, 14);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(288, 345, 70, 23);
		contentPane.add(btnNewButton);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(387, 345, 70, 23);
		contentPane.add(btnConsultar);
		
		btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(467, 345, 70, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(547, 345, 68, 23);
		contentPane.add(btnNewButton_3);
		
		cboTipo = new JComboBox();
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar...", "Administrador", "Cliente", "Cajero"}));
		cboTipo.setBounds(501, 273, 127, 22);
		contentPane.add(cboTipo);

		// determinar columnas de la tabla
		model.addColumn("codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Usuario");
		model.addColumn("Calve");
		model.addColumn("Fecha");
	}
}
