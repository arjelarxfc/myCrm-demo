package com.myproject.ssm.crm.dal.common.object;

import java.io.Serializable;

import com.myproject.ssm.crm.common.domain.SysMenuKey;

public class SysMenuDO extends SysMenuKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3961950720227293025L;
	private Integer sort;
    private String menuName;
    private String title;
    private String url;
    private String target;
    private String icon;
    private String remark;
    
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
    public String getTarget() {
        return target;
    }
    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}