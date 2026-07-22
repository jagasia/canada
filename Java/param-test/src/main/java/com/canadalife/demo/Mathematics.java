package com.canadalife.demo;

public class Mathematics {
	private Integer no1, no2, result;

	public void setNo1(Integer n) {
		no1 = n;
	}

	public void setNo2(Integer n) {
		no2 = n;
	}

	public Integer getResult() {
		return result;
	}

	public void add() {
		result = no1 + no2;
	}

	public void multiply() {
		result = no1 * no2;
	}

	public void subtract() {
		result = no1 - no2;
	}
}