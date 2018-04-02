package me.imyu.home.file.service.impl;

import me.imyu.home.base.service.ServiceException;
import me.imyu.home.file.service.FileService;
import me.imyu.home.file.util.CodeGenerator;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by imyu on 2018-03-30.
 */
@Service
public class FileServiceImpl implements FileService {
    private static Log LOGGER = LogFactory.getLog(FileServiceImpl.class);
    @Value("${file.storage}")
    String storage;
    @Override
    public String upload(HttpServletRequest request) throws Exception {
        if (ServletFileUpload.isMultipartContent(request)){
            LOGGER.error("不是文件上传请求");
            throw new ServiceException("不是文件上传请求");
        }

        DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);

        List<FileItem> list = upload.parseRequest(request);

        if (CollectionUtils.isEmpty(list)) {
            LOGGER.error("没有选择文件上传");
            throw new ServiceException("没有选择文件上传");
        }

        if (list.size() > 1) {
            LOGGER.error("只支持单个文件上传");
            throw new ServiceException("只支持单个文件上传");
        }

        FileItem item = list.get(0);

        String name = item.getName();
        String type = getType(name);
        String uuid = CodeGenerator.get();

        File file = new File(storage, uuid + "." + type);
        item.write(file);
        item.delete();


        return uuid;
    }

    private String getType(String name) {
        if (StringUtils.isEmpty(name)) {
            return "";
        }

        int index = name.lastIndexOf(".");
        if (index == -1) {
            return "";
        }

        if (index + 1 > name.length()) {
            return "";
        }

        return name.substring(index + 1);
    }
}
