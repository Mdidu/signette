package com.signette.service;

import com.signette.domains.DataContratPdf;
import com.signette.repository.PostRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.*;

@Component
public class PDFService {

    @Autowired
    PostRepository postRepository;
    public String exportReport(long userId, long tripId) throws FileNotFoundException, JRException {
        System.out.println("0");
        List<Object[]> listPDFData = postRepository.findListPDFData(userId, tripId);
        DataContratPdf data = new DataContratPdf();
        listPDFData.forEach((obj) -> {

            data.setNameUser((String) obj[0]);
            data.setUserLastname((String) obj[1]);
            data.setUserMail((String) obj[2]);
            data.setUserPhone((String) obj[3]);
            data.setTripStartDate((Date) obj[5]);
            data.setTripEndDate((Date) obj[5]);
            data.setCenterName((String) obj[6]);
        });
        List<DataContratPdf> contrat = new ArrayList<>();
        contrat.add(data);

        String path = "C://JasperReports/";
        File file = ResourceUtils.getFile("classpath:contrat.jrxml");

        JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(contrat, false);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("client", "kjhgfd");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parameters, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "PDFContrat.pdf");

        return "path : " + path;
    }
}
