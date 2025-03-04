package de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.repository;

import de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.model.WFFile;
import org.springframework.data.repository.CrudRepository;

public interface WFFileRepository extends CrudRepository<WFFile, Integer> {
    WFFile findById(int fileId);
}
