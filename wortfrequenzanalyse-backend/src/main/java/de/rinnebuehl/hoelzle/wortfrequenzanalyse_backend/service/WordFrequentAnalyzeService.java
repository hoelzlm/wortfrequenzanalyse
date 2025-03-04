package de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.service;

import de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.model.Wortfrequenz;
import de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.repository.DatabaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class WordFrequentAnalyzeService {

    @Autowired
    DatabaseRepository repository;

    private static final Logger log = LoggerFactory.getLogger(WordFrequentAnalyzeService.class);

    /**
     * Adds time to fileName to generate unique fileName on Database
     * @param fileName original fileName
     * @return new fileName with date (splittable by _)
     */
    private String generateUniqueFileName(String fileName) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedNow = now.format(formatter);

        return String.format("%s_%s", formattedNow, fileName);
    }

    /**
     * converts map to Wortfrequenz objects and stores them into database
     * @param result output of analyzeFile func
     * @param fileName to identify which word maps to which file on Database level
     */
    private void storeWortfrequenz(Map<String, Integer> result, String fileName) {
        List<Wortfrequenz> wfList = new ArrayList<>();

        result.forEach((word, count)-> {
            wfList.add(new Wortfrequenz(fileName, word, count));
        });

        repository.saveAll(wfList);
    }

    /**
     * Returns result of word frequency analyze for a given file name from database
     *
     * @param fileName filename of a previously analyzed file
     * @return List of Database entries ordered by count
     */
    public List<Wortfrequenz> getAnalyzeByFileName(String fileName) {
        List<Wortfrequenz> wf = repository.findTop10ByFileNameOrderByCountDesc(fileName);
        return wf;
    }

    /**
     * Analyzes given text file and calculates how often a word is in that file. Stores the result in the database
     * @param file a plain text file
     * @return returns fileName for later use
     * @throws IOException is thrown when it is not possible to convert the content of the file to string
     */
    public String analyzeFile(MultipartFile file) throws IOException{
        String fileName = this.generateUniqueFileName(file.getOriginalFilename());
        Map<String, Integer> resultMap = new HashMap<>();

        byte[] contentBytes = file.getBytes();
        String content = new String(contentBytes, StandardCharsets.UTF_8);

        // split text into single words
        String[] tokens = content.split("\\s");

        // count the tokens
        for (String token : tokens) {
            token = token.toLowerCase().replaceAll("[^a-z]", "");
            resultMap.put(token, resultMap.getOrDefault(token, 0) +1);
        }

        //store tokens as new wortfrequenz object
        this.storeWortfrequenz(resultMap, fileName);
        return fileName;
    }

}
