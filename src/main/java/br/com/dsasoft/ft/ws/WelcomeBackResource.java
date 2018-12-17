package br.com.dsasoft.ft.ws;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import br.com.dsasoft.ft.ws.config.AppConfig;

@RestController
public class WelcomeBackResource {

	@Autowired
	private AppConfig appConfig;

	@RequestMapping(value = "welcome", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> welcome() {
		JSONObject res = new JSONObject();
		res.put("message", "Welcome Back!");
		return new ResponseEntity<>(res.toString(), HttpStatus.OK);
	}

	@RequestMapping(value = "helloMongoCloud", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> helloMongoCloud() {
		JSONObject res = new JSONObject();
		MongoClient mongoClient = new MongoClient(new ServerAddress("mongodb+srv://" + appConfig.getMongoUser() + ":"
				+ appConfig.getMongoPass() + ":@" + appConfig.getUrl()));

		
		MongoDatabase database = mongoClient.getDatabase("test");
		
		res.put("dbName", database.getName());
		res.put("appName", mongoClient.getMongoClientOptions());

		mongoClient.close();
		return new ResponseEntity<String>(res.toString(), HttpStatus.OK);
	}

}
