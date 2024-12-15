package com.myportfolio.portfolioms.service;

import com.myportfolio.portfolioms.dto.MutualFund;
import com.myportfolio.portfolioms.dto.MutualInputList;
import com.myportfolio.portfolioms.dto.Stock;
import com.myportfolio.portfolioms.dto.StockInputList;
import com.myportfolio.portfolioms.fienclients.MutualServiceFeignClient;
import com.myportfolio.portfolioms.fienclients.StockServiceFeignClients;
import com.myportfolio.portfolioms.model.Portfolio;
import com.myportfolio.portfolioms.repository.PortfolioRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.sound.sampled.Port;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class PortfolioServiceimpl implements PortfolioService{

    // Rest Template
    // WebClient
    // Feign CLient
    // HttpClient

    @Autowired
    private PortfolioRepository portfolioRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StockServiceFeignClients stockServiceFeignClient;

    @Autowired
    private MutualServiceFeignClient mutualServiceFeignClient;

    public Portfolio createPortfolio(Portfolio portfolio) {
        Portfolio savedportfolio= portfolioRepo.save(portfolio);
        savedportfolio.setTotalValue(fetchTotalValue(savedportfolio));
        savedportfolio.setTotalmutualfund(fetchtotalMutualfund(savedportfolio));
        return savedportfolio;
    }

    public Portfolio getPortfolioById(String id) {
        Portfolio portfolio=portfolioRepo.findById(id).orElseThrow(()->new RuntimeException("Portfolio Not Found by this Id"));
        portfolio.setTotalValue(fetchTotalValue(portfolio));
        portfolio.setTotalmutualfund(fetchtotalMutualfund(portfolio));
        return portfolio;
    }

//    @CircuitBreaker(name = "stocks-service-cb", fallbackMethod = "fetchTotalValueFallback")
    public  double fetchTotalValue(Portfolio portfolio){
        double totalValue=0;
        String url = "http://STOCKS-SERVICE/stocks/getallbyids";
        StockInputList stockInputList=new StockInputList(portfolio.getStocks().stream().toList());
//        ResponseEntity<List<Stock>> response=restTemplate.exchange(
//                url,
//                HttpMethod.POST,
//                new HttpEntity<>(stockInputList),
//                new ParameterizedTypeReference<List<Stock>>() {}
//        );
//        List<Stock> res=response.getBody();

        List<Stock> res = stockServiceFeignClient.getStocksByIds(stockInputList);
        for(Stock s: res){
            totalValue+=s.getPrice();
        }

        return totalValue;

    }
    public  double fetchTotalValueFallback(Portfolio portfolio, Exception ex){
        double totalValue=0;
        log.error(ex.getMessage());
        return totalValue;
    }

    public double fetchtotalMutualfund(Portfolio portfolio){
        double totalValue=0;
        String url = "http://MUTUAL-FUND-SERVICE/mutualfunds/getallbyids";
        MutualInputList stockInputList=new MutualInputList(portfolio.getMutualfunds().stream().toList());

        List<MutualFund> res = mutualServiceFeignClient.getMutualFundById(stockInputList);
        for(MutualFund s: res){
            totalValue+=s.getAmountInvested()+(s.getAmountInvested()*s.getGrowthRate()/100);
        }

        return totalValue;
    }
}
