package br.com.cafBot.ui;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.cafBot.Listener;

public class cafBotTela {
	
	JFrame frame = new JFrame();
	JLabel lblNome = new JLabel("Nome");
	JLabel lblEndereco = new JLabel("Endereço");
	
	JTextField txtNome = new JTextField(null, 20);
	JTextField txtEndereco = new JTextField(null, 30);
	 
	JButton btnLootGetterIniciar = new JButton("Iniciar");
	JButton btnLootGetterParar = new JButton("Parar"); 
	
	JButton btnPointMouseGetterIniciar = new JButton("Iniciar");
	JButton btnPointMouseGetterParar = new JButton("Parar"); 
	
	JPanel panelLootGetter = new JPanel();
	JPanel panelPointMouseGetter = new JPanel();
	
	
	public cafBotTela() {
		panelLootGetter.setBorder(BorderFactory.createTitledBorder("Loot Getter"));
		panelLootGetter.setLayout(new GridBagLayout());		
		panelLootGetter.add(btnLootGetterIniciar);
		panelLootGetter.add(btnLootGetterParar);
		
		panelPointMouseGetter.setBorder(BorderFactory.createTitledBorder("Point Mouse Getter"));
		panelPointMouseGetter.setLayout(new GridBagLayout());
		panelPointMouseGetter.add(btnPointMouseGetterIniciar);
		panelPointMouseGetter.add(btnPointMouseGetterParar);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLayout(new GridLayout(2,1));
		frame.getContentPane().add(panelLootGetter);
		frame.getContentPane().add(panelPointMouseGetter);	
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		btnLootGetterIniciar.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        Listener listener = new Listener();
		        listener.startListener();
		    }
		});
		
		btnLootGetterParar.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        Listener listener = new Listener();
		        listener.stopListener();
		    }
		});



	}

}
