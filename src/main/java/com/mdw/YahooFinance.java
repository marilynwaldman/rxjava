package com.mdw;

public class YahooFinance {
    public static double getPrice(final String ticker){
        System.out.println(ticker);
        if(ticker.equals("AMZN")) return 500.99;
        if(ticker.equals("GOOG")) return 400.00;
        if(ticker.equals("ORCL")) return 1000.00;
        return 0.0;
    }
}
