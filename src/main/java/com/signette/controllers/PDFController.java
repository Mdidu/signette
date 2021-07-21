package com.signette.controllers;

import com.signette.service.PDFService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api")
public class PDFController {

    @Autowired
    PDFService pdfService;

    @GetMapping("/user/{userId}/trip/{tripId}")
    public String exportReport(@PathVariable("userId") long userId, @PathVariable("tripId") long tripId) throws FileNotFoundException, JRException {
        return pdfService.exportReport(userId, tripId);
    }
}
