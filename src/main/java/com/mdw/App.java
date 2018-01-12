package com.mdw;

import rx.Observable;
import rx.Subscriber;

import java.util.Arrays;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        List<String> symbols = Arrays.asList("AMZN", "GOOG", "ORCL");

        Observable<StockInfo> feed = StockSever.getFeed(symbols);

        feed.subscribe(new Subscriber<StockInfo>() {
            @Override
            public void onCompleted() {
                System.out.println("Feed has ended.");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(StockInfo stockInfo) {
                System.out.println(stockInfo);

                //May be after some time, may be on user input, may be upon getting some particular value,
                //the client no longer wants the data.
                if (Math.random() > 0.9) {
                    System.out.println("Client wants to stop...");
                    unsubscribe();
                }
            }
        });
        //feed.skipWhile(stockInfo -> stockInfo.value < 1900)
         //       .take(20)
         //       .subscribe(System.out::println, System.out::println, System.out::println);

        System.out.println("_____________________________________________________________");




    }
}
