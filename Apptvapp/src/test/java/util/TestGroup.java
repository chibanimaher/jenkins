package util;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestGroup {
	@Test
	public void test1() {
		System.out.println("this is test 1");
	}
	@Ignore
	@Test(groups= {"sanity23"})
	public void test2() {
		System.out.println("this is test 2");
	}
	@Test
	public void test3() {
		System.out.println("this is test 3");
	}
}
