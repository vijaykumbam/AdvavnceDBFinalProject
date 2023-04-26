package com.rowan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rowan.model.Stock;
import com.rowan.repo.StockI;

@RestController("/stock")
@CrossOrigin(origins = "*")
public class StockController {
	
	  	@Autowired
	     StockI stockRepo;
	  
	  
	@PostMapping("/getStock")
    public List<Stock> getstock(){
        List<Stock> result=  stockRepo.findAll();
        if(!result.isEmpty()){
            return result;
        }
        return null;
    }

}
