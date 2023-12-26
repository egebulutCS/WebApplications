package com.gp225.persistencetables.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TestBean {

    @PersistenceContext(unitName = "PersistenceTablesPU")
    EntityManager em;
}
