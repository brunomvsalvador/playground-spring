package com.bs.playgroung.spring.insurance.rest.controlers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bs.playgroung.spring.insurance.service.domain.Policy;
import com.bs.playgroung.spring.insurance.service.domain.PolicyObject;
import com.bs.playgroung.spring.insurance.service.domain.PolicyStatus;
import com.bs.playgroung.spring.insurance.service.domain.PolicySubObject;
import com.bs.playgroung.spring.insurance.service.domain.RiskType;
import com.bs.playgroung.spring.insurance.service.premium.PremiumCalculationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/premium")
@RequiredArgsConstructor
public class PremiumController {

	private final PremiumCalculationService premiumCalculationService;

	@PostMapping(value = "/calculate", consumes = "application/json")
	public BigDecimal calculate(@RequestBody Policy policy) {
		log.info("New calculation request for policy: {}", policy);
		return this.premiumCalculationService.calculate(policy);
	}

	public static void main(String[] args) {

		final Policy policy1 = Policy.builder()
				.number("LV20-02-100000-5")
				.status(PolicyStatus.APPROVED)
				.objects(List.of(
						PolicyObject.builder()
								.name("item1")
								.subObjects(List.of(
										PolicySubObject.builder()
												.name("item1::sub-item1")
												.riskType(RiskType.FIRE)
												.insured(BigDecimal.valueOf(100.00))
												.build(),
										PolicySubObject.builder()
												.name("item1::sub-item2")
												.riskType(RiskType.THEFT)
												.insured(BigDecimal.valueOf(8.00))
												.build()
								))
								.build()
				))
				.build();

		final Policy policy2 = Policy.builder()
				.number("LV20-02-100000-5")
				.status(PolicyStatus.APPROVED)
				.objects(List.of(
						PolicyObject.builder()
								.name("item1")
								.subObjects(List.of(
										PolicySubObject.builder()
												.name("item1::sub-item1")
												.riskType(RiskType.FIRE)
												.insured(BigDecimal.valueOf(500.00))
												.build(),
										PolicySubObject.builder()
												.name("item1::sub-item2")
												.riskType(RiskType.THEFT)
												.insured(BigDecimal.valueOf(102.51))
												.build()
								))
								.build()
				))
				.build();

		final Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(policy1));
		System.out.println("\n\n");
		System.out.println(gson.toJson(policy2));

	}
}
