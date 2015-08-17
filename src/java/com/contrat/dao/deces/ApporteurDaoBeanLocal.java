package com.contrat.dao.deces;

import com.contrat.dao.BaseDaoBeanLocal;
import com.contrat.entities.Apporteur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface ApporteurDaoBeanLocal extends BaseDaoBeanLocal<Apporteur, Integer>{
    List<Apporteur> apporteurall();
    List<Apporteur> recherchenom(String nom);
    
}