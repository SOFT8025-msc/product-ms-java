package org.soft.assignment.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Stock implements BaseObject{
    @Id
    @GenericGenerator(name = "uuid-hex", strategy = "org.hibernate.id.UUIDHexGenerator")
    @GeneratedValue(generator = "uuid-hex")
    protected String id;

    private String productId;
    @Transient
    private boolean inStock;
    @Transient
    private int stockCapacity;

    public Stock(){}

    public Stock(String productId){
        this.setProductId(productId);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getStockCapacity() {
        return stockCapacity;
    }

    public void setStockCapacity(int stockCapacity) {
        this.stockCapacity = stockCapacity;
    }
}
