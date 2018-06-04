package com.springboot.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping
    public String index() {
        return "hello Spring boot";
    }
    
    @RequestMapping(value = "/info")
    public Map<String, String> getInfo(@RequestParam String name) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return map;
    }
    
    @RequestMapping(value = "/list")
    public List<Map<String, String>> getList() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = null;
        for (int i = 1; i < 6; i++) {
            map = new HashMap<>();
            map.put("name", "share-" + i);
            list.add(map);
        }
        return list;
    }
    
    @RequestMapping("/hi")
    public String sayHi() {
        return "Hi ~~~~~~~";
    }
    public void testdiff() {}
    public void testdiff2() {}
<<<<<<< HEAD
    public void testdiff3() {}
=======
    public void testdiff4() {}
>>>>>>> 89bf3eb91d76f9c905644a516802ba93201be327
}
