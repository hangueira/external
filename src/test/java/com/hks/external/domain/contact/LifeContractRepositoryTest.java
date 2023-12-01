package com.hks.external.domain.contact;

import com.hks.external.domain.contact.entity.LifeContract;
import com.hks.external.domain.contact.entity.LifeContractRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class LifeContractRepositoryTest {

    @Autowired
    LifeContractRepository lifeContractRepository;

    @AfterEach
    public void cleanup() {
        lifeContractRepository.deleteAll();
    }

    @Test
    public void findById() {
        // given
        String insuranceCode = "L01";
        String policyNo = "L010001";

        LifeContract saveLifeContract = lifeContractRepository.save(LifeContract.builder()
                .insuranceCd(insuranceCode)
                .policyNo(policyNo)
                .build());
        // when
        Optional<LifeContract> findLifeContract = lifeContractRepository.findById(saveLifeContract.getId());

        // then
        LifeContract lifeContract = findLifeContract
                .orElseThrow(() -> new NoSuchElementException("Life Contract not found"));
        assertThat(lifeContract).isNotNull();
        assertThat(lifeContract.getInsuranceCd()).isEqualTo(insuranceCode);
        assertThat(lifeContract.getPolicyNo()).isEqualTo(policyNo);
    }
}