package com.cg.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Asset
{
    @Column
    private String itemName;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int itemNum;

    @Column
    private int serialNum;

    @Column
    private String status;
    
    @ManyToOne
    private Employee employee;


    public Asset() {}


	public Asset(String itemName, int itemNum, int serialNum, String status, Employee employee) {
		super();
		this.itemName = itemName;
		this.itemNum = itemNum;
		this.serialNum = serialNum;
		this.status = status;
		this.employee = employee;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public int getItemNum() {
		return itemNum;
	}


	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}


	public int getSerialNum() {
		return serialNum;
	}


	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Asset [itemName=" + itemName + ", itemNum=" + itemNum + ", serialNum=" + serialNum + ", status="
				+ status + ", employee=" + employee + "]";
	}


	

}