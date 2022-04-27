package com.bs.playgroung.spring.insurance.service.premium.calculator;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.bs.playgroung.spring.insurance.service.domain.RiskType;

@Service
public class PremiumTheftCalculator extends AbstractPremiumCalculator {

	private static final BigDecimal DEFAULT_BASE_COEFFICIENT = BigDecimal.valueOf(0.11);
	private static final BigDecimal DEFAULT_OVER_COEFFICIENT = BigDecimal.valueOf(0.05);
	private static final BigDecimal BASE_COEFFICIENT_LIMIT = BigDecimal.valueOf(15.);

	public PremiumTheftCalculator() {
		super(Set.of(RiskType.THEFT));
	}

	@Override
	protected BigDecimal resolveCoefficient(BigDecimal totalInsured) {
		return totalInsured.compareTo(BASE_COEFFICIENT_LIMIT) >= 0 ? DEFAULT_OVER_COEFFICIENT : DEFAULT_BASE_COEFFICIENT;
	}
}
