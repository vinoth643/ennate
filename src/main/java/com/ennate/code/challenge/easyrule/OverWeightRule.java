package com.ennate.code.challenge.easyrule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ennate.code.challenge.entity.Alerts;
import com.ennate.code.challenge.service.impl.AlertsService;

@Component
@Rule(name = "overweight", description = "alert if the weight is greater than 10% of base weight")
public class OverWeightRule {

	@Autowired
	AlertsService alertsService;

	@Condition
	public boolean overWeight(@Fact("start") int baseWeight, @Fact("end") int currentWeight) {
		if (currentWeight > (1.1 * baseWeight)) {
			return true;
		} else {
			return false;
		}
	}

	@Action
	public void generateAlert(@Fact("start") int baseWeight, @Fact("end") int currentWeight) {

		Alerts alerts = new Alerts();
		alerts.setStatus("overweight");
		alerts.setBaseWeight(baseWeight);
		alerts.setCurrentWeight(currentWeight);
		alertsService.create(alerts);
	}

}
