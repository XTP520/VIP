package cn.appsys.service.developer;

import cn.appsys.pojo.DevUser;

/**
 * Created with IntelliJ IDEA.
 * User: XTP
 * Date: 2018/11/26
 * Time: 14:09
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface DevUserService {
    //µÇÂ¼ÑéÖ¤
    public DevUser login (String devCode,String password);
}