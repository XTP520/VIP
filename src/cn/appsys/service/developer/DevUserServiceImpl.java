package cn.appsys.service.developer;

import cn.appsys.dao.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: XTP
 * Date: 2018/11/26
 * Time: 14:11
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class DevUserServiceImpl implements DevUserService {
    @Resource
    private DevUserMapper mapper;

    @Override
    public DevUser login(String devCode, String devPassword) {
        // TODO Auto-generated method stub
        DevUser user = null;
        try {
            user = mapper.getLoginUser(devCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //∆•≈‰√‹¬Î
        if (null != user) {
            if (!user.getDevPassword().equals(devPassword))
                user = null;
        }
        return user;

    }
}