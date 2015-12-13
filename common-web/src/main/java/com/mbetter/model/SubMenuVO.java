package com.mbetter.model;

public class SubMenuVO {
	private long id;
	private String menuName;
	private Boolean add;
	private Boolean view;
	private Boolean update;
	private Integer menuIndex;
	private Boolean isPageRedirect;

	public Boolean getUpdate() {
		return update;
	}

	public void setUpdate(Boolean update) {
		this.update = update;
	}

	private String redirectPageName;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
