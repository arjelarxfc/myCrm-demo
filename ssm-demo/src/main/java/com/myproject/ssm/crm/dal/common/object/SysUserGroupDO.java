package com.myproject.ssm.crm.dal.common.object;

import java.io.Serializable;

public class SysUserGroupDO implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3730827912782039538L;
	
	private Integer id;
    private String name;
    private String principal;
    private String incumbent;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public String getIncumbent() {
        return incumbent;
    }

    public void setIncumbent(String incumbent) {
        this.incumbent = incumbent == null ? null : incumbent.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}