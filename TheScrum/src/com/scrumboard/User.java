package com.scrumboard;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.apphosting.client.datastoreservice.proto.DatastoreService;

@SuppressWarnings("unused")
public class User 
{
private static com.google.appengine.api.datastore.DatastoreService datastore=DatastoreServiceFactory.getDatastoreService();
	public static boolean creatorUpdateUser(String name, String email,
			String password) 
	
	{
		// TODO Auto-generated method stub
		
		System.out.println("in creatorupdateuser");
		
		Entity user=new Entity("User",name);
		user.setProperty("name",name);
		user.setProperty("email",email);
		user.setProperty("password",password);
		System.out.println("the datastore: "+datastore.put(user));
		Entity e=new Entity("xxx");
		e.setProperty("name", "pathfinders");
		Key k=datastore.put(e);
		System.out.println("end creatorupdateuser");
		System.out.println("the key is "+user.getKey()+"the kind is: "+user.getKind());
		return true;
	}

	public static Iterable<Entity> listUsers(String kind, String name)
	{
		
		System.out.println("the kind is:"+kind+"name is:"+name);
		Query q=new Query(kind).addSort("name", Query.SortDirection.ASCENDING);
		Iterable<Entity> pq=datastore.prepare(q).asIterable(FetchOptions.Builder.withLimit(5));
		return pq;
	}
	
	public static boolean loginuser(String username, String password)
	{
		String uname=null;
		String passw=null;
		Query q=new Query("User");
		PreparedQuery pq = datastore.prepare(q);
		List<Entity> res = pq.asList(FetchOptions.Builder.withLimit(2));
		for (Entity user : pq.asIterable())
		{
			uname=(String)user.getProperty("username");
			passw=(String)user.getProperty("password");
		    System.out.println("the username and password are: "+uname+"password:"+passw);
		}
		if(passw !=  null && passw.equalsIgnoreCase(password))return true;
		
		else return false;
	}
		
		
		
	}
	
