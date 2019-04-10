package com.example.demo.dao;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.bean.Coffee;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
