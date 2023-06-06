package kz.mediQR.model;

import jakarta.persistence.*;
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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int orderIndex;

    @NotBlank
    private boolean isYourTurn;
}
