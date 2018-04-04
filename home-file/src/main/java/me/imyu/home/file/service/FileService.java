package me.imyu.home.file.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;

/**
 * Created by imyu on 2018-02-28.
 */
public interface FileService {
    String upload(CommonsMultipartFile file) throws IOException;
}
