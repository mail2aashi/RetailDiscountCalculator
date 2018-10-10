package com.assignment.domain;

public class BillPaymentInfo {

	private Double billAmount;
	private Double payableAmount;
	private Double percentage;
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BillPaymentInfo(Double billAmount) {
		super();
		this.billAmount = billAmount;
	}
	public Double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}
	public Double getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(Double payableAmount) {
		this.payableAmount = payableAmount;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billAmount == null) ? 0 : billAmount.hashCode());
		result = prime * result + ((payableAmount == null) ? 0 : payableAmount.hashCode());
		result = prime * result + ((percentage == null) ? 0 : percentage.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillPaymentInfo other = (BillPaymentInfo) obj;
		if (billAmount == null) {
			if (other.billAmount != null)
				return false;
		} else if (!billAmount.equals(other.billAmount))
			return false;
		if (payableAmount == null) {
			if (other.payableAmount != null)
				return false;
		} else if (!payableAmount.equals(other.payableAmount))
			return false;
		if (percentage == null) {
			if (other.percentage != null)
				return false;
		} else if (!percentage.equals(other.percentage))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BillPaymentInfo [billAmount=" + billAmount + ", payableAmount=" + payableAmount + ", percentage="
				+ percentage + "]";
	}

}
