package me.imyu.home.base.service.impl;

import me.imyu.home.base.service.EmailService;
import me.imyu.home.base.util.SAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by imyu on 2018-04-17.
 */
@Service
public class EmailServiceImpl implements EmailService {
    private final static String SPLIT_MARK = ";";
    @Autowired
    JavaMailSender sender;
    @Value("${mail.username}")
    String username;
    @Override
    public void send(String to, String subject, String content) {
        SAssert.hasLength(to, "收件人不能为空");

        // 不知为何不能直接设置多个发件人
        for (String item : to.split(SPLIT_MARK)) {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom(username);
            mail.setTo(item);
            mail.setSubject(subject);
            mail.setText(content);
            sender.send(mail);
        }
    }
}
