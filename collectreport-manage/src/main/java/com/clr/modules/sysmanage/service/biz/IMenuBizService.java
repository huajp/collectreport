
package com.clr.modules.sysmanage.service.biz;

import com.clr.modules.sysmanage.entity.bo.MenuBO;
import com.clr.modules.sysmanage.entity.po.MenuPO;

import java.util.List;
import java.util.Map;


/**
 * 系统菜单
 */
public interface IMenuBizService {

	public List<MenuBO> listMenuByCondition(Map<String,Object> params);

}
