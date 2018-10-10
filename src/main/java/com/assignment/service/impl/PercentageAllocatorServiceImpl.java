package com.assignment.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.assignment.domain.BillPaymentInfo;
import com.assignment.domain.Constants;
import com.assignment.exceptions.ErrorCode;
import com.assignment.exceptions.MyBusinessException;
import com.assignment.service.PercentageAllocatorService;
/**
 * @author ASHIF ASHRAF
 * 
 
 *This Implementation class serving for Percentage Calculator 
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

	@Override
	public double getPercentage(BillPaymentInfo billPaymentInfo) throws MyBusinessException {
		try {
			double percentage = 0.00;

			percentage = (userPercentageMap.get(billPaymentInfo.getUser().getIsCompanyEmployee())) == null ? percentage
					: userPercentageMap.get(billPaymentInfo.getUser().getIsCompanyEmployee());
			percentage = (percentage == 0.00) ? userPercentageMap.get(billPaymentInfo.getUser().getIsAffiliated()) : percentage;
			percentage = (percentage == 0.00) ? userPercentageMap.get(billPaymentInfo.getUser().getIs2YearsCustomer()) : percentage;
			percentage = (percentage == 0.00) ? calculateBillAmountBasedPercentage(billPaymentInfo) : percentage;
			return percentage;
		} catch (Exception exception) {
			log.info(exception);
			throw new MyBusinessException(ErrorCode.TECH_ERROR);
		}
	}

	private double calculateBillAmountBasedPercentage(BillPaymentInfo billPaymentInfo) {
		int comparisonValue = Double.compare(billPaymentInfo.getBillAmount(), 100);
		if (comparisonValue > 0) {
			Double hundreds = billPaymentInfo.getBillAmount() / 100;
			return hundreds.intValue() * 5 / billPaymentInfo.getBillAmount() * 100;
		}else {
			return 0.00;

		}
	}

}
