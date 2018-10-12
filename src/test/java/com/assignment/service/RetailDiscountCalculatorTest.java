package com.assignment.service;

import static com.assignment.constants.Constants.DEFAULT_KEY;
import static com.assignment.constants.Constants.GROCERY_VALUE;
import static org.junit.Assert.assertEquals;

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
import com.assignment.exceptions.RetailDiscountCalculatorException;
import com.assignment.service.impl.PayableAmountCalculatorServiceImpl;
import com.assignment.service.impl.PercentageAllocatorServiceImpl;
/**
* @author ASHIF ASHRAF
* @version v1
* @since 2018 10 11 This Implementation class serving as  PayinAmount Calculator Various Test Methods
*/
public class RetailDiscountCalculatorTest {
	private static Logger log = LogManager.getLogger(RetailDiscountCalculatorTest.class);
	BillPaymentInfo billPaymentInfo = null;
	User user = null;
	User user2;
	private PurchaseItems purchaseItems;
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
	 * to  get the  User is completed 2 years as loyal customer.
	 * @see assertEquals
	 */
	@Test
	public void getPayinAmountfor2YearsCustomer() {
		log.info("is isPayoutAmountfor2YearsCustomer **** ");
		try {
			PercentageAllocatorService percentageAllocatorService = new PercentageAllocatorServiceImpl();
			PayableAmountCalculatorService payableAmountCalculatorService = new PayableAmountCalculatorServiceImpl();
			billPaymentInfo = new BillPaymentInfo(new Double(970.00));

			purchaseItems = new PurchaseItems(DEFAULT_KEY,"Sweets");
			billPaymentInfo.setPurchaseItems(purchaseItems);
			user = new User(DEFAULT_KEY, DEFAULT_KEY, "2Y");
			billPaymentInfo.setUser(user);
			log.info("Percentage**** " + percentageAllocatorService.getPercentage(billPaymentInfo));
			billPaymentInfo.setPercentage(percentageAllocatorService.getPercentage(billPaymentInfo));
			billPaymentInfo = payableAmountCalculatorService.doCalculatePayableAmount(billPaymentInfo);
			assertEquals(new Double(921.5), billPaymentInfo.getPayableAmount());
		} catch (RetailDiscountCalculatorException exception) {
			log.info("***** MyBusinessException *** " + exception.getCode().getDescription());

		}
	}
	/**
	 * to  get the payinamount If User is affiliate
	 * @see assertEquals
	 */
	@Test
	public void getPayinAmountforAffiliate() {
		log.info("is isPayoutAmountforAffiliate **** ");
		try {
			PercentageAllocatorService percentageAllocatorService = new PercentageAllocatorServiceImpl();
			PayableAmountCalculatorService payableAmountCalculatorService = new PayableAmountCalculatorServiceImpl();
			purchaseItems = new PurchaseItems(DEFAULT_KEY,"Sweets");
			user = new User(DEFAULT_KEY, "A", DEFAULT_KEY);
			billPaymentInfo = new BillPaymentInfo(new Double(789));
			billPaymentInfo.setUser(user);
			billPaymentInfo.setPurchaseItems(purchaseItems);

			log.info("Percentage**** " + percentageAllocatorService.getPercentage( billPaymentInfo));
			billPaymentInfo.setPercentage(percentageAllocatorService.getPercentage( billPaymentInfo));
			billPaymentInfo = payableAmountCalculatorService.doCalculatePayableAmount(billPaymentInfo);
			assertEquals(new Double(710.1), billPaymentInfo.getPayableAmount());
		} catch (RetailDiscountCalculatorException exception) {
			log.info("***** MyBusinessException *** " + exception.getCode().getDescription());

		}
	}
	/**
	 * to  get the payinamount If User is employee of this organization 
	 * @see assertEquals
	 */
	@Test
	public void getPayinAmountforEmployee() {
		log.info("is isPayoutAmountforEmployee **** ");
		try {
			PercentageAllocatorService percentageAllocatorService = new PercentageAllocatorServiceImpl();
			PayableAmountCalculatorService payableAmountCalculatorService = new PayableAmountCalculatorServiceImpl();

			user = new User("E", DEFAULT_KEY, DEFAULT_KEY);
			purchaseItems = new PurchaseItems(DEFAULT_KEY,"Sweets");
			billPaymentInfo = new BillPaymentInfo(new Double(560));
			billPaymentInfo.setUser(user);
			billPaymentInfo.setPurchaseItems(purchaseItems);

			log.info("Percentage**** " + percentageAllocatorService.getPercentage( billPaymentInfo));
			billPaymentInfo.setPercentage(percentageAllocatorService.getPercentage( billPaymentInfo));
			billPaymentInfo = payableAmountCalculatorService.doCalculatePayableAmount(billPaymentInfo);
			assertEquals(new Double(392), billPaymentInfo.getPayableAmount());
		} catch (RetailDiscountCalculatorException exception) {
			log.info("***** MyBusinessException *** " + exception.getCode().getDescription());

		}
	}
	/**
	 * to  get the payinamount If purchasing amount is more than 100
	 * @see assertEquals
	 */
	@Test
	public void getPayinAmountforAmountGreaterThan100() {
		log.info("is getPayinAmountforAmountGreaterThan100 **** ");
		try {
			PercentageAllocatorService percentageAllocatorService = new PercentageAllocatorServiceImpl();
			PayableAmountCalculatorService payableAmountCalculatorService = new PayableAmountCalculatorServiceImpl();
			purchaseItems = new PurchaseItems(DEFAULT_KEY,"Sweets");
			user = new User(DEFAULT_KEY, DEFAULT_KEY, DEFAULT_KEY);
			billPaymentInfo = new BillPaymentInfo(new Double(990));
			billPaymentInfo.setUser(user);
			billPaymentInfo.setPurchaseItems(purchaseItems);
			log.info("Percentage**** " + percentageAllocatorService.getPercentage(billPaymentInfo));
			billPaymentInfo.setPercentage(percentageAllocatorService.getPercentage( billPaymentInfo));
			billPaymentInfo = payableAmountCalculatorService.doCalculatePayableAmount(billPaymentInfo);
			assertEquals(new Double(544.5), billPaymentInfo.getPayableAmount());
		} catch (RetailDiscountCalculatorException exception) {
			log.info("***** MyBusinessException *** " + exception.getCode().getDescription());

		}
	}
	/**
	 * to  get the payinamount If purchasing amount is less than 100
	 * @see assertEquals
	 */
	@Test
	public void getPayinAmountforAmountlessthanThan100() {
		log.info("is getPayinAmountforAmountlessthanThan100 **** ");
		try {
			PercentageAllocatorService percentageAllocatorService = new PercentageAllocatorServiceImpl();
			PayableAmountCalculatorService payableAmountCalculatorService = new PayableAmountCalculatorServiceImpl();
			purchaseItems = new PurchaseItems(DEFAULT_KEY,"Sweets");
			user = new User(DEFAULT_KEY, DEFAULT_KEY, DEFAULT_KEY);
			billPaymentInfo = new BillPaymentInfo(new Double(99));
			billPaymentInfo.setUser(user);
			billPaymentInfo.setPurchaseItems(purchaseItems);
			log.info("Percentage**** " + percentageAllocatorService.getPercentage(billPaymentInfo));
			billPaymentInfo.setPercentage(percentageAllocatorService.getPercentage( billPaymentInfo));
			billPaymentInfo = payableAmountCalculatorService.doCalculatePayableAmount(billPaymentInfo);
			assertEquals(new Double(99), billPaymentInfo.getPayableAmount());
		} catch (RetailDiscountCalculatorException exception) {
			log.info("***** MyBusinessException *** " + exception.getCode().getDescription());

		}
	}
	/**
	 * to  get the payinamount If purchasing item is grocery
	 * @see assertEquals
	 */
	@Test
	public void getPayinAmountforwithoutPercentageforGroceryItem() {
		log.info("is getPayinAmountforwithoutPercentageforGroceryItem **** ");
		try {
			PercentageAllocatorService percentageAllocatorService = new PercentageAllocatorServiceImpl();
			PayableAmountCalculatorService payableAmountCalculatorService = new PayableAmountCalculatorServiceImpl();
			
			user = new User(DEFAULT_KEY, DEFAULT_KEY, "2Y");
			billPaymentInfo = new BillPaymentInfo(new Double(970.00));
			billPaymentInfo.setUser(user);
			purchaseItems = new PurchaseItems(GROCERY_VALUE,"Sweets");
			billPaymentInfo.setPurchaseItems(purchaseItems);
			log.info("Percentage**** " + percentageAllocatorService.getPercentage(billPaymentInfo));
			billPaymentInfo.setPercentage(percentageAllocatorService.getPercentage(billPaymentInfo));
			billPaymentInfo = payableAmountCalculatorService.doCalculatePayableAmount(billPaymentInfo);
			assertEquals(new Double(970.00), billPaymentInfo.getPayableAmount());
		} catch (RetailDiscountCalculatorException exception) {
			log.info("***** MyBusinessException *** " + exception.getCode().getDescription());

		}
	}
	
	@Test
	public void exceptionCatchMethod() {
		log.info("is exceptionCatchMethod **** ");
		try {
			PercentageAllocatorService percentageAllocatorService = new PercentageAllocatorServiceImpl();
			PayableAmountCalculatorService payableAmountCalculatorService = new PayableAmountCalculatorServiceImpl();

			user = new User("", null, DEFAULT_KEY);
			billPaymentInfo = new BillPaymentInfo(new Double(340));
			billPaymentInfo.setUser(user);
			log.info("Percentage**** " + percentageAllocatorService.getPercentage(billPaymentInfo));
			billPaymentInfo.setPercentage(percentageAllocatorService.getPercentage( billPaymentInfo));
			billPaymentInfo = payableAmountCalculatorService.doCalculatePayableAmount(billPaymentInfo);
			assertEquals(new Double(325), billPaymentInfo.getPayableAmount());
		} catch (RetailDiscountCalculatorException exception) {
			log.error("***** MyBusinessException *** " + exception.getCode().getDescription());
			assertEquals("00001",exception.getCode().getCode());

		}
	}
}
