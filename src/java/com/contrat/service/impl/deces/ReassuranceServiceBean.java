package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.ReassuranceServiceBeanLocal;
import com.contrat.dao.deces.ReassuranceDaoBeanLocal;
import com.contrat.entities.Reassurance;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ReassuranceServiceBean extends BaseServiceBean<Reassurance, Integer> implements ReassuranceServiceBeanLocal {

@EJB
private ReassuranceDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Reassurance, Integer> getDAO() {
        return this.dao;
    }
}