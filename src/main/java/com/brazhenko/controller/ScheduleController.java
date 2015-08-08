package com.brazhenko.controller;

import com.brazhenko.dao.CinemasDAOImpl;
import com.brazhenko.dao.MovieDAOImpl;
import com.brazhenko.dao.TicketsDAOImpl;
import com.brazhenko.dao.daoInterface.CinemasDao;
import com.brazhenko.dao.daoInterface.MovieDAO;
import com.brazhenko.dao.daoInterface.ScheduleDAO;
import com.brazhenko.dao.daoInterface.TicketsDAO;
import com.brazhenko.entity.Cinemas;
import com.brazhenko.entity.Movie;
import com.brazhenko.entity.Schedule;
import com.brazhenko.entity.Tickets;
import com.brazhenko.service.SchdeuleService;
import com.brazhenko.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Created by Admin on 30.07.2015.
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    SchdeuleService schdeuleService; ;

    @Autowired
    CinemasDao cinemasDao= new CinemasDAOImpl();

    @Autowired
    MovieDAO movieDAO = new MovieDAOImpl();

    @Autowired
    TicketsDAO ticketsDAO = new TicketsDAOImpl();

    @Autowired
    Tickets ticket = new Tickets();

    @Autowired
    Cinemas cinemas;

    @Autowired
    Movie movie;

    @Autowired
    Schedule schedule;

    @Autowired
    ScheduleDAO scheduleDAO;

    @Autowired
    SchdeuleService scheduleService;

    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/getAllSchedule", method = RequestMethod.GET)
    public String getAllCinemas (Model model){
        model.addAttribute("schedule", schdeuleService.getSchdeule());
    return "scheduleDisplay";
    }

    @RequestMapping(value = "/sellTicket", method = RequestMethod.POST)
    public String sellTicket(HttpServletRequest request, Model model) {
        Long scheduleId = Long.valueOf(request.getParameter("scheduleId"));
        schedule = scheduleDAO.getScheduleById(scheduleId);
        model.addAttribute("chooseschedule", schedule);
        ticketService.createQrCode(schedule);
//        ADd ticket)
        Integer tQuantity = Integer.valueOf(request.getParameter("ticketquantity"));
        int reqQuanitity= schedule.getFreePlace() - tQuantity;
        if (reqQuanitity > 0) {
            ticket.setTicketQuantity(tQuantity);
            ticket.setSchedule(schedule);
            ticketsDAO.addTickets(ticket);
            schedule.setFreePlace(schedule.getFreePlace() - ticket.getTicketQuantity());
            scheduleDAO.updateSchedule(schedule);
            model.addAttribute("ticket", ticket);
            return "finalDisplay";
        }
        model.addAttribute("reqQuantity",reqQuanitity);
        model.addAttribute("availableTickets",schedule.getFreePlace());
        return "hello";
    }
}
