package com.mbetter.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_MASTER")
public class MenuMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MENU_ID")
	private Long menuId;
	@Column(name = "MENU_NAME")
	private String menuName;
	@Column(name = "MENU_INDEX")
	private Integer menuIndex;
	@Column(name = "IS_PAGE_REDIRECT")
	private Boolean isPageRedirect;
	@Column(name = "REDIRECT_PAGE")
	private String redirectPageName;
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
	@OneToMany(mappedBy = "menuMaster", fetch = FetchType.EAGER)
	private List<SubMenuMaster> subMenus = new ArrayList<SubMenuMaster>();

	public List<SubMenuMaster> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenuMaster> subMenus) {
		this.subMenus = subMenus;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getMenuIndex() {
		return menuIndex;
	}

	public void setMenuIndex(Integer menuIndex) {
		this.menuIndex = menuIndex;
	}

	public Boolean isPageRedirect() {
		return isPageRedirect;
	}

	public void setPageRedirect(Boolean isPageRedirect) {
		this.isPageRedirect = isPageRedirect;
	}

	public String getRedirectPageName() {
		return redirectPageName;
	}

	public void setRedirectPageName(String redirectPageName) {
		this.redirectPageName = redirectPageName;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
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

}
