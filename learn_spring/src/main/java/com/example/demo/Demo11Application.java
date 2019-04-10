package com.example.demo;

import java.util.Arrays;
import java.util.Collections;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.bean.Coffee;
import com.example.demo.bean.CoffeeOrder;
import com.example.demo.dao.CoffeeOrderRepository;
import com.example.demo.dao.CoffeeRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class Demo11Application implements ApplicationRunner {
    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeOrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(Demo11Application.class, args);
	}

	@Override
    public void run(ApplicationArguments args) throws Exception {
        //initOrders();
    }

    private void initOrders() {
        Coffee espresso = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();
        coffeeRepository.save(espresso);
        log.info("Coffee: {}", espresso);
        
        Coffee xx = Coffee.builder().name("xx").price(Money.of(CurrencyUnit.of("CNY"), 10)).build();
        coffeeRepository.save(xx);
        log.debug("Coffee: {}", xx);
        //占位符的特性, {}, 类似于String#format() 中的%s, 可以在运行时延迟字符串的建立, 只有需要String对象时才会被创建
        //logger.debug("Processing trade with id: {} and symbol : {} ", id, symbol);

        Coffee latte = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .build();
        coffeeRepository.save(latte);
        log.info("Coffee: {}", latte);

        CoffeeOrder order = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Collections.singletonList(espresso))
                .state(0)
                .build();
        orderRepository.save(order);
        log.info("Order: {}", order);

        order = CoffeeOrder.builder()
                .customer("Li Lei")
                .items(Arrays.asList(espresso, latte, xx))
                .state(0)
                .build();        
        orderRepository.save(order);
        log.info("Order: {}", order);
        
        
    }
}
