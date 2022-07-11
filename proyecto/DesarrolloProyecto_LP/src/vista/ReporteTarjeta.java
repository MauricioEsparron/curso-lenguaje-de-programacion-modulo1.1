package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Cliente;
import entidad.Tarjeta;
import mantenimiento.GestionClienteDAO;
import mantenimiento.GestionTarjetaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReporteTarjeta extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cboCliente;
	private JTable tbCliente;
	private JScrollPane scrollPane;
	private JButton btnReporte;

	DefaultTableModel model = new DefaultTableModel();
	GestionClienteDAO gCliente = new GestionClienteDAO();
	GestionTarjetaDAO gTarjeta = new GestionTarjetaDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteTarjeta frame = new ReporteTarjeta();
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
	public ReporteTarjeta() {
		setMaximizable(true);
		setClosable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Código Cliente :");
		lblNewLabel.setBounds(10, 44, 129, 14);
		contentPane.add(lblNewLabel);

		cboCliente = new JComboBox();
		cboCliente.setBounds(125, 40, 170, 22);
		contentPane.add(cboCliente);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 623, 206);
		contentPane.add(scrollPane);

		tbCliente = new JTable();
		tbCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbCliente);

		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(256, 345, 89, 23);
		contentPane.add(btnReporte);

		model.addColumn("Núm Tarjeta");
		model.addColumn("Cod CLiente");
		model.addColumn("Cod Cuenta");
		model.addColumn("Núm Cuenta");
		model.addColumn("Fec Afiliación");
		model.addColumn("Fec Caducidad");
		model.addColumn("Saldo");

		tbCliente.setModel(model);

		cargarDataComboBox();
	}

	private void cargarDataComboBox() {
		ArrayList<Cliente> listarCliente = gCliente.listarCliente();
		if (listarCliente.size() == 0) {
			mensajeError("La lista se encuentra Vacía");
		} else {
			cboCliente.addItem("Seleccione...");
			for (Cliente c : listarCliente) {
				cboCliente.addItem(c.getCod_cliente() + " - " + c.getNombre());
			}
		}

	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}

	protected void actionPerformedBtnReporte(ActionEvent e) {
//		cargarReporte();
		model.setRowCount(0);
		int tipo = getCliente();
		if (tipo == 0) {
			return;
		} else {
			ArrayList<Tarjeta> listCuenta = gTarjeta.listarClienteXCodigoCliente(tipo);
			if (listCuenta.size() == 0) {
				mensajeError("Lista vacía");
			} else {
				for (Tarjeta t : listCuenta) {
					Object fila[] = { t.getNum_Tarjeta(), t.getCod_cliente(), t.getCodTipo_cuenta(), t.getNum_cuenta(),
							t.getFecAfliacion(), t.getFecCaducidad(), t.getSaldo() };
					model.addRow(fila);
				}
			}
		}

	}

	private int getCliente() {
		return cboCliente.getSelectedIndex();
	}
}
