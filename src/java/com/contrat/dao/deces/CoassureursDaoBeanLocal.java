package com.contrat.dao.deces;

import com.contrat.dao.BaseDaoBeanLocal;
import com.contrat.entities.Coassureurs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface CoassureursDaoBeanLocal extends BaseDaoBeanLocal<Coassureurs, Integer>{
    List<Coassureurs> coassureurall();
    
}