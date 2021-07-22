package com.signette.controllers;

import com.itextpdf.text.DocumentException;
import com.signette.domains.Document;
import com.signette.service.DocumentService;
import com.signette.signature.SignatureExternalHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    DocumentService documentService;
    @Autowired
    SignatureExternalHash signature;

    @GetMapping("/sign/{id}")
    public void sign(@PathVariable long id) throws GeneralSecurityException, DocumentException, IOException {
        signature.signPdfDetached(documentService.findById(id).getDocumentLink(), "Sign" + documentService.findById(id).getDocumentName());
    }

    @GetMapping("/read")
    public List<Document> read() {
        return documentService.findAll();
    }

    @GetMapping("/read/{id}")
    public Document readById(@PathVariable long id) {
        return documentService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Document document) {
        documentService.add(document);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable long id, @RequestBody Document document) {
        document.setDocumentId(id);
        documentService.update(document);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        documentService.delete(documentService.findById(id));
    }

    @GetMapping("/read/user/{id}")
    public List<Document> readByUser(@PathVariable long id) {
        return documentService.findDocumentByUser(id);
    }

    @GetMapping("/read/trip/{id}")
    public List<Document> readByTrip(@PathVariable long id) {
        return documentService.findDocumentByTrip(id);
    }
}
