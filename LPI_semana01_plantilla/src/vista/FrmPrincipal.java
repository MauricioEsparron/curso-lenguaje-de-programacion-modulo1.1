package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloHora;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.InputEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class FrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSistema;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmClientes;
	private JMenuItem mntmProductos;
	private JMenu mnReportes;
	private JMenuItem mntmVentas;
	private JMenuItem mntmUsuarios;
	private JDesktopPane escritorio;
	public static JLabel lblHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		try {

			// seleccionar el diseño a trabajar
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");

		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 441);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnSistema = new JMenu("Sistema");
		mnSistema.setMnemonic('S');
		mnSistema.setIcon(new ImageIcon(FrmPrincipal.class
				.getResource("/img/976607_appliances_computer_laptop_notebook_portable computer_icon.png")));
		menuBar.add(mnSistema);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.ALT_DOWN_MASK));
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/img/646197_cancel_close_cross_delete_remove_icon.png")));
		mnSistema.add(mntmSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setMnemonic('M');
		mnMantenimiento.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/img/3844474_gear_setting_settings_wheel_icon.png")));
		menuBar.add(mnMantenimiento);

		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/img/4781818_account_avatar_face_man_people_icon.png")));
		mnMantenimiento.add(mntmClientes);

		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mntmProductos.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/img/2849824_store_shopping_market_buy_shop_icon.png")));
		mnMantenimiento.add(mntmProductos);

		mnReportes = new JMenu("Reportes");
		mnReportes.setMnemonic('R');
		mnReportes.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/img/7557017_result_test_product_research_icon.png")));
		menuBar.add(mnReportes);

		mntmVentas = new JMenuItem("Ventas");
		mntmVentas.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/img/2093655_box_logistic_package_present_product_icon.png")));
		mnReportes.add(mntmVentas);

		mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/img/4781818_account_avatar_face_man_people_icon.png")));
		mnReportes.add(mntmUsuarios);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		escritorio = new JDesktopPane();
		escritorio.setBackground(Color.LIGHT_GRAY);
		contentPane.add(escritorio, BorderLayout.CENTER);

		lblHora = new JLabel("00:00:00");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHora.setBounds(458, 24, 100, 33);
		escritorio.add(lblHora);

		// mostrar hora
		mostrarHora();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmProductos) {
			actionPerformedMntmProductos(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}

	protected void actionPerformedMntmSalir(ActionEvent e) {

		// Salir de la aplicación
		System.exit(0);
	}

	protected void actionPerformedMntmProductos(ActionEvent e) {

		// instancia
		FrmRegProd prod = new FrmRegProd();
		prod.setVisible(true);
		escritorio.add(prod);
	}

	private void mostrarHora() {
		// llamar al proceso
		HiloHora hora = new HiloHora();
		// ejecutar el proceso
		hora.start();
	}
}
