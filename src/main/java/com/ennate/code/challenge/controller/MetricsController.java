package com.ennate.code.challenge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.mongodb.morphia.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ennate.code.challenge.entity.Metrics;
import com.ennate.code.challenge.entity.WeightHistory;
import com.ennate.code.challenge.service.impl.MetricsService;

@RestController
@RequestMapping(path = "v1/metrics")
public class MetricsController {

	@Autowired
	MetricsService metricsService;

	@RequestMapping(path = "create", method = RequestMethod.POST)
	public ResponseEntity<String> create(@Valid @RequestBody WeightHistory weightHistory) {

		try {

			Key<Metrics> key = metricsService.create(weightHistory);
			return new ResponseEntity<>("Saved Successfully", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(path = "read", method = RequestMethod.GET)
	public ResponseEntity<List<Metrics>> read(@RequestBody Metrics metrics) {

		try {

			List<Metrics> metricsList = metricsService.fetchAll();
			return new ResponseEntity<>(metricsList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ArrayList<Metrics>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(path = "readByTimeRange", method = RequestMethod.GET)
	public ResponseEntity<List<Metrics>> read(@RequestParam long start, @RequestParam long end) {

		try {

			List<Metrics> metricsList = metricsService.fetchByTimeStampRange(start, end);
			return new ResponseEntity<>(metricsList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ArrayList<Metrics>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
