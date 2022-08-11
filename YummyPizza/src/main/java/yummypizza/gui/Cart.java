package yummypizza.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.FocusManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import yummypizza.model.Order2;
import yummypizza.model.Pizza;
import yummypizza.model.SideMenu;
import yummypizza.repo.OrderList;
import yummypizza.repo.PizzaList;
import yummypizza.repo.SideMenuList;

public class Cart extends JDialog {

	private final JPanel contentPanel = new JPanel();

	Order2 order;
	OrderList orders;
	Pizza pizza = new Pizza();
	PizzaList pizzas;
	SideMenu sidemenu = new SideMenu();
	JComboBox comboxBoxSearchbyName;

	private PizzaTableModel pizzaModel;
	private SideMenuTableModel sideMenuModel;

	SideMenuList sidemenus;
	private JTable tablePizza;
	private JTable tableSideMenu;
	JButton btnEditPizza;
	JButton btnEditSideMenu;
	JButton btnDelteSideMenu;
	JButton btnDeletePizza;
//	
//	private PizzaTableModel model1 ;

	/**
	 * Create the dialog.
	 */
	public Cart(HashMap<String, Object> map) {

		this.pizzas = (PizzaList) map.get("pizzas");
		this.order = (Order2) map.get("order");
		this.sidemenus = (SideMenuList) map.get("sidemenus");
		this.orders = (OrderList) map.get("orders");
		
		setAlwaysOnTop(true);
		setTitle("Cart");
		setBounds(100, 100, 834, 556);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JComboBox comboxBoxSearchbyName = new JComboBox();
		this.comboxBoxSearchbyName = comboxBoxSearchbyName;
		pizzaModel = new PizzaTableModel();
		sideMenuModel = new SideMenuTableModel();
		comboxBoxSearchbyName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pizzaModel.refreshData();
				sideMenuModel.refreshData();
			}
		});
		
		Iterator iterator = orders.findAll().iterator();
		while (iterator.hasNext()) {
			Order2 myOrder = (Order2) iterator.next();
			comboxBoxSearchbyName.addItem(myOrder);
		}

		JScrollPane scrollPanePizza = new JScrollPane();

		JLabel lblCustomerName = new JLabel("CustomerName");

		JLabel lblPizzaOrder = new JLabel("Pizza Order");

		JLabel lblSideMenuOrder = new JLabel("SideMenuOrder");

		JScrollPane scrollPaneSideMenu = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPanePizza, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addComponent(lblCustomerName)
							.addGap(23)
							.addComponent(comboxBoxSearchbyName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblPizzaOrder, Alignment.LEADING)
						.addComponent(scrollPaneSideMenu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
						.addComponent(lblSideMenuOrder, Alignment.LEADING))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboxBoxSearchbyName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCustomerName))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPizzaOrder)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPanePizza, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSideMenuOrder)
					.addGap(18)
					.addComponent(scrollPaneSideMenu, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableSideMenu = new JTable(sideMenuModel);
		scrollPaneSideMenu.setViewportView(tableSideMenu);

		tablePizza = new JTable(pizzaModel);
		
		scrollPanePizza.setViewportView(tablePizza);
		contentPanel.setLayout(gl_contentPanel);
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		

				btnEditPizza = new JButton("Edit Pizza");
				
				btnEditPizza.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(tablePizza.getSelectedRow() < 0) {
							return;
						}	
						
						Pizza editPizza = pizzaModel.getPizzaAt(tablePizza.getSelectedRow());
						PizzaMenu dialog = new PizzaMenu(FocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),
                        ModalityType.APPLICATION_MODAL,map,editPizza);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
						dialog.addWindowListener(new WindowListener() {
							
							@Override
							public void windowOpened(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowIconified(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowDeiconified(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowDeactivated(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowClosing(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowClosed(WindowEvent e) {
								pizzaModel.refreshData();
								
							}
							
							@Override
							public void windowActivated(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
						});
					}
					
				});
				
				JButton btnAddSideMenu = new JButton("Add Side Menu");
				btnAddSideMenu.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Order2 order = (Order2)comboxBoxSearchbyName.getSelectedItem();
						map.put("order", order);
						SelectSideMenu dialog = new SelectSideMenu(FocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),
		                        ModalityType.APPLICATION_MODAL,map);
						dialog.setVisible(true);
						dialog.addWindowListener(new WindowListener() {
							
							@Override
							public void windowOpened(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowIconified(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowDeiconified(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowDeactivated(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowClosing(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowClosed(WindowEvent e) {
								sideMenuModel.refreshData();
								
							}
							
							@Override
							public void windowActivated(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
						});
						
					}
				});
				buttonPane.add(btnAddSideMenu);
				
				JButton btnAddPizza = new JButton("Add Pizza");
				btnAddPizza.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Order2 order = (Order2)comboxBoxSearchbyName.getSelectedItem();
						map.put("order", order);
						PizzaMenu dialog = new PizzaMenu(FocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),
                        ModalityType.APPLICATION_MODAL,map);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
						dialog.addWindowListener(new WindowListener() {
							
							@Override
							public void windowOpened(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowIconified(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowDeiconified(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowDeactivated(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowClosing(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowClosed(WindowEvent e) {
								pizzaModel.refreshData();
								
							}
							
							@Override
							public void windowActivated(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
						});
					}
					
				});
				buttonPane.add(btnAddPizza);
				
				btnDelteSideMenu = new JButton("Delete Side Menu");
				btnDelteSideMenu.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(tableSideMenu.getSelectedRow() < 0) {
							return;
						}
						SideMenu deleteSideMenu = sideMenuModel.getSideMenuAt(tableSideMenu.getSelectedRow());
						if(deleteSideMenu == null) {
							return;
						}
						sidemenus.delete(deleteSideMenu);
						sideMenuModel.refreshData();
						
					}
				});
				buttonPane.add(btnDelteSideMenu);
			
				{
					btnDeletePizza = new JButton("Delete Pizza");
					btnDeletePizza.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							if(tablePizza.getSelectedRow() < 0) {
								return;
							}
							Pizza deletePizza = pizzaModel.getPizzaAt(tablePizza.getSelectedRow());
							pizzas.delete(deletePizza);
							pizzaModel.refreshData();
							
						}
					});
					btnDeletePizza.setActionCommand("OK");
					buttonPane.add(btnDeletePizza);
					getRootPane().setDefaultButton(btnDeletePizza);

				}
				
				btnEditSideMenu = new JButton("Edit Side Menu");
				btnEditSideMenu.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(tableSideMenu.getSelectedRow() < 0) {
							return;
						}
						SideMenu editSideMenu = sideMenuModel.getSideMenuAt(tableSideMenu.getSelectedRow());
						SelectSideMenu dialog = new SelectSideMenu(FocusManager.getCurrentKeyboardFocusManager().getActiveWindow(),
                        ModalityType.APPLICATION_MODAL,map,editSideMenu);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
						dialog.addWindowListener(new WindowListener() {
							
							@Override
							public void windowOpened(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowIconified(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowDeiconified(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowDeactivated(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowClosing(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void windowClosed(WindowEvent e) {
								sideMenuModel.refreshData();
								
							}
							
							@Override
							public void windowActivated(WindowEvent e) {
								// TODO Auto-generated method stub
								
							}
						});
					}
					
				});
				buttonPane.add(btnEditSideMenu);
				
				buttonPane.add(btnEditPizza);
				JButton cancelButton = new JButton("Close");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						close();
					}
				});
		{
			{
				GroupLayout groupLayout = new GroupLayout(getContentPane());
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 774, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(3, Short.MAX_VALUE))
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(86))
				);
				getContentPane().setLayout(groupLayout);
			}
		}
	}

	private void close() {
		this.setVisible(false);
		this.dispose();
	}

	private class PizzaTableModel extends AbstractTableModel {

		private List<Pizza> pizzaRow;
		String[] columns = { "Pizza Id","Size", "Base", "sauce", "Topping", "Pizza Amount" };

		public PizzaTableModel() {
			refreshData();
		}

		public void refreshData() {

			this.pizzaRow = new ArrayList<Pizza>();

			
			Order2 selectedOrder;
			if (comboxBoxSearchbyName.getSelectedItem() == null) {
				selectedOrder = order;
			} else {
				selectedOrder = (Order2) comboxBoxSearchbyName.getSelectedItem();
			}
			
			
			for (Pizza pizza : pizzas.findAll()) {
				if (selectedOrder.getOrderid().equals(pizza.getOrderid())) {
					this.pizzaRow.add(pizza);
				}
			}
			
			//visible and  unvisible  for edit and delete button
			if(this.pizzaRow.size() <= 0) {
				if(btnEditPizza != null) {
					btnEditPizza.setEnabled(false);
				}
				if(btnDeletePizza != null) {
					btnDeletePizza.setEnabled(false);
				}
				 
			}else {
				if(btnEditPizza != null) {
					btnEditPizza.setEnabled(true);
				}
				if(btnDeletePizza != null) {
					btnDeletePizza.setEnabled(true);
				}
				 
			}
			fireTableChanged(null);
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return pizzaRow.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columns.length;
		}

		@Override
		public String getColumnName(int column) {
			return columns[column];
		}

		//decide what to display on the cart 
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch (columnIndex) {
			case 0:
				return pizzaRow.get(rowIndex).getPizzaid();
			case 1:
				return pizzaRow.get(rowIndex).getSize();
			case 2:
				return pizzaRow.get(rowIndex).getBase();
			case 3:
				return pizzaRow.get(rowIndex).getSauce();
			case 4:
				return pizzaRow.get(rowIndex).getTopping();
			case 5:
				return pizzaRow.get(rowIndex).getPizza_amount();

			}
			return null;
		}
		
		public Pizza getPizzaAt(int rowIndex) {
			return pizzaRow.get(rowIndex);
		}

	}
	private class SideMenuTableModel extends AbstractTableModel {
		
		private List<SideMenu> sideMenuRow;
		String[] columns = {"Side Option ID","Side Option","Side Option Amount"};
		public SideMenuTableModel() {
	    	refreshData();
	    }
		
		public void refreshData() {
		
			this.sideMenuRow = new ArrayList<SideMenu>();  //
			
			//decided which data to choose 
			Order2 selectedOrder;
			if (comboxBoxSearchbyName.getSelectedItem() == null) {  //as the default 
				selectedOrder = order;
			} else { 
				selectedOrder = (Order2) comboxBoxSearchbyName.getSelectedItem();
			}
			
			for (SideMenu sidemenu: sidemenus.findAll()) {
				if (selectedOrder.getOrderid().equals(sidemenu.getOrderid())) {  //filter: search the data and find the data by Order id 
					this.sideMenuRow.add(sidemenu) ; //list the data 
				}
				
    		}
			if(this.sideMenuRow.size() <= 0) {
				if(btnEditSideMenu != null) {
					btnEditSideMenu.setEnabled(false);
				}
				if(btnDelteSideMenu != null) {
					btnDelteSideMenu.setEnabled(false);
				}
				 
			}else {
				if(btnEditSideMenu != null) {
					btnEditSideMenu.setEnabled(true);
				}
				if(btnDelteSideMenu != null) {
					btnDelteSideMenu.setEnabled(true);
				}
				 
			}
			
			fireTableChanged(null); //if the selected combo box change, the data will automatically changed
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return sideMenuRow.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columns.length;
		}

		@Override
		public String getColumnName(int column) {
			return columns[column];
		}


		//decide what to display on the cart
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex) {
				case 0:
					return sideMenuRow.get(rowIndex).getSideoptionid();
				case 1:
					return sideMenuRow.get(rowIndex).getSideoption();
				case 2:
					return sideMenuRow.get(rowIndex).getSideMenuAmount();
			}
			return null;
		}
		
		public SideMenu getSideMenuAt(int rowIndex) {
			return sideMenuRow.get(rowIndex);
		}
	}
	
}
