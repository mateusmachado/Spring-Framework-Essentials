package com.travel.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.manager.dto.TravelDto;
import com.travel.manager.entities.Travel;
import com.travel.manager.repository.TravelRepository;

@Service
public class TravelService {

	@Autowired
	private TravelRepository travelRepository;
	
	public List<Travel> list(){
		return travelRepository.findAll();
	}
	
	public Travel save(TravelDto travelDto) {

		Travel travel = new Travel();

		travel.setLocalDestination(travelDto.getLocalDestination());
		travel.setDepartureDate(travelDto.getDepartureDate());
		travel.setDateReturn(travelDto.getDateReturn());
		travel.setCompanion(travelDto.getCompanion());
		return travelRepository.save(travel);
	}
	
	public Travel find(Long id) {
		Travel travel = travelRepository.findOne(id);

		if (travel == null) {
			throw new TravelServiceException("No travel recorded");
		}
		return travel;
	}
}
