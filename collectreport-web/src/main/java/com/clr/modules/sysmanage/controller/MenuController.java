
package com.clr.modules.sysmanage.controller;

import com.clr.common.utils.R;
import com.clr.modules.sysmanage.entity.bo.MenuBO;
import com.clr.modules.sysmanage.service.IUserBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统菜单
 */
@RestController
@RequestMapping("/sys/menu")
public class MenuController {
	@Autowired
	private IUserBizService userBizService;
	/**
	 * 导航菜单
	 */
	@RequestMapping("/nav")
	public R nav(){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userID",1);
		List<MenuBO> sysMenuPOS = userBizService.listMenuByCondition(params);
		List<MenuBO> ulist = new ArrayList<>();
		List<MenuBO> list = new ArrayList<>();
		for (MenuBO pos:sysMenuPOS) {
			if(pos.getParentId() == 1){
				list.add(pos);
			}
			if(pos.getMenuId() == 1){
				ulist.add(pos);
			}
		}

		for (MenuBO po:ulist) {
			po.setList(list);
		}


		return R.ok().put("menuList",ulist);
	}

}
