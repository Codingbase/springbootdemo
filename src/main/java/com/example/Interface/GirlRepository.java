package com.example.Interface;

import com.example.Entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 接口方法,继承jpa的一些方法
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
     List<Girl> findByAge(Integer age);
}
