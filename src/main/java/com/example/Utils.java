package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    public static void slowMethod() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ADServiceFakeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
