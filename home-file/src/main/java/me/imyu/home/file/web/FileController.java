package me.imyu.home.file.web;

import me.imyu.home.base.model.dto.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by imyu on 2018-02-28.
 */
@RestController
public class FileController {
    @RequestMapping("/file/upload")
    public ResultBean upload(HttpServletRequest request) {

        return null;
    }
}
