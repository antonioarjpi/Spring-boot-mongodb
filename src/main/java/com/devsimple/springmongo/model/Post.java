package com.devsimple.springmongo.model;

import com.devsimple.springmongo.Dto.AuthorDTO;
import com.devsimple.springmongo.Dto.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private String title;
    private Date date;
    private String body;
    private AuthorDTO author;
    private List<CommentDTO> comments = new ArrayList<>();

    public Post(String id, String title, Date date, String body, AuthorDTO author) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.body = body;
        this.author = author;
    }
}
