package com.drugstore.drugstoremanagement.service;

import com.drugstore.drugstoremanagement.entity.mysql.Drug;
import com.drugstore.drugstoremanagement.entity.redis.DrugRedis;
import com.drugstore.drugstoremanagement.repository.DrugRepository;
import com.drugstore.drugstoremanagement.repository.RedisDrugRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@EnableCaching
public class DrugService {

    private final DrugRepository drugRepository;
    private final RedisDrugRepository redisDrugRepository;

    public DrugService(DrugRepository drugRepository, RedisDrugRepository redisDrugRepository) {
        this.drugRepository = drugRepository;
        this.redisDrugRepository = redisDrugRepository;
    }


    public Drug postDrugToDatabaseServers(Drug drug) {
        // Save given drug into mysql database
        drugRepository.save(drug);

        // Save given drug into redis database
        DrugRedis drugRedis = new DrugRedis(
                drug.getId().toString(),
                drug.getName(),
                drug.getCompany(),
                drug.getPrice().toString()
        );
        redisDrugRepository.save(drugRedis);
        return drug;
    }

    @CacheEvict(value = "drug", key = "#id")
    public Drug deleteDrug(Long id) {
        // Delete given drug into mysql database
        Drug drug = drugRepository.findById(id).get();
        drugRepository.delete(drug);

        // Delete given drug into redis   database
        DrugRedis drugRedis = redisDrugRepository.findById(id.toString()).get();
        redisDrugRepository.delete(drugRedis);
        return drug;
    }

    @Cacheable(value = "Drug",key = "#id")
    public Drug getDrug(Long id) {
        Drug drug = drugRepository.findById(id).get();
        return drug;
    }
}
