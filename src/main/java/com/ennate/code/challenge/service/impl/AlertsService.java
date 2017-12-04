package com.ennate.code.challenge.service.impl;

import java.util.List;

import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ennate.code.challenge.dao.AlertsDao;
import com.ennate.code.challenge.entity.Alerts;

@Service
public class AlertsService {

	@Autowired
	AlertsDao alertsDao;

	public Key<Alerts> create(Alerts alerts) {

		Key<Alerts> key = alertsDao.save(alerts);
		return key;

	}

	public List<Alerts> fetchAll() {

		List<Alerts> alertsList = alertsDao.find().asList();
		return alertsList;

	}

	public List<Alerts> fetchByTimeStampRange(long start, long end) {

		Query<Alerts> query = alertsDao.getDatastore().createQuery(Alerts.class);
		query.and(query.criteria("timestamp").greaterThanOrEq(start), query.criteria("timestamp").lessThanOrEq(end));
		List<Alerts> AlertsList = alertsDao.find(query).asList();
		return AlertsList;

	}

}
