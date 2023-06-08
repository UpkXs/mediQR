package kz.mediQR.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "queue")
public class RoomLinks {
    @Id
    private String verificationCode;
    @NotBlank
    private String qrLink;
    @NotBlank
    private String qrPoster;
    @NotBlank
    private String roomLink;
}
