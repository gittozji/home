package me.imyu.home.model.dto;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * 统一返回对象
 *
 * 参考自：https://zhuanlan.zhihu.com/p/28717374
 *
 * Created by imyu on 2017-12-19.
 */
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     * 注：约定非零即失败
     */
    public static final int SUCCESS = 0;

    /**
     * 普通失败
     */
    public static final int FAIL = 1;

    /**
     * 未知的错误信息
     */
    private static final String UNKNOWN_INFO = "未知的错误";
    private static final String SUCCESS_INFO = "请求成功";

    private String info = SUCCESS_INFO;

    private int status = SUCCESS;

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(Throwable e) {
        super();
        this.info = StringUtils.isEmpty(e.getMessage()) ? UNKNOWN_INFO : e.getMessage();
        this.status = FAIL;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setInfoWhitStatus(String info, int status) {
        setInfo(info);
        setStatus(status);
    }

    public void setException(Throwable e) {
        this.info = StringUtils.isEmpty(e.getMessage()) ? UNKNOWN_INFO : e.getMessage();
        this.status = FAIL;
    }
}
