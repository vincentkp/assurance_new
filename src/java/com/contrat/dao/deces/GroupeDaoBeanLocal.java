package com.contrat.dao.deces;

import com.contrat.dao.BaseDaoBeanLocal;
import com.contrat.entities.Groupe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface GroupeDaoBeanLocal extends BaseDaoBeanLocal<Groupe, Integer>{
    List<Groupe> groupeall();
     
}