package edu.sjsu.cmpe226.lab.dto;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import edu.sjsu.cmpe226.lab.domain.Book;
import edu.sjsu.cmpe226.lab.domain.Cosmetics;
import edu.sjsu.cmpe226.lab.domain.Product;
import edu.sjsu.cmpe226.lab.domain.Homeappliance;
import edu.sjsu.cmpe226.lab.domain.Electronics;

public class MongoDao {

	private MongoClient mongoClient = null;
	private DB db;
	private DBCollection collection;

	public MongoDao() {
		// TODO Auto-generated constructor stub

		try {
			mongoClient = new MongoClient();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception thrown while creating Mongo Client");
		}
		db = mongoClient.getDB("cmpe226");
		collection = db.getCollection("productcatalog");
	}

	public String getProducts() {
		String[] categories = { "Electronics", "Home Appliances", "Fashion","Books" };
		List<Product> products = new LinkedList<Product>();
		StringBuilder result = new StringBuilder();
		for (String cat : categories) {
			BasicDBObject query = new BasicDBObject("category", cat);
			DBCursor cursor = collection.find(query);
			int i = 0;
			while (i < 3) {
				DBObject dbo = cursor.next();
				products.add(new Product(
						dbo.get("name").toString(),
						dbo.get("product_id").toString(),
						dbo.get("image").toString(),
						dbo.get("price").toString(),
						dbo.get("description").toString(),
						dbo.get("category").toString()));
				result.append("Name : " + dbo.get("name") + "\n");
				result.append("Price : " + dbo.get("price") + "\n");
				result.append("Product-ID : " + dbo.get("product_id") + "\n" + "\n");
				i++;
			}
			cursor.close();
		}
		FreeMarker fm = new FreeMarker();
		fm.setCategoryTemplate();
		return fm.writeHTMLOutput(products);
	}

	public String getElectronicsProducts() {
		BasicDBObject query = new BasicDBObject("category", "Electronics");
		DBCursor cursor = collection.find(query);
		List<Electronics> products = new LinkedList<Electronics>();
		while (cursor.hasNext()) {
			DBObject dbo = cursor.next();
			products.add(new Electronics(
					dbo.get("name").toString(), 
					dbo.get("product_id").toString(),
					dbo.get("image").toString(), 
					dbo.get("price").toString(),
					dbo.get("description").toString(),
					dbo.get("category").toString(),
					dbo.get("ratings").toString(),
					dbo.get("dimensions").toString(),
					dbo.get("width").toString(),
					dbo.get("resolution").toString(),
					dbo.get("refresh_rate").toString()));
/*			System.out.println("Name : " + dbo.get("name") + "\n");
			System.out.println("Price : " + dbo.get("price") + "\n");
			System.out.println("Category : " + dbo.get("category") + "\n"
					+ "\n");
*/
		}
//		System.out.println("Closing Cursor...");
		cursor.close();
		FreeMarker fm = new FreeMarker();
		fm.setCategoryTemplate();
		return fm.writeHTMLOutput(products);
	}

	public String getHomeAppliancesProducts() {
		BasicDBObject query = new BasicDBObject("category", "Home Appliances");
		DBCursor cursor = collection.find(query);
	//	System.out.println("Home Appliances getting fetched...");
		List<Homeappliance> products = new LinkedList<Homeappliance>();
		while (cursor.hasNext()) {
			DBObject dbo = cursor.next();
			products.add(new Homeappliance(
					dbo.get("name").toString(), 
					dbo.get("product_id").toString(), 
					dbo.get("image").toString(), 
					dbo.get("price").toString(),
					dbo.get("description").toString(), 
					dbo.get("category").toString(),
					dbo.get("brand").toString(), 
					dbo.get("colour").toString()));

		/*	System.out.println("Name : " + dbo.get("name") + "\n");
			System.out.println("Price : " + dbo.get("price") + "\n");
			System.out.println("Category : " + dbo.get("category") + "\n"+ "\n");*/
		}
		//System.out.println("Closing Cursor...");
		cursor.close();
		FreeMarker fm = new FreeMarker();
		fm.setCategoryTemplate();
		return fm.writeHTMLOutput(products);
	}

	public String getFashionProducts() {
		BasicDBObject query = new BasicDBObject("category", "Fashion");
		DBCursor cursor = collection.find(query);
//		System.out.println("Fashion products getting fetched...");
		List<Cosmetics> products = new LinkedList<Cosmetics>();

		while (cursor.hasNext()) {
			DBObject dbo = cursor.next();
			products.add(new Cosmetics(
					dbo.get("name").toString(), 
					dbo.get("product_id").toString(),
					dbo.get("image").toString(),
					dbo.get("price").toString(),
					dbo.get("description").toString(),
					dbo.get("category").toString(),
					dbo.get("brand").toString(),
					dbo.get("colour").toString(),
					dbo.get("weight").toString()));

/*			System.out.println("Name : " + dbo.get("name") + "\n");
			System.out.println("Price : " + dbo.get("price") + "\n");
			System.out.println("Category : " + dbo.get("category") + "\n"
					+ "\n");*/
		}
//		System.out.println("Closing Cursor...");
		cursor.close();
		FreeMarker fm = new FreeMarker();
		fm.setCategoryTemplate();
		return fm.writeHTMLOutput(products);

	}

	public String getBooksProducts() {
		BasicDBObject query = new BasicDBObject("category", "Books");
		DBCursor cursor = collection.find(query);
//		System.out.println("Books products getting fetched...");
		List<Book> products = new LinkedList<Book>();
		while (cursor.hasNext()) {
			DBObject dbo = cursor.next();
			products.add(new Book(
					dbo.get("name").toString(), 
					dbo.get("product_id").toString(),
					dbo.get("image").toString(),
					dbo.get("price").toString(),
					dbo.get("description").toString(),
					dbo.get("category").toString(),
					dbo.get("author").toString(),	
					dbo.get("publisher").toString()));

/*			System.out.println("Name : " + dbo.get("name") + "\n");
			System.out.println("Price : " + dbo.get("price") + "\n");
			System.out.println("Category : " + dbo.get("category") + "\n"
					+ "\n");*/
		}
//		System.out.println("Closing Cursor...");
		cursor.close();
		FreeMarker fm = new FreeMarker();
		fm.setCategoryTemplate();
		return fm.writeHTMLOutput(products);

	}

	public String getProduct(String product_id) {
		// TODO Auto-generated method stub
		BasicDBObject query = new BasicDBObject("product_id", product_id);
		DBCursor cursor = collection.find(query);
//		System.out.println("Fetching product details for Product ID : "+ product_id);
		DBObject dbo = cursor.next();
		String category = dbo.get("category").toString();
		FreeMarker fm = new FreeMarker();
		if (category.equalsIgnoreCase("Fashion")) {
			fm.setFashionProductTemplate();
/*			System.out.println("Name : " + dbo.get("name") + "\n");
			System.out.println("Price : " + dbo.get("price") + "\n");
			System.out.println("Category : " + dbo.get("category") + "\n"+ "\n");*/
			Cosmetics np = new Cosmetics(
					dbo.get("name").toString(),
					dbo.get("product_id").toString(),
					dbo.get("image").toString(),
					dbo.get("price").toString(),
					dbo.get("description").toString(),
					dbo.get("category").toString(),
					dbo.get("brand").toString(),
					dbo.get("colour").toString(),
					dbo.get("weight").toString());
			return fm.writeHTMLOutput(np);
		} else if (category.equalsIgnoreCase("Books")) {
			fm.setBookProductTemplate();
			/*System.out.println("Name : " + dbo.get("name") + "\n");
			System.out.println("Price : " + dbo.get("price") + "\n");
			System.out.println("Category : " + dbo.get("category") + "\n"+ "\n");*/
			Book b = new Book(
					dbo.get("name").toString(),
					dbo.get("product_id").toString(),
					dbo.get("image").toString(),
					dbo.get("price").toString(),
					dbo.get("description").toString(),
					dbo.get("category").toString(),
					dbo.get("author").toString(),
					dbo.get("publisher").toString());
			return fm.writeHTMLOutput(b);
		} else if (category.equalsIgnoreCase("Electronics")) {
			fm.setElectronicProductTemplate();
			/*System.out.println("Name : " + dbo.get("name") + "\n");
			System.out.println("Price : " + dbo.get("price") + "\n");
			System.out.println("Category : " + dbo.get("category") + "\n"+ "\n");*/
			Electronics t = new Electronics(
					dbo.get("name").toString(), 
					dbo.get("product_id").toString(),
					dbo.get("image").toString(),
					dbo.get("price").toString(),
					dbo.get("description").toString(),
					dbo.get("category").toString(),
					dbo.get("ratings").toString(),
					dbo.get("width").toString(),
					dbo.get("dimensions").toString(),
					dbo.get("resolution").toString(),
					dbo.get("refresh_rate").toString());
			return fm.writeHTMLOutput(t);
		} else if (category.equalsIgnoreCase("Home Appliances")) {
			fm.setHomeApplianceProductTemplate();
			/*System.out.println("Name : " + dbo.get("name") + "\n");
			System.out.println("Price : " + dbo.get("price") + "\n");
			System.out.println("Category : " + dbo.get("category") + "\n"+ "\n");*/
			Homeappliance r = new Homeappliance(
					dbo.get("name").toString(), 
					dbo.get("product_id").toString(),
					dbo.get("image").toString(),
					dbo.get("price").toString(), 
					dbo.get("description").toString(), 
					dbo.get("category").toString(), 
					dbo.get("brand").toString(),
					dbo.get("colour").toString());
			return fm.writeHTMLOutput(r);
		}
		return null;
	}

	public String getsearch(String searchtxt) {

		StringBuilder result = new StringBuilder();
		DBObject query = new BasicDBObject();
		query.put("text", collection.toString());
		query.put("search", searchtxt);

		// CommandResult cr=db.command(query);
		CommandResult cr = db.command(query);
		BasicDBList bdblist = (BasicDBList) cr.get("results");
		// String st=cr.getClass().toString();
		// System.out.println(cr.values());
		// CommandResult[] obj= (CommandResult[]) cr.values().toArray();
		List<Product> products = new ArrayList<Product>();

		int length = cr.size();
		// Object dbo= new BasicDBObject();

		System.out.println("total search results" + length);

		for (Object obj : bdblist) {
			// dbo=cm.next();
			BasicDBObject b = (BasicDBObject) obj;
			BasicDBObject dbo = (BasicDBObject) b.get("obj");
			products.add(new Product(
			dbo.get("name").toString(),
			dbo.get("product_id").toString(),
			dbo.get("image").toString(),
			dbo.get("price").toString(),
			dbo.get("description").toString(),
			dbo.get("category").toString()));
			result.append("Name : " + dbo.get("name") + "\n");
			result.append("Price : " + dbo.get("price") + "\n");
			result.append("Product-ID : " + dbo.get("product_id") + "\n" + "\n");

			//System.out.println("Closing Cursor...");
		}

		FreeMarker fm = new FreeMarker();
		fm.setCategoryTemplate();
		return fm.writeHTMLOutput(products);
	}

}
