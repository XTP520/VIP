package cn.appsys.controller.developer;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;
import cn.appsys.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: XTP
 * Date: 2018/11/26
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Controller
@RequestMapping(value = "/dev")
public class DevUserController {
    @Resource
    private DevUserService service;
    private Logger logger = Logger.getLogger(DevUserController.class);
    @RequestMapping(value = "/login")
    public String login(){
        logger.debug("Controller===================>");
        return "devlogin";
    }
    //
    @RequestMapping(value = "/dologin")
    public String dologin(@RequestParam String devCode,
                          @RequestParam String devpassword,
                          HttpSession session,
                          HttpServletRequest servletRequest){
        logger.debug("dologin===================>");
        DevUser user = null;
        //调用Service方法，用户匹配
        user = service.login(devCode ,devpassword);
        if (null != user){
            //放入session
            session.setAttribute(Constants.DEV_USER_SESSION,user);
            //页面跳转main.jsp,提示信息
            return "redirect:/dev/flatform/main";
        }else {
            //保留在devlogin页面
            servletRequest.setAttribute("error","用户名或密码不正确");
            return "devlogin";
        }
    }

    @RequestMapping(value = "/flatform/main")
    public String main(HttpSession session){
        if(session.getAttribute(Constants.DEV_USER_SESSION) == null){
            return "redirect:/dev/login";
        }
        return "developer/main";
    }
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        //清除session
        session.removeAttribute(Constants.DEV_USER_SESSION);
        return "devlogin";
    }
}