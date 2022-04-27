package com.bs.playgroung.spring.insurance.service.domain;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class PolicySubObject {
	private final String name;
	private final RiskType riskType;
	private final BigDecimal insured;
}
