package br.com.heitorflorido.interview.gateway.database;

import br.com.heitorflorido.interview.gateway.CriarUsuarioGateway;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CriarUsuarioDatabaseGateway implements CriarUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Mono<Usuario> execute(Usuario req) {
        Usuario user = Usuario.builder()
            .nome(req.getNome())
            .cidade(req.getCidade())
            .uf(req.getUf())
            .dataNascimento(req.getDataNascimento())
            .cep(req.getCep())
            .build();
        return usuarioRepository.save(user);
    }
}
