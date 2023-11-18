package com.kyy.java.mission.bankapp.infra.repo.impl;

import com.kyy.java.mission.bankapp.domain.vo.CustomerVO;
import com.kyy.java.mission.bankapp.infra.repo.CustomerRepo;
import com.kyy.java.mission.shopapp.infra.repo.MemRepo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CustomerRepoImpl implements CustomerRepo {

    private final List<CustomerVO> CustomerVOList;

    @Override
    public void create(CustomerVO CustomerVO) {
        this.CustomerVOList.add(CustomerVO);
    }

    @Override
    public void update(long id, CustomerVO CustomerVO) {
        this.CustomerVOList.stream()
                .filter(customer -> customer.getCustomerId() == id)
                .forEach(customer -> {
            customer.setName(CustomerVO.getName());
        });
    }

    @Override
    public void delete(long id) {
        this.CustomerVOList.removeIf(customer -> customer.getCustomerId() == id);
    }

    @Override
    public CustomerVO findById(long id) {
        return this.CustomerVOList.stream()
                .filter(customer -> customer.getCustomerId() == id)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public List<CustomerVO> findAll() {
        return this.CustomerVOList;
    }
}
