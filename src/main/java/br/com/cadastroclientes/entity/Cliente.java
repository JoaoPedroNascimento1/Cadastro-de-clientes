package br.com.cadastroclientes.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false,unique = true)
  private String email;

  @Column(nullable = false)
  private String telefone;
}
