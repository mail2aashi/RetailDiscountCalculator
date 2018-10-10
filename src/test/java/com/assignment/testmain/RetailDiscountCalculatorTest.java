package com.assignment.testmain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.assignment.domain.BillPaymentInfo;
import com.assignment.domain.User;
import com.assignment.exceptions.MyBusinessException;
import com.assignment.service.PayableAmountCalculatorService;
import com.assignment.service.PercentageAllocatorService;
import com.assignment.service.impl.PayableAmountCalculatorServiceImpl;
import com.assignment.service.impl.PercentageAllocatorServiceImpl;

public class RetailDiscountCalculatorTest {
	private static Logger log = LogManager.getLogger(RetailDiscountCalculatorTest.class);
	BillPaymentInfo billPaymentInfo = null;
	User user = null;
	User user2;
	private BillPaymentInfo billPaymentInfo2;

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

	@Test
	public void isPayinAmountfor2YearsCustomer() {
		log.info("is isPayoutAmountfor2YearsCustomer **** ");
		try {
			PercentageAllocatorService percentageAllocatorService = new PercentageAllocatorServiceImpl();
			PayableAmountCalculatorService payableAmountCalculatorService = new PayableAmountCalculatorServiceImpl();

			user = new User("D", "D", "2Y");
			billPaymentInfo = new BillPaymentInfo(new Double(970.00));
			billPaymentInfo.setUser(user);
			log.info("Percentage**** " + percentageAllocatorService.getPercentage(billPaymentInfo));
			billPaymentInfo.setPercentage(percentageAllocatorService.getPercentage(billPaymentInfo));
			billPaymentInfo = payableAmountCalculatorService.doCalculatePayableAmount(billPaymentInfo);
			assertEquals(new Double(921.5), billPaymentInfo.getPayableAmount());
		} catch (MyBusinessException exception) {
			log.info("***** MyBusinessException *** " + exception.getCode().getDescription());

		}
	}

	@Test
	public void isPayinAmountforAffiliate() {
		log.info("is isPayoutAmountforAffiliate **** ");
		try {
			PercentageAllocatorService percentageAllocatorService = new PercentageAllocatorServiceImpl();
			PayableAmountCalculatorService payableAmountCalculatorService = new PayableAmountCalculatorServiceImpl();

			user = new User("D", "A", "D");
			billPaymentInfo = new BillPaymentInfo(new Double(789));
			billPaymentInfo.setUser(user);

			log.info("Percentage**** " + percentageAllocatorService.getPercentage( billPaymentInfo));
			billPaymentInfo.setPercentage(percentageAllocatorService.getPercentage( billPaymentInfo));
			billPaymentInfo = payableAmountCalculatorService.doCalculatePayableAmount(billPaymentInfo);
			assertEquals(new Double(710.1), billPaymentInfo.getPayableAmount());
		} catch (MyBusinessException exception) {
			log.info("***** MyBusinessException *** " + exception.getCode().getDescription());

		}
	}

	@Test
	public void isPayinAmountforEmployee() {
		log.info("is isPayoutAmountforEmployee **** ");
		try {
			PercentageAllocatorService percentageAllocatorService = new PercentageAllocatorServiceImpl();
			PayableAmountCalculatorService payableAmountCalculatorService = new PayableAmountCalculatorServiceImpl();

			user = new User("E", "D", "D");
			billPaymentInfo = new BillPaymentInfo(new Double(560));
			billPaymentInfo.setUser(user);
			log.info("Percentage**** " + percentageAllocatorService.getPercentage( billPaymentInfo));
			billPaymentInfo.setPercentage(percentageAllocatorService.getPercentage( billPaymentInfo));
			billPaymentInfo = payableAmountCalculatorService.doCalculatePayableAmount(billPaymentInfo);
			assertEquals(new Double(392), billPaymentInfo.getPayableAmount());
		} catch (MyBusinessException exception) {
			log.info("***** MyBusinessException *** " + exception.getCode().getDescription());

		}
	}

	@Test
	public void isPayinAmountforAmountGreaterThan100() {
		log.info("is isPayinAmountforAmountGreaterThan100 **** ");
		try {
			PercentageAllocatorService percentageAllocatorService = new PercentageAllocatorServiceImpl();
			PayableAmountCalculatorService payableAmountCalculatorService = new PayableAmountCalculatorServiceImpl();

			user = new User("D", "D", "D");
			billPaymentInfo = new BillPaymentInfo(new Double(340));
			billPaymentInfo.setUser(user);
			log.info("Percentage**** " + percentageAllocatorService.getPercentage(billPaymentInfo));
			billPaymentInfo.setPercentage(percentageAllocatorService.getPercentage( billPaymentInfo));
			billPaymentInfo = payableAmountCalculatorService.doCalculatePayableAmount(billPaymentInfo);
			assertEquals(new Double(325), billPaymentInfo.getPayableAmount());
		} catch (MyBusinessException exception) {
			log.info("***** MyBusinessException *** " + exception.getCode().getDescription());

		}
	}

	@Test
	public void userEqualsMethod() {
		log.info("is userEqualsMethod **** ");
		user = new User("D", "D", "D");
		user2 = new User("D", "D", "D");
		assertTrue(user.equals(user2));
	}

	@Test
	public void userHashcodeMethod() {
		log.info("is userHashcodeMethod **** ");
		user = new User("D", "D", "D");
		user2 = new User("D", "D", "D");
		assertTrue(user.hashCode() == user2.hashCode());
	}
	@Test
	public void usertoStringMethod() {
		log.info("is userHashcodeMethod **** ");
		user = new User("D", "D", "D");
		user2 = new User("D", "D", "D");
		assertTrue(user.toString().equals(user2.toString()));
	}
	@Test
	public void billPaymentEqualsMethod() {
		log.info("is userEqualsMethod **** ");
		billPaymentInfo =  new BillPaymentInfo(new Double(340));
		billPaymentInfo2 = new BillPaymentInfo(new Double(340));;
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
	@Test
	public void exceptionCatchMethod() {
		log.info("is exceptionCatchMethod **** ");
		try {
			PercentageAllocatorService percentageAllocatorService = new PercentageAllocatorServiceImpl();
			PayableAmountCalculatorService payableAmountCalculatorService = new PayableAmountCalculatorServiceImpl();

			user = new User("", null, "D");
			billPaymentInfo = new BillPaymentInfo(new Double(340));
			billPaymentInfo.setUser(user);
			log.info("Percentage**** " + percentageAllocatorService.getPercentage(billPaymentInfo));
			billPaymentInfo.setPercentage(percentageAllocatorService.getPercentage( billPaymentInfo));
			billPaymentInfo = payableAmountCalculatorService.doCalculatePayableAmount(billPaymentInfo);
			assertEquals(new Double(325), billPaymentInfo.getPayableAmount());
		} catch (MyBusinessException exception) {
			log.info("***** MyBusinessException *** " + exception.getCode().getDescription());
			assertEquals("00001",exception.getCode().getCode());

		}
	}
}
