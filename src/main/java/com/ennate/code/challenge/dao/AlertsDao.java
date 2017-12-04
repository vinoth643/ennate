package com.ennate.code.challenge.dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;
import org.springframework.stereotype.Component;

import com.ennate.code.challenge.entity.Alerts;

@Component
public interface AlertsDao extends DAO<Alerts, ObjectId> {

}
