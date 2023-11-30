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
        return usuarioRepository.save(req);
    }
}
