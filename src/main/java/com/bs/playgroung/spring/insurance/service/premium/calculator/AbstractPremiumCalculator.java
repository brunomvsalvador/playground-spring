package com.bs.playgroung.spring.insurance.service.premium.calculator;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.bs.playgroung.spring.insurance.service.domain.Policy;
import com.bs.playgroung.spring.insurance.service.domain.PolicySubObject;
import com.bs.playgroung.spring.insurance.service.domain.RiskType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public abstract class AbstractPremiumCalculator implements PremiumCalculator {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final Set<RiskType> riskTypes;

	private final String coefficientExpression;

	@Override
	public BigDecimal calculate(Policy policy) {
		final var totalInsured = sumInsuredValues(policy);
		final var coefficient = resolveCoefficient(totalInsured);
		final var result = totalInsured.multiply(coefficient);

		log.info("Total insured: {} | Coefficient: {} | Result: {}", totalInsured, coefficient, result);

		return result;
	}

	protected BigDecimal resolveCoefficient(BigDecimal totalInsured) {
		final var context = new StandardEvaluationContext();
		context.setVariable("totalInsured", totalInsured);

		return new SpelExpressionParser()
				.parseExpression(this.coefficientExpression)
				.getValue(context, BigDecimal.class);
	}

	protected BigDecimal sumInsuredValues(Policy policy) {
		return policy.getObjects().stream()
				.flatMap(policyObject -> policyObject.getSubObjects().stream())
				.filter(policySubObject -> riskTypes.contains(policySubObject.getRiskType()))
				.map(PolicySubObject::getInsured)
				.filter(Objects::nonNull)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
