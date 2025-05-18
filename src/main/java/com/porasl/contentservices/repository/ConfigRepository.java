package com.porasl.contentservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.porasl.contentservices.domain.Config;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {
}
