package com.bs.playgroung.spring.insurance.service.premium;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.bs.playgroung.spring.insurance.service.domain.Policy;
import com.bs.playgroung.spring.insurance.service.premium.calculator.PremiumCalculator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PremiumCalculationService {

	private final List<PremiumCalculator> premiumStrategies;

	public BigDecimal calculate(Policy policy) {
		return this.premiumStrategies.stream()
				.map(premiumCalculator -> premiumCalculator.calculate(policy))
				.filter(Objects::nonNull)
				.reduce(BigDecimal.ZERO, BigDecimal::add)
				.setScale(2, RoundingMode.HALF_UP);
	}
}
