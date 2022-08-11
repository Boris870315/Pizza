package yummypizza.gui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import yummypizza.model.Order2;
import yummypizza.model.Pizza;
import yummypizza.model.SideMenu;
import yummypizza.model.product.SideOption;
import yummypizza.repo.SideMenuList;
import javax.swing.SpinnerNumberModel;

public class SelectSideMenu extends JDialog {

	SideMenuList sidemenus; 
	Order2 order;
	SideMenu editSidemenu;
	JComboBox cboSIDEMENU;
	JSpinner spQUANTITY;
	
	private final JPanel contentPanel = new JPanel();
	/**
	 * Create the dialog.
	 */
	//edit
	public SelectSideMenu(Window owner, Dialog.ModalityType modalityType,HashMap<String, Object> map, SideMenu editSidemenu) {
		this(owner, modalityType, map);
		this.editSidemenu = editSidemenu;
		cboSIDEMENU.setSelectedIndex(editSidemenu.getSideoption().ordinal());
		spQUANTITY.setValue(editSidemenu.getSideMenuAmount());;
		
	}
	
	//add
	public SelectSideMenu(Window owner, Dialog.ModalityType modalityType,HashMap <String, Object> map) {
		super(owner, modalityType);
		
		sidemenus=(SideMenuList) map.get("sidemenus");
		order = (Order2) map.get("order");
		
		setTitle("Side Menu Select");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		cboSIDEMENU = new JComboBox();
		cboSIDEMENU.setFont(new Font("Arial", Font.PLAIN, 14));
		cboSIDEMENU.setModel(new DefaultComboBoxModel(SideOption.descriptions));
		JLabel lblNewLabel = new JLabel("Side Menu List");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		JLabel lblNewLabel_1 = new JLabel("Quantity");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		spQUANTITY = new JSpinner();
		spQUANTITY.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spQUANTITY.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(cboSIDEMENU, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
						.addComponent(spQUANTITY, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(cboSIDEMENU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(spQUANTITY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addContainerGap(100, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("save");
			
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						printSideMenu();  //show
						
						//get the selected item and transfer String into enum 
						SideOption sideoption = null;
						switch ((String)cboSIDEMENU.getSelectedItem()) {
						
						case "creamy mushroom pasta":
							sideoption = SideOption.creamy_mushroom_pasta;
							break;
						case "classic bolognese":
							sideoption = SideOption.classic_bolognese;
							break;
						case "chicken wings":
							sideoption = SideOption.chicken_wings;
							break;
						case "garlic bread":
							sideoption = SideOption.garlic_bread;
							break;
						case "soft drinks":
							sideoption = SideOption.soft_drinks;
							break;
						case "fruit juice":
							sideoption = SideOption.fruit_juice;
							break;
						}
						int quantity=(int) spQUANTITY.getValue();
						
						saveSideMenuDetail(sideoption, quantity);
						System.err.println("sidemenu save successful");
						
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						close();
					}
				});
			}
		}
	}
	private void saveSideMenuDetail(SideOption sideoption, int sideoption_amount) {
		System.out.println("Saving up side options");
		SideMenu sidemenu = new SideMenu();
		
		//set id 
		int id = 0;
		if(editSidemenu != null) {
			id = editSidemenu.getSideoptionid();
			sidemenu.setOrderid(editSidemenu.getOrderid());
		}else{
			//search the order from DB
			Iterator<SideMenu> iterator = sidemenus.findAll().iterator();
			int MAX = 0;
			while(iterator.hasNext()) 
			{
				SideMenu mySidemenu = iterator.next();
				if(order.getOrderid().equals(mySidemenu.getOrderid())) {
					if(mySidemenu.getSideoptionid()> MAX) {
						MAX = mySidemenu.getSideoptionid();
					}
				}
				
			}
			MAX++;
			sidemenu.setOrderid(order.getOrderid());
			id = MAX;
		}
		sidemenu.setSideoptionid(id);
		sidemenu.setSideoptionlist(sideoption);
		sidemenu.setAmount(sideoption_amount);
		sidemenus.save(sidemenu);
		
	}

	private void close() {
    this.setVisible(false);
    this.dispose();
}
	
	private  void printSideMenu() {
		System.out.println(SideOption.question);
		for (int i = 0; i < SideOption.values().length; i++) {
			System.out.println(SideOption.descriptions[i]);
		}
	}
	
}