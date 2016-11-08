package com.myproject.ssm.crm.service.common.model;

public class SysUserModel {
	private Integer id;
	private String creator; // 
	private String createTime; // 创建时间 yyyy-mm-dd HH24:mm:ss
	private String updater; // 
	private String updateTime; // 修建时间 yyyy-mm-dd HH24:mm:ss
	private String remark;
	private String name;
	private String cnName;
	private String password;
	private String address;
	private String telephone;
	private String email;
	private String beginDate; 
	private String endDate;
	private SysRoleModel sysRoleModel; 
	private SysUserGroupModel sysUserGroupModel;  
	private String accessFileLevel;
	private String status; 
	private String commendMan;
	private String movetelePhone;
	private String nowAddress;
	private String nowtelePhone;
	private String identityCode;
	private String insuranceCode;
	private String instancyLinkman;
	private String instancytelePhone;
	private String sex;
	private String birthday; // 出生日期
	private String personnelType;
	private String duty;
	private String workDate; // 入职日期
	private String highSchool;
	private String finishSchool;
	private String finishSchoolDate; // 毕业日期
	private String consortName;
	private String youngoneName;
	private String officetelePhone;
	private String consorttelePhone;
	private String avocation;
	private String consortCompany;
	private String strongSuit;
	private String commUniCate;
	private String bringup;
	private String organise;
	private String analyse;
	private String planing;
	private String empolder;
	private String relation;
	
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
		this.creator = creator;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public SysRoleModel getSysRoleModel() {
		return sysRoleModel;
	}
	public void setSysRoleModel(SysRoleModel sysRoleModel) {
		this.sysRoleModel = sysRoleModel;
	}
	public SysUserGroupModel getSysUserGroupModel() {
		return sysUserGroupModel;
	}
	public void setSysUserGroupModel(SysUserGroupModel sysUserGroupModel) {
		this.sysUserGroupModel = sysUserGroupModel;
	}
	public String getAccessFileLevel() {
		return accessFileLevel;
	}
	public void setAccessFileLevel(String accessFileLevel) {
		this.accessFileLevel = accessFileLevel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCommendMan() {
		return commendMan;
	}
	public void setCommendMan(String commendMan) {
		this.commendMan = commendMan;
	}
	public String getMovetelePhone() {
		return movetelePhone;
	}
	public void setMovetelePhone(String movetelePhone) {
		this.movetelePhone = movetelePhone;
	}
	public String getNowAddress() {
		return nowAddress;
	}
	public void setNowAddress(String nowAddress) {
		this.nowAddress = nowAddress;
	}
	public String getNowtelePhone() {
		return nowtelePhone;
	}
	public void setNowtelePhone(String nowtelePhone) {
		this.nowtelePhone = nowtelePhone;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public String getInsuranceCode() {
		return insuranceCode;
	}
	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}
	public String getInstancyLinkman() {
		return instancyLinkman;
	}
	public void setInstancyLinkman(String instancyLinkman) {
		this.instancyLinkman = instancyLinkman;
	}
	public String getInstancytelePhone() {
		return instancytelePhone;
	}
	public void setInstancytelePhone(String instancytelePhone) {
		this.instancytelePhone = instancytelePhone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPersonnelType() {
		return personnelType;
	}
	public void setPersonnelType(String personnelType) {
		this.personnelType = personnelType;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getHighSchool() {
		return highSchool;
	}
	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}
	public String getFinishSchool() {
		return finishSchool;
	}
	public void setFinishSchool(String finishSchool) {
		this.finishSchool = finishSchool;
	}
	public String getFinishSchoolDate() {
		return finishSchoolDate;
	}
	public void setFinishSchoolDate(String finishSchoolDate) {
		this.finishSchoolDate = finishSchoolDate;
	}
	public String getConsortName() {
		return consortName;
	}
	public void setConsortName(String consortName) {
		this.consortName = consortName;
	}
	public String getYoungoneName() {
		return youngoneName;
	}
	public void setYoungoneName(String youngoneName) {
		this.youngoneName = youngoneName;
	}
	public String getOfficetelePhone() {
		return officetelePhone;
	}
	public void setOfficetelePhone(String officetelePhone) {
		this.officetelePhone = officetelePhone;
	}
	public String getConsorttelePhone() {
		return consorttelePhone;
	}
	public void setConsorttelePhone(String consorttelePhone) {
		this.consorttelePhone = consorttelePhone;
	}
	public String getAvocation() {
		return avocation;
	}
	public void setAvocation(String avocation) {
		this.avocation = avocation;
	}
	public String getConsortCompany() {
		return consortCompany;
	}
	public void setConsortCompany(String consortCompany) {
		this.consortCompany = consortCompany;
	}
	public String getStrongSuit() {
		return strongSuit;
	}
	public void setStrongSuit(String strongSuit) {
		this.strongSuit = strongSuit;
	}
	public String getCommUniCate() {
		return commUniCate;
	}
	public void setCommUniCate(String commUniCate) {
		this.commUniCate = commUniCate;
	}
	public String getBringup() {
		return bringup;
	}
	public void setBringup(String bringup) {
		this.bringup = bringup;
	}
	public String getOrganise() {
		return organise;
	}
	public void setOrganise(String organise) {
		this.organise = organise;
	}
	public String getAnalyse() {
		return analyse;
	}
	public void setAnalyse(String analyse) {
		this.analyse = analyse;
	}
	public String getPlaning() {
		return planing;
	}
	public void setPlaning(String planing) {
		this.planing = planing;
	}
	public String getEmpolder() {
		return empolder;
	}
	public void setEmpolder(String empolder) {
		this.empolder = empolder;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessFileLevel == null) ? 0 : accessFileLevel.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((analyse == null) ? 0 : analyse.hashCode());
		result = prime * result + ((avocation == null) ? 0 : avocation.hashCode());
		result = prime * result + ((beginDate == null) ? 0 : beginDate.hashCode());
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((bringup == null) ? 0 : bringup.hashCode());
		result = prime * result + ((cnName == null) ? 0 : cnName.hashCode());
		result = prime * result + ((commUniCate == null) ? 0 : commUniCate.hashCode());
		result = prime * result + ((commendMan == null) ? 0 : commendMan.hashCode());
		result = prime * result + ((consortCompany == null) ? 0 : consortCompany.hashCode());
		result = prime * result + ((consortName == null) ? 0 : consortName.hashCode());
		result = prime * result + ((consorttelePhone == null) ? 0 : consorttelePhone.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((duty == null) ? 0 : duty.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((empolder == null) ? 0 : empolder.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((finishSchool == null) ? 0 : finishSchool.hashCode());
		result = prime * result + ((finishSchoolDate == null) ? 0 : finishSchoolDate.hashCode());
		result = prime * result + ((highSchool == null) ? 0 : highSchool.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identityCode == null) ? 0 : identityCode.hashCode());
		result = prime * result + ((instancyLinkman == null) ? 0 : instancyLinkman.hashCode());
		result = prime * result + ((instancytelePhone == null) ? 0 : instancytelePhone.hashCode());
		result = prime * result + ((insuranceCode == null) ? 0 : insuranceCode.hashCode());
		result = prime * result + ((movetelePhone == null) ? 0 : movetelePhone.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nowAddress == null) ? 0 : nowAddress.hashCode());
		result = prime * result + ((nowtelePhone == null) ? 0 : nowtelePhone.hashCode());
		result = prime * result + ((officetelePhone == null) ? 0 : officetelePhone.hashCode());
		result = prime * result + ((organise == null) ? 0 : organise.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((personnelType == null) ? 0 : personnelType.hashCode());
		result = prime * result + ((planing == null) ? 0 : planing.hashCode());
		result = prime * result + ((relation == null) ? 0 : relation.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((strongSuit == null) ? 0 : strongSuit.hashCode());
		result = prime * result + ((sysRoleModel == null) ? 0 : sysRoleModel.hashCode());
		result = prime * result + ((sysUserGroupModel == null) ? 0 : sysUserGroupModel.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((updater == null) ? 0 : updater.hashCode());
		result = prime * result + ((workDate == null) ? 0 : workDate.hashCode());
		result = prime * result + ((youngoneName == null) ? 0 : youngoneName.hashCode());
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
		SysUserModel other = (SysUserModel) obj;
		if (accessFileLevel == null) {
			if (other.accessFileLevel != null)
				return false;
		} else if (!accessFileLevel.equals(other.accessFileLevel))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (analyse == null) {
			if (other.analyse != null)
				return false;
		} else if (!analyse.equals(other.analyse))
			return false;
		if (avocation == null) {
			if (other.avocation != null)
				return false;
		} else if (!avocation.equals(other.avocation))
			return false;
		if (beginDate == null) {
			if (other.beginDate != null)
				return false;
		} else if (!beginDate.equals(other.beginDate))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (bringup == null) {
			if (other.bringup != null)
				return false;
		} else if (!bringup.equals(other.bringup))
			return false;
		if (cnName == null) {
			if (other.cnName != null)
				return false;
		} else if (!cnName.equals(other.cnName))
			return false;
		if (commUniCate == null) {
			if (other.commUniCate != null)
				return false;
		} else if (!commUniCate.equals(other.commUniCate))
			return false;
		if (commendMan == null) {
			if (other.commendMan != null)
				return false;
		} else if (!commendMan.equals(other.commendMan))
			return false;
		if (consortCompany == null) {
			if (other.consortCompany != null)
				return false;
		} else if (!consortCompany.equals(other.consortCompany))
			return false;
		if (consortName == null) {
			if (other.consortName != null)
				return false;
		} else if (!consortName.equals(other.consortName))
			return false;
		if (consorttelePhone == null) {
			if (other.consorttelePhone != null)
				return false;
		} else if (!consorttelePhone.equals(other.consorttelePhone))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (duty == null) {
			if (other.duty != null)
				return false;
		} else if (!duty.equals(other.duty))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (empolder == null) {
			if (other.empolder != null)
				return false;
		} else if (!empolder.equals(other.empolder))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (finishSchool == null) {
			if (other.finishSchool != null)
				return false;
		} else if (!finishSchool.equals(other.finishSchool))
			return false;
		if (finishSchoolDate == null) {
			if (other.finishSchoolDate != null)
				return false;
		} else if (!finishSchoolDate.equals(other.finishSchoolDate))
			return false;
		if (highSchool == null) {
			if (other.highSchool != null)
				return false;
		} else if (!highSchool.equals(other.highSchool))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identityCode == null) {
			if (other.identityCode != null)
				return false;
		} else if (!identityCode.equals(other.identityCode))
			return false;
		if (instancyLinkman == null) {
			if (other.instancyLinkman != null)
				return false;
		} else if (!instancyLinkman.equals(other.instancyLinkman))
			return false;
		if (instancytelePhone == null) {
			if (other.instancytelePhone != null)
				return false;
		} else if (!instancytelePhone.equals(other.instancytelePhone))
			return false;
		if (insuranceCode == null) {
			if (other.insuranceCode != null)
				return false;
		} else if (!insuranceCode.equals(other.insuranceCode))
			return false;
		if (movetelePhone == null) {
			if (other.movetelePhone != null)
				return false;
		} else if (!movetelePhone.equals(other.movetelePhone))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nowAddress == null) {
			if (other.nowAddress != null)
				return false;
		} else if (!nowAddress.equals(other.nowAddress))
			return false;
		if (nowtelePhone == null) {
			if (other.nowtelePhone != null)
				return false;
		} else if (!nowtelePhone.equals(other.nowtelePhone))
			return false;
		if (officetelePhone == null) {
			if (other.officetelePhone != null)
				return false;
		} else if (!officetelePhone.equals(other.officetelePhone))
			return false;
		if (organise == null) {
			if (other.organise != null)
				return false;
		} else if (!organise.equals(other.organise))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (personnelType == null) {
			if (other.personnelType != null)
				return false;
		} else if (!personnelType.equals(other.personnelType))
			return false;
		if (planing == null) {
			if (other.planing != null)
				return false;
		} else if (!planing.equals(other.planing))
			return false;
		if (relation == null) {
			if (other.relation != null)
				return false;
		} else if (!relation.equals(other.relation))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (strongSuit == null) {
			if (other.strongSuit != null)
				return false;
		} else if (!strongSuit.equals(other.strongSuit))
			return false;
		if (sysRoleModel == null) {
			if (other.sysRoleModel != null)
				return false;
		} else if (!sysRoleModel.equals(other.sysRoleModel))
			return false;
		if (sysUserGroupModel == null) {
			if (other.sysUserGroupModel != null)
				return false;
		} else if (!sysUserGroupModel.equals(other.sysUserGroupModel))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (updater == null) {
			if (other.updater != null)
				return false;
		} else if (!updater.equals(other.updater))
			return false;
		if (workDate == null) {
			if (other.workDate != null)
				return false;
		} else if (!workDate.equals(other.workDate))
			return false;
		if (youngoneName == null) {
			if (other.youngoneName != null)
				return false;
		} else if (!youngoneName.equals(other.youngoneName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SysUserModel [id=" + id + ", creator=" + creator + ", createTime=" + createTime + ", updater=" + updater
				+ ", updateTime=" + updateTime + ", remark=" + remark + ", name=" + name + ", cnName=" + cnName
				+ ", password=" + password + ", address=" + address + ", telephone=" + telephone + ", email=" + email
				+ ", beginDate=" + beginDate + ", endDate=" + endDate + ", sysRoleModel=" + sysRoleModel
				+ ", sysUserGroupModel=" + sysUserGroupModel + ", accessFileLevel=" + accessFileLevel + ", status="
				+ status + ", commendMan=" + commendMan + ", movetelePhone=" + movetelePhone + ", nowAddress="
				+ nowAddress + ", nowtelePhone=" + nowtelePhone + ", identityCode=" + identityCode + ", insuranceCode="
				+ insuranceCode + ", instancyLinkman=" + instancyLinkman + ", instancytelePhone=" + instancytelePhone
				+ ", sex=" + sex + ", birthday=" + birthday + ", personnelType=" + personnelType + ", duty=" + duty
				+ ", workDate=" + workDate + ", highSchool=" + highSchool + ", finishSchool=" + finishSchool
				+ ", finishSchoolDate=" + finishSchoolDate + ", consortName=" + consortName + ", youngoneName="
				+ youngoneName + ", officetelePhone=" + officetelePhone + ", consorttelePhone=" + consorttelePhone
				+ ", avocation=" + avocation + ", consortCompany=" + consortCompany + ", strongSuit=" + strongSuit
				+ ", commUniCate=" + commUniCate + ", bringup=" + bringup + ", organise=" + organise + ", analyse="
				+ analyse + ", planing=" + planing + ", empolder=" + empolder + ", relation=" + relation + "]";
	}
	
}