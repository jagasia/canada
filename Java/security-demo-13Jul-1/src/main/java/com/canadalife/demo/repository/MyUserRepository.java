package com.canadalife.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canadalife.demo.entity.MyUser;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, String>{

}
