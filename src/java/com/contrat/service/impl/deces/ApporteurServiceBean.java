package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.dao.deces.ApporteurDaoBeanLocal;
import com.contrat.entities.Apporteur;
import com.contrat.service.deces.ApporteurServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ApporteurServiceBean extends BaseServiceBean<Apporteur, Integer> implements ApporteurServiceBeanLocal {

@EJB
private ApporteurDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Apporteur, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Apporteur> apporteurall() {
        return this.dao.apporteurall();
    }

    @Override
    public List<Apporteur> recherchenom(String nom) {
        return this.dao.recherchenom(nom);
    }
    
}