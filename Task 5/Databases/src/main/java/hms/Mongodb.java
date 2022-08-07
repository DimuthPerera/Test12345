package hms;

import com.mongodb.client.*;
import org.bson.Document;

public class Mongodb implements Strategy{

    public void doOperation(Student studentDetails) {

        String uri = "mongodb://studentAdmin:student123@localhost";

        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase db = mongoClient.getDatabase("students");
        MongoCollection<Document> collection = db.getCollection("details");



        Document document = new Document("name", studentDetails.getName())
                .append("address", studentDetails.getAddress())
                .append("phoneNumber", studentDetails.getPhoneNumber());

        collection.insertOne(document);

    }
}
