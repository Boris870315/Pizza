package yummypizza.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order2 {
	
	//refer to no free ride -- student 
		@Id
		private Integer orderid;
		private String name;
		
		
		public Order2(){
			
		}
		
		public Order2(Integer orderid, String name ) {
	        this.orderid= orderid;
	        this.name=name;
	    }
		
		

		
		    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

			public Integer getOrderid() {
			return orderid;
		}

		public void setOrderid(Integer orderid) {
			this.orderid = orderid;
		}


	
		public String toString() {
		       return "Order ID: "+ orderid +  " Name: " + name ;
		}
}
