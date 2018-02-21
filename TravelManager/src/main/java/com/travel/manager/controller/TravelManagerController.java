package com.travel.manager.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.travel.manager.dto.TravelDto;
import com.travel.manager.entities.Travel;
import com.travel.manager.responses.Response;
import com.travel.manager.service.TravelService;

@RestController
@RequestMapping("/api/travels")
public class TravelManagerController {

	@Autowired
	private TravelService travelService;

	@PostMapping(path = "/new")
	public ResponseEntity<Response<Travel>> register(@Valid @RequestBody TravelDto travelDto, BindingResult result) {
		Response<Travel> response = new Response<Travel>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Travel travelSave = this.travelService.save(travelDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(travelDto.getId())
				.toUri();
		response.setData(travelSave);
		return ResponseEntity.created(location).body(response);
	}

	@GetMapping
	public ResponseEntity<List<Travel>> list() {
		List<Travel> travels = TravelService.list();
		return ResponseEntity.status(HttpStatus.OK).body(travels);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Travel>> find(@PathVariable("id") Long id) {

		Travel travel = travelService.find(id);
		Response<Travel> response = new Response<Travel>();
		response.setData(travel);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
