package br.com.heitorflorido.interview.entrypoint.rest;

import br.com.heitorflorido.interview.model.Usuario;
import br.com.heitorflorido.interview.usecase.ObterUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {

    private final ObterUsuarioUseCase obterUsuarioUseCase;

    @GetMapping("/usuario/{id}")
    public Mono<Usuario> validar(final @PathVariable Long id) {
        return obterUsuarioUseCase.execute(id);
    }

    @PostMapping("/usuario/{id}")
    public Mono<Usuario> create(@RequestBody Usuario req) {
        service.save(new Usuario (req));
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    @GetMapping("/usuario")
    public List<Usuario> all() {
        return service.findAll();
    }

     @PutMapping("/usuario/{id}")
     Usuario replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Long id) {

        return obterUsuarioUseCase.execute(id)
        .map(usuario -> {
            usuario.setNome(newUsuario.getNome());
            usuario.setCidade(newUsuario.getCidade());
            usuario.setUf(newUsuario.getUf());
            usuario.setDataNascimento(newUsuario.getDataNascimento());
            usuario.setCep(newUsuario.getCep());
            return service.save(usuario);
        })
        .orElseGet(() -> {
            newUsuario.setId(id);
            return service.save(newUsuario);
        });
    }

    @DeleteMapping("/usuario/{id}")
    void deleteUsuario(@PathVariable Long id) {
        service.deleteById(id);
    }
}
