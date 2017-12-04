package com.ennate.code.challenge.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class WeightHistory {

	@Min(value=20)
	@Max(value=400)
	private int value;
	private long timeStamp;

	public int getValue() {
		return value;
	}

	public void setWeight(int value) {
		this.value = value;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
