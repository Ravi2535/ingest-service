package com.iat.epoints.ingestservice.test;

import static org.mockito.Mockito.doNothing;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/*
 * IntegrationTest
 */

@RunWith(CamelSpringRunner.class)
public class IngetIntegrationTest extends CamelTestSupport {

	@Mock
	private RouteBuilder route;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void integrationTest() throws Exception {

		System.out.println("integrationTest() : ");

		doNothing().when(route).configure();
		// verify(route).configure();
		System.out.println("CAMEL-SQS Mock Test Done!!!");
	}

}
