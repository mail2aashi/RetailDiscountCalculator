package com.assignment.service;

import com.assignment.domain.BillPaymentInfo;

public interface PercentageAllocatorService {

	double getPercentage(BillPaymentInfo billPaymentInfo);
}
