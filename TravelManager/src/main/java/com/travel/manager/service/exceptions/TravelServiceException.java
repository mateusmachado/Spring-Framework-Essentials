package com.travel.manager.service.exceptions;

public class TravelServiceException extends RuntimeException {

	private static final long serialVersionUID = -1402677565107062800L;

	public TravelServiceException(String mensagem) {
		super(mensagem);
	}

	public TravelServiceException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
