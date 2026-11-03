package test;

import org.testng.annotations.Test;

import base.Basee;
import pages.Browse;
import pages.Cart;
import pages.Checkout;
import pages.Login;
import pages.Signup;
import org.testng.annotations.AfterTest;

// Every test opens its own browser. Test 1 creates the account that tests 2 and 5 use,
// so keep the priority order (0 to 4).
public class Testing extends Basee {

    // a new username every run, so signup never says "already exists"
    String user = "rajna" + System.currentTimeMillis();
    String pwd = "Razi1234";

    // Module 1 : Register
    @Test(priority = 0)
    public void testtfirst() {
    	tests=extent.createTest("Registration Page:");   

        Signup s = new Signup(driver);
        s.signin();
        s.register();
        s.uname(user);
        s.password(pwd);
        s.fname("AYISHATH");
        s.lname("RAJNA");
        s.email("rajna@gmail.com");
        s.phone("9876729378");
        s.address("12 Main Road");
        s.address2("cherkala");
        s.city("Kasaragod");
        s.state("Kerala");
        s.zip("671121");
        s.country("India");
        s.save();
    }

    // Module 2 : Login
    @Test(priority = 1)
    public void testsecond() {
    	tests=extent.createTest("Login page:");

        Login l = new Login(driver);
        l.loginclick();
        l.Lname(user);
        l.Pssword(pwd);
        l.clicklogin();
    }
 // Module 3 : Browse catalog (category, product, item details)
    @Test(priority = 2)
    public void testthird() {
    	tests=extent.createTest("Browse catalog:");

        Browse b = new Browse(driver);
        b.category();
        b.product();
        b.itemdetails();
    }
    // Module 4 : Cart
    @Test(priority = 3)
    public void testfourth() {
    	tests=extent.createTest("Cart page:");

        Cart c = new Cart(driver);
        c.category();
        c.sproduct();
        c.addtocartt();
        c.qty("2");
        c.updatee();
    }

    // Module 5 : Checkout (new browser, so log in first)
    @Test(priority = 4)
    public void testfifth() {
    	tests=extent.createTest("Checkout order:");

        Login l = new Login(driver);
        l.loginclick();
        l.Lname(user);
        l.Pssword(pwd);
        l.clicklogin();

        Cart c = new Cart(driver);
        c.category();
        c.sproduct();
        c.addtocartt();
        c.checkout();

        Checkout o = new Checkout(driver);
        o.continuee();
        o.confirm();
    }
    @AfterTest
	public void end() {
		extent.flush();
	}
}