package com.rowan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.rowan.model.AdventureWorks;
import com.rowan.model.Customer;
import com.rowan.model.NorthWind;
import com.rowan.model.Sakila_Films;
import com.rowan.repo.AdventureWorksI;
import com.rowan.repo.CustomerI;
import com.rowan.repo.NorthWindI;
import com.rowan.repo.SakilaFilmsI;

@SpringBootApplication
@EnableScheduling
public class ShopNowServerApplication {
	
	@Autowired
	CustomerI customerRepo;
	@Autowired
	AdventureWorksI advenRepo;
	@Autowired
	NorthWindI northRepo;
	@Autowired
	SakilaFilmsI sakilaRepo;

	public static void main(String[] args) {
		SpringApplication.run(ShopNowServerApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		System.out.println("Started********");
		Customer precustomer = customerRepo.findByRole("Admin");
		if(precustomer==null){
			
			Customer newadmin = new Customer();
			newadmin.setCustomerName("Vijay");
			newadmin.setRole("Admin");
			newadmin.setPassword("123456789");
			customerRepo.save(newadmin);
			
			
			NorthWind northWindCustomer = new NorthWind();
			northWindCustomer.company="NorthWind";
			northWindCustomer.last_Name="Bedecs";
			northWindCustomer.first_Name="Anna";
			northWindCustomer.email_address="anna.bedecs@gmail.com";
			northWindCustomer.jobtitle="Cashier";
			northWindCustomer.business_PhoneNumber="09090909090";
			northWindCustomer.home_PhoneNumber="123123123";
			northWindCustomer.mobile_PhoneNumber="456456456456";
			northWindCustomer.fax_Number="2424";
			northWindCustomer.address="Sector i-8/3";
			northWindCustomer.city="New York";
			northWindCustomer.state="New Tork";
			northWindCustomer.zip_code="123123";
			northWindCustomer.country="South";
			northWindCustomer.webpage="google.com";
			northWindCustomer.notes="Something";
			northWindCustomer.attachements="N\\A";
			northRepo.save(northWindCustomer);
			
			
			AdventureWorks adventureCustomer = new AdventureWorks();
			adventureCustomer.customer_type="Permanent";
			adventureCustomer.terr_Id=1212;
			adventureCustomer.acc_Number="123213";
			adventureCustomer.temp_Grid="22";
			adventureCustomer.modified_Date="12-02-2023";
			advenRepo.save(adventureCustomer);
			
			
			Sakila_Films skilaCustomer = new Sakila_Films();
			skilaCustomer.store_Id=12;
			skilaCustomer.first_Name="Mary";
			skilaCustomer.last_Name="Smith";
			skilaCustomer.email_Address="mary.smith@gmail.com";
			skilaCustomer.addresss="Sector 12 Stret#2 ";
			skilaCustomer.active="1";
			skilaCustomer.create_Date="12-02-2023";
			skilaCustomer.latest_update="";
			sakilaRepo.save(skilaCustomer);
		}
	}

}
