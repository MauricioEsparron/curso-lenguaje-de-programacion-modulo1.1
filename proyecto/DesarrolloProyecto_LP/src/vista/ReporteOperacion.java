package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Movimiento;
import entidad.TipoOperacion;
import mantenimiento.GestionMovimientoDAO;
import mantenimiento.GestionTipoOperacionDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReporteOperacion extends JInternalFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cboTipoOperacion;
	private JTable tbTipoOperacion;
	private JScrollPane scrollPane;
	private JButton btnReportar;
	DefaultTableModel model = new DefaultTableModel();
	GestionTipoOperacionDAO gTipoOperacion = new GestionTipoOperacionDAO();
	GestionMovimientoDAO gMovimiento = new GestionMovimientoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteOperacion frame = new ReporteOperacion();
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
	public ReporteOperacion() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Tipo Operación :");
		lblNewLabel.setBounds(21, 38, 129, 14);
		contentPane.add(lblNewLabel);

		cboTipoOperacion = new JComboBox();
		cboTipoOperacion.setBounds(124, 34, 174, 22);
		contentPane.add(cboTipoOperacion);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 678, 211);
		contentPane.add(scrollPane);

		tbTipoOperacion = new JTable();
		tbTipoOperacion.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbTipoOperacion);

		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(288, 324, 89, 23);
		contentPane.add(btnReportar);

		model.addColumn("Cod Movimiento");
		model.addColumn("Num Tarjeta");
		model.addColumn("Cod Cliente");
		model.addColumn("Núm Cuenta");
		model.addColumn("Fec Movimiento");
		model.addColumn("Cuenta destino");
		model.addColumn("Monto");

		tbTipoOperacion.setModel(model);

		cargarDataComboBox();

	}

	private void cargarDataComboBox() {
		ArrayList<TipoOperacion> listaTipoOperacion = gTipoOperacion.listaTipoOperacion();
		if (listaTipoOperacion.size() == 0) {
			mensajeError("La lista se encuentra Vacía");
		} else {
			cboTipoOperacion.addItem("Seleccione...");
			for (TipoOperacion to : listaTipoOperacion) {
				cboTipoOperacion.addItem(to.getCod_operacion() + " - " + to.getDescripcion());

			}
		}
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error !!!", 0);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReportar) {
			actionPerformedBtnReportar(e);
		}
	}

	protected void actionPerformedBtnReportar(ActionEvent e) {

		model.setRowCount(0);
		int tipo = getOperacion();
		if (tipo == 0) {
			return;
		} else {
			ArrayList<Movimiento> Listmovimiento = gMovimiento.listarMovimientoXCodigoOperacion(tipo);
			if (Listmovimiento.size() == 0) {
				mensajeError("Lista Vacía");
			} else {
				for (Movimiento m : Listmovimiento) {
					Object fila[] = { m.getCod_movimiento(), m.getNum_tarjeta(), m.getCod_cliente(), m.getNum_cuenta(),
							m.getFecha_movimiento(), m.getCuenta_destino(), m.getMonto() };
					model.addRow(fila);
				}
			}
		}
	}

	private int getOperacion() {
		return cboTipoOperacion.getSelectedIndex();
	}
}
