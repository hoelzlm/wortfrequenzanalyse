package de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "wortfrequenz")
public class Wortfrequenz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="wf_id")
    private int id;

    @Column(name="file_id")
    private int fileId;
    private String word;
    private int count;

    protected Wortfrequenz() {}

    public Wortfrequenz(int fileId, String word, int count) {
        this.fileId = fileId;
        this.word = word;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFileName() {
        return fileId;
    }

    public void setFileName(int fileId) {
        this.fileId = fileId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
