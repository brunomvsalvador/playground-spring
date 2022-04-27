package com.bs.playgroung.spring.insurance.service.premium.calculator;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.bs.playgroung.spring.insurance.service.domain.RiskType;

@Service
public class PremiumFireCalculator extends AbstractPremiumCalculator {

	private static final BigDecimal DEFAULT_BASE_COEFFICIENT = BigDecimal.valueOf(0.014);
	private static final BigDecimal DEFAULT_OVER_COEFFICIENT = BigDecimal.valueOf(0.024);
	private static final BigDecimal BASE_COEFFICIENT_LIMIT = BigDecimal.valueOf(100.);

	public PremiumFireCalculator() {
		super(Set.of(RiskType.FIRE));
	}

	@Override
	protected BigDecimal resolveCoefficient(BigDecimal totalInsured) {
		return totalInsured.compareTo(BASE_COEFFICIENT_LIMIT) > 0 ? DEFAULT_OVER_COEFFICIENT : DEFAULT_BASE_COEFFICIENT;
	}
}
