package com.matrix.load;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.matrix.annotation.Inject;
import com.matrix.base.BaseClass;
import com.matrix.base.interfaces.ILoadCache;
import com.matrix.cache.CacheLaunch;
import com.matrix.cache.enums.DCacheEnum;
import com.matrix.cache.inf.IBaseLaunch;
import com.matrix.cache.inf.ICacheFactory;
import com.matrix.dao.IMcUserInfoMapper;
import com.matrix.dao.IMcUserInfoOrganizationMapper;
import com.matrix.pojo.entity.McUserInfo;
import com.matrix.pojo.entity.McUserInfoOrganization;
import com.matrix.pojo.view.McUserInfoView;
/**
 * @description: 如果缓存取值为空则此处做处理
 * key: user_name + "," + password（md5加密后的密码）|特殊处理，中间有逗号
 * value: 
	 {
	    "id": 1,
	    "userName": "admin",
	    "password": "63a9f0ea7bb98050796b649e85481845",
	    "createTime": 1491362113000, 
	    "platform": "P01",
	    "sex": 1,
	    "picUrl": "",
	    "remark": "admin edit this user",
	    "idcard": "4677",
	    "flag": 2,
	    "email": "root@pm.com",
	    "pageCss": "",
	    "mobile": "13511112221",
	    "orgidList":[
	    	23948127349182348,
	    	12394109751029349
	    ]
	}
 * @author Yangcl
 * @home https://github.com/PowerYangcl
 * @date 2017年11月20日 下午10:09:18 
 * @version 1.0.0.1
 */
public class InitUserInfoNp extends BaseClass implements ILoadCache<String> {
	private IBaseLaunch<ICacheFactory> launch = CacheLaunch.getInstance().Launch();
	
	@Inject
	private IMcUserInfoMapper mcUserInfoMapper;
	@Inject
	private IMcUserInfoOrganizationMapper mcUserInfoOrganizationMapper;
	
	@Override
	public String load(String key, String field) {			// key 这里做特殊处理|user_name + "," + password（md5加密后的密码）|中间有逗号
		McUserInfo e = new McUserInfo();
		e.setUserName(key.split(",")[0]);
		e.setPassword(key.split(",")[1]);
		McUserInfoView view = mcUserInfoMapper.login(e);
		if(view != null) {	
			if(view.getType().equals("user")) {	// 取出关联的用户数据权限信息
				McUserInfoOrganization org = new McUserInfoOrganization();
				org.setMcUserInfoId(view.getId());
				List<McUserInfoOrganization> list = mcUserInfoOrganizationMapper.findList(org );
				if(list != null && list.size() !=0) {
					List<Long> orgidList = new ArrayList<Long>(list.size());
					for(McUserInfoOrganization o : list) {
						orgidList.add(o.getMcOrganizationId());
					}
					view.setOrgidList(orgidList);
				}
			}
			
			String value = JSONObject.toJSONString(view);
			launch.loadDictCache(DCacheEnum.UserInfoNp , null).set(e.getUserName() + "," + e.getPassword() , value , 30*24*60*60);
			return value;
		}
		return "";
	}

}



























