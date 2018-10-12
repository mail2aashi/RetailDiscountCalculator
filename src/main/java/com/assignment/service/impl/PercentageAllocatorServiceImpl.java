package com.assignment.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.assignment.domain.BillPaymentInfo;
import com.assignment.constants.Constants;
import com.assignment.exceptions.ErrorCode;
import com.assignment.exceptions.RetailDiscountCalculatorException;
import com.assignment.service.PercentageAllocatorService;

/**
 * @author ASHIF ASHRAF
 * @version v1
 * @since 2018 10 11 This Implementation class serving for Percentage Calculator
 */
public class PercentageAllocatorServiceImpl implements PercentageAllocatorService {
	Map<String, Double> userPercentageMap = new HashMap<String, Double>();
	private static Logger log = LogManager.getLogger(PercentageAllocatorServiceImpl.class);

	public PercentageAllocatorServiceImpl() {
		userPercentageMap.put(Constants.IS_EMPLOYEE_KEY, Constants.IS_EMPLOYEE_VALUE);
		userPercentageMap.put(Constants.IS_AFFILIATE_KEY, Constants.IS_AFFILIATE_VALUE);
		userPercentageMap.put(Constants.IS_2YEARSCUSTOMER_KEY, Constants.IS_2YEARSCUSTOMER_VALUE);
		userPercentageMap.put(Constants.DEFAULT_KEY, Constants.DEFAULT_VALUE);
	}

	/**
	 * In this method, Only one type of percentage is applied to a user based on Criteria.
	 * @param BillPaymentInfo
	 *            billPaymentInfo
	 * @return double
	 * @see percentage
	 */
	public double getPercentage(BillPaymentInfo billPaymentInfo) throws RetailDiscountCalculatorException {
		try {
			double percentage = 0.00;
			if(billPaymentInfo.getPurchaseItems().getItemType().equals(Constants.GROCERY_VALUE))
				return percentage; 
			percentage = (userPercentageMap.get(billPaymentInfo.getUser().getIsCompanyEmployee())) == null ? percentage
					: userPercentageMap.get(billPaymentInfo.getUser().getIsCompanyEmployee());
			percentage = (percentage == 0.00) ? userPercentageMap.get(billPaymentInfo.getUser().getIsAffiliated())
					: percentage;
			percentage = (percentage == 0.00) ? userPercentageMap.get(billPaymentInfo.getUser().getIs2YearsCustomer())
					: percentage;
			percentage = (percentage == 0.00) ? calculateBillAmountBasedPercentage(billPaymentInfo) : percentage;
			return percentage;
		} catch (Exception exception) {
			log.error(exception);
			throw new RetailDiscountCalculatorException(ErrorCode.TECH_ERROR, exception);
		}
	}

	/**
	 *In this method, based on count of 100s in Bill Amount, user will get 5% for each 100s.
	 
	 * @param BillPaymentInfo
	 *            billPaymentInfo
	 * @return double
	 * @see percentage
	 */
	private double calculateBillAmountBasedPercentage(BillPaymentInfo billPaymentInfo) {
		try {
			int comparisonValue = Double.compare(billPaymentInfo.getBillAmount(), 100);
			if (comparisonValue > 0) {
				Double hundreds = billPaymentInfo.getBillAmount() / 100;
				return hundreds.intValue() * 5 ;
			} else {
				return 0.00;

			}
		} catch (Exception exception) {
			log.error(exception);
			throw new RetailDiscountCalculatorException(ErrorCode.TECH_ERROR, exception);
		}
	}

}
