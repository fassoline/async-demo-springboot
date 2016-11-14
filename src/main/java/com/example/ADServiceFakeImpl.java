package com.example;

import java.util.Calendar;
import static java.util.Calendar.getInstance;
import java.util.concurrent.Future;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class ADServiceFakeImpl implements ADService {

    @Async
    @Override
    public Future<Calendar> getExpirationDateFromLogin(String login) {

        if (login.equals("admin")) {

            Utils.slowMethod();
            Calendar today = getInstance();
            today.add(Calendar.DATE, 10);

            return new AsyncResult<>(today);

        }

        return null;

    }

}
