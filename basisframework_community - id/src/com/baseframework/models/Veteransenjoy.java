package com.baseframework.models;

import javax.persistence.*;

import com.baseframework.dao.BaseEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name="veteransenjoy")
public class Veteransenjoy extends BaseEntity  {
	private static final long serialVersionUID = 1L;

	private String address;

	private Timestamp birthday;

	private String community;

	private Timestamp dischargedate;

	private String domicile;

	private String employmentsituation;

	private Timestamp enlistmentdate;

	private String family;

	private String idcard;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String name;

	private String personnelType;

	private String resettlementsituation;

	private String retirementsituation;

	private String sex;

	private String socialsecurity;

	private String specialsituation;

	private String street;

	private String subsistenceallowances;

	private String telnumber;

	@Column(name = "address", nullable = true)
	public String getAddress() {
		return this.address;
	}

	@Column(name = "navigationName", nullable = true)
	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "birthday", nullable = true)
	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	@Column(name = "community", nullable = true)
	public String getCommunity() {
		return this.community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	@Column(name = "dischargedate", nullable = true)
	public Timestamp getDischargedate() {
		return this.dischargedate;
	}

	public void setDischargedate(Timestamp dischargedate) {
		this.dischargedate = dischargedate;
	}

	@Column(name = "domicile", nullable = true)
	public String getDomicile() {
		return this.domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	@Column(name = "employmentsituation", nullable = true)
	public String getEmploymentsituation() {
		return this.employmentsituation;
	}

	public void setEmploymentsituation(String employmentsituation) {
		this.employmentsituation = employmentsituation;
	}

	@Column(name = "enlistmentdate", nullable = true)
	public Timestamp getEnlistmentdate() {
		return this.enlistmentdate;
	}

	public void setEnlistmentdate(Timestamp enlistmentdate) {
		this.enlistmentdate = enlistmentdate;
	}

	@Column(name = "family", nullable = true)
	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Column(name = "idcard", nullable = true)
	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	@Column(name = "latitude", nullable = true)
	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude", nullable = true)
	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	@Column(name = "name", nullable = true)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "personnelType", nullable = true)
	public String getPersonnelType() {
		return this.personnelType;
	}

	public void setPersonnelType(String personnelType) {
		this.personnelType = personnelType;
	}

	@Column(name = "resettlementsituation", nullable = true)
	public String getResettlementsituation() {
		return this.resettlementsituation;
	}

	public void setResettlementsituation(String resettlementsituation) {
		this.resettlementsituation = resettlementsituation;
	}

	@Column(name = "retirementsituation", nullable = true)
	public String getRetirementsituation() {
		return this.retirementsituation;
	}

	public void setRetirementsituation(String retirementsituation) {
		this.retirementsituation = retirementsituation;
	}

	@Column(name = "sex", nullable = true)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "socialsecurity", nullable = true)
	public String getSocialsecurity() {
		return this.socialsecurity;
	}

	public void setSocialsecurity(String socialsecurity) {
		this.socialsecurity = socialsecurity;
	}

	@Column(name = "specialsituation", nullable = true)
	public String getSpecialsituation() {
		return this.specialsituation;
	}

	public void setSpecialsituation(String specialsituation) {
		this.specialsituation = specialsituation;
	}

	@Column(name = "street", nullable = true)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "subsistenceallowances", nullable = true)
	public String getSubsistenceallowances() {
		return this.subsistenceallowances;
	}

	public void setSubsistenceallowances(String subsistenceallowances) {
		this.subsistenceallowances = subsistenceallowances;
	}

	@Column(name = "telnumber", nullable = true)
	public String getTelnumber() {
		return this.telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

}