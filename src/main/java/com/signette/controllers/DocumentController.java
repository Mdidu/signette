package com.signette.controllers;

import com.signette.domains.Document;
import com.signette.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    DocumentService documentService;

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
}
