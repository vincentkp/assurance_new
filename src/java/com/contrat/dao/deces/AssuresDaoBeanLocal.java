package com.contrat.dao.deces;

import com.contrat.dao.BaseDaoBeanLocal;
import com.contrat.entities.Assures;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface AssuresDaoBeanLocal extends BaseDaoBeanLocal<Assures, Integer>{
    List<Assures> assureall();
    List<Assures> assureentreprise();
    Integer moyenneage();
    
}