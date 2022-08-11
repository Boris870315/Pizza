package yummypizza;



import java.util.HashMap;

import javax.swing.JDialog;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;



import yummypizza.gui.TypeDetails;
import yummypizza.model.Order2;
import yummypizza.model.product.Base;
import yummypizza.model.product.Menu;
import yummypizza.model.product.Sauce;
import yummypizza.model.product.Size;
import yummypizza.model.product.Topping;
import yummypizza.repo.OrderList;
import yummypizza.repo.PizzaList;
import yummypizza.repo.SideMenuList;

@SpringBootApplication
public class App implements InitializingBean {

	@Autowired
	private OrderList orders;
	@Autowired
	private PizzaList pizzas;
	@Autowired
	private SideMenuList sidemenus;
	
	private HashMap<String, Object> map = new HashMap();
	Order2 order = new Order2();


	//User interface
	public void typeDetailsUi(HashMap<String,Object> map) {
		try {
			TypeDetails dialog = new TypeDetails(map);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplicationBuilder builder = new SpringApplicationBuilder(App.class);
        builder.headless(false).run(args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("working");
		map.put("orders", orders);
		map.put("order", order);
		map.put("pizzas", pizzas);
		map.put("sidemenus", sidemenus);
		
		typeDetailsUi(map);
	
		
	}

}
