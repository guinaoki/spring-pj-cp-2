package br.com.fiap.concessionaria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_CARACTERISTICA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NOME", columnNames = "NOME_CARACTERISTICA")
})
public class Caracteristica {

    @Id
    @SequenceGenerator(name = "SQ_CARACTERISTICA", sequenceName = "SQ_CARACTERISTICA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CARACTERISTICA")
    @Column(name = "ID_CARACTERISTICA")
    private Long id;

    //30 digitos
    @Column(name = "NOME_CARACTERISTICA")
    @Size(min = 30)
    private String nome;

    //20 digitos
    @Column(name = "DESCRICAO")
    @Size(min = 20)
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_VEICULO",
            referencedColumnName = "ID_VEICULO",
            foreignKey = @ForeignKey(
                    name = "FK_CARACTERISTICA_VEICULO"
            )
    )
    private Veiculo veiculo;


}
