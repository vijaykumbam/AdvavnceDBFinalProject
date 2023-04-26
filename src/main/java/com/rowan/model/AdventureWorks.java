package com.rowan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="adventure_works")
public class AdventureWorks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public int terr_Id;
    public String acc_Number;
    public String customer_type;
    public String temp_Grid;
    public String modified_Date;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getterr_Id() {
		return terr_Id;
	}
	public void setterr_Id(int terr_Id) {
		terr_Id = terr_Id;
	}
	public String getacc_Number() {
		return acc_Number;
	}
	public void setacc_Number(String acc_Number) {
		this.acc_Number = acc_Number;
	}
	public String getcustomer_type() {
		return customer_type;
	}
	public void setcustomer_type(String customer_type) {
		customer_type = customer_type;
	}
	public String gettemp_Grid() {
		return temp_Grid;
	}
	public void settemp_Grid(String temp_Grid) {
		this.temp_Grid = temp_Grid;
	}
	public String getmodified_Date() {
		return modified_Date;
	}
	public void setmodified_Date(String modified_Date) {
		this.modified_Date = modified_Date;
	}
    
    
}
