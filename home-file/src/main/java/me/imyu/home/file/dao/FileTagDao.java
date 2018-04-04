package me.imyu.home.file.dao;

import me.imyu.home.file.model.File;
import me.imyu.home.file.model.FileTag;
import me.imyu.home.file.model.Tag;

/**
 * 文件、标签 DAO
 * Created by imyu on 2018-04-04.
 */
public interface FileTagDao {
    void insertFile(File file);

    void insertTag(Tag tag);

    void insertFileTag(FileTag fileTag);
}
