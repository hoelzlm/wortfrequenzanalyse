package de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.repository;

import de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.model.Wortfrequenz;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DatabaseRepository extends CrudRepository<Wortfrequenz, Integer> {

    List<Wortfrequenz> findTop10ByFileNameOrderByCountDesc(String fileName);
}
