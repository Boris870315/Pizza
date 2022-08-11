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
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import yummypizza.model.Order2;
import yummypizza.model.Pizza;
import yummypizza.model.product.Base;
import yummypizza.model.product.Sauce;
import yummypizza.model.product.Size;
import yummypizza.model.product.Topping;
import yummypizza.repo.OrderList;
import yummypizza.repo.PizzaList;

public class PizzaMenu extends JDialog {
	
	Order2 order;
	OrderList orders;
	PizzaList pizzas;
	Pizza editPizza;
	JComboBox cboSIZE, cboSAUCE, cboTopping, cboBASE;
	JSpinner sprQUANTITY;
	
	private final JPanel contentPanel = new JPanel();

	 /* Create the dialog.
	 */
	
	//edit method
	public PizzaMenu(Window owner, Dialog.ModalityType modalityType,HashMap<String, Object> map, Pizza editPizza) {
		this(owner, modalityType, map);
		this.editPizza = editPizza;
		cboSIZE.setSelectedIndex(editPizza.getSize().ordinal());
		cboSAUCE.setSelectedIndex(editPizza.getSauce().ordinal());
		cboTopping.setSelectedIndex(editPizza.getTopping().ordinal());
		cboBASE.setSelectedIndex(editPizza.getBase().ordinal());
		sprQUANTITY.setValue(editPizza.getPizza_amount());
		
	}
	
	
	//add method
	public PizzaMenu(Window owner, Dialog.ModalityType modalityType,HashMap<String, Object> map) {
		super(owner, modalityType);
		
		pizzas = (PizzaList) map.get("pizzas");
		order = (Order2) map.get("order");
		
		
		setTitle("Pizza Selection");
		setBounds(100, 100, 658, 434);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lbl_base = new JLabel("Base");
		lbl_base.setFont(new Font("Arial", Font.BOLD, 16));
		
		cboBASE = new JComboBox();
		cboBASE.setFont(new Font("Dialog", Font.PLAIN, 14));
		cboBASE.setModel(new DefaultComboBoxModel(Base.descriptions));
		JLabel lbl_size = new JLabel("Size");
		lbl_size.setFont(new Font("Arial", Font.BOLD, 16));
		JLabel lbl_topping = new JLabel("Topping");
		lbl_topping.setFont(new Font("Arial", Font.BOLD, 16));
		JLabel lbl_sauce = new JLabel("Sauce");
		lbl_sauce.setFont(new Font("Arial", Font.BOLD, 16));
		cboSIZE = new JComboBox();
		cboSIZE.setFont(new Font("Dialog", Font.PLAIN, 14));
		cboSIZE.setModel(new DefaultComboBoxModel(Size.descriptions));
		cboSAUCE = new JComboBox();
		cboSAUCE.setFont(new Font("Dialog", Font.PLAIN, 14));
		cboSAUCE.setModel(new DefaultComboBoxModel(Sauce.descriptions));
		
		cboTopping = new JComboBox();
		cboTopping.setFont(new Font("Dialog", Font.PLAIN, 14));
		cboTopping.setModel(new DefaultComboBoxModel(Topping.descriptions));
		
		sprQUANTITY = new JSpinner();
		sprQUANTITY.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		
		JLabel lblNewLabel = new JLabel("Quantity");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_size, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_base)
								.addComponent(lbl_sauce, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addGap(31))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_topping, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
							.addGap(18)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(cboTopping, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboBASE, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboSIZE, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
						.addComponent(cboSAUCE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(sprQUANTITY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(271, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_size)
						.addComponent(cboSIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cboBASE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_base))
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cboSAUCE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_sauce))
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cboTopping, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_topping))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(sprQUANTITY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(62))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
					}
				});
				
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//data transfer from Sting to enum
						//combo box is storing String  
						
						Sauce sauce = Sauce.valueOf((String)cboSAUCE.getSelectedItem()); //data transfer from String to enum
						
						Size size = null;
						switch((String)cboSIZE.getSelectedItem()){
							case "8 inch":
								size = Size.small;
								break;
							case "11 inch":
								size = Size.large;
								break;
							case "12 inch":
								size = Size.extra_large;	
								break;
						}
						
						Topping topping = null;
						switch((String)cboTopping.getSelectedItem()){
						case "supreme":
							topping = Topping.supreme;
							break;
						case "sauage sizzle":
							topping = Topping.sauage_sizzle;
							break;
						case "hawaiian":
							topping = Topping.hawaiian;
							break;
						case "sweet chilli chicken":
							topping = Topping.sweet_chilli_chicken;
							break;
						case "garden goodness":
							topping = Topping.garden_goodness;
							break;
						case "periperi chicken":
							topping = Topping.garden_goodness;
							break;
						case "vegan cheese":
							topping = Topping.vegan_cheese;
							break;
						}
						Base base = null;
						switch ((String)cboBASE.getSelectedItem()){
						case "traditional":
							base = Base.traditional;
							break;
						case "wholemeal":
							base = Base.wholemeal;
							break;
						case "gluten free":
							base = Base.gluten;
							break;
						}
						
						int quantity=(int) sprQUANTITY.getValue();
						
						savePizzaDetail(sauce, base, size, topping, quantity);
						System.err.println("Pizza save successful");
						
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
	
	private void savePizzaDetail(Sauce sauce, Base base, Size size, Topping topping, int amount) 
	{
		System.out.println("Saving up pizza");
		Pizza pizza = new Pizza();
		
		//set up id
		int id = 0;
		if(editPizza != null) {
			id = editPizza.getPizzaid();
			pizza.setOrderid(editPizza.getOrderid());
		}else{
			//search the order from DB
			Iterator<Pizza> iterator = pizzas.findAll().iterator();
			
			int MAX = 0;
			while(iterator.hasNext()) 
			{
				Pizza myPizza = iterator.next();
				if(order.getOrderid().equals(myPizza.getOrderid())) {
					if(myPizza.getPizzaid() > MAX) {
						MAX = myPizza.getPizzaid();
					}
				}
				
			}
			MAX++;
			pizza.setOrderid(order.getOrderid());
			id = MAX;
		}
		
		
		
		pizza.setPizzaid(id);
		pizza.setSauce(sauce);
		pizza.setSize(size);
		pizza.setBase(base);
		pizza.setTopping(topping);
		pizza.setPizza_amount(amount);
		pizzas.save(pizza);
		
	}
		
		
	
	private void close() {
        this.setVisible(false);
        this.dispose();
        }
    
	}
	


