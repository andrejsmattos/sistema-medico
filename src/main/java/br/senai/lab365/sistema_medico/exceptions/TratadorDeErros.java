package br.senai.lab365.sistema_medico.exceptions;

import br.senai.lab365.sistema_medico.exceptions.dtos.ErroResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroResponse> trataEntidadeNaoEncontrada(EntityNotFoundException exception){
        ErroResponse erroResponse = new ErroResponse();
        erroResponse.setCampo("Id");
        erroResponse.setMensagem(exception.getMessage());
        return ResponseEntity.status(404).body(erroResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroResponse>> trataParametroInvalido(
            MethodArgumentNotValidException exception
    ) {
        return ResponseEntity.badRequest().body(
                exception.getFieldErrors().stream().map(ErroResponse::new).collect(Collectors.toList())
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResponse> trataEnumInvalido(HttpMessageNotReadableException exception) {
        ErroResponse response = new ErroResponse();
        response.setCampo("Especialidade inválida");
        response.setMensagem(exception.getLocalizedMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ErroResponse> trataChaveDuplicada(DuplicateKeyException exception) {
        ErroResponse response = new ErroResponse();
        response.setCampo("crm");
        response.setMensagem(exception.getLocalizedMessage());

        return ResponseEntity.badRequest().body(response);
    }
}
