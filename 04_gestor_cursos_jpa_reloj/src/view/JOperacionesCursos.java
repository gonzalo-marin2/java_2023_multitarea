package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.FormacionService;
import service.FormacionServiceFactory;

public class JOperacionesCursos extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblReloj = new JLabel("\"\"");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOperacionesCursos frame = new JOperacionesCursos();
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
	public JOperacionesCursos() {
		setTitle("Cursos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 101, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Acciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuActualizar = new JMenuItem("Actualizar cursos");
		menuActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormacionService service=FormacionServiceFactory.getFormacionService();//llamamos al método getFormacionService de FormacionServiceFactory
				service.actualizarDatos();//llamamos al método de actualizar
			}
		});
		mnNewMenu.add(menuActualizar);
		
		JMenuItem MenuConsulta = new JMenuItem("Consulta");
		MenuConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JConsultarDatos();
			}
		});
		mnNewMenu.add(MenuConsulta);
		
		JMenuItem MenuEliminar = new JMenuItem("Eliminar alumno");
		MenuEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JEliminar();
			}
		});
		mnNewMenu.add(MenuEliminar);
		
		JMenuItem MenuBuscarCursoFecha = new JMenuItem("Buscar curso por fecha");
		MenuBuscarCursoFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JBuscarCursoFecha();
			}
		});
		mnNewMenu.add(MenuBuscarCursoFecha);
		
		
		lblReloj.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblReloj.setBounds(125, 63, 244, 142);
		contentPane.add(lblReloj);
		new Thread(this).start();
	}

	@Override
	public void run() {
		while(true) {
			var time=LocalTime.now();
			lblReloj.setText(time.toString());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
