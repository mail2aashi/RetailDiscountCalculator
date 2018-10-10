package com.assignment.service.impl;

import com.assignment.domain.BillPaymentInfo;
import com.assignment.service.PayableAmountCalculatorService;

public class PayableAmountCalculatorServiceImpl implements PayableAmountCalculatorService {

	@Override
	public BillPaymentInfo doCalculatePayableAmount(BillPaymentInfo billPaymentInfo) {
		billPaymentInfo.setPayableAmount(billPaymentInfo.getBillAmount() * (1- billPaymentInfo.getPercentage() * 0.01));
		return billPaymentInfo;
	}

}
