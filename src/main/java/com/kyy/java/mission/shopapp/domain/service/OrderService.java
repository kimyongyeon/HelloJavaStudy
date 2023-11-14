package com.kyy.java.mission.shopapp.domain.service;

import com.kyy.java.mission.shopapp.domain.dto.OrderStatus;
import com.kyy.java.mission.shopapp.domain.dto.OrderDTO;
import com.kyy.java.mission.shopapp.domain.dto.ProductDTO;
import com.kyy.java.mission.shopapp.infra.repo.MemRepo;

public class OrderService {

    private final MemRepo<OrderDTO> orderRepo;

    public OrderService(MemRepo<OrderDTO> orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void placeOrder(OrderDTO order) {

        // TODO: 2021/03/07 1. 주문할 때, 고객의 이메일이 gmail.com으로 끝나면 10% 할인을 적용한다.
        if (order.getCustomer().getEmail().contains("@gmail.com")) {
            order.getProductDTO().applyDiscount(0.1);
        }

        OrderDTO orderDTO = OrderDTO.of(order.getId(), OrderStatus.ORDERED, order.getProductDTO(), order.getTotalAmount(), order.getCustomer(), order.getOrderDate());

        orderRepo.create(orderDTO);
    }

    public void cancelOrder(OrderDTO order) {

        OrderDTO byId = orderRepo.findById(order.getId());
        if (byId.getStatus() == OrderStatus.DELIVERED) {
            throw new IllegalArgumentException("이미 배송된 주문입니다.");
        }
        if (byId.getStatus() == OrderStatus.CANCELED) {
            throw new IllegalArgumentException("이미 취소된 주문입니다.");
        }

        OrderDTO orderDTO = OrderDTO.of(order.getId(), OrderStatus.CANCELED, order.getProductDTO(), order.getTotalAmount(), order.getCustomer(), order.getOrderDate());

        orderRepo.update(order.getId(), orderDTO);
    }


    public void addProduct(long id, ProductDTO product) {
        OrderDTO orderRepoById = orderRepo.findById(id);

        OrderDTO updateOrder = OrderDTO.of(orderRepoById.getId(), OrderStatus.ORDERED, product, orderRepoById.getTotalAmount(), orderRepoById.getCustomer(), orderRepoById.getOrderDate());

        orderRepo.update(id, updateOrder);

    }

    public void removeProduct(long id, ProductDTO product) {
        OrderDTO orderRepoById = orderRepo.findById(id);

        OrderDTO.of(orderRepoById.getId(), OrderStatus.ORDERED, ProductDTO.emptyProduct(), orderRepoById.getTotalAmount(), orderRepoById.getCustomer(), orderRepoById.getOrderDate());

        orderRepo.update(id, orderRepoById);
    }


}
