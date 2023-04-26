package com.rowan.controller;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rowan.model.Products;
import com.rowan.model.Stock;
import com.rowan.repo.ProductsI;
import com.rowan.repo.StockI;

@RestController("/product")
@CrossOrigin(origins = "*")
public class ProductController {
	
	   @Autowired
	    ProductsI productsrepo;
	   @Autowired
	    StockI stockRepo;
	   private int minimumStock=10;
	   
	    @PostMapping("/addProduct")
	    public String addProduct(@RequestParam("product_name") String product_name, 
	    						 @RequestParam("product_price") String product_price, 
	    						 @RequestParam("description") String description, 
	    						 @RequestParam("stock") int stock, 
	    						 @RequestParam("code") String code){
	        Products product = new Products();
	        product.setProduct_name(product_name);
	        product.setCode(code);
	        product.setProduct_description(description);
	        product.setProduct_price(product_price);
	        product.setAvailable_stock(stock);
	        productsrepo.save(product);
	        
	        JSONObject status = new JSONObject();
	        status.put("Status", "200");
	        status.put("Message", "Product add Successfully");
	        status.put("Response", "success");
	        return status.toString();
	    }
	    
	    @PostMapping("/getallproducts")
	    public List<Products> getallproducts(){
	        List<Products> result=  productsrepo.findAll();
	        if(!result.isEmpty()){
	            return result;
	        }
	        return null;

	    }
	    
	    @PostMapping("/getproductbyid")
	    public Optional<Products> getproductbyid(@RequestParam("id") int id){
	        Optional<Products> result=  productsrepo.findById(id);
	        if(result.isPresent()){
	            return result;
	        }
	        return null;

	    }

	 
	    @PostMapping("/deleteproduct")
	    public void deleteproduct(@RequestParam("id") int id){
	        productsrepo.deleteById(id);

	    }
	    
	    
	    @PostMapping("/editProduct")
	    public String editProduct(@RequestParam("id") int id,
	    						  @RequestParam("name") String name, 
	    						  @RequestParam("price") String price, 
	    						  @RequestParam("description") String description, 
	    						  @RequestParam("stock") int stock, 
	    						  @RequestParam("code") String code){
	        Optional<Products> result=  productsrepo.findById(id);
	        Products product = result.get();
	        product.setProduct_name(name);
	        product.setCode(code);
	        product.setProduct_description(description);
	        product.setProduct_price(price);
	        int preStock = product.getAvailable_stock();
	        if(preStock<=this.minimumStock&&stock>this.minimumStock){
	            removeStock(id);
	        }
	        product.setAvailable_stock(stock);
	        productsrepo.save(product);
	        JSONObject status = new JSONObject();
	        status.put("Status", "200");
	        status.put("Message", "Customer add Successfully");
	        status.put("Response", "success");
	        return status.toString();
	    }
	    
	    @PostMapping("/addCart")
	    public void addCart(@RequestParam("id") int id){
	        Optional<Products> result=  productsrepo.findById(id);
	        Products product = result.get();
	        int stock = product.getAvailable_stock()-1;
	        Stock prestock=  stockRepo.findByProductId(id);
	        if(stock<=this.minimumStock){
	            if(prestock==null){
	            Stock newStock = new Stock();
	            newStock.productId=id;
	            newStock.product_Name=product.getProduct_name();
	            stockRepo.save(newStock);
	            }
	        }
	        product.setAvailable_stock(product.getAvailable_stock()-1);
	        productsrepo.save(product);
	    }
	    
	    public void removeStock(int productid){
	        Stock prestock=  stockRepo.findByProductId(productid);
	        stockRepo.deleteById(prestock.id);
	    }

}
