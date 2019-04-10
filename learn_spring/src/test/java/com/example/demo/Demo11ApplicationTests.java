package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.bean.UserInfo;
import com.example.demo.dao.UserInfoDao;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Demo11ApplicationTests {
    
    @Autowired
    private UserInfoDao userInfoDao;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void insertTest() {
	    UserInfo ui = UserInfo.builder().name("张三").sex("男").build();
	    userInfoDao.save(ui);
	}
	
	@Test
	public void updateTest() {
	    UserInfo ui = UserInfo.builder().id(18).name("李四").sex("女").build();
	    userInfoDao.save(ui);
	}
	
	@Test
	public void deleteTest() {
	    userInfoDao.deleteById(13);
	}
	
	@Test
	public void queryTest() {
	    List<UserInfo> list = userInfoDao.findByName("张三");
        for (UserInfo ui : list) {
            log.info("UserInfo: {}", ui);
        }
        
        list = userInfoDao.findByNameAndSex("李四", "女");
        for (UserInfo ui : list) {
            log.info("UserInfo: {}", ui);
        }
        
        //UserInfo ui = UserInfo.builder().id(18).name("李四").sex("女").build();
        
        Pageable pageable = PageRequest.of(0, 2);
        Page<UserInfo> page = userInfoDao.findByNameLike("%三%", pageable);

        for (UserInfo ui : page.getContent()) {
            log.info("UserInfo: {}", ui);
        }
	}
}
