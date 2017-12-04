package com.ennate.code.challenge.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(noClassnameStored = true, value = "alerts")
public class Alerts {

	@Id
	private ObjectId id;

	private int baseWeight;
	private int currentWeight;
	private String status;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public int getBaseWeight() {
		return baseWeight;
	}

	public void setBaseWeight(int baseWeight) {
		this.baseWeight = baseWeight;
	}

	public int getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
