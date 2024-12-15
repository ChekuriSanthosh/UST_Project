package com.myportfolio.mutualfundsms.api;


import com.myportfolio.mutualfundsms.dto.MutualInputList;
import com.myportfolio.mutualfundsms.model.MutualFund;
import com.myportfolio.mutualfundsms.repository.MutualFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mutualfunds")
public class MutualFundapi {

    @Autowired
    private MutualFundRepository mutualFundRepository;


    @PostMapping
    public MutualFund createMutualFund(MutualFund mutualFund){
        return mutualFundRepository.save(mutualFund);
    }

    @GetMapping("/{id}")
    public MutualFund GetMutualFundByID(@PathVariable int id){
        return mutualFundRepository.findById(id).orElseThrow(()->new RuntimeException("Mutual Fund Not Found By this id"));
    }

    @PostMapping("/getallbyids")
    public List<MutualFund> getallbyids(@RequestBody MutualInputList stockInputList){
        List<MutualFund> stocks=mutualFundRepository.findAllById(stockInputList.ids());
        return stocks;
    }
}
