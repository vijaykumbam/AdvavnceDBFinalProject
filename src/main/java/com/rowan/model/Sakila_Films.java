package com.rowan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="sakila")
public class Sakila_Films {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public int store_Id;
    public String first_Name;
    public String last_Name;
    public String email_Address;
    public String addresss;
    public String active;
    public String create_Date;
    public String latest_update;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStore_Id() {
		return store_Id;
	}
	public void setStore_Id(int store_Id) {
		this.store_Id = store_Id;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getEmail_Address() {
		return email_Address;
	}
	public void setEmail_Address(String email_Address) {
		this.email_Address = email_Address;
	}
	public String getAddresss() {
		return addresss;
	}
	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getCreate_Date() {
		return create_Date;
	}
	public void setCreate_Date(String create_Date) {
		this.create_Date = create_Date;
	}
	public String getLatest_update() {
		return latest_update;
	}
	public void setLatest_update(String latest_update) {
		this.latest_update = latest_update;
	}
    
    
}