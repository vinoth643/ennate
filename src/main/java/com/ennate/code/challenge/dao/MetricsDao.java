package com.ennate.code.challenge.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;
import org.springframework.stereotype.Component;

import com.ennate.code.challenge.entity.Metrics;

@Component
public interface MetricsDao extends DAO<Metrics, ObjectId> {

}
