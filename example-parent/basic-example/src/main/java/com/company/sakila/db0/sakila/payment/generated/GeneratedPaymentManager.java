package com.company.sakila.db0.sakila.payment.generated;

import com.company.sakila.db0.sakila.payment.Payment;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.core.manager.Manager;

/**
 * The generated base interface for the manager of every {@link
 * com.company.sakila.db0.sakila.payment.Payment} entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedPaymentManager extends Manager<Payment> {
    
    @Override
    default Class<Payment> getEntityClass() {
        return Payment.class;
    }
}