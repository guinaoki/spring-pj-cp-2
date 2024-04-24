package br.com.fiap.concessionaria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CodePointLength;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_VEICULO")

public class Veiculo {

    @Id
    @SequenceGenerator(name = "SQ_VEICULO", sequenceName = "SQ_VEICULO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VEICULO")
    @Column(name = "ID_VEICULO")
    private Long id;

    @Column(name = "NOME_VEICULO")
    private String nome;

    @Column(name = "ANO_FABRICACAO")
    private Year anoDeFabricacao;

    @Column(name = "COR")
    private String cor;

    @Column(name = "PRECO_VEICULO")
    private Double preco;

    @Column(name = "CILINDRADAS")
    private Short cilindradas;

    @Column(name = "MODELO_VEICULO")
    private String modelo;

    //15 digitos
    @Column(name = "PALAVRA_DE_EFEITO")
    @Size(max = 15)
    private String palavraDeEfeito;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ID_FABRICANTE", referencedColumnName = "ID_FABRICANTE",foreignKey = @ForeignKey(name = "FK_VEICULO_FABRICANTE"))
    private Fabricante fabricante;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ID_TIPO_VEICULO",referencedColumnName = "ID_TIPO_VEICULO" ,foreignKey = @ForeignKey(name = "FK_VEICULO_TIPO_VEICULO"))
    private TipoVeiculo tipo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_VEICULO_ACESSORIO",
            joinColumns = @JoinColumn(name = "ID_VEICULO",
                    referencedColumnName = "ID_VEICULO",
                    foreignKey = @ForeignKey(name = "FK_VEICULO_ACESSORIO")),
            inverseJoinColumns = @JoinColumn(name = "ID_ACESSORIO",
                    referencedColumnName = "ID_ACESSORIO",
                    foreignKey = @ForeignKey(name = "FK_ACESSORIO_VEICULO"))
    )

    private Set<Acessorio> acessorios = new LinkedHashSet<>();

}
