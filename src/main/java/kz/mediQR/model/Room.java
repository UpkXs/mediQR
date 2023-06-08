package kz.mediQR.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
    @Id
    private String verificationCode;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String patronymic;
    @NotBlank
    private long phoneNumber;
    @NotBlank
    private long roomNumber;
    @NotBlank
    private String reasonsOne;
    @NotBlank
    private String reasonsTwo;
    @NotBlank
    private String reasonsThree;
}
