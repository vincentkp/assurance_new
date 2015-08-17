package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.ReassuranceDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Reassurance;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ReassuranceDaoBean extends BaseDaoBean<Reassurance,Integer> implements ReassuranceDaoBeanLocal {

    public ReassuranceDaoBean() {
        super(Reassurance.class);
    }

    
}
