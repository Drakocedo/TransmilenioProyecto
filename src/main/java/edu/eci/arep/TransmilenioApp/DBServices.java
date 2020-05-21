/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.TransmilenioApp;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
//import com.mashape.unirest.http.JsonNode;
import com.amazonaws.regions.Regions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
//import org.json.JSONObject;
//import java.net.*;
import java.util.Map;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import java.util.Iterator;
import org.springframework.stereotype.Service;

/**
 *
 * @author Santiago
 */

@Service("DBServicesImpl")
public class DBServices  {
    
   
    //public void ConnectionRequest(){
       
    public static void main(String[] args) {
    	InstanceProfileCredentialsProvider credentials =
    			InstanceProfileCredentialsProvider.createAsyncRefreshingProvider(true);
	          
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
        	.withCredentials(new EnvironmentVariableCredentialsProvider())
            .withRegion(Regions.US_EAST_1)
            .build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable("RealTimeBuses");
        GetItemSpec spec = new GetItemSpec().withPrimaryKey("IDBus","T111");

        try {
            System.out.println("Attempting to read the item...");
            Item outcome = table.getItem(spec);
            System.out.println("GetItem succeeded: " + outcome);

        }
        catch (Exception e) {
            System.err.println("Unable to read item:");
            System.err.println(e.getMessage());
        }
        
       	ScanSpec scanSpec = new ScanSpec().withProjectionExpression("IDBus, Latitud, Longitud");

        
        	

            ItemCollection<ScanOutcome> items = table.scan(null, // FilterExpression
                "IDBus, Latitud, Longitud", // ProjectionExpression
                null, // ExpressionAttributeNames - not used in this example
                null);

            System.out.println("Scan of RealTimeBuses for items ");
            Iterator<Item> iterator = items.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toJSONPretty());
            }
        
    
 
    
    
    
    
    }
    
}

