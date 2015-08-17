package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.SouscripteurServiceBeanLocal;
import com.contrat.dao.deces.SouscripteurDaoBeanLocal;
import com.contrat.entities.Souscripteur;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class SouscripteurServiceBean extends BaseServiceBean<Souscripteur, Integer> implements SouscripteurServiceBeanLocal {

@EJB
private SouscripteurDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Souscripteur, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Souscripteur> souscripteurall() {
        return this.dao.souscripteurall();
    }
}