package guitarV1.action;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import guitarV1.entity.Guitar;
import guitarV1.service.GuitarService;

public class GuitarAction extends ActionSupport {
	  private String serialNumber, builder, model, type, backWood, topWood;
	  private double price;
	 
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBackWood() {
		return backWood;
	}
	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}
	public String getTopWood() {
		return topWood;
	}
	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	public String find() throws Exception{
		GuitarService a=new GuitarService();
		List<Guitar> list =a.getAll(price,serialNumber, builder, model, type, backWood, topWood);
		ActionContext.getContext().getSession().put("GuitarList", list);
		return SUCCESS;
		
	}
}