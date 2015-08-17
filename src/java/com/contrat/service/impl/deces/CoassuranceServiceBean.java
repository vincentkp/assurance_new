package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.CoassuranceServiceBeanLocal;
import com.contrat.dao.deces.CoassuranceDaoBeanLocal;
import com.contrat.entities.Coassurance;

/**
 *
 * @author K.M.A
 */
@Stateless
public class CoassuranceServiceBean extends BaseServiceBean<Coassurance, Integer> implements CoassuranceServiceBeanLocal {

@EJB
private CoassuranceDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Coassurance, Integer> getDAO() {
        return this.dao;
    }
}