package com.contrat.service.impl.deces;

import com.contrat.service.impl.BaseServiceBean;
import com.contrat.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.contrat.service.deces.ReassureursServiceBeanLocal;
import com.contrat.dao.deces.ReassureursDaoBeanLocal;
import com.contrat.entities.Reassureurs;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ReassureursServiceBean extends BaseServiceBean<Reassureurs, Integer> implements ReassureursServiceBeanLocal {

@EJB
private ReassureursDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Reassureurs, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Reassureurs> reassureurall() {
        return this.dao.reassureurall();
    }

    @Override
    public List<Reassureurs> recherchereassureurnom(String nom) {
        return this.dao.recherchereassureurnom(nom);
    }
}