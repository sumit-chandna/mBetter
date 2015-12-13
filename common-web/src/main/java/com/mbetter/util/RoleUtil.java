package com.mbetter.util;

import java.util.ArrayList;
import java.util.List;

import com.mbetter.domain.MenuMaster;
import com.mbetter.domain.SubMenuMaster;
import com.mbetter.model.MenuVO;
import com.mbetter.model.SubMenuVO;

public class RoleUtil {
	public static List<String> getRoles() {
		List<String> roles = new ArrayList<String>();
		roles.add("doctor");
		roles.add("admin");
		roles.add("reception");
		roles.add("lab");
		roles.add("pharmacy");
		return roles;
	}

	public static void populateMenuVO(MenuVO menuVO, MenuMaster master) {
		menuVO.setMenuName(master.getMenuName());
		menuVO.setId(master.getMenuId());
		menuVO.setIsPageRedirect(master.isPageRedirect());
		menuVO.setRedirectPageName(master.getRedirectPageName());
	}

	public static void populateSubMenuVO(SubMenuVO subMenuVO,
			SubMenuMaster subMenuMaster) {
		subMenuVO.setMenuName(subMenuMaster.getMenuName());
		subMenuVO.setId(subMenuMaster.getMenuId());
		subMenuVO.setIsPageRedirect(subMenuMaster.isPageRedirect());
		subMenuVO.setRedirectPageName(subMenuMaster.getRedirectPageName());
	}

}
