package com.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeuController {

    @Autowired
    private MeuServico meuServico;

    @RequestMapping(value = "/slow", method = GET)
    public MeuObj slowMethod() {

        MeuObj obj = new MeuObj("Meu Nome");

        Future<Integer> valorFuture = meuServico.processar2();
        try {
            Integer valor = valorFuture.get(1, TimeUnit.SECONDS);
            obj.setValor(valor);
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            Logger.getLogger(MeuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }

}
