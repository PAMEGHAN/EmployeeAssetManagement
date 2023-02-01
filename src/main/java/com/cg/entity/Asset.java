package com.cg.entity;

 

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
    

    public Asset() {}


	public Asset(String itemName, int itemNum, int serialNum, String status) {
		super();
		this.itemName = itemName;
		this.itemNum = itemNum;
		this.serialNum = serialNum;
		this.status = status;
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


	@Override
	public String toString() {
		return "Asset [itemName=" + itemName + ", itemNum=" + itemNum + ", serialNum=" + serialNum + ", status="
				+ status + "]";
	}

	

}