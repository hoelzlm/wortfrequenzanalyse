package de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.controller;

import de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.model.Wortfrequenz;
import de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.service.WordFrequentAnalyzeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    WordFrequentAnalyzeService wordFrequentAnalyzeService;

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/result")
    public List<Wortfrequenz> getAnalyse(@RequestParam(name = "fileName") String fileName) {
        return wordFrequentAnalyzeService.getAnalyzeByFileName(fileName);
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();

        try {
            this.wordFrequentAnalyzeService.analyzeFile(file);
            return "{\"status\": \"OK\", \"message\": \""+ fileName +" \"}";
        } catch (IOException e) {
            log.error(e.getMessage());
            return "{\"status\": \"ERROR\", \"message\": \"an error accured during reading of file.\"}";
        }
    }
}
