package com.bs.playgroung.spring.insurance.service.premium.strategy;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class PremiumStrategy2 implements PremiumStrategy{
	@Override
	public BigDecimal calculate(Object obj) {
		return BigDecimal.TEN;
	}
}
