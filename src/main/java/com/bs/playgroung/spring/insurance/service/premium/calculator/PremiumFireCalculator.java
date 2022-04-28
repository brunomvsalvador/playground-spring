package com.bs.playgroung.spring.insurance.service.premium.calculator;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bs.playgroung.spring.insurance.service.domain.RiskType;

@Service
public class PremiumFireCalculator extends AbstractPremiumCalculator {

	public PremiumFireCalculator(@Value("${premium.fire.coefficient.expression}") String coefficientExpression) {
		super(Set.of(RiskType.FIRE), coefficientExpression);
	}
}
