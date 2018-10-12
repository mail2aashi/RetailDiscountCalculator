package com.assignment.domain;

import static com.assignment.constants.Constants.DEFAULT_KEY;
import static com.assignment.constants.Constants.GROCERY_VALUE;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.assignment.domain.BillPaymentInfo;
import com.assignment.domain.PurchaseItems;
import com.assignment.domain.User;

public class DomainObjectTest {
	private static Logger log = LogManager.getLogger(DomainObjectTest.class);

	BillPaymentInfo billPaymentInfo = null;
	User user = null;
	User user2;
	private BillPaymentInfo billPaymentInfo2;
	private PurchaseItems purchaseItems;
	private PurchaseItems purchaseItems2;
	private User user3;
	private BillPaymentInfo billPaymentInfo3;
	private PurchaseItems purchaseItems3;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		log.info("Before all test case execution");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		log.info("After all test case execution");
	}

	@Before
	public void setUp() throws Exception {
		log.info("Before single test case execution");
	}

	@After
	public void tearDown() throws Exception {
		log.info("After single test case execution");
	}
	/**
	 * to  check the object Equality
	 * @see assertEquals
	 */
	@Test
	public void userEqualsMethod() {
		log.info("is userEqualsMethod **** ");
		user = new User(DEFAULT_KEY, DEFAULT_KEY, DEFAULT_KEY);
		user2 = new User(DEFAULT_KEY, DEFAULT_KEY, DEFAULT_KEY);
		user3 = new User(DEFAULT_KEY, DEFAULT_KEY, GROCERY_VALUE);
		assertTrue(user.equals(user2));
		assertNotEquals(user, user3);
	}

	@Test
	public void userHashcodeMethod() {
		log.info("is userHashcodeMethod **** ");
		user = new User(DEFAULT_KEY, DEFAULT_KEY, DEFAULT_KEY);
		user2 = new User(DEFAULT_KEY, DEFAULT_KEY, DEFAULT_KEY);
		assertTrue(user.hashCode() == user2.hashCode());
	}
	@Test
	public void usertoStringMethod() {
		log.info("is userHashcodeMethod **** ");
		user = new User(DEFAULT_KEY, DEFAULT_KEY, DEFAULT_KEY);
		user2 = new User(DEFAULT_KEY, DEFAULT_KEY, DEFAULT_KEY);
		assertTrue(user.toString().equals(user2.toString()));
	}
	/**
	 * to  check the object Equality
	 * @see assertEquals
	 */
	@Test
	public void billPaymentEqualsMethod() {
		log.info("is userEqualsMethod **** ");
		billPaymentInfo =  new BillPaymentInfo(new Double(340));
		billPaymentInfo2 = new BillPaymentInfo(new Double(340));
		billPaymentInfo3 = new BillPaymentInfo(new Double(341));

		assertNotEquals(billPaymentInfo, billPaymentInfo3);
		assertTrue(billPaymentInfo.equals(billPaymentInfo2));
	}

	@Test
	public void billPaymentHashcodeMethod() {
		log.info("is userHashcodeMethod **** ");
		billPaymentInfo =  new BillPaymentInfo(new Double(340));
		billPaymentInfo2 = new BillPaymentInfo(new Double(340));;
		assertTrue(billPaymentInfo.hashCode() == billPaymentInfo2.hashCode());
	}
	@Test
	public void billPaymenttoStringMethod() {
		log.info("is userHashcodeMethod **** ");
		billPaymentInfo =  new BillPaymentInfo(new Double(340));
		billPaymentInfo2 = new BillPaymentInfo(new Double(340));;
		assertTrue(billPaymentInfo.toString().equals(billPaymentInfo2.toString()));
	}
	/**
	 * to  check the object Equality
	 * @see assertEquals
	 */
	@Test
	public void purchaseItemsEqualsMethod() {
		log.info("is purchaseItemsEqualsMethod **** ");
		purchaseItems = new PurchaseItems(GROCERY_VALUE,"Sweets");
		purchaseItems2 = new PurchaseItems(GROCERY_VALUE,"Sweets");
		purchaseItems3 = new PurchaseItems(GROCERY_VALUE,"Sweetsu");
		assertNotEquals(purchaseItems2, purchaseItems3);
		assertTrue(purchaseItems.equals(purchaseItems2));
	}

	@Test
	public void purchaseItemsHashcodeMethod() {
		log.info("is purchaseItemsHashcodeMethod **** ");
		purchaseItems = new PurchaseItems(GROCERY_VALUE,"Sweets");
		purchaseItems2 = new PurchaseItems(GROCERY_VALUE,"Sweets");
		assertTrue(purchaseItems.hashCode() == purchaseItems2.hashCode());
	}
	/**
	 * to  check exception catched.
	 * @see assertEquals
	 */
	@Test
	public void purchaseItemstoStringMethod() {
		log.info("is userHashcodeMethod **** ");
		purchaseItems = new PurchaseItems(GROCERY_VALUE,"Sweets");
		purchaseItems2 = new PurchaseItems(GROCERY_VALUE,"Sweets");
		assertTrue(purchaseItems2.toString().equals(purchaseItems.toString()));
	}
}
