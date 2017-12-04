package com.ennate.code.challenge.easyrule;

import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RulesConfiguration {

	@Autowired
	UnderWeightRule underWeightRule;

	@Autowired
	OverWeightRule overWeightRule;

	@Bean
	public RulesEngine easyRulesEngine() {

		RulesEngineParameters parameters = new RulesEngineParameters();
		parameters.setSkipOnFirstAppliedRule(true);
		RulesEngine rulesEngine = new DefaultRulesEngine(parameters);

		return rulesEngine;

	}

	@Bean
	public Rules weightRules() {

		// create rules
		Rules rules = new Rules();
		rules.register(overWeightRule);
		rules.register(underWeightRule);

		return rules;

	}
}
