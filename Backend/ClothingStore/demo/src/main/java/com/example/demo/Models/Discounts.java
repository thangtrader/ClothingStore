package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.*;

@Data //toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "discounts")
@Entity
public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "percent")
    private float percent;

<<<<<<< HEAD
    @Column(name = "note")
    private String note;
}
=======
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
>>>>>>> main
