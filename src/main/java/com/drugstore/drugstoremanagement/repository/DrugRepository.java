package com.drugstore.drugstoremanagement.repository;

import com.drugstore.drugstoremanagement.entity.mysql.Drug;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends CrudRepository<Drug, Long> {
}
