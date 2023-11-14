package com.kyy.java.mission.shopapp.infra.repo.impl;

import com.kyy.java.mission.shopapp.domain.dto.OrderDTO;
import com.kyy.java.mission.shopapp.domain.dto.OrderStatus;
import com.kyy.java.mission.shopapp.infra.repo.MemRepo;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRepoImpl implements MemRepo<OrderDTO> {

    List<OrderDTO> orders;

    public OrderRepoImpl(List<OrderDTO> list) {
        orders = list;
    }

    @Override
    public void create(OrderDTO orderDTO) {
        orders.add(orderDTO);
    }

    @Override
    public void update(long id, OrderDTO orderDTO) {
        orders.stream().filter(order -> order.getId() == id).findFirst().ifPresent(order -> {
            OrderDTO.of(order.getId(), orderDTO.getStatus(), orderDTO.getProductDTO(), orderDTO.getTotalAmount(), orderDTO.getCustomer(), LocalDateTime.now());
        });
    }

    @Override
    public void delete(long id) {
        orders.remove((int) id);
    }

    @Override
    public OrderDTO findById(long id) {
        return orders.stream().filter(orderDTO -> orderDTO.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<OrderDTO> findAll() {
        return orders;
    }
}
