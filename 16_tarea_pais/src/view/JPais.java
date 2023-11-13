package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import view.adapters.JComboContinentesModel;
import view.adapters.TablaPaisesModel;

public class JPais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbPaises;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPais frame = new JPais();
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
	public JPais() {
		setTitle("Países por continente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContinente = new JLabel("Selecciona un continente");
		lblContinente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContinente.setBounds(110, 25, 175, 25);
		contentPane.add(lblContinente);
		
		JComboBox cbContinente = new JComboBox();
		cbContinente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String continente=cbContinente.getSelectedItem().toString();
				//cargamos el tablemodel con el id del curso seleccionado
				tbPaises.setModel(new TablaPaisesModel(continente));
			}
		});
		cbContinente.setBounds(120, 65, 160, 22);
		contentPane.add(cbContinente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 109, 341, 141);
		contentPane.add(scrollPane);
		
		tbPaises = new JTable();
		scrollPane.setViewportView(tbPaises);
		cbContinente.setModel(new JComboContinentesModel());
	}
}
