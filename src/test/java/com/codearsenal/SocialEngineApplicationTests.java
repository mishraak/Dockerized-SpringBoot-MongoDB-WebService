package com.codearsenal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.amishra.RestfulApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestfulApplication.class)
@WebAppConfiguration
public class SocialEngineApplicationTests {

	@Test
	public void contextLoads() {
	}

}
