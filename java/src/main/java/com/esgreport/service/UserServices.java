package com.esgreport.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.esgreport.entity.User;
import com.esgreport.repository.UserRepository;

import net.bytebuddy.utility.RandomString;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class UserServices {
 
    @Autowired
    private UserRepository repo;
     
    @Autowired
    private PasswordEncoder passwordEncoder;
     
    @Autowired
    private JavaMailSender mailSender;
 
     
    public void register(User user, String siteURL)
            throws UnsupportedEncodingException, MessagingException {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
         
        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        user.setEnabled(false);
         
        repo.save(user);
         
        sendVerificationEmail(user, siteURL);
    }
    private void sendVerificationEmail(User user, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "Your email address";
        String senderName = "Your company name";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";
         
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
         
        content = content.replace("[[Email]]", user.getEmail());
        String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();
         
        content = content.replace("[[URL]]", verifyURL);
         
        helper.setText(content, true);
         
        mailSender.send(message);
         
    }
    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "D:\\j\\";
        List<User> user = repo.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:Users.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(user);
        Map<String, Object> parameters = new HashMap<>();
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\users.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\users.pdf");
        }

        return "report generated in path : " + path;
    }
         
}


