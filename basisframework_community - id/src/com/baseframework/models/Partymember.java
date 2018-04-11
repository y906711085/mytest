package com.baseframework.models;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name="partymember")
public class Partymember extends com.baseframework.dao.BaseEntity  {
	private static final long serialVersionUID = 1L;

	private String address;

	private String archivesUnit;

	private String birthDay;

	private String cardCode;

	private String contactPhone;

	private String education;

	private String joinDate;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String maritalStatus;

	private String name;

	private String nation;

	private String nativePlace;

	private String rotationTime;

	private String sex;

	private int tenementId;

	private String work;

	private int dptId;

	@Column(name="address", nullable = true)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="archivesUnit", nullable = true)
	public String getArchivesUnit() {
		return this.archivesUnit;
	}

	public void setArchivesUnit(String archivesUnit) {
		this.archivesUnit = archivesUnit;
	}

	@Column(name="birthDay", nullable = true)
	public String getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	@Column(name="cardCode", nullable = true)
	public String getCardCode() {
		return this.cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	@Column(name="contactPhone", nullable = true)
	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@Column(name="education", nullable = true)
	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Column(name="joinDate", nullable = true)
	public String getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Column(name="latitude", nullable = true)
	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	@Column(name="longitude", nullable = true)
	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	@Column(name="maritalStatus", nullable = true)
	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Column(name="name", nullable = true)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="nation", nullable = true)
	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name="nativePlace", nullable = true)
	public String getNativePlace() {
		return this.nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	@Column(name="rotationTime", nullable = true)
	public String getRotationTime() {
		return this.rotationTime;
	}

	public void setRotationTime(String rotationTime) {
		this.rotationTime = rotationTime;
	}

	@Column(name="sex", nullable = true)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name="tenementId", nullable = true)
	public int getTenementId() {
		return this.tenementId;
	}

	public void setTenementId(int tenementId) {
		this.tenementId = tenementId;
	}

	@Column(name="work", nullable = true)
	public String getWork() {
		return this.work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	@Column(name="dptId",nullable=true)
	public int getDptId() {
		return this.dptId;
	}

	public void setDptId(int dptId) {
		this.dptId = dptId;
	}

}