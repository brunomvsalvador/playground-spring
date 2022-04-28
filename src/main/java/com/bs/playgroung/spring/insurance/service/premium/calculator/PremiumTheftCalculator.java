package com.bs.playgroung.spring.insurance.service.premium.calculator;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bs.playgroung.spring.insurance.service.domain.RiskType;

@Service
public class PremiumTheftCalculator extends AbstractPremiumCalculator {

	public PremiumTheftCalculator(@Value("${premium.theft.coefficient.expression}") String coefficientExpression) {
		super(Set.of(RiskType.THEFT), coefficientExpression);
	}
}
