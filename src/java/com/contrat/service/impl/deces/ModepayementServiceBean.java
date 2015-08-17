package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.ModepayementServiceBeanLocal;
import com.contrat.dao.deces.ModepayementDaoBeanLocal;
import com.contrat.entities.Modepayement;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ModepayementServiceBean extends BaseServiceBean<Modepayement, Integer> implements ModepayementServiceBeanLocal {

@EJB
private ModepayementDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Modepayement, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Modepayement> listmodepayementall() {
        return this.dao.listmodepayementall();
    }
}