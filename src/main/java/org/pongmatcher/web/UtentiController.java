package org.pongmatcher.web;



 
import java.util.Iterator;
import java.util.List;








import org.pongmatcher.domain.Match;
import org.pongmatcher.domain.Indirizzi;
import org.pongmatcher.domain.Prenotazioni;
import org.pongmatcher.domain.Utenti;
import org.pongmatcher.repositories.MatchRepository;
import org.pongmatcher.repositories.PrenotazioniRepository;
import org.pongmatcher.repositories.ResultRepository;
import org.pongmatcher.repositories.StazioniNamedQueryRepository;
import org.pongmatcher.repositories.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtentiController {

	private final UtentiRepository usrRepository;
	private final StazioniNamedQueryRepository stazioniRepository;
	private final PrenotazioniRepository prenotazioniRepository;

    @Autowired
    UtentiController(UtentiRepository userRepository,StazioniNamedQueryRepository stazioniRepository , PrenotazioniRepository prenotazioniRepository) {
        this.usrRepository = userRepository;
        this.stazioniRepository = stazioniRepository;
        this.prenotazioniRepository = prenotazioniRepository;
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/utenti/{id}")
    ResponseEntity<List<Indirizzi>> show(@PathVariable String id) {
        
    	
    	List<Utenti> lista = usrRepository.findAll();

       /*
        *  if (match == null) {
        
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(match, HttpStatus.OK);
        }
        */
    	
    	System.out.println(" ");
    	System.out.println(" utenti {id} OK ");
    	System.out.println(" ");
    	System.out.println(lista.get(1).getNome());
    	System.out.println(lista.get(1).getCognome());
    	
    	
    	List<Indirizzi> indirizzi = stazioniRepository.findNearest(41,12,Double.valueOf(1000));
    	//List<Indirizzi> indirizzi = stazioniRepository.findNearest();
		
    	System.out.println("NUMERO ELEMENTI --> " + indirizzi.size());
    	
    	
    	
    	//System.out.println(indirizzi.get(1).toXML());
    	
    	
    	Prenotazioni prenotazione = new Prenotazioni( "AAAA", "BBBBB", "WWWWW", 33, 44);
    	
    	this.prenotazioniRepository.saveAndFlush(prenotazione);
        
    	
    	//return new ResponseEntity<>(result, HttpStatus.CREATED);
        
        
    	
    	return new ResponseEntity<>(indirizzi, HttpStatus.OK);
    	//return new ResponseEntity<>(lista , HttpStatus.OK);
    	
    	//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    
    
    
    

}
