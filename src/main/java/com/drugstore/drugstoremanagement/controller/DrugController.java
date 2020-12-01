package com.drugstore.drugstoremanagement.controller;

import com.drugstore.drugstoremanagement.entity.mysql.Drug;
import com.drugstore.drugstoremanagement.repository.RedisDrugRepository;
import com.drugstore.drugstoremanagement.service.DrugService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drugs")
@EnableCaching
public class DrugController {

    DrugService drugService;

    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping("/test-persistence")
    public String testDrugRepositoryPersistance() {
        Drug drug = new Drug(1L, "Pranol", "Minoo", 100L);
        drugService.postDrugToDatabaseServers(drug);
        return "drug";
    }


    @GetMapping("/test-cache/{id}")
    public String testDrugRepository(@PathVariable String id) throws IllegalAccessException {
        drugService.getDrug(1L);
        return "drug";
    }
}
