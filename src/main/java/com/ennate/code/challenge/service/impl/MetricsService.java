package com.ennate.code.challenge.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ennate.code.challenge.dao.MetricsDao;
import com.ennate.code.challenge.entity.Metrics;
import com.ennate.code.challenge.entity.WeightHistory;

@Service
public class MetricsService {

	@Autowired
	MetricsDao metricsDao;

	@Autowired
	RulesEngine rulesEngine;

	@Autowired
	Rules weightRules;

	public Key<Metrics> create(WeightHistory history) {

		Metrics metrics = new Metrics();

		List<Metrics> metricsList = metricsDao.find().asList();
		if (metricsList.size() == 0) {
			metrics.setBaseWeight(history.getValue());
			metrics.setHistories(new ArrayList<WeightHistory>());
			metrics.getHistories().add(history);

		} else {
			metrics = metricsList.get(0);
			metrics.getHistories().add(history);
		}

		Key<Metrics> key = metricsDao.save(metrics);
		if (key != null && metricsList.size() != 0) {
			Facts facts = new Facts();
			facts.put("start", metrics.getBaseWeight());
			facts.put("end", history.getValue());
			rulesEngine.fire(weightRules, facts);
		}
		return key;

	}

	public List<Metrics> fetchAll() {

		List<Metrics> metricsList = metricsDao.find().asList();
		return metricsList;

	}

	public List<Metrics> fetchByTimeStampRange(long start, long end) {

		Query<Metrics> query = metricsDao.getDatastore().createQuery(Metrics.class);
		query.and(query.criteria("timestamp").greaterThanOrEq(start), query.criteria("timestamp").lessThanOrEq(end));
		List<Metrics> metricsList = metricsDao.find(query).asList();
		return metricsList;

	}

}
