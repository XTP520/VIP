package cn.appsys.dao.devuser;

import cn.appsys.pojo.DevUser;

/**
 * Created with IntelliJ IDEA.
 * User: XTP
 * Date: 2018/11/26
 * Time: 13:54
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface DevUserMapper {
    //����devUser��ȡ�û���¼
    public DevUser getLoginUser (String devCode);

}