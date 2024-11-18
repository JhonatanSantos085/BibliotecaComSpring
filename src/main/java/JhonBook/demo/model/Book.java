package JhonBook.demo.model;


import JhonBook.demo.enums.BookType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titulo")
    private String title;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Author author;

    @Column(name = "descricao")
    private String description;

    @Column(name = "tipo")
    private BookType bookType;

}
