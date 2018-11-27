package cn.appsys.controller.developer;

import cn.appsys.service.developer.DevUserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
        return "index";
    }
}