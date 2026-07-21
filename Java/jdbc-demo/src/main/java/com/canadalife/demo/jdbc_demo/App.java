package com.canadalife.demo.jdbc_demo;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        // Connect to MongoDB
        MongoClient client = MongoClients.create("mongodb://localhost:27017");

        // Select database
        MongoDatabase database = client.getDatabase("reza");
        MongoCollection<Document> users = database.getCollection("employees");
        
        System.out.println("Mongodb connected");
/*
        // Select collection
        MongoCollection<Document> users = database.getCollection("USER_MASTER");

        // Build query
        Document query = new Document("USERNAME", username)
                                .append("PASSWORD", password);

        // Execute query
        FindIterable<Document> result = users.find(query);

        if (result.first() != null) {
            System.out.println("Login is successful");
        } else {
            System.out.println("Login has failed");
        }
*/
        client.close();
        sc.close();
    }
}