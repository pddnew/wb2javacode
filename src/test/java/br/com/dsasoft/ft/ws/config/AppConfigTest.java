package br.com.dsasoft.ft.ws.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.dsasoft.ft.ws.config.AppConfig;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AppConfigTest {

	@Autowired
	private AppConfig appConfig;
	
	@Test
	public void assertAppVersion() {
		assertEquals(appConfig.getAppVersion(), "1.0.0");
	}
	
	@Test
	public void assertMongoDBAuthUser() {
		assertNotEquals(appConfig.getMongoUser(), "dbadmin");
	}
	
	@Test
	public void assertMongoDBAuthPass() {
		assertNotEquals(appConfig.getMongoPass(), "admin123");
	}
	
	@Test
	public void assertMongoDBClusterURL() {
		assertEquals(appConfig.getUrl(), "cluster0-shard-00-00-lvaes.mongodb.net/");
	}
}
