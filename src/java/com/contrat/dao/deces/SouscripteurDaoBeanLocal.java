package com.contrat.dao.deces;

import com.contrat.dao.BaseDaoBeanLocal;
import com.contrat.entities.Souscripteur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface SouscripteurDaoBeanLocal extends BaseDaoBeanLocal<Souscripteur, Integer>{
    List<Souscripteur> souscripteurall();
    
}