package com.porasl.contentservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.porasl.contentservices.domain.Attach;

public interface AttachRepository extends JpaRepository<Attach, Integer> {

 @Query(value = "select attach from Attach attach inner join User u on attach.userid = u.id where attach.userid = :id")
  List<Attach> findAllByUsetId(long userid);
 
  
}