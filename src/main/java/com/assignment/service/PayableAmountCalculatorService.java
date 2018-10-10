package com.assignment.service;

import com.assignment.domain.BillPaymentInfo;

public interface PayableAmountCalculatorService {

	BillPaymentInfo doCalculatePayableAmount(BillPaymentInfo billPaymentInfo);
}
