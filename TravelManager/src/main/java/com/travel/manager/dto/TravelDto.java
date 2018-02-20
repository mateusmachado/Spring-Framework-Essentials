package com.travel.manager.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TravelDto implements Serializable {

	private static final long serialVersionUID = -8105241933692707649L;

	private Long id;

	private String destination;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date departureDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateReturn;

	private String companion;

	public TravelDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull(message = "Place of destination is a mandatory information")
	@Length(min = 3, max = 40, message = "Target Location must be between 3 and 40 characters")
	public String getLocalDeDestino() {
		return destination;
	}

	public void setLocalDeDestino(String destination) {
		this.destination = destination;
	}

	@NotNull(message = "Departure Date is mandatory information")
	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	public String getCompanion() {
		return companion;
	}

	public void setCompanion(String companion) {
		this.companion = companion;
	}

	@Override
	public String toString() {
		return "TravelDto [id=" + id + ", destination=" + destination + ", departureDate=" + departureDate
				+ ", dateReturn=" + dateReturn + ", companion=" + companion + "]";
	}
}