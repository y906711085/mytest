package com.baseframework.models;

import javax.persistence.*;

@Entity
@Table(name="disabledbaseinfo")
public class Disabledbaseinfo extends com.baseframework.dao.BaseEntity  {
	private static final long serialVersionUID = 1L;

	
	private String address;

	private String birthDay;
	
	private String cardCode;

	private String cardState;

	private String cardType;

	private String contactPhone;
	
	private String disabilityCategory;

	private String disabilityCertificate;

	private String disabilityLevel;

	private String education;
	
	private String name;

	private String nation;

	private String sex;

	private int regionId;

	@Column(name="address",nullable=false)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@Column(name="disabilityCategory",nullable=false)
	public String getDisabilityCategory() {
		return this.disabilityCategory;
	}

	public void setDisabilityCategory(String disabilityCategory) {
		this.disabilityCategory = disabilityCategory;
	}

	@Column(name="disabilityCertificate",nullable=false)
	public String getDisabilityCertificate() {
		return this.disabilityCertificate;
	}

	public void setDisabilityCertificate(String disabilityCertificate) {
		this.disabilityCertificate = disabilityCertificate;
	}

	@Column(name="disabilityLevel",nullable=false)
	public String getDisabilityLevel() {
		return this.disabilityLevel;
	}

	public void setDisabilityLevel(String disabilityLevel) {
		this.disabilityLevel = disabilityLevel;
	}

	@Column(name="education",nullable=false)
	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Column(name="name",nullable=false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="nation",nullable=false)
	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name="sex",nullable=false)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name="regionId",nullable=false)
	public int getRegionId() {
		return this.regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

}