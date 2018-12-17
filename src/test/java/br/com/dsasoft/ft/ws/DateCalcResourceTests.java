package br.com.dsasoft.ft.ws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * Insights collected from :
 * https://dzone.com/articles/testing-spring-mvc-with-spring-boot-14-part-1
 * https://github.com/dsasoft/unittesting
 *
 * https://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-rest-api/
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = DateCalcResource.class)
public class DateCalcResourceTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@MockBean
	private DateCalcResource dateCalcResource;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void assertFixtureNotNull() {
		assertNotNull(this.dateCalcResource);
	}

	@Test
	public void isOk() throws Exception {

		MvcResult mvc = mockMvc.perform(MockMvcRequestBuilders.get("/howLongSoFarInDays/20180324"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		assertEquals(200, mvc.getResponse().getStatus());
	}
}
