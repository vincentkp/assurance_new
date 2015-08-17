package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.ProducteurServiceBeanLocal;
import com.contrat.dao.deces.ProducteurDaoBeanLocal;
import com.contrat.entities.Producteur;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ProducteurServiceBean extends BaseServiceBean<Producteur, Integer> implements ProducteurServiceBeanLocal {

@EJB
private ProducteurDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Producteur, Integer> getDAO() {
        return this.dao;
    }
}