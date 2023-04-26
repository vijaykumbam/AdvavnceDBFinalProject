package com.rowan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String supplier_Name;
    private String supplier_Address;
    private String zipcode;
    private String supplier_PhoneNumber;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSupplier_Name() {
		return supplier_Name;
	}
	public void setSupplier_Name(String supplier_Name) {
		this.supplier_Name = supplier_Name;
	}
	public String getSupplier_Address() {
		return supplier_Address;
	}
	public void setSupplier_Address(String supplier_Address) {
		this.supplier_Address = supplier_Address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSupplier_PhoneNumber() {
		return supplier_PhoneNumber;
	}
	public void setSupplier_PhoneNumber(String supplier_PhoneNumber) {
		this.supplier_PhoneNumber = supplier_PhoneNumber;
	}

   
    
    
}
