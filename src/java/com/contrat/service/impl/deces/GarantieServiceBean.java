package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.GarantieServiceBeanLocal;
import com.contrat.dao.deces.GarantieDaoBeanLocal;
import com.contrat.entities.Garantie;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class GarantieServiceBean extends BaseServiceBean<Garantie, Integer> implements GarantieServiceBeanLocal {

@EJB
private GarantieDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Garantie, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Garantie> garantieall() {
        return this.dao.garantieall();
    }
}