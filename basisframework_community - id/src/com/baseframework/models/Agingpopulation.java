package com.baseframework.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Table(name="agingpopulation")
public class Agingpopulation extends com.baseframework.dao.BaseEntity  {
	private static final long serialVersionUID = 1L;

	private String address;

	private String agingCode;

	private String birthDay;

	private String cardCode;

	private String cardState;

	private String cardType;

	private String contactPhone;
	
	private String isAlone;
	
	private String name;
	
	private String nativePlace;

	private BigDecimal oldageMoney;

	private String operator;

	private String orgCode;

	private String orgName;

	private String sex;

	private String stateReason;

	private Timestamp stateTime;

	private Timestamp takeDate;

	private int tenementId;

	private int regionId;

	@Column(name="address",nullable=false)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="agingCode",nullable=false)
	public String getAgingCode() {
		return this.agingCode;
	}

	public void setAgingCode(String agingCode) {
		this.agingCode = agingCode;
	}

	@Column(name="birthDay",nullable=false)
	public String getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	@Column(name="cardCode",nullable=false)
	public String getCardCode() {
		return this.cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	@Column(name="cardState",nullable=false)
	public String getCardState() {
		return this.cardState;
	}

	public void setCardState(String cardState) {
		this.cardState = cardState;
	}

	@Column(name="cardType",nullable=false)
	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Column(name="contactPhone",nullable=false)
	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@Column(name="isAlone",nullable=false)
	public String getIsAlone() {
		return this.isAlone;
	}

	public void setIsAlone(String isAlone) {
		this.isAlone = isAlone;
	}

	@Column(name="name",nullable=false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="nativePlace",nullable=false)
	public String getNativePlace() {
		return this.nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	@Column(name="oldageMoney",nullable=false)
	public BigDecimal getOldageMoney() {
		return this.oldageMoney;
	}

	public void setOldageMoney(BigDecimal oldageMoney) {
		this.oldageMoney = oldageMoney;
	}

	@Column(name="operator",nullable=false)
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(name="orgCode",nullable=false)
	public String getOrgCode() {
		return this.orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	@Column(name="orgName",nullable=false)
	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name="sex",nullable=false)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name="stateReason",nullable=false)
	public String getStateReason() {
		return this.stateReason;
	}

	public void setStateReason(String stateReason) {
		this.stateReason = stateReason;
	}

	@Column(name="stateTime",nullable=false)
	public Timestamp getStateTime() {
		return this.stateTime;
	}

	public void setStateTime(Timestamp stateTime) {
		this.stateTime = stateTime;
	}

	@Column(name="takeDate",nullable=false)
	public Timestamp getTakeDate() {
		return this.takeDate;
	}

	public void setTakeDate(Timestamp takeDate) {
		this.takeDate = takeDate;
	}

	@Column(name="tenementId",columnDefinition="int default 0")
	public int getTenementId() {
		return this.tenementId;
	}

	public void setTenementId(int tenementId) 
	{
		this.tenementId = tenementId;
	}

	@Column(name="RegionId",nullable=false)
	public int getRegionId() {
		return this.regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
}