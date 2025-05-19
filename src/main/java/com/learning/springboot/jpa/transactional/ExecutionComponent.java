package com.learning.springboot.jpa.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class ExecutionComponent {

    @Autowired
    PlatformTransactionManager executionTransactionManager;

    @Autowired
    TransactionTemplate executionTransactionTemplate;




   // @Transactional(transactionManager = "executionTransactionManager")
   @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void execute() {
       TransactionStatus transactionStatus  = executionTransactionManager.getTransaction(null);
       try {
           System.out.println("Executing");
           System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
           method1();
           executionTransactionManager.commit(transactionStatus);
       } catch (Exception e) {
           executionTransactionManager.rollback(transactionStatus);
       }
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void method1() {
        System.out.println("Method 1");
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("Method 2");
        

//        TransactionCallback<TransactionStatus> transactionCallback = (TransactionStatus transactionStatus) -> {
//            System.out.println("Method 2");
//            System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
//            return transactionStatus;
//        };
//
//        executionTransactionTemplate.execute(transactionCallback);
        }
}
