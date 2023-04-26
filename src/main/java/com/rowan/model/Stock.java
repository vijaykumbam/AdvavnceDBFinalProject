package com.rowan.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public int productId;
    public String product_Name;
}
