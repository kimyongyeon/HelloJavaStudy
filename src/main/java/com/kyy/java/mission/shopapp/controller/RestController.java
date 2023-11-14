package com.kyy.java.mission.shopapp.controller;

import com.kyy.java.mission.shopapp.domain.dto.CustomerDTO;
import com.kyy.java.mission.shopapp.domain.dto.OrderDTO;
import com.kyy.java.mission.shopapp.domain.dto.ProductDTO;
import com.kyy.java.mission.shopapp.domain.service.CustomerService;
import com.kyy.java.mission.shopapp.domain.service.OrderService;
import com.kyy.java.mission.shopapp.domain.service.ProductService;

public class RestController {

    private final ProductService productService;
    private final CustomerService customerService;
    private final OrderService orderService;

    public RestController(ProductService productService, CustomerService customerService, OrderService orderService) {
        this.productService = productService;
        this.customerService = customerService;
        this.orderService = orderService;
    }

    // 회원가입
    public void signUp(CustomerDTO customerDTO) {
        CustomerDTO.of(customerDTO.getId(), customerDTO.getName(), customerDTO.getEmail(), customerDTO.getShippingAddress());

        customerService.registerProfile(customerDTO);

        System.out.println(String.format("회원가입이 완료되었습니다. %s", customerDTO.getName()));

    }

    // 회원조회
    public CustomerDTO getProfile(long id) {
        return customerService.getProfile(id);
    }

    // 회원수정
    public void updateProfile(long id, CustomerDTO customerDTO) {
        CustomerDTO.of(customerDTO.getId(), customerDTO.getName(), customerDTO.getEmail(), customerDTO.getShippingAddress());

        customerService.editProfile(id, customerDTO);

        System.out.println(String.format("회원정보가 수정되었습니다. %s", customerDTO.getName()));
    }

    // 회원탈퇴
    public void deleteProfile(long id) {
        customerService.removeProfile(id);

        System.out.println(String.format("회원탈퇴가 완료되었습니다. %s", id));
    }

    // 주문생성
    public void createOrder(OrderDTO orderDTO) {
        orderService.placeOrder(orderDTO);

        System.out.println(String.format("주문이 완료되었습니다. %s", orderDTO.getCustomer().getName()));
    }

    // 주문취소
    public void cancelOrder(OrderDTO orderDTO) {
        orderService.cancelOrder(orderDTO);

        System.out.println(String.format("주문이 취소되었습니다. %s", orderDTO.getCustomer().getName()));
    }

    // 상품등록
    public void registerProduct(ProductDTO productDTO) {
        productService.registerProduct(productDTO);

        System.out.println(String.format("상품등록이 완료되었습니다. %s", productDTO.getName()));
    }

    // 상품삭제
    public void removeProduct(long id) {
        productService.removeProduct(id);

        System.out.println(String.format("상품삭제가 완료되었습니다. %s", id));
    }

    // 상품조회
    public ProductDTO getProduct(long id) {
        return productService.getProduct(id);
    }

    // 수량수정
    public void decreaseStock(long id, int quantity) {
        productService.decreaseStock(id, quantity);

        System.out.println(String.format("재고수정이 완료되었습니다. %s", id));
    }

}
