package com.bs.playgroung.spring.insurance.service.premium.calculator;

import java.math.BigDecimal;

import com.bs.playgroung.spring.insurance.service.domain.Policy;

public interface PremiumCalculator {

	BigDecimal calculate(Policy policy);
}
