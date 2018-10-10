package com.assignment.domain;

public class User {
	
	public User(String isCompanyEmployee, String isAffiliated, String is2YearsCustomer) {
		super();
		this.isCompanyEmployee = isCompanyEmployee;
		this.isAffiliated = isAffiliated;
		this.is2YearsCustomer = is2YearsCustomer;
	}

	private String isCompanyEmployee;
	private String isAffiliated;
	private String is2YearsCustomer;

	public String getIs2YearsCustomer() {
		return is2YearsCustomer;
	}

	public void setIs2YearsCustomer(String is2YearsCustomer) {
		this.is2YearsCustomer = is2YearsCustomer;
	}

	public String getIsCompanyEmployee() {
		return isCompanyEmployee;
	}

	public void setIsCompanyEmployee(String isCompanyEmployee) {
		this.isCompanyEmployee = isCompanyEmployee;
	}

	public String getIsAffiliated() {
		return isAffiliated;
	}

	public void setIsAffiliated(String isAffiliated) {
		this.isAffiliated = isAffiliated;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((is2YearsCustomer == null) ? 0 : is2YearsCustomer.hashCode());
		result = prime * result + ((isAffiliated == null) ? 0 : isAffiliated.hashCode());
		result = prime * result + ((isCompanyEmployee == null) ? 0 : isCompanyEmployee.hashCode());
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
		User other = (User) obj;
		if (is2YearsCustomer == null) {
			if (other.is2YearsCustomer != null)
				return false;
		} else if (!is2YearsCustomer.equals(other.is2YearsCustomer))
			return false;
		if (isAffiliated == null) {
			if (other.isAffiliated != null)
				return false;
		} else if (!isAffiliated.equals(other.isAffiliated))
			return false;
		if (isCompanyEmployee == null) {
			if (other.isCompanyEmployee != null)
				return false;
		} else if (!isCompanyEmployee.equals(other.isCompanyEmployee))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [isCompanyEmployee=" + isCompanyEmployee + ", isAffiliated=" + isAffiliated + ", is2YearsCustomer="
				+ is2YearsCustomer + "]";
	}

}
