package com.smile.admin.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gaowenjin
 * @date 2021/1/6
 * @description:
 */
@Controller
public class IndexController {

    @RequestMapping("index")
    public String index() {
        return "index";
    }

}
