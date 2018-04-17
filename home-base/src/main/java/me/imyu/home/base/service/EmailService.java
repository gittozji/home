package me.imyu.home.base.service;

/**
 * 邮件发送
 * Created by imyu on 2018-04-17.
 */
public interface EmailService {
    void send(String to, String subject, String Content);
}
