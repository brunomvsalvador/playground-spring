package com.bs.playgroung.spring.insurance.service.domain;

import java.util.Collection;
import java.util.Collections;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class Policy {

	private final String number;
	private final PolicyStatus status;

	@Builder.Default
	private final Collection<PolicyObject> objects = Collections.emptyList();
}
