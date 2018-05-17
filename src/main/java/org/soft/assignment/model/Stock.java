package org.soft.assignment.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stock implements BaseObject{
    @Id
    @GenericGenerator(name = "uuid-hex", strategy = "org.hibernate.id.UUIDHexGenerator")
    @GeneratedValue(generator = "uuid-hex")
    protected String id;

    private String productId;
    private boolean inStock;
    private Integer stockCapacity;

    public Stock(){}

    public Stock(String productId, boolean inStock, Integer stockCapacity){
        this.setProductId(productId);
        this.setInStock(inStock);
        this.setStockCapacity(stockCapacity);
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

    public Integer getStockCapacity() {
        return stockCapacity;
    }

    public void setStockCapacity(Integer stockCapacity) {
        this.stockCapacity = stockCapacity;
    }
}
