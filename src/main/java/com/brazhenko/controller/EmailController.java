package com.brazhenko.controller;

import com.brazhenko.dao.TicketsDAOImpl;
import com.brazhenko.dao.daoInterface.TicketsDAO;
import com.brazhenko.entity.Tickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 02.08.2015.
 */
@Controller
@RequestMapping("/send")
public class EmailController {

    static final String ENCODING = "UTF-8";
    Tickets ticket = new Tickets();

    @Autowired
    TicketsDAO ticketsDAO=new TicketsDAOImpl();

    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    public String sendmail(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        String email = request.getParameter("email");
        Long ticketId = Long.valueOf(request.getParameter("ticket"));
        ticket= ticketsDAO.getTicketsById(ticketId);
        final String username = "fandango.ua@gmail.com";
        final String password = "hex4idip";
        Properties props = new Properties();
        props.put("mail.mime.charset", ENCODING);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("fandango.ua@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Fandango билет #" + ticket.getTicketId());
            message.setText("Fandango! " + "\n"
                    + "Ваш билет # " + ticket.getTicketId()+ "\n"
                    + "Фильм: " + ticket.getSchedule().getMovie().getName() + "\n"
                    + "Кинотеатр: " + ticket.getSchedule().getCinema().getName() + "\n"
                    + "Количество билетов: " + ticket.getTicketQuantity());
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    return "hello";
    }
}
