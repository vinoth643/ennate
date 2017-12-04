package com.ennate.code.challenge.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ennate.code.challenge.dao.AlertsDao;
import com.ennate.code.challenge.entity.Alerts;

@Component
public class AlertsDaoImpl extends BasicDAO<Alerts, ObjectId> implements AlertsDao {

	public AlertsDaoImpl(@Autowired Datastore ds) {
		super(Alerts.class, ds);
	}

}
