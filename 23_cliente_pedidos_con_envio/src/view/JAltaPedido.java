package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Pedido;
import service.PedidosService;
import service.PedidosServiceFactory;

public class JAltaPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProducto;
	private JTextField txtTienda;
	private JTextField txtFecha;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAltaPedido frame = new JAltaPedido();
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
	public JAltaPedido() {
		setTitle("Dar de alta un pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(10, 25, 100, 21);
		contentPane.add(lblProducto);
		
		JLabel lblTienda = new JLabel("Tienda");
		lblTienda.setBounds(10, 57, 100, 21);
		contentPane.add(lblTienda);
		
		JLabel lblFechaPedido = new JLabel("Fecha de pedido");
		lblFechaPedido.setBounds(10, 89, 100, 21);
		contentPane.add(lblFechaPedido);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 121, 100, 21);
		contentPane.add(lblPrecio);
		
		txtProducto = new JTextField();
		txtProducto.setBounds(180, 25, 120, 20);
		contentPane.add(txtProducto);
		txtProducto.setColumns(10);
		
		txtTienda = new JTextField();
		txtTienda.setColumns(10);
		txtTienda.setBounds(180, 57, 120, 20);
		contentPane.add(txtTienda);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(180, 89, 120, 20);
		contentPane.add(txtFecha);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(180, 121, 120, 20);
		contentPane.add(txtPrecio);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidosService service=PedidosServiceFactory.getPedidosService();
				Pedido pedido=new Pedido(0,
						txtProducto.getText(),
						txtTienda.getText(),
						LocalDate.parse(txtFecha.getText()),
						Double.parseDouble(txtPrecio.getText()));
				service.altaPedido(pedido);
			}
		});
		btnEnviar.setBounds(145, 182, 155, 23);
		contentPane.add(btnEnviar);
	}
}
