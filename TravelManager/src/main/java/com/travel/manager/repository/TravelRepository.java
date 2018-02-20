package com.travel.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.manager.entities.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

	Travel findByDestination(String destination);
}
