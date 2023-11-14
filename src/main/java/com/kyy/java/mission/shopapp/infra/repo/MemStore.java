package com.kyy.java.mission.shopapp.infra.repo;

import com.kyy.java.mission.shopapp.domain.dto.CustomerDTO;
import com.kyy.java.mission.shopapp.domain.dto.OrderDTO;
import com.kyy.java.mission.shopapp.domain.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class MemStore {
    public static List<CustomerDTO> customers = new ArrayList<>();
    public static List<OrderDTO> orders = new ArrayList<>();
    public static List<ProductDTO> products = new ArrayList<>();
}
