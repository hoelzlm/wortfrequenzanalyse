package de.rinnebuehl.hoelzle.wortfrequenzanalyse_backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "wortfrequenz")
public class Wortfrequenz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fileName;
    private String word;
    private int count;

    protected Wortfrequenz() {}

    public Wortfrequenz(String fileName, String word, int count) {
        this.fileName = fileName;
        this.word = word;
        this.count = count;
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
