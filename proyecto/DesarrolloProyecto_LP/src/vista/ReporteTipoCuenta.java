package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import entidad.Tarjeta;
import entidad.TipoCuenta;
import mantenimiento.GestionTarjetaDAO;
import mantenimiento.GestionTipoCuentaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ReporteTipoCuenta extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cboTipoCuenta;
	private JTable tbTipoCuenta;
	private JButton btnReporte;

	DefaultTableModel model = new DefaultTableModel();
	GestionTipoCuentaDAO gTipoCuenta = new GestionTipoCuentaDAO();
	GestionTarjetaDAO gTarjeta = new GestionTarjetaDAO();
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteTipoCuenta frame = new ReporteTipoCuenta();
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
	public ReporteTipoCuenta() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Tipo Cuenta :  ");
		lblNewLabel.setBounds(10, 25, 126, 14);
		contentPane.add(lblNewLabel);

		cboTipoCuenta = new JComboBox();
		cboTipoCuenta.setBounds(108, 21, 160, 22);
		contentPane.add(cboTipoCuenta);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 606, 181);
		contentPane.add(scrollPane);

		tbTipoCuenta = new JTable();
		tbTipoCuenta.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbTipoCuenta);

		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(262, 269, 89, 23);
		contentPane.add(btnReporte);

		model.addColumn("Núm Tarjeta");
		model.addColumn("Cod CLiente");
		model.addColumn("Núm Cuenta");
		model.addColumn("Fec Afiliación");
		model.addColumn("Fec Caducidad");
		model.addColumn("Saldo");
		
		tbTipoCuenta.setModel(model);
		
		cargarDataComboBox();
	}

	private void cargarDataComboBox() {
		ArrayList<TipoCuenta> listarTipoCuentas = gTipoCuenta.listaTipoCuenta();
		if (listarTipoCuentas.size() == 0) {
			mensajeError("La lista se encuentra vacía");
		} else {
			cboTipoCuenta.addItem("Seleccione...");
			for (TipoCuenta tipoCuenta : listarTipoCuentas) {
				cboTipoCuenta.addItem(tipoCuenta.getCod_cuenta() + " - " + tipoCuenta.getDescripcion());
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
		// obtener el tipo cuenta
		int tipo = getTipo();
		// validar
		if (tipo == 0) {
			return;
		} else {
			// obtnener el resultado del porceso
			ArrayList<Tarjeta> listCuenta = gTarjeta.listarTarjetaXTipoCuenta(tipo);
			// validar el resultado
			if (listCuenta.size() == 0) {
				mensajeError("Lista vacía");
			} else {
				// bucle
				for (Tarjeta t : listCuenta) {
					Object fila[] = { t.getNum_Tarjeta(), t.getCod_cliente(), t.getNum_cuenta(), t.getFecAfliacion(),
							t.getFecCaducidad(), t.getSaldo() };
					model.addRow(fila);
				}
			}
		}

	}

	private int getTipo() {
		return cboTipoCuenta.getSelectedIndex();
	}
}
