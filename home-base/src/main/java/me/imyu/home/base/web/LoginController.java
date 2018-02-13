package me.imyu.home.base.web;

import me.imyu.home.base.model.dto.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by imyu on 2018-02-13.
 */
@RestController
public class LoginController {
    @RequestMapping("/base/login")
    public ResultBean login() {
        int i = 1/0;
        return new ResultBean();
    }
}
