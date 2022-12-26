package nbd.member.controller;


import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

    public String sendMail(String email) {

        boolean result = false;

        Random r = new Random();
        StringBuilder sb = new StringBuilder(); // String 배열

        // 0~3
        // 0: 숫자 1: 영어대문자 2: 영어소문자
        for (int i = 0; i < 8; i++) {
            int flag = r.nextInt(3);

            if (flag == 0) {
                // 랜덤숫자
                int ranNum = r.nextInt(10);
                sb.append(ranNum);
            } else if (flag == 1) {
                // 영어 소문자
                char ranSmall = (char) (r.nextInt(26) + 65);
                sb.append(ranSmall);
            } else if (flag == 2) {
                // 영어 대문자
                char ranBig = (char) (r.nextInt(26) + 97);
                sb.append(ranBig);
            }
        }

        Properties prop = System.getProperties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465); // 포트설정
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.starttls.required", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // 인증정보설정(로그인) javax.mail-Session
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() { // 구글 아이디 패스워드
                PasswordAuthentication pa =
                        new PasswordAuthentication("bomkh123", "oplntjofdzxwuvaf");
                return pa;// 여기까지가 구글에서 로그인 한 시점
            }
        });

        // 메세지를 전송하는 객체
        MimeMessage msg = new MimeMessage(session);
        try {
            // 이메일 작성
            msg.setSentDate(new Date());
            // 보내는 사람 정보
            msg.setFrom(new InternetAddress("bomkh123@gmail.com", "nearByDoctor를 방문해주셔서 감사합니다."));
            // 받는 사람 정보 객체(email)
            InternetAddress to = new InternetAddress(email);
            msg.setRecipient(Message.RecipientType.TO, to);

            // 이메일 제목 설정
            msg.setSubject("nearByDoctor 인증메일 입니다.", "UTF-8");

            // 이메일 문구
            msg.setContent("<h1>안녕하세요. nearByDoctor입니다.</h1>"
                    + "<h3>인증번호는 [<span style='color:red'>" + sb.toString() + "</span>] 입니다.",
                    "text/html;charset=utf-8");

            // 이메일 전송
            Transport.send(msg);
            result = true;

        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (result) {
            return sb.toString();
        } else {
            return null;
        }

    }

}


