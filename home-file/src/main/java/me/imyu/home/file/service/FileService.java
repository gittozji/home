package me.imyu.home.file.service;

import java.io.InputStream;

/**
 * Created by imyu on 2018-02-28.
 */
public interface FileService {
    void upload(String fileName, InputStream in);
}
