package com.scrumboard;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;


@SuppressWarnings("serial")
public class TheScrumServlet extends HttpServlet {


@SuppressWarnings("unused")
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

//entity creation and data storing
com.google.appengine.api.datastore.Key key = KeyFactory.createKey("Name", 600);	
try{
Entity ent = new Entity("Name");
ent.setProperty("new-tasks", req.getParameter("name"));


System.out.println("putting entity to datastore" + req.getParameter("name"));
ds.put(ent);

}
catch(Exception e){
e.printStackTrace();
}
resp.setContentType("text/plain");
resp.getWriter().println("name");
}


/*Query q =new Query("Name");
q.addSort("Name", SortDirection.ASCENDING);
PreparedQuery pq = ds.prepare(q);

for (Entity result : pq.asIterable()) {
String str = (String) result.getProperty("name");
System.out.println("string"+str);
}*/
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
DatastoreService das = DatastoreServiceFactory.getDatastoreService();	

JSONArray jarr = new JSONArray();
Query q = new Query("Name"); 

// Use PreparedQuery interface to retrieve results
PreparedQuery pq = das.prepare(q);

for (Entity result : pq.asIterable()) {


String str = result.getProperty("new-tasks").toString();

JSONObject json = new JSONObject();

try {
json.put("new-tasks", result.getProperty("new-tasks"));
jarr.put(json);
} catch (JSONException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

System.out.println("string : "+str);
}
resp.getWriter().println(jarr);
}
}