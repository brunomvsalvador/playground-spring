package com.bs.playgroung.spring.insurance.service.premium.strategy;

import java.math.BigDecimal;

public interface PremiumStrategy {

	BigDecimal calculate(Object obj);
}
