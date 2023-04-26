package com.rowan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="northwind")
public class NorthWind {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   
    public String company;
    public String first_Name;
    public String last_Name;
    public String email_address;
    public String jobtitle;
    
    public String business_PhoneNumber;
    public String home_PhoneNumber;
    public String mobile_PhoneNumber;
    public String fax_Number;
    public String address;
    public String city;
    public String state;
    public String zip_code;
    public String country;
    public String webpage;
    public String notes;
    public String attachements;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getBusiness_PhoneNumber() {
		return business_PhoneNumber;
	}
	public void setBusiness_PhoneNumber(String business_PhoneNumber) {
		this.business_PhoneNumber = business_PhoneNumber;
	}
	public String getHome_PhoneNumber() {
		return home_PhoneNumber;
	}
	public void setHome_PhoneNumber(String home_PhoneNumber) {
		this.home_PhoneNumber = home_PhoneNumber;
	}
	public String getMobile_PhoneNumber() {
		return mobile_PhoneNumber;
	}
	public void setMobile_PhoneNumber(String mobile_PhoneNumber) {
		this.mobile_PhoneNumber = mobile_PhoneNumber;
	}
	public String getFax_Number() {
		return fax_Number;
	}
	public void setFax_Number(String fax_Number) {
		this.fax_Number = fax_Number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getWebpage() {
		return webpage;
	}
	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getAttachements() {
		return attachements;
	}
	public void setAttachements(String attachements) {
		this.attachements = attachements;
	}
    
    
}
