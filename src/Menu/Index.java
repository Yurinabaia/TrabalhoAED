package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		ImageIcon icone = new ImageIcon("./src/icon.png");
		setIconImage(icone.getImage());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vindo ao TRE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(82, 11, 300, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Escolha uma das op\u00E7\u00F5es");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(10, 58, 263, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cadastro Candidato");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				View.Index Candidato = new View.Index();
				Candidato.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(27, 109, 157, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastro Eleitor");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				View2.Eleitor eleitor = new View2.Eleitor();
				eleitor.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(247, 109, 157, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cadastro Urna Eletronica");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				View3.UrnaEletronica urna = new View3.UrnaEletronica();
				urna.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(27, 178, 190, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Grupo: Yuri Nabaia, Jo\u00E3o Pedro, Christian, Jo\u00E3o Victor.");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(10, 235, 424, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("Configurar Urna");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				View4.ConfigUrnna config = new View4.ConfigUrnna();
				config.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(247, 178, 157, 23);
		contentPane.add(btnNewButton_3);
	}

}
