package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.UserInfo;

public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
    public List<UserInfo> findByName(String name);

    public List<UserInfo> findByNameAndSex(String name, String sex);
    
    public Page<UserInfo> findByNameLike(String name,Pageable pageable);
}
