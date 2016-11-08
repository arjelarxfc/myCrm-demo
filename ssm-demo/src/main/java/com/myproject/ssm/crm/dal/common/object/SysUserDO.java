package com.myproject.ssm.crm.dal.common.object;

import java.io.Serializable;
import java.util.Date;

public class SysUserDO implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3401688458082991423L;

	private Integer id;

    private String creator;

    private String createTime;

    private String updater;

    private String updateTime;

    private String name;

    private String cnName;

    private String password;

    private String address;

    private String telephone;

    private String email;

    private Date beginDate;

    private Date endDate;

    private String roleId;

    private Integer groupId;

    private String accessFileLevel;

    private String status;

    private String commendMan;

    private String moveTelephone;

    private String nowAddress;

    private String nowTelephone;

    private String identityCode;

    private String insuranceCode;

    private String instancyLinkman;

    private String instancyTelephone;

    private String sex;

    private Date birthday;

    private String personnelType;

    private String duty;

    private Date workDate;

    private String highSchool;

    private String finishSchool;

    private Date finishSchoolDate;

    private String consortName;

    private String youngoneName;

    private String officeTelephone;

    private String consortTelephone;

    private String consortCompany;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getAccessFileLevel() {
        return accessFileLevel;
    }

    public void setAccessFileLevel(String accessFileLevel) {
        this.accessFileLevel = accessFileLevel == null ? null : accessFileLevel.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCommendMan() {
        return commendMan;
    }

    public void setCommendMan(String commendMan) {
        this.commendMan = commendMan == null ? null : commendMan.trim();
    }

    public String getMoveTelephone() {
		return moveTelephone;
	}

	public void setMoveTelephone(String moveTelephone) {
		this.moveTelephone = moveTelephone;
	}

	public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress == null ? null : nowAddress.trim();
    }

    public String getNowTelephone() {
        return nowTelephone;
    }

    public void setNowTelephone(String nowTelephone) {
        this.nowTelephone = nowTelephone == null ? null : nowTelephone.trim();
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode == null ? null : identityCode.trim();
    }

    public String getInsuranceCode() {
        return insuranceCode;
    }

    public void setInsuranceCode(String insuranceCode) {
        this.insuranceCode = insuranceCode == null ? null : insuranceCode.trim();
    }

    public String getInstancyLinkman() {
        return instancyLinkman;
    }

    public void setInstancyLinkman(String instancyLinkman) {
        this.instancyLinkman = instancyLinkman == null ? null : instancyLinkman.trim();
    }

    public String getInstancyTelephone() {
        return instancyTelephone;
    }

    public void setInstancyTelephone(String instancyTelephone) {
        this.instancyTelephone = instancyTelephone == null ? null : instancyTelephone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(String personnelType) {
        this.personnelType = personnelType == null ? null : personnelType.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool == null ? null : highSchool.trim();
    }

    public String getFinishSchool() {
        return finishSchool;
    }

    public void setFinishSchool(String finishSchool) {
        this.finishSchool = finishSchool == null ? null : finishSchool.trim();
    }

    public Date getFinishSchoolDate() {
        return finishSchoolDate;
    }

    public void setFinishSchoolDate(Date finishSchoolDate) {
        this.finishSchoolDate = finishSchoolDate;
    }

    public String getConsortName() {
        return consortName;
    }

    public void setConsortName(String consortName) {
        this.consortName = consortName == null ? null : consortName.trim();
    }

    public String getYoungoneName() {
        return youngoneName;
    }

    public void setYoungoneName(String youngoneName) {
        this.youngoneName = youngoneName == null ? null : youngoneName.trim();
    }

    public String getOfficeTelephone() {
        return officeTelephone;
    }

    public void setOfficeTelephone(String officeTelephone) {
        this.officeTelephone = officeTelephone == null ? null : officeTelephone.trim();
    }

    public String getConsortTelephone() {
        return consortTelephone;
    }

    public void setConsortTelephone(String consortTelephone) {
        this.consortTelephone = consortTelephone == null ? null : consortTelephone.trim();
    }

    public String getConsortCompany() {
        return consortCompany;
    }

    public void setConsortCompany(String consortCompany) {
        this.consortCompany = consortCompany == null ? null : consortCompany.trim();
    }
}