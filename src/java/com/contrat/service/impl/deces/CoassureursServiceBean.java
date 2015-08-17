package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.CoassureursServiceBeanLocal;
import com.contrat.dao.deces.CoassureursDaoBeanLocal;
import com.contrat.entities.Coassureurs;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class CoassureursServiceBean extends BaseServiceBean<Coassureurs, Integer> implements CoassureursServiceBeanLocal {

@EJB
private CoassureursDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Coassureurs, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Coassureurs> coassureurall() {
        return this.dao.coassureurall();
    }
}