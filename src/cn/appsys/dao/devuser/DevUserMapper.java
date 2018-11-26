package cn.appsys.dao.devuser;

import cn.appsys.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * User: XTP
 * Date: 2018/11/26
 * Time: 13:54
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface DevUserMapper {
    //根据devUser获取用户记录
    public DevUser getLoginUser (@Param("devCode") String devCode);

}