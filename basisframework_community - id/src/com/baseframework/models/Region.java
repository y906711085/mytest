package com.baseframework.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="region")
public class Region extends com.baseframework.dao.BaseEntity  {
	private static final long serialVersionUID = 1L;

	private String address;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String name;

	private int parentId;

//	private List<AgingpopulationRegion> agingpopulations;
//
//	private List<Disabledbaseinfo> disabledbaseinfos;

	@Column(name="address", nullable = true)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@Column(name="name", nullable = true)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="parentid", nullable = false)
	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

//	@OneToMany(mappedBy = "region", cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY)
//	public List<AgingpopulationRegion> getAgingpopulations() {
//		return this.agingpopulations;
//	}
//
//	public void setAgingpopulations(List<AgingpopulationRegion> agingpopulations) {
//		this.agingpopulations = agingpopulations;
//	}
//
//	@OneToMany(mappedBy = "region", cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY)
//	public List<Disabledbaseinfo> getDisabledbaseinfos() {
//		return this.disabledbaseinfos;
//	}
//
//	public void setDisabledbaseinfos(List<Disabledbaseinfo> disabledbaseinfos) {
//		this.disabledbaseinfos = disabledbaseinfos;
//	}

}