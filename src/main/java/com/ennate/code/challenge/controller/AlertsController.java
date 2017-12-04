package com.ennate.code.challenge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ennate.code.challenge.entity.Alerts;
import com.ennate.code.challenge.service.impl.AlertsService;

@RestController
@RequestMapping(path = "v1/alerts")
public class AlertsController {

	@Autowired
	AlertsService alertsService;

	@RequestMapping(path = "read", method = RequestMethod.GET)
	public ResponseEntity<List<Alerts>> read(@RequestBody Alerts alerts) {

		try {

			List<Alerts> alertsList = alertsService.fetchAll();
			return new ResponseEntity<>(alertsList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ArrayList<Alerts>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(path = "readByTimeRange", method = RequestMethod.GET)
	public ResponseEntity<List<Alerts>> read(@RequestParam long start, @RequestParam long end) {

		try {

			List<Alerts> alertsList = alertsService.fetchByTimeStampRange(start, end);
			return new ResponseEntity<>(alertsList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ArrayList<Alerts>(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
