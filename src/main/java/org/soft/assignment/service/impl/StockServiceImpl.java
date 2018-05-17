package org.soft.assignment.service.impl;

import org.soft.assignment.model.Stock;
import org.soft.assignment.repositories.StockRepository;
import org.soft.assignment.service.ProductService;
import org.soft.assignment.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository repo;
    @Autowired
    private ProductService productService;

    @Override
    public List<Stock> list() {
        return repo.findAll();
    }

    @Override
    public Stock getStockDetails(String productId) {
        List<Stock> items = repo.findByProductIdAndProductIdNotNull(productId);

        Stock status = new Stock();
        status.setProductId(productId);
        status.setStockCapacity(items.size());
        status.setInStock(items.size() > 0 ? true : false);

        return status;
    }

    @Override
    public Stock create(Stock stock) {
        return repo.save(stock);
    }

    @Override
    public Stock update(Stock stock) {
        Stock existingStock = repo.getOne(stock.getId());
        existingStock.setProductId(stock.getProductId());

        return repo.save(existingStock);
    }

    @Override
    public void delete(Stock stock) {
        repo.delete(stock);
    }

    @Override
    public void delete(String id) {
        Optional<Stock> toBeDeleted = repo.findById(id);
        if (!Objects.isNull(toBeDeleted)) {
            delete(toBeDeleted.orElse(null));
        }
    }
}
