package com.mbetter.domain.dropdown;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="GENMST_DROPDOWN")
@NamedQueries(value = {
		@NamedQuery(name="DropDown.getAllDropDownValues", query="select d from DropDown d where d.isActive ='y' and (d.startDate > current_date or d.startDate is null) and (d.endDate < current_date or d.endDate is null)  and d.dropDownType = :dropDownType order by d.dropDownText ")
})
public class DropDown implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8953999509932007234L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="DROPDOWN_ID")
	private Integer dropDownId;
	
	@Column(name="DROPDOWN_TYPE", nullable=false)
	private String dropDownType;
	
	@Column(name="DROPDOWN_TEXT", nullable=false)
	private String dropDownText;
	
	@Column(name="DROPDOWN_VALUE", nullable=false)
	private String dropDownValue;
	
	@Column(name="DAT_START_DATE")
	private Date startDate;
	
	@Column(name="DAT_END_DATE")
	private Date endDate;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@Column(name="NUM_INSERT_ID")
	private Integer numInserId;
	
	@Column(name="DAT_INSERT_DATE")
	private Date insertDate;
	
	@Column(name="NUM_MODIFY_ID")
	private Integer modifyId;
	
	@Column(name="DAT_MODIFY_DATE")
	private Date modifyDate;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	public Integer getDropDownId() {
		return dropDownId;
	}

	public void setDropDownId(Integer dropDownId) {
		this.dropDownId = dropDownId;
	}

	public String getDropDownType() {
		return dropDownType;
	}

	public void setDropDownType(String dropDownType) {
		this.dropDownType = dropDownType;
	}

	public String getDropDownText() {
		return dropDownText;
	}

	public void setDropDownText(String dropDownText) {
		this.dropDownText = dropDownText;
	}

	public String getDropDownValue() {
		return dropDownValue;
	}

	public void setDropDownValue(String dropDownValue) {
		this.dropDownValue = dropDownValue;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Integer getNumInserId() {
		return numInserId;
	}

	public void setNumInserId(Integer numInserId) {
		this.numInserId = numInserId;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Integer getModifyId() {
		return modifyId;
	}

	public void setModifyId(Integer modifyId) {
		this.modifyId = modifyId;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	@Override
	public String toString(){
		return dropDownValue.concat(dropDownText);
	}
	
}
