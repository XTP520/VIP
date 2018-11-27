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
        //����Service�������û�ƥ��
        user = service.login(devCode ,devpassword);
        if (null != user){
            //����session
            session.setAttribute(Constants.DEV_USER_SESSION,user);
            //ҳ����תmain.jsp,��ʾ��Ϣ
            return "redirect:/dev/flatform/main";
        }else {
            //������devloginҳ��
            servletRequest.setAttribute("error","�û��������벻��ȷ");
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
        //���session
        session.removeAttribute(Constants.DEV_USER_SESSION);
        return "devlogin";
    }
}