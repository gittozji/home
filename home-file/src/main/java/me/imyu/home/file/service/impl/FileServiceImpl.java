package me.imyu.home.file.service.impl;

import me.imyu.home.file.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * Created by imyu on 2018-03-30.
 */
@Service
public class FileServiceImpl implements FileService {
    @Value("${file.storage}")
    String storage;
    @Override
    public void upload(String fileName, InputStream in) {

    }
}
