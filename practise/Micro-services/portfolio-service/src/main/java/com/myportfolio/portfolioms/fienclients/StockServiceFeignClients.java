package com.myportfolio.portfolioms.fienclients;

import com.myportfolio.portfolioms.dto.Stock;
import com.myportfolio.portfolioms.dto.StockInputList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "stocks-service")
public interface StockServiceFeignClients {

    @RequestMapping(value = "/stocks/getallbyids", method = RequestMethod.POST)
    List<Stock> getStocksByIds(@RequestBody StockInputList stockInputList);
}