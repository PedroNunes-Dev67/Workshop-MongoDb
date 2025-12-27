package PedroNunesDev.WorkshopMongo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CommentDto implements Serializable {

    private String text;
    private LocalDate date;

    private AuthorDto authorDto;

    public CommentDto() {
    }

    public CommentDto(String text, LocalDate date, AuthorDto authorDto) {
        this.text = text;
        this.date = date;
        this.authorDto = authorDto;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public void setAuthorDto(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }
}
