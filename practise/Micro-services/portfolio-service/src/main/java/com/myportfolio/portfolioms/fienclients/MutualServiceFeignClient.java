package com.myportfolio.portfolioms.fienclients;

import com.myportfolio.portfolioms.dto.MutualFund;
import com.myportfolio.portfolioms.dto.MutualInputList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "mutual-fund-service")
public interface MutualServiceFeignClient {

    @RequestMapping( value = "/mutualfunds/getallbyids", method = RequestMethod.POST)
    List<MutualFund> getMutualFundById(@RequestBody MutualInputList mutualInputList);

}

