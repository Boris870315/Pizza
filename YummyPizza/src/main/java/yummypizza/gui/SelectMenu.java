package yummypizza.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.FocusManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class SelectMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnpizzamenu;
	private JButton btnsidemenu;


	/**
	 * Create the dialog.
	 */
	public SelectMenu(HashMap<String, Object> map) {
		
		setTitle("Menu Selection");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			btnpizzamenu = new JButton("\r\nPizza");
			btnpizzamenu.setIcon(new ImageIcon("C:\\Users\\b2281\\Downloads\\pizza (1).png"));
			btnpizzamenu.setFont(new Font("Arial", Font.BOLD, 15));
			btnpizzamenu.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					PizzaMenu dialog = new PizzaMenu(FocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),
	                        ModalityType.APPLICATION_MODAL,map);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
			});
		}
		{
			btnsidemenu = new JButton("Side Menu");
			btnsidemenu.setIcon(new ImageIcon("C:\\Users\\b2281\\Downloads\\drink.png"));
			btnsidemenu.setFont(new Font("Arial", Font.BOLD, 14));
			btnsidemenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					SelectSideMenu dialog = new SelectSideMenu(FocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),
							ModalityType.APPLICATION_MODAL,map);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
			});
		}
		
		
		
		JButton btn_cart = new JButton(" Cart");
		btn_cart.setFont(new Font("Arial", Font.BOLD, 13));
		btn_cart.setIcon(new ImageIcon("C:\\Users\\b2281\\Downloads\\shopping-cart (1).png"));
		btn_cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart dialog = new Cart(map);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				close();
			}
		});
		
		
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(15)
							.addComponent(btnpizzamenu, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnsidemenu, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addContainerGap(335, Short.MAX_VALUE)
							.addComponent(btn_cart)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(btn_cart, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnpizzamenu, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnsidemenu, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	
	
	//close windows
	private void close() {
        this.setVisible(false);
        this.dispose();
    }
}
