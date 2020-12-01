package com.drugstore.drugstoremanagement.entity.redis;

import com.drugstore.drugstoremanagement.entity.mysql.Drug;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RedisHash("Drugs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugRedis implements Serializable {
    @Id
    private String id;
    private String drugName;
    private String company;
    private String price;
}
