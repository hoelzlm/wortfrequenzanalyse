package de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend;

import de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.controller.ApiController;
import de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.model.WFFile;
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
        WFFile file = wfaService.analyzeFile(testFile);

        // test if fileName is generated
        assertThat(fileName).isEqualTo(file.getFileName());

        // test if something is written to the database
        List<Wortfrequenz> wfTest = wfaService.getAnalyzeByFileId(file.getId());
        assertThat(wfTest).isNotEmpty();
    }
}
