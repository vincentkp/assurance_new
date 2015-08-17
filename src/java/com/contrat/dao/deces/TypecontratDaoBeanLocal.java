package com.contrat.dao.deces;

import com.contrat.dao.BaseDaoBeanLocal;
import com.contrat.entities.Typecontrat;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface TypecontratDaoBeanLocal extends BaseDaoBeanLocal<Typecontrat, Integer>{
    List<Typecontrat> typecontratall();
    List<Typecontrat> autretypecontrat();
}