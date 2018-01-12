package com.mdw;



public class StockInfo {
    public final String ticker;
    public final double value;

    public StockInfo(String ticker, double value){
        this.ticker = ticker;
        this.value = value;
    }

    public static StockInfo fetch(String ticker){
        return new StockInfo(ticker, YahooFinance.getPrice(ticker));
    }

    @Override
    public String toString(){
        return String.format("%s : %f", ticker, value);
    }



}
