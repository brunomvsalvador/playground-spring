package com.bs.playgroung.spring.insurance.domain;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class Policy {

	private final String number;
	private final Status status;
	private final

	enum Status {
		REGISTERED, APPROVED
	}
}
