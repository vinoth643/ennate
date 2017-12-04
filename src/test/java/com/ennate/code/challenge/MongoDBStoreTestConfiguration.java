package com.ennate.code.challenge;

import java.io.IOException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

@Profile("test")
@Configuration
public class MongoDBStoreTestConfiguration {
	
	private static final String MONGO_DB_URL = "localhost";
	private static final String MONGO_DB_NAME = "embeded_db";
	
	@Bean
	@Primary
	public Datastore dataStore() throws IOException {
		
		EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
		mongo.setBindIp(MONGO_DB_URL);
		MongoClient mongoClient = mongo.getObject();
		return new Morphia().createDatastore(mongoClient, MONGO_DB_NAME);
		
	}
}
