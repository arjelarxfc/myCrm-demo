package com.myproject.ssm.crm.service.common.enums;

public enum MenuModuleEnum {

	company("company"), report("report"), sys("sys");

	private String value;

	MenuModuleEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
