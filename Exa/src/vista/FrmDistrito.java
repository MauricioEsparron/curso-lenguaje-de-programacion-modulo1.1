package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmDistrito extends JFrame {

	private JPanel contentPane;
	private JLabel lblNombreDistrito;
	private JTextField txtNombreDistrito;
	private JLabel lblCodigoDistrito;
	private JTextField txtCodigoDistrito;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JTable tblDistrito;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDistrito frame = new FrmDistrito();
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
	public FrmDistrito() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombreDistrito = new JLabel("Distrito :");
		lblNombreDistrito.setBounds(10, 141, 69, 14);
		contentPane.add(lblNombreDistrito);
		
		txtNombreDistrito = new JTextField();
		txtNombreDistrito.setBounds(100, 138, 86, 20);
		contentPane.add(txtNombreDistrito);
		txtNombreDistrito.setColumns(10);
		
		lblCodigoDistrito = new JLabel("Código :");
		lblCodigoDistrito.setBounds(10, 116, 69, 14);
		contentPane.add(lblCodigoDistrito);
		
		txtCodigoDistrito = new JTextField();
		txtCodigoDistrito.setBounds(100, 107, 86, 20);
		contentPane.add(txtCodigoDistrito);
		txtCodigoDistrito.setColumns(10);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(287, 83, 89, 23);
		contentPane.add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(386, 83, 89, 23);
		contentPane.add(btnGuardar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(287, 137, 89, 23);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(397, 137, 89, 23);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 179, 523, 174);
		contentPane.add(scrollPane);
		
		tblDistrito = new JTable();
		scrollPane.setViewportView(tblDistrito);
	}
}
