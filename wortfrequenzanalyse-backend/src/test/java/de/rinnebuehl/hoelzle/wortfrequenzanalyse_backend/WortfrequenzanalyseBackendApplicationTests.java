package de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend;

import de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.controller.ApiController;
import de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.model.Wortfrequenz;
import de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.service.WordFrequentAnalyzeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WortfrequenzanalyseBackendApplicationTests {

    @Autowired
    private ApiController controller;

    @Autowired
    private WordFrequentAnalyzeService wfaService;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void analyzeFileTest() throws Exception{

        String fileName = "test.txt";
        String content = "This is a test. This test is executed during test of the app";

        MockMultipartFile testFile = new MockMultipartFile("file", fileName, MediaType.TEXT_PLAIN_VALUE, content.getBytes());
        String newFileName = wfaService.analyzeFile(testFile);

        // test if fileName is generated
        String testFileName = newFileName.split("_")[1];
        assertThat(fileName).isEqualTo(testFileName);

        // test if something is written to the database
        List<Wortfrequenz> wfTest = wfaService.getAnalyzeByFileName(newFileName);
        assertThat(wfTest).isNotEmpty();
    }
}
