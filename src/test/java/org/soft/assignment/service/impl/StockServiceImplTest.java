package org.soft.assignment.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.soft.assignment.model.Stock;
import org.soft.assignment.repositories.StockRepository;
import org.soft.assignment.service.StockService;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {

    @Mock
    private StockRepository stockRepositoryMock;

    @InjectMocks
    private StockService stockService = new StockServiceImpl();

    @Test
    public void list_when_stockExist_then_listOfStockIsReturned() {
        Stock stockItem1 = new Stock("prod 1");
        stockItem1.setId(UUID.randomUUID().toString());

        Stock stockItem2 = new Stock("prod 1");
        stockItem2.setId(UUID.randomUUID().toString());

        List<Stock> existingBrands = Arrays.asList(stockItem1, stockItem2);

        when(stockRepositoryMock.findAll()).thenReturn(existingBrands);

        List<Stock> stocks = stockService.list();
        assertThat(stocks, hasSize(2));
        assertThat(stocks.get(0).getProductId(), is("prod 1"));
        assertThat(stocks.get(0).getId(), is(stockItem1.getId()));
        assertThat(stocks.get(1).getProductId(), is("prod 1"));
        assertThat(stocks.get(1).getId(), is(stockItem2.getId()));

        verify(stockRepositoryMock).findAll();
    }

//    @Test
//    public void create_when_validStockProvided_then_stockIsPersisted() {
//        Stock toBeSaved = new Stock("prod 1", true, 10);
//        when(stockRepositoryMock.save(toBeSaved)).thenReturn(new Stock());
//
//        Stock result = stockService.create(toBeSaved);
//
//        assertThat(result, notNullValue());
//        ArgumentCaptor<Stock> stockCaptor = ArgumentCaptor.forClass(Stock.class);
//        verify(stockRepositoryMock).save(stockCaptor.capture());
//        Stock capturedStock = stockCaptor.getValue();
//        assertThat(capturedStock.getProductId(), is("prod 1"));
//        assertThat(capturedStock.getStockCapacity(), is(10));
//        assertThat(capturedStock.isInStock(), is(true));
//    }
//
//    @Test
//    public void update_when_validStockProvided_then_stockIsUpdated() {
//        Stock existing = new Stock("prod 1", true, 10);
//        existing.setId(UUID.randomUUID().toString());
//
//        Stock toBeSaved = new Stock("UpdatedStock", "UpdatedOwner");
//        toBeSaved.setId(existing.getId());
//        when(stockRepositoryMock.getOne(existing.getId())).thenReturn(existing);
//
//        stockService.update(toBeSaved);
//
//        ArgumentCaptor<Stock> stockCaptor = ArgumentCaptor.forClass(Stock.class);
//        verify(stockRepositoryMock).save(stockCaptor.capture());
//        Stock capturedStock = stockCaptor.getValue();
//        assertThat(capturedStock.getName(), is(toBeSaved.getName()));
//        assertThat(capturedStock.getOwner(), is(toBeSaved.getOwner()));
//    }
//
//    @Test
//    public void delete_when_stockToBeDeletedExists_then_stockIsDeleted() {
//        Stock toBeDeleted = new Stock("name", "owner");
//        stockService.delete(toBeDeleted);
//
//        ArgumentCaptor<Stock> stockCaptor = ArgumentCaptor.forClass(Stock.class);
//        verify(stockRepositoryMock).delete(stockCaptor.capture());
//        Stock capturedStock = stockCaptor.getValue();
//        assertThat(capturedStock.getName(), is(toBeDeleted.getName()));
//        assertThat(capturedStock.getOwner(), is(toBeDeleted.getOwner()));
//
//        verify(stockRepositoryMock).delete(toBeDeleted);
//    }
//
//    @Test
//    public void delete_when_idToBeDeletedDoesntExist_then_noStockIsDeleted() {
//        when(stockRepositoryMock.findById("id")).thenReturn(null);
//
//        stockService.delete("id");
//
//        verify(stockRepositoryMock).findById("id");
//        verify(stockRepositoryMock, never()).delete(Mockito.any(Stock.class));
//    }
//    @Test
//    public void delete_when_idToBeDeletedExists_then_stockForThatIdIsDeleted() {
//        Optional<Stock> toBeDeleted = Optional.of(new Stock("name", "owner"));
//        when(stockRepositoryMock.findById("id")).thenReturn(toBeDeleted);
//
//        stockService.delete("id");
//
//        verify(stockRepositoryMock).delete(toBeDeleted.get());
//    }

}