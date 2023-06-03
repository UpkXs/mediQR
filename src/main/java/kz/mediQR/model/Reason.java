package kz.mediQR.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reason")
public class Reason {
    @Id
    private String id;

    @NotBlank(message = "Name is required")
    private String name;
}
