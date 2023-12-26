package com.gp225.counter.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class CounterBean {
    
    private int hits = 1;

    // Increment and return the number of hits
    public int getHits() {
        return hits++;
    }
    
    @PostConstruct
    public void postConstruct() {
        System.out.println("CounterBean: CounterBean: postConstruct");
    }
    
    @PreDestroy
    public void preDestroy() {
        System.out.println("CounterBean: CounterBean: preDestroy");
    }
}
