/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package com.gp225.counter.jsf;

import java.io.Serializable;
import com.gp225.counter.ejb.CounterBean;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class Count implements Serializable {
    
    @EJB
    private CounterBean counterBean;
    
    private int hitCount;
    
    public Count() {
        this.hitCount = 0;
    }

    public int getHitCount() {
        hitCount = counterBean.getHits();
        return hitCount;
    }

    public void setHitCount(int newHits) {
        this.hitCount = newHits;
    }
    
    @PostConstruct
    public void postConstruct() {
        System.out.println("Count: postConstruct");
    }
    
    @PreDestroy
    public void preDestroy() {
        System.out.println("Count: preDestroy");
    }
}
