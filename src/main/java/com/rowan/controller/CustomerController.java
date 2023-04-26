package com.rowan.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rowan.model.Customer;
import com.rowan.repo.CustomerI;

@RestController("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {
	
    @Autowired
	 CustomerI customerRepo;
    
    
	@PostMapping("/login")
	   public String customerLogin(@RequestParam("Username") String customer_Name, @RequestParam("password") String customer_Password){
	        try {
	            List<Customer> result=  customerRepo.findByCustomerNameAndPassword (customer_Name, customer_Password);
	            JSONObject json_Status = new JSONObject();
	            if(!result.isEmpty()){
	                Customer checkCustomer = result.get(0);
	                System.out.println(checkCustomer.toString());
	                json_Status.put("json_Status", "200");
	                json_Status.put("id", checkCustomer.getCustomerId());
	                json_Status.put("role", checkCustomer.getRole());
	                json_Status.put("Message", "login operation was  Successfully");
	                json_Status.put("Response", "success");
	                return json_Status.toString();
	            }
	            else {
	                json_Status.put("json_Status", "401");
	                json_Status.put("Message", "Invalid Credentials");
	                json_Status.put("Response", "fail");
	                return json_Status.toString();
	            }
	        }
	        catch (NoResultException e){
	            return null;
	        }
	    }
	   
	   
	    @PostMapping("/register")
	    public String customerRegister(@RequestParam("customer_name") String customer_name,
	    							   @RequestParam("password") String password, 
	    							   @RequestParam("role") String role, 
	    							   @RequestParam("customer_Address") String customer_Address, 
	    							   @RequestParam("zipcode") String zipcode, 
	    							   @RequestParam("phone") String phone){

	        JSONObject json_Status = new JSONObject();
	        Customer addCustomer = new Customer();
	        addCustomer.setCustomerName(customer_name);
	        addCustomer.setPassword(password);
	        addCustomer.setRole(role);
	        addCustomer.setCustomer_address(customer_Address);
	        addCustomer.setPhone(phone);
	        addCustomer.setZipcode(zipcode);
	        customerRepo.save(addCustomer);
	        json_Status.put("json_Status", "200");
	        json_Status.put("Message", "Customer registered Successfully");
	        json_Status.put("Response", "success");
	        return json_Status.toString();
	    }
	    
	    
	    
	    @GetMapping("/getCustomers")
	    public List<Customer> getCustomers(){
	        List<Customer> customersList =  customerRepo.findAll();
	        if(!customersList.isEmpty()){
	            return customersList;
	        }
	        return null;

	    }
	    
	    
	    @PostMapping("/addCustomer")
	    public String addCustomer(@RequestParam("customer_name") String customer_name,
	    						  @RequestParam("customer_Address") String customer_Address, 
	    						  @RequestParam("zipcode") String zipcode, 
	    						  @RequestParam("phone") String phone){
	        Customer customerObj = new Customer();
	        customerObj.setCustomerName(customer_name);
	        customerObj.setCustomer_address(customer_Address);
	        customerObj.setZipcode(zipcode);
	        customerObj.setPhone(phone);
	        customerRepo.save(customerObj);
	        JSONObject status = new JSONObject();
	        status.put("Status", "200");
	        status.put("Message", "Customer add Successfully");
	        status.put("Response", "success");
	        return status.toString();
	    }
	    
	    
	    @GetMapping("/id")
	    public Optional<Customer> getCustomerById(@RequestParam("id") int id){
	        Optional<Customer> customerObj=  customerRepo.findById(id);
	        if(customerObj.isPresent()){
	            return customerObj;
	        }
	        return null;

	    }
	    
	    @DeleteMapping("/deleteCustomer")
	    public void deleteCustomer(@RequestParam("id") int id){
	    	customerRepo.deleteById(id);

	    }
	    
	    
	    @PutMapping("/editCustomer")
	    public String editCustomerDetails(@RequestParam("customer_id") int customer_id,
	    						   		  @RequestParam("name") String name, 
	    						   		  @RequestParam("Address") String Address, 
	    						   		  @RequestParam("zip") String zipcode, 
	    						   		  @RequestParam("phone") String phone){
	        Optional<Customer> result=  customerRepo.findById(customer_id);
	        Customer precustomer = result.get();
	        precustomer.setPhone(phone);
	        precustomer.setZipcode(zipcode);
	        precustomer.setCustomer_address(Address);
	        precustomer.setCustomerName(name);
	        customerRepo.save(precustomer);
	        JSONObject status = new JSONObject();
	        status.put("Status", "200");
	        status.put("Message", "Customer add Successfully");
	        status.put("Response", "success");
	        return status.toString();
	    }
}
