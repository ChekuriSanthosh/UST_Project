package com.myportfolio.stocksms.api;


import com.myportfolio.stocksms.dto.StockInputList;
import com.myportfolio.stocksms.model.Stock;
import com.myportfolio.stocksms.repository.StocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StocksApi {

    @Autowired
    private StocksRepository stocksRepo;

    @PostMapping
    public Stock addStock(@RequestBody Stock stock){
        return stocksRepo.save(stock);
    }

    @GetMapping
    public List<Stock> getAllStocks(){
        return stocksRepo.findAll();
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable int id){
        return stocksRepo.findById(id)
                .orElseThrow(()->new RuntimeException("No stock found with ID : "+id));
    }

    @PostMapping("/getallbyids")
    public List<Stock> getallbyids(@RequestBody StockInputList stockInputList){
        List<Stock> stocks=stocksRepo.findAllById(stockInputList.ids());
        return stocks;
    }


}
