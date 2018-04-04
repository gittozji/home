package me.imyu.home.file.web;

import me.imyu.home.base.model.dto.ResultBean;
import me.imyu.home.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;

/**
 * Created by imyu on 2018-02-28.
 */
@RestController
public class FileController {
    @Autowired
    FileService fileService;

    @RequestMapping("/file/upload")
    public ResultBean uploadS(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        return new ResultBean(fileService.upload(file));
    }
}
