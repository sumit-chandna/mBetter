package com.mbetter.model;

import java.util.ArrayList;
import java.util.List;

public class MenuVO {
	public MenuVO() {
		super();
	}

	public MenuVO(String menuName) {
		super();
		this.menuName = menuName;
	}

	private String menuName;
	private List<SubMenuVO> subMenus = new ArrayList<SubMenuVO>();
	private Boolean add;
	private Boolean view;
	private Boolean delete;
	private long id;
	private Integer menuIndex;
	private Boolean isPageRedirect;
	private String redirectPageName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<SubMenuVO> getSubMenus() {
		return subMenus;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setSubMenus(List<SubMenuVO> subMenus) {
		this.subMenus = subMenus;
	}

	public Boolean getAdd() {
		return add;
	}

	public void setAdd(Boolean add) {
		this.add = add;
	}

	public Boolean getView() {
		return view;
	}

	public void setView(Boolean view) {
		this.view = view;
	}

	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	public Integer getMenuIndex() {
		return menuIndex;
	}

	public void setMenuIndex(Integer menuIndex) {
		this.menuIndex = menuIndex;
	}

	public Boolean getIsPageRedirect() {
		return isPageRedirect;
	}

	public void setIsPageRedirect(Boolean isPageRedirect) {
		this.isPageRedirect = isPageRedirect;
	}

	public String getRedirectPageName() {
		return redirectPageName;
	}

	public void setRedirectPageName(String redirectPageName) {
		this.redirectPageName = redirectPageName;
	}

}
