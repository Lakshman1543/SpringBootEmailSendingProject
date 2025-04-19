package com.klef.fsad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.fsad.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer>{

}
