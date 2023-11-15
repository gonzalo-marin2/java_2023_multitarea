package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import view.adapters.TablaPedidosModel;

public class JPedidosTienda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTienda;
	private JTable tbPedidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPedidosTienda frame = new JPedidosTienda();
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
	public JPedidosTienda() {
		setTitle("Mostrar pedidos por tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreTienda = new JLabel("Nombre de la tienda");
		lblNombreTienda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreTienda.setBounds(143, 21, 185, 24);
		contentPane.add(lblNombreTienda);
		
		txtTienda = new JTextField();
		txtTienda.setBounds(114, 56, 185, 20);
		contentPane.add(txtTienda);
		txtTienda.setColumns(10);
		
		JButton btnVerPedidos = new JButton("Ver Pedidos");
		btnVerPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbPedidos.setModel(new TablaPedidosModel(txtTienda.getText()));
			}
		});
		btnVerPedidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVerPedidos.setBounds(114, 87, 185, 23);
		contentPane.add(btnVerPedidos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 121, 383, 129);
		contentPane.add(scrollPane);
		
		tbPedidos = new JTable();
		scrollPane.setViewportView(tbPedidos);
	}
}
