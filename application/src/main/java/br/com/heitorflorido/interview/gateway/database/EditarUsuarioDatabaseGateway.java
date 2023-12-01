package br.com.heitorflorido.interview.gateway.database;

import br.com.heitorflorido.interview.gateway.EditarUsuarioGateway;
import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class EditarUsuarioDatabaseGateway implements EditarUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Mono<Object> execute(Usuario req, Long id) {
        return (usuarioRepository.findById(id)
        .map(usuario -> {
            usuario.setNome(req.getNome());
            usuario.setCidade(req.getCidade());
            usuario.setCep(req.getUf());
            usuario.setDataNascimento(req.getDataNascimento());
            usuario.setCep(req.getCep());
            return usuarioRepository.save(usuario);
        }));
    }
}
