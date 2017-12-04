package com.ennate.code.challenge.dao.impl;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ennate.code.challenge.dao.MetricsDao;
import com.ennate.code.challenge.entity.Metrics;

@Component
public class MetricsDaoImpl extends BasicDAO<Metrics, ObjectId> implements MetricsDao {

	public MetricsDaoImpl(@Autowired Datastore ds) {
		super(Metrics.class, ds);
	}

}
