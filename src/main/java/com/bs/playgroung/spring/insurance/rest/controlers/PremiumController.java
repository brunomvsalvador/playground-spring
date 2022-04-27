package com.bs.playgroung.spring.insurance.rest.controlers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.playgroung.spring.insurance.service.premium.PremiumCalculationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/premium")
@RequiredArgsConstructor
public class PremiumController {

	private final PremiumCalculationService premiumCalculationService;

	@PostMapping("/calculate")
	public BigDecimal calculate(Object obj) {
		return this.premiumCalculationService.calculate(obj);
	}
}
