package com.admitone.configuration;

import com.admitone.dao.CancellationDAO;
import com.admitone.dao.ExchangeDAO;
import com.admitone.dao.PurchaseDAO;
import com.admitone.model.Cancellation;
import com.admitone.services.PurchaseService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.beans.PropertyVetoException;

/**
 * Created by j_elbatn on 1/21/17.
 */

@Configuration
public class ApplicationConfiguration {

    /*@Bean(name="purchaseDAO")
    public PurchaseDAO purchaseDAO()
    {
        return new PurchaseDAO();
    }

    @Bean(name="cancellationDAO")
    public CancellationDAO cancellationDAO() {
        return new CancellationDAO();
    }

    @Bean(name="ExchageDAO")
    public ExchangeDAO exchangeDAO(){
        return new ExchangeDAO();
    }*/


}
