package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.CoassuranceDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Coassurance;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class CoassuranceDaoBean extends BaseDaoBean<Coassurance,Integer> implements CoassuranceDaoBeanLocal {

    public CoassuranceDaoBean() {
        super(Coassurance.class);
    }

    
}
