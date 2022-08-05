package com.operation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.operation.Model.User;

public interface Userrepo extends JpaRepository<User,Integer>{

}
