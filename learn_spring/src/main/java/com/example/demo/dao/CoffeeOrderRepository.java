package com.example.demo.dao;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.bean.CoffeeOrder;

public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder, Long> {
}
