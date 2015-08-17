package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.AssuresServiceBeanLocal;
import com.contrat.dao.deces.AssuresDaoBeanLocal;
import com.contrat.entities.Assures;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class AssuresServiceBean extends BaseServiceBean<Assures, Integer> implements AssuresServiceBeanLocal {

@EJB
private AssuresDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Assures, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Assures> assureall() {
        return this.dao.assureall();
    }


    

    @Override
    public Integer moyenneage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Assures> assureentreprise() {
        return this.dao.assureentreprise();
    }
}