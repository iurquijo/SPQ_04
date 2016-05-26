package com.moviemanager.app;

import org.junit.*; 
import org.databene.contiperf.*;
import org.databene.contiperf.junit.ContiPerfRule;

public class ContiperfTest {

	@Rule
	public ContiPerfRule i = new ContiPerfRule();

	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 1200, average = 250)
	/*the test is configured to be executed 1000 times with 20 concurrent threads, so each thread does 50 invocations.
	A maximum execution time of 1.2 seconds and and an average below or equals 250 milliseconds are tolerated.*/
	public void test1() throws Exception {
	Thread.sleep(200);
	}
}

//http://databene.org/contiperf