package com.example;

import java.util.Calendar;
import java.util.concurrent.Future;

public interface ADService {

    Future<Calendar> getExpirationDateFromLogin(String login);

}
