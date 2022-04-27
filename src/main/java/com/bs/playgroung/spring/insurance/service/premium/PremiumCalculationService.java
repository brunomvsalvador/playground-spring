package com.bs.playgroung.spring.insurance.service.premium;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.bs.playgroung.spring.insurance.service.premium.strategy.PremiumStrategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PremiumCalculationService {

	private final List<PremiumStrategy> premiumStrategies;

	public BigDecimal calculate(Object obj) {
		return this.premiumStrategies.stream()
				.map(premiumStrategy -> {
					log.info("Executing premium strategy '{}'", premiumStrategy.getClass().getSimpleName());
					return premiumStrategy.calculate(obj);
				})
				.filter(Objects::nonNull)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
