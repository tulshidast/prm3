package testng;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

//@Listeners(ListnersUse.class)
public class GroupsITestNg {

	@Test(groups = { "sanity" })
	public void verifyValidLogin() {
		System.out.println("1");
		assertTrue(false);
	}

	@Test(groups = { "smoke" })
	public void verifyRegisterPageTitle() {
		System.out.println("2");
		assertTrue(false);
	}

	@Test(groups = { "E2E", "smoke" })
	public void test3() {
		System.out.println("3");
	}

	@Test(groups = { "reg" })
	public void test4() {
		System.out.println("4");
	}

}
