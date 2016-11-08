package com.myproject.ssm.crm.service.common.enums;

public enum PopedomModuleEnum {

	city("city", "城市资料模块"), code("code", "编码规则模块"), company("company", "客户拜访模块"), group("group", "部门设置模块"), linkman(
			"linkman", "联系人管理模块"), linktouch("linktouch", "联系记录管理模块模块"), province("province", "省份资料模块"), report(
					"report", "报表与分析模块"), role("role", "操作权限组模块"), rule("rule", "客户策略管理模块"), user("user", "人事管理模块");

	private String key;
	private String value;

	PopedomModuleEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
