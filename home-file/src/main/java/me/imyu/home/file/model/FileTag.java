package me.imyu.home.file.model;

import me.imyu.home.base.model.Id;

/**
 * 文件与标签关联实体
 * Created by imyu on 2018-04-04.
 */
public class FileTag extends Id {
    Long tagId;
    Long fileId;

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
}
