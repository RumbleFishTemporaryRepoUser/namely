package dev.rumblefish.namely.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Person {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    private String name;


    @Column
    @Basic(optional = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private ZonedDateTime creationDate; // to pole można wydzielić do osobnej klasy, po której Person i inne klasy by dziedziczyły

    @PrePersist
    void prePersistTimestampEntity() {
        creationDate = ZonedDateTime.now();
    }
}
