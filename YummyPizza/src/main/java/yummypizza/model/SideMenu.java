package yummypizza.model;

import yummypizza.model.product.SideOption;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CombineOrderSideMenu.class)
public class SideMenu {
	
	
	
	
	@Id
	private int sideoptionid;
	@Id
	private int orderid;
	private SideOption sideoption;
	private int sideoption_amount;
	
	public SideMenu() {
		
	}
	
	public SideMenu( int orderid, SideOption sideoption, int sideoption_amount, int sideoptionid) {
	
		this.sideoptionid=sideoptionid;
		this.sideoption=sideoption;
		this.sideoption_amount=sideoption_amount;
		this.orderid=orderid;
	}
	
	public int getSideoptionid() {
		return sideoptionid;
	}

	public void setSideoptionid(int sideoptionid) {
		this.sideoptionid = sideoptionid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public SideOption getSideoption() {
		return sideoption;
	}
	public void setSideoptionlist(SideOption sideoption) {
		this.sideoption = sideoption;
	}
	public int getSideMenuAmount() {
		return sideoption_amount;
	}
	public void setAmount(int sidemenu_amount) {
		this.sideoption_amount = sidemenu_amount;
	}
}