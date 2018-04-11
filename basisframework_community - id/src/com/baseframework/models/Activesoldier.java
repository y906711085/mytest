package com.baseframework.models;
 
import com.baseframework.dao.BaseEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="activesoldiers")
public class Activesoldier extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String community;

	private String FAddress;

	private Timestamp fbirthday;

	private String FDomicile;

	private String fidcard;

	private String FIsSoldier;

	private String FName;

	private String FSex;

	private String FTelNumber;

	private String ftype;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String remark;

	private String sacrificeDisDate;

	private Timestamp sbirthday;

	private Timestamp SEnlistmentdate;

	private String sidcard;

	private String SName;

	private String specialsituation;

	private String SPersonnelType;

	private String SSex;

	private String STelNumber;

	private String street; 
	
	@Column(name="community", nullable = true)
	public String getCommunity() {
		return this.community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	@Column(name="faddress", nullable = true)
	public String getFAddress() {
		return this.FAddress;
	}

	public void setFAddress(String FAddress) {
		this.FAddress = FAddress;
	}

	@Column(name="fbirthday", nullable = true)
	public Timestamp getFbirthday() {
		return this.fbirthday;
	}

	public void setFbirthday(Timestamp fbirthday) {
		this.fbirthday = fbirthday;
	}

	@Column(name="fdomicile", nullable = true)
	public String getFDomicile() {
		return this.FDomicile;
	}

	public void setFDomicile(String FDomicile) {
		this.FDomicile = FDomicile;
	}

	@Column(name="fidcard", nullable = true)
	public String getFidcard() {
		return this.fidcard;
	}

	public void setFidcard(String fidcard) {
		this.fidcard = fidcard;
	}

	@Column(name="fissoldier", nullable = true)
	public String getFIsSoldier() {
		return this.FIsSoldier;
	}

	public void setFIsSoldier(String FIsSoldier) {
		this.FIsSoldier = FIsSoldier;
	}

	@Column(name="fname", nullable = true)
	public String getFName() {
		return this.FName;
	}

	public void setFName(String FName) {
		this.FName = FName;
	}

	@Column(name="fsex", nullable = true)
	public String getFSex() {
		return this.FSex;
	}

	public void setFSex(String FSex) {
		this.FSex = FSex;
	}

	@Column(name="ftelnumber", nullable = true)
	public String getFTelNumber() {
		return this.FTelNumber;
	}

	public void setFTelNumber(String FTelNumber) {
		this.FTelNumber = FTelNumber;
	}

	@Column(name="ftype", nullable = true)
	public String getFtype() {
		return this.ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
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

	@Column(name="remark", nullable = true)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name="sacrificedisdate", nullable = true)
	public String getSacrificeDisDate() {
		return this.sacrificeDisDate;
	}

	public void setSacrificeDisDate(String sacrificeDisDate) {
		this.sacrificeDisDate = sacrificeDisDate;
	}

	@Column(name="sbirthday", nullable = true)
	public Timestamp getSbirthday() {
		return this.sbirthday;
	}

	public void setSbirthday(Timestamp sbirthday) {
		this.sbirthday = sbirthday;
	}

	@Column(name="senlistmentdate", nullable = true)
	public Timestamp getSEnlistmentdate() {
		return this.SEnlistmentdate;
	}

	public void setSEnlistmentdate(Timestamp SEnlistmentdate) {
		this.SEnlistmentdate = SEnlistmentdate;
	}

	@Column(name="sidcard", nullable = true)
	public String getSidcard() {
		return this.sidcard;
	}

	public void setSidcard(String sidcard) {
		this.sidcard = sidcard;
	}

	@Column(name="sname", nullable = true)
	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	@Column(name="specialsituation", nullable = true)
	public String getSpecialsituation() {
		return this.specialsituation;
	}

	public void setSpecialsituation(String specialsituation) {
		this.specialsituation = specialsituation;
	}

	@Column(name="spersonneltype", nullable = true)
	public String getSPersonnelType() {
		return this.SPersonnelType;
	}

	public void setSPersonnelType(String SPersonnelType) {
		this.SPersonnelType = SPersonnelType;
	}

	@Column(name="ssex", nullable = true)
	public String getSSex() {
		return this.SSex;
	}

	public void setSSex(String SSex) {
		this.SSex = SSex;
	}

	@Column(name="stelnumber", nullable = true)
	public String getSTelNumber() {
		return this.STelNumber;
	}

	public void setSTelNumber(String STelNumber) {
		this.STelNumber = STelNumber;
	}

	@Column(name="street", nullable = true)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}