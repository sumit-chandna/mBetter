package com.mbetter.domain.employee.department;

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
@Table(name="GENMST_DEPARTMENT")
@NamedQueries(value={
	@NamedQuery(name="EmployeeDepartment.getAllDepartments", query="select e from EmployeeDepartment e where e.isActive ='y' and (e.startDate > current_date or e.startDate is null) and (e.endDate < current_date or e.endDate is null) ")
})
public class EmployeeDepartment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8953999509932007876L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="NUM_DEPT_CD")
	private Integer id;
	
	@Column(name="TXT_DEPT_NAME", nullable=false)
	private String departmentName;
	
	@Column(name="TABINDX", nullable=false)
	private Integer tabIndex;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(Integer tabIndex) {
		this.tabIndex = tabIndex;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
