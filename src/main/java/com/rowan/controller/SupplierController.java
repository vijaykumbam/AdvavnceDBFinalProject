package com.rowan.controller;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rowan.model.Supplier;
import com.rowan.repo.SupplierI;

@RestController("/supplier")
@CrossOrigin(origins = "*")
public class SupplierController {
	
	  @Autowired
	   SupplierI supplierI;
	  
	  
	    	@PostMapping("/addSupplier")
		    public String addSupplier(@RequestParam("supplier_name") String supplier_name, 
		    						  @RequestParam("supplier_address") String supplier_address, 
		    						  @RequestParam("zipcode") String zipcode, 
		    						  @RequestParam("phone") String phone){
		        Supplier supplierObj = new Supplier();
		        supplierObj.setSupplier_Name(supplier_name);
		        supplierObj.setSupplier_Address(supplier_address);
		        supplierObj.setZipcode(zipcode);
		        supplierObj.setSupplier_PhoneNumber(phone);
		        supplierI.save(supplierObj);
		        JSONObject status = new JSONObject();
		        status.put("Status", "200");
		        status.put("Message", "Supplier added Successfully");
		        status.put("Response", "success");
		        return status.toString();
		    }
		  
		  
		    @GetMapping("/getSuppliers")
		    public List<Supplier> getAllSupplier(){
		        List<Supplier> supplierObjs=  supplierI.findAll();
		        if(!supplierObjs.isEmpty()){
		            return supplierObjs;
		        }
		        return null;

		    }
		    
		    
		    
		    @GetMapping("/getbyid")
		    public Optional<Supplier> getSupplierById(@RequestParam("id") int id){
		        Optional<Supplier> supplierObj=  supplierI.findById(id);
		        if(supplierObj.isPresent()){
		            return supplierObj;
		        }
		        return null;

		    }
		    
		    
		    @DeleteMapping("/deleteSupplier")
		    public void deleteSupplier(@RequestParam("id") int id){
		        supplierI.deleteById(id);

		    }
		    
		    
		    @PutMapping("/edit")
		    public String editSupplier(@RequestParam("supplier_id") int id,
		    						   @RequestParam("supplier_name") String supplier_name, 
		    						   @RequestParam("supplier_address") String supplier_address, 
		    						   @RequestParam("zipcode") String zipcode, 
		    						   @RequestParam("phone") String phone){
		        Optional<Supplier> supplierObj=  supplierI.findById(id);
		        Supplier precustomer = supplierObj.get();
		        precustomer.setSupplier_PhoneNumber(phone);
		        precustomer.setZipcode(zipcode);
		        precustomer.setSupplier_Address(supplier_address);
		        precustomer.setSupplier_Name(supplier_name);
		        supplierI.save(precustomer);
		        JSONObject status = new JSONObject();
		        status.put("Status", "200");
		        status.put("Message", "Supplier edit was Successfully executed");
		        status.put("Response", "success");
		        return status.toString();
		    }

}
