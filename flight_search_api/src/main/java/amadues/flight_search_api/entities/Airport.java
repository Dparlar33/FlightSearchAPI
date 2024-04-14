package amadues.flight_search_api.entities;

import amadues.flight_search_api.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "airports")
public class Airport extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;
}
