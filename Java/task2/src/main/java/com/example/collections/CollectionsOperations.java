package com.example.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsOperations {

    public static void main(String[] args) {
        System.out.println("Collection Operations Task\n");

        // Part 1: Managing a Shopping List (ArrayList)
        System.out.println("--- Part 1: Managing a Shopping List (ArrayList) ---");
        // TODO: 1. Create an ArrayList named shoppingList to store String items.
	List<String> shoppingList=new ArrayList<>();
        
        // TODO: 2. Add the following items to shoppingList: "Milk", "Bread", "Eggs", "Milk", "Apples".
	shoppingList.add("Milk");
	shoppingList.add("Bread");
	shoppingList.add("Eggs");
	shoppingList.add("Milk");
	shoppingList.add("Apples");
        // TODO: 3. Print the entire shoppingList to the console.
	for(String item:shoppingList){
		System.out.println(item);
	}
	
        // TODO: 4. Remove the first occurrence of "Milk" from the shoppingList.
	shoppingList.remove("Milk");
        // TODO: 5. Check if "Bread" is present in the shoppingList and print the boolean result.
	System.out.println(shoppingList.contains("Bread"));
        // TODO: 6. Print the shoppingList again after removal.
    System.out.println(shoppingList);

        System.out.println("\n");

        // Part 2: Tracking Unique Product IDs (HashSet)
        System.out.println("--- Part 2: Tracking Unique Product IDs (HashSet) ---");
        // TODO: 1. Create a HashSet named uniqueProductIDs to store Integer IDs.
        // TODO: 2. Add the following IDs to uniqueProductIDs: 101, 205, 101, 312, 400, 205.
        // TODO: 3. Print the uniqueProductIDs set to the console. What do you observe about duplicate IDs when using a HashSet?
        // TODO: 4. Remove 205 from the uniqueProductIDs.
        // TODO: 5. Check if 101 is present in uniqueProductIDs and print the boolean result.
        // TODO: 6. Print the uniqueProductIDs set again.
        System.out.println("\n");

        // Part 3: Storing Product Stock (HashMap)
        System.out.println("--- Part 3: Storing Product Stock (HashMap) ---");
        // TODO: 1. Create a HashMap named productStock where keys are String product names and values are Integer stock quantities.
        // TODO: 2. Add the following entries:
        //    - "Laptop" -> 10
        //    - "Mouse" -> 50
        //    - "Keyboard" -> 25
        //    - "Monitor" -> 15
        // TODO: 3. Print the entire productStock map to the console.
        // TODO: 4. Update the stock of "Laptop" to 8.
        // TODO: 5. Add a new product "Webcam" with a stock of 30.
        // TODO: 6. Retrieve and print the stock quantity for "Mouse".
        // TODO: 7. Remove "Keyboard" from the productStock.
        // TODO: 8. Iterate through the productStock map and print each product name and its quantity in the format: "Product: [Name], Stock: [Quantity]"
    }
}
