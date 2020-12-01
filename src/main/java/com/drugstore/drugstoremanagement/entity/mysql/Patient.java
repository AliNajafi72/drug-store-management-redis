package com.drugstore.drugstoremanagement.entity.mysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private String age;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="PATIENT_DRUG", joinColumns=@JoinColumn(name="PATIENT_ID"), inverseJoinColumns=@JoinColumn(name="DRUG_ID"))
    private List<Drug> drugs = new ArrayList<>();
}
