package br.com.heitorflorido.interview.gateway.database.model;

import br.com.heitorflorido.interview.model.Usuario;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Value
@Builder
@Table("seg_usuario")
public class UsuarioData {

    @Id
    @Column("id_usuario")
    Long id;
    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    @Column("nm_usuario")
    String nome;
    @Size(min = 1, max = 100, message = "Cidade must be between 1 and 100 characters")
    @Column("ds_cidade")
    String cidade;
    @Pattern(regexp = "^[A-Z]{2}$")
    @Column("cd_uf")
    String uf;
    @Size(min = 8, max = 8, message = "Data de Nascimento must have 8 characters")
    @Column("dn_usuario")
    LocalDate dataNascimento;
    @Pattern(regexp = "^[0-9]{8}$")
    @Column("cep_usuario")
    String cep;

    public static UsuarioData toUsuarioData(final Usuario usuario) {

        return UsuarioData.builder()
            .id(usuario.getId())
            .nome(usuario.getNome())
            .cidade(usuario.getCidade())
            .uf(usuario.getUf())
            .dataNascimento(usuario.getDataNascimento())
            .cep(usuario.getCep())
            .build();
    }

    public static Usuario toUsuario(final UsuarioData usuario) {

        return Usuario.builder()
            .id(usuario.getId())
            .nome(usuario.getNome())
            .cidade(usuario.getCidade())
            .uf(usuario.getUf())
            .dataNascimento(usuario.getDataNascimento())
            .cep(usuario.getCep())
            .build();
    }
}
