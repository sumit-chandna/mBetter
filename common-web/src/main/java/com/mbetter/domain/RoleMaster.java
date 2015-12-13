package com.mbetter.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE_MASTER")
@NamedQueries(value = {
		@NamedQuery(name = "RoleMaster.getAllRolesByDepartment", query = "select r from RoleMaster r where r.userRole=:department and r.isActive=true"),
		@NamedQuery(name = "RoleMaster.getRoleMasterForMenuAndSubMenu", query = "select r from RoleMaster r where r.menu=:menu and r.subMenu=:submenu and r.userRole=:department"),
		@NamedQuery(name = "RoleMaster.getRoleMasterForMenuAndNoSubMenu", query = "select r from RoleMaster r where r.menu=:menu and r.userRole=:department"),
		@NamedQuery(name = "RoleMaster.getDistinctRoles", query = "select distinct r.userRole from RoleMaster r") })
public class RoleMaster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROLE_ID")
	private Long roleId;
	@Column(name = "USER_ROLE")
	private String userRole;
	@OneToOne
	@JoinColumn(name = "MENU_ID")
	private MenuMaster menu;
	@Column(name = "MENU_INDEX")
	private Integer menuIndx;
	@OneToOne
	@JoinColumn(name = "SUB_MENU_ID")
	private SubMenuMaster subMenu;
	@Column(name = "SUB_MENU_INDEX")
	private Integer subMenuIndx;
	@Column(name = "ACTIVE")
	private Boolean isActive;
	@Column(name = "INSERT_ID")
	private Long insertId;
	@Column(name = "INSERT_DATE")
	private Date insertDate;
	@Column(name = "MODIFY_ID")
	private Long modifyId;
	@Column(name = "MODIFY_DATE")
	private Date modifyDate;
	@Column(name = "MODIFY_BY")
	private Long modifyBy;
	@Column(name = "OPTIONS")
	private String options;

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Integer getMenuIndx() {
		return menuIndx;
	}

	public void setMenuIndx(Integer menuIndx) {
		this.menuIndx = menuIndx;
	}

	public Integer getSubMenuIndx() {
		return subMenuIndx;
	}

	public void setSubMenuIndx(Integer subMenuIndx) {
		this.subMenuIndx = subMenuIndx;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getInsertId() {
		return insertId;
	}

	public void setInsertId(Long insertId) {
		this.insertId = insertId;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Long getModifyId() {
		return modifyId;
	}

	public void setModifyId(Long modifyId) {
		this.modifyId = modifyId;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public MenuMaster getMenu() {
		return menu;
	}

	public void setMenu(MenuMaster menu) {
		this.menu = menu;
	}

	public SubMenuMaster getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(SubMenuMaster subMenu) {
		this.subMenu = subMenu;
	}

}
