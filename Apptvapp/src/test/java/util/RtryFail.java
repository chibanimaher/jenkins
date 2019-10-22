package util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RtryFail {
	@Test
	public void test1() {
		System.out.println("iam in the test 1");
	}
	@Test
	public void test2() {
		System.out.println("iam in the test 1");
		//int i=1/0;
	}
	@Test(retryAnalyzer = RetryANA.class)

	public void test3() {
		System.out.println("iam in the test 1");
		Assert.assertTrue(0>1);
	}

}
