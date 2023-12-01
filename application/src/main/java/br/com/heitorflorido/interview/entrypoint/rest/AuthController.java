package br.com.heitorflorido.interview.entrypoint.rest;

import br.com.heitorflorido.interview.model.Usuario;
import br.com.heitorflorido.interview.usecase.CriarUsuarioUseCase;
import br.com.heitorflorido.interview.usecase.ObterUsuarioUseCase;
import br.com.heitorflorido.interview.usecase.ObterUsuariosUseCase;
import br.com.heitorflorido.interview.usecase.DeletarUsuarioUseCase;
import br.com.heitorflorido.interview.usecase.EditarUsuarioUseCase;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {

    private final ObterUsuarioUseCase obterUsuarioUseCase;
    private final ObterUsuariosUseCase obterUsuariosUseCase;
    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final DeletarUsuarioUseCase deletarUsuarioUseCase;
    private final EditarUsuarioUseCase editarUsuarioUseCase;

    @GetMapping("/usuario/{id}")
    public Mono<Usuario> validar(final @PathVariable Long id) {
        return obterUsuarioUseCase.execute(id);
    }

    @PostMapping("/usuario")
    public Mono<Usuario> create(@RequestBody Usuario req) {
        return criarUsuarioUseCase.execute(req);
    }

    @GetMapping("/usuario")
    public Flux<Usuario> all() {
        return obterUsuariosUseCase.execute();
    }

     @PutMapping("/usuario/{id}")
     Mono<Object> validar(@RequestBody Usuario req, @PathVariable Long id) {
        return editarUsuarioUseCase.execute(req, id);
    }
    
    @DeleteMapping("/usuario/{id}")
    void deleteUsuario(@PathVariable Long id) {
        deletarUsuarioUseCase.execute(id);
    }
}
