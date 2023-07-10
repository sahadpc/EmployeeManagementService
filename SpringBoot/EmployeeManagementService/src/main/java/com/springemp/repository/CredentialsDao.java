package com.springemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springemp.entity.Credentials;

@Repository
public interface CredentialsDao extends JpaRepository<Credentials, Integer> {

}
