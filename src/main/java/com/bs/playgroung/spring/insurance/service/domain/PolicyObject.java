package com.bs.playgroung.spring.insurance.service.domain;

import java.util.Collection;
import java.util.Collections;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class PolicyObject {
	private final String name;

	@Builder.Default
	private final Collection<PolicySubObject> subObjects = Collections.emptyList();
}
