package vista;

import java.awt.EventQueue;

import javax.swing.JLabel;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRptVtas extends JFrame implements ActionListener {
	private JLabel lblFechaActual;
	private JTextField txtFechaActual;
	private JDateChooser dcFecha;
	private JButton btnReporte;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRptVtas frame = new FrmRptVtas();
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
	public FrmRptVtas() {
		setBounds(100, 100, 467, 359);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Reporte de Ventas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 0, 215, 37);
		getContentPane().add(lblNewLabel);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(30, 71, 39, 24);
		getContentPane().add(lblFecha);

		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setBounds(322, 44, 89, 23);
		getContentPane().add(btnReporte);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 140, 408, 158);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

		lblFechaActual = new JLabel("Fecha actual:");
		lblFechaActual.setBounds(30, 48, 76, 14);
		getContentPane().add(lblFechaActual);

		txtFechaActual = new JTextField();
		txtFechaActual.setEditable(false);
		txtFechaActual.setBounds(116, 45, 101, 20);
		getContentPane().add(txtFechaActual);
		txtFechaActual.setColumns(10);

		// Asignar fecha actual
		txtFechaActual.setText(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));

		dcFecha = new JDateChooser();
		dcFecha.setBounds(116, 75, 104, 20);
		getContentPane().add(dcFecha);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnReporte) {
			actionPerformedBtnReporte(e);
		}
	}

	protected void actionPerformedBtnReporte(ActionEvent e) {

		String fechAct, fechFin;
		fechAct = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		fechFin = getFechFin();
		
		//Mostrar
		txtS.setText("Fecha Actual : " + fechAct + "\n");
		txtS.append("Fecha Fin : " + fechFin);
	}

	private String getFechFin() {
		return new SimpleDateFormat("yyyy/MM/dd").format(dcFecha.getDate());
	}
}
