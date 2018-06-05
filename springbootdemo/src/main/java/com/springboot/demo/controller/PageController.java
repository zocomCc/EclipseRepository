package com.springboot.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    private static final Logger log = LoggerFactory.getLogger(PageController.class);
    
    @Value("${application.hello:Hello Shansy}")
    private String hello = "Hello Shansy";
    
    /**
     * 默认页<br/>
     * @RequestMapping("/") 和 @RequestMapping 是有区别的
     * 如果不写参数，则为全局默认页，加入输入404页面，也会自动访问到这个页面。
     * 如果加了参数“/”，则只认为是根页面。
     *
     * @return
     * @author SHANHY
     * @create  2016年1月5日
     */
    @RequestMapping(value = {"/","/index"})
    public String index(Map<String, Object> model){
        // 直接返回字符串，框架默认会去 spring.mvc.view.prefix 目录下的 （index拼接spring.mvc.view.suffix）页面
        // 本例为 /WEB-INF/jsp/index.jsp
        log.info("logback 访问index");
        log.error("logback 访问INDEX");
        log.debug("logback 访问index");
        model.put("time", new Date());
        model.put("message", this.hello);
        return "index";
    }
    
    @RequestMapping("/page1")
    public ModelAndView page1() {
        // 页面位置 /WEB-INF/jsp/page/page.jsp
        ModelAndView mv = new ModelAndView("page/page1");
        mv.addObject("content", hello);
        return mv;
    }
    
    /**
     * 响应到JSP页面page1（可以直接使用Model封装内容，直接返回页面字符串）
     *
     *
     */
    @RequestMapping("/page2")
    public String page2(Model model){
        // 页面位置 /WEB-INF/jsp/page/page.jsp
        model.addAttribute("content", hello + "（第二种）");
        return "page/page1";
    }
    
    /**
     * 
     * <p>Title: thymeleaf</p>
     * @author cjc
     * @date 2018年6月5日 上午8:37:46
     * @return String
     * <p>Description: thymeleaf 模板</p>
     * @param map
     * @return
     */
    @RequestMapping("/thymeleaf")
    public String thymeleaf(ModelMap map) {
        log.info("thymeleaf 模板测试");
        List<Map<String, Object>> li = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Map<String, Object> maps = new HashMap<>();
            maps.put("name", "milk" + i);
            maps.put("price", 2.35D + i);
            maps.put("inStock", i % 2 == 0 ? "yes" : "no");
            li.add(maps);
        }
        map.addAttribute("ls", li);
        map.addAttribute("host", "qq.com");
        return "thymeleaf/thymeleaf1";
    }
}
