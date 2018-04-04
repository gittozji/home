package me.imyu.home.file.service.impl;

import me.imyu.home.base.service.ServiceException;
import me.imyu.home.base.util.UserBinder;
import me.imyu.home.file.dao.FileTagDao;
import me.imyu.home.file.service.FileService;
import me.imyu.home.file.util.CodeGenerator;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by imyu on 2018-03-30.
 */
@Service
public class FileServiceImpl implements FileService {
    private static Log LOGGER = LogFactory.getLog(FileServiceImpl.class);
    @Value("${file.storage}")
    private String storage;
    @Autowired
    FileTagDao fileTagDao;

    @Override
    public String upload(CommonsMultipartFile file) throws IOException {

        if (file.isEmpty()) {
            LOGGER.error("文件为空");
            throw new ServiceException("文件不能为空");
        }

        FileItem item = file.getFileItem();
        String name = item.getName();
        String type = getType(name);
        String uuid = CodeGenerator.get();
        LOGGER.debug(String.format("文件属性：storage[%s], name[%s], type[%s], uuid[%s]",storage, name, type, uuid));

        File dest = new File(storage, getDestName(uuid, type));
        file.transferTo(dest);

        persistFile(uuid, type, name, UserBinder.get().getId());

        return uuid;
    }

    // 文件数据入库
    private void persistFile(String uuid, String type, String name, Long userId) {
        me.imyu.home.file.model.File file = new me.imyu.home.file.model.File();
        file.setUserId(userId);
        file.setUuid(uuid);
        file.setType(type);
        file.setName(name);
        file.setLevel(0);
        fileTagDao.insertFile(file);
    }

    private String getDestName(String uuid, String type) {
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
