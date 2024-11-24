package JhonBook.demo.model;


import JhonBook.demo.enums.BookType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String title;

    @ManyToOne(optional = false) // Define que o Author é obrigatório
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    private String description;


    @Enumerated(EnumType.STRING)
    private BookType type;

}
