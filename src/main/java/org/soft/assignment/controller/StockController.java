package org.soft.assignment.controller;

import org.soft.assignment.model.Stock;
import org.soft.assignment.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/stockElements")
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Stock> getList() {
        return stockService.list();
    }

    @RequestMapping(value ="/status/{productId}", method = RequestMethod.GET)
    public Stock getStockStatus(@RequestParam String productId){
        return stockService.getStockDetails(productId);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Stock create(@RequestBody Stock object) {
        return stockService.create(object);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Stock update(@RequestParam String id, @RequestBody Stock object) {
        return stockService.update(object);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@RequestParam String id) {
        stockService.delete(id);
    }
}
