package com.api.fileTransfer.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan("com.api.fileTransfer.model")
@EnableMongoRepositories(basePackages = "com.api.fileTransfer.repository")
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.username}")
    private String username;
    @Value("${spring.data.mongodb.password}")
    private String password;
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.port}")
    private Integer port;


    @Override
    public MongoClient mongoClient() {
        MongoCredential mongoCredential = MongoCredential.createCredential(username, database, password.toCharArray());
        ServerAddress serverAddress = new ServerAddress(host, port);
        MongoClientOptions mongoClientOptions = MongoClientOptions.builder().applicationName("fileTransfer").build();
        return new MongoClient(serverAddress, mongoCredential, mongoClientOptions);
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }
}
