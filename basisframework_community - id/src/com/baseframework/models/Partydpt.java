package com.baseframework.models;

import javax.persistence.*;
import com.baseframework.dao.BaseEntity;
import java.math.BigDecimal;


@Entity
@Table(name="partydpt")
public class Partydpt extends BaseEntity  {
	private static final long serialVersionUID = 1L;

	private String address;

	private String contactNumber;

	private String dptHead;

	private String dptName;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private int parentId;

	@Column(name="address", nullable = true)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="contactNumber", nullable = true)
	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name="dptHead", nullable = true)
	public String getDptHead() {
		return this.dptHead;
	}

	public void setDptHead(String dptHead) {
		this.dptHead = dptHead;
	}

	@Column(name="dptName", nullable = true)
	public String getDptName() {
		return this.dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
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

	@Column(name="parentId", nullable = true, columnDefinition = "int default 0")
	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}