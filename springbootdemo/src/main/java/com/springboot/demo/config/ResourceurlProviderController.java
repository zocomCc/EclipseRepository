package com.springboot.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

/**
 * 
 * @ClassName: ResourceurlProviderController 
 * @Description: 处理静态资源URL
 * @author cjc
 * @date 2018年5月31日 下午2:34:32
 */
@ControllerAdvice
public class ResourceurlProviderController {

    @Autowired
    private ResourceUrlProvider resourceUrlProvider;
    
    @ModelAttribute("urls")
    public ResourceUrlProvider urls() {
        return this.resourceUrlProvider;
    }
}
