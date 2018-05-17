package org.soft.assignment.repositories;

import org.soft.assignment.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

    public List<Stock> findByProductIdAndProductIdNotNull(String productId);

}
