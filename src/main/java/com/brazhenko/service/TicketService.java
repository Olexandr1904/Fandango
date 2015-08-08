package com.brazhenko.service;

import com.brazhenko.dao.TicketsDAOImpl;
import com.brazhenko.entity.Schedule;
import com.brazhenko.entity.Tickets;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Admin on 24.07.2015.
 */

@Service
public class TicketService {

    @Autowired
    private TicketsDAOImpl ticketDAO;

    public Long addTicket (Tickets ticket){
        Long id = ticketDAO.addTickets(ticket);
        return id;
    }

    public List<Tickets> getTicket(){
        List ticketId= ticketDAO.getTickets();
        return ticketId;
    }

    public Tickets getTicketById(Long id){
        Tickets ticketr = ticketDAO.getTicketsById(id);
        return ticketr;
    }

    public void updateTicket(Tickets tickets){
        ticketDAO.updateTickets(tickets);
    }

    public void deleteTicket(Tickets tickets){
        ticketDAO.deleteTickets(tickets);
    }

    //qr code generate method
    public void createQrCode (Schedule schedule){
        String myCodeText = ("Билет # "+ " \nвремя сеанса: "+ schedule.getTime().getTime().getDay() + "." + schedule.getTime().getTime().getMonth() + "."  + schedule.getTime().getTime().getYear() + "  " +schedule.getTime().getTime().getHours() + ":" + schedule.getTime().getTime().getMinutes() +
                " Фильм: " + schedule.getMovie().getName() + " кинотеатр: " + schedule.getCinema().getName() + " адрес: " + schedule.getCinema().getAdresses());
        String filePath = "/Users/admin/Google/projects/Fandango/src/main/webapp/qrc.png";
        int size = 250;
        String fileType = "png";
        File myFile = new File(filePath);
        try {
            Hashtable hintMap = new Hashtable();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hintMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
            int CrunchifyWidth = byteMatrix.getWidth();
            BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
                    BufferedImage.TYPE_INT_RGB);
            image.createGraphics();

            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < CrunchifyWidth; i++) {
                for (int j = 0; j < CrunchifyWidth; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            ImageIO.write(image, fileType, myFile);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
