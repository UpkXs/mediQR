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
public class Queue {
    @Id
    private String queueId;

    @NotBlank
    private String verificationCode;

    @NotBlank
    private long queueCode;

    @NotBlank
    private long queueNumber;

    @NotBlank
    private String reason;

    @NotBlank
    private boolean isLeaved;
}
