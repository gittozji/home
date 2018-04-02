package me.imyu.home.file.service;

import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by imyu on 2018-02-28.
 */
public interface FileService {
    String upload(HttpServletRequest request) throws Exception;
}
