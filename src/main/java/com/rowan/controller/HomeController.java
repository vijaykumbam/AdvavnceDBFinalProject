package com.rowan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rowan.model.AdventureWorks;
import com.rowan.model.NorthWind;
import com.rowan.model.Sakila_Films;
import com.rowan.repo.AdventureWorksI;
import com.rowan.repo.NorthWindI;
import com.rowan.repo.SakilaFilmsI;

@RestController()
@CrossOrigin(origins = "*")
public class HomeController {
	
	
    @Autowired
	 AdventureWorksI adventureWorksI;
	@Autowired
	 NorthWindI northWindI;
	@Autowired
	 SakilaFilmsI sakilaFilmsI;


    @GetMapping("/getallNorthWind")
    public List<NorthWind> getallNorthWind(){
        List<NorthWind> northWindObject=  northWindI.findAll();
        if(!northWindObject.isEmpty()){
            return northWindObject;
        }
        return null;

    }
    @GetMapping("/getalladvenWork")
    public List<AdventureWorks> getalladvenWork(){
        List<AdventureWorks> adventureWorksObj=  adventureWorksI.findAll();
        if(!adventureWorksObj.isEmpty()){
            return adventureWorksObj;
        }
        return null;

    }
    @GetMapping("/getallsakila")
    public List<Sakila_Films> getallsakila(){
        List<Sakila_Films> result=  sakilaFilmsI.findAll();
        if(!result.isEmpty()){
            return result;
        }
        return null;

    }


 
 

   
  

   
 



}
