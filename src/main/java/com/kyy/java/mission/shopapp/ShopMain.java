package com.kyy.java.mission.shopapp;

import com.kyy.java.mission.shopapp.controller.RestController;
import com.kyy.java.mission.shopapp.domain.dto.CustomerDTO;
import com.kyy.java.mission.shopapp.domain.dto.OrderDTO;
import com.kyy.java.mission.shopapp.domain.dto.OrderStatus;
import com.kyy.java.mission.shopapp.domain.dto.ProductDTO;
import com.kyy.java.mission.shopapp.domain.service.CustomerService;
import com.kyy.java.mission.shopapp.domain.service.OrderService;
import com.kyy.java.mission.shopapp.domain.service.ProductService;
import com.kyy.java.mission.shopapp.infra.repo.MemStore;
import com.kyy.java.mission.shopapp.infra.repo.impl.CustomerRepoImpl;
import com.kyy.java.mission.shopapp.infra.repo.impl.OrderRepoImpl;
import com.kyy.java.mission.shopapp.infra.repo.impl.ProductRepoImpl;

import java.time.LocalDateTime;

public class ShopMain {
    public static void main(String[] args) {
        System.out.println("Hello ShopApp");

        ProductService productService = new ProductService(new ProductRepoImpl(MemStore.products));
        CustomerService customerService = new CustomerService(new CustomerRepoImpl(MemStore.customers));
        OrderService orderService = new OrderService(new OrderRepoImpl(MemStore.orders));
        RestController restController = new RestController(
                productService, customerService, orderService
        );

        // 회원가입
        restController.signUp(CustomerDTO.of(1, "홍길동", "test@gmail.com", "서울시 강남구"));

        // 상품등록
        restController.registerProduct(ProductDTO.of(1, "아이폰99", "스마트폰", 1000000, 1000));

        // --------- 주문생성 ------------
        // 1. 회원조회
        CustomerDTO profile = restController.getProfile(1L);
        // 2. 상품조회
        ProductDTO product = restController.getProduct(1L);
        // 3. 주문생성
        restController.createOrder(OrderDTO.of(1, OrderStatus.ORDERED, product, 1000, profile, LocalDateTime.now()));
        // --------- 주문생성 ------------


    }
}
