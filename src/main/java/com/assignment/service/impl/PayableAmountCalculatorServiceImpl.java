package com.assignment.service.impl;

import com.assignment.domain.BillPaymentInfo;
import com.assignment.exceptions.ErrorCode;
import com.assignment.exceptions.RetailDiscountCalculatorException;
import com.assignment.service.PayableAmountCalculatorService;
/**
 * @author ASHIF ASHRAF
 * @version v1
 * @since 2018 10 11 This Implementation class serving as  PayinAmount Calculator
 */
public class PayableAmountCalculatorServiceImpl implements PayableAmountCalculatorService {

	/**
	 * @param BillPaymentInfo billPaymentInfo
	 * @return BillPaymentInfo
	 */
	public BillPaymentInfo doCalculatePayableAmount(BillPaymentInfo billPaymentInfo) {
		try{billPaymentInfo.setPayableAmount(billPaymentInfo.getBillAmount() * (1- billPaymentInfo.getPercentage() * 0.01));
		return billPaymentInfo;
		}catch (Exception exceptions) {
			throw new RetailDiscountCalculatorException(ErrorCode.TECH_ERROR, exceptions);
		}
	}

}
