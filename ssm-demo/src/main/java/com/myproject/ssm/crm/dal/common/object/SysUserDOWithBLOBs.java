package com.myproject.ssm.crm.dal.common.object;

import java.io.Serializable;

public class SysUserDOWithBLOBs extends SysUserDO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5615835491027182980L;

	private String remark;

    private String avocation;

    private String strongSuit;

    private String commUniCate;

    private String bringup;

    private String organization;

    private String analyse;

    private String planing;

    private String empolder;

    private String relation;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAvocation() {
        return avocation;
    }

    public void setAvocation(String avocation) {
        this.avocation = avocation == null ? null : avocation.trim();
    }

    public String getStrongSuit() {
        return strongSuit;
    }

    public void setStrongSuit(String strongSuit) {
        this.strongSuit = strongSuit == null ? null : strongSuit.trim();
    }

    public String getCommUniCate() {
        return commUniCate;
    }

    public void setCommUniCate(String commUniCate) {
        this.commUniCate = commUniCate == null ? null : commUniCate.trim();
    }

    public String getBringup() {
        return bringup;
    }

    public void setBringup(String bringup) {
        this.bringup = bringup == null ? null : bringup.trim();
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public String getAnalyse() {
        return analyse;
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse == null ? null : analyse.trim();
    }

    public String getPlaning() {
        return planing;
    }

    public void setPlaning(String planing) {
        this.planing = planing == null ? null : planing.trim();
    }

    public String getEmpolder() {
        return empolder;
    }

    public void setEmpolder(String empolder) {
        this.empolder = empolder == null ? null : empolder.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }
}