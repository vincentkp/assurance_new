package com.contrat.dao.deces;

import com.contrat.dao.BaseDaoBeanLocal;
import com.contrat.entities.Typeapporteur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface TypeapporteurDaoBeanLocal extends BaseDaoBeanLocal<Typeapporteur, Integer>{
    List<Typeapporteur> typeapporteurall(); 
}