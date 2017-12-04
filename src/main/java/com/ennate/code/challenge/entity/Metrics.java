package com.ennate.code.challenge.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(noClassnameStored = true, value = "metrics")
public class Metrics {

	@Id
	private ObjectId id;

	private int baseWeight;

	@Embedded
	private List<WeightHistory> histories;

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

	public List<WeightHistory> getHistories() {
		return histories;
	}

	public void setHistories(List<WeightHistory> histories) {
		this.histories = histories;
	}

}
