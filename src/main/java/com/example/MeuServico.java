package com.example;

import java.util.concurrent.Future;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class MeuServico {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeuServico.class);

    @Async
    public void processar() {

        LOGGER.info("Inicio processamento");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {

        }

        LOGGER.info("Fim processamento");
    }

    @Async
    public Future<Integer> processar2() {

        LOGGER.info("Inicio processamento");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(MeuServico.class.getName()).log(Level.SEVERE, null, ex);
        }

        LOGGER.info("Fim processamento");

        return new AsyncResult<>(123);
    }

}
