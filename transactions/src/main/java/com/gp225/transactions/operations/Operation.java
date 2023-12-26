package com.gp225.transactions.operations;

import com.gp225.transactions.ejb.TransactionEJB;

/**
 *
 * @author ianw
 */
public abstract class Operation {

    public abstract String execute(TransactionEJB bean);
}
