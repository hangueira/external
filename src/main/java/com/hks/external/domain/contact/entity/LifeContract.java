package com.hks.external.domain.contact.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class LifeContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 3, nullable = false)
    private String insuranceCd;

    @Column(length = 24, nullable = false)
    private String policyNo;

    @Builder
    public LifeContract(String insuranceCd, String policyNo) {
        this.insuranceCd = insuranceCd;
        this.policyNo = policyNo;
    }
}
