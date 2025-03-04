package de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "wfFile")
public class WFFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="file_id")
    private int id;

    private String fileName;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createDateTime;

    /*
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", referencedColumnName = "file_id")
    private Set<Wortfrequenz> wfList;
    */

    public WFFile(String fileName) {
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Timestamp getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Timestamp createDateTime) {
        this.createDateTime = createDateTime;
    }
}
