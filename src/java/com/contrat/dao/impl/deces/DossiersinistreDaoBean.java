package com.contrat.dao.impl.deces;

import com.contrat.dao.deces.DossiersinistreDaoBeanLocal;
import com.contrat.dao.impl.BaseDaoBean;
import com.contrat.entities.Dossiersinistre;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class DossiersinistreDaoBean extends BaseDaoBean<Dossiersinistre,Integer> implements DossiersinistreDaoBeanLocal {

    public DossiersinistreDaoBean() {
        super(Dossiersinistre.class);
    }

    
}
