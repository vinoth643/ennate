package com.ennate.code.challenge.datastore;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Component
public class MorphiaDatastore {

	@Value("${mongodb.server.uri}")
	private String serverURI;

	@Value("${mongodb.db.name}")
	private String dbName;

	@Bean
	public Datastore datastore() {

		System.out.println("URI : " + serverURI + " ; Name : " + dbName + " ;");
		MongoClient mongoClient = new MongoClient(new MongoClientURI(serverURI));
		Morphia morphia = new Morphia();
		return morphia.createDatastore(mongoClient, dbName);

	}

}
