package com.drugstore.drugstoremanagement.repository;

import com.drugstore.drugstoremanagement.entity.redis.DrugRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisDrugRepository extends CrudRepository<DrugRedis, String> {
}
