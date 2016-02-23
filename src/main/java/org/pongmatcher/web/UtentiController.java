package org.pongmatcher.web;



import java.util.List;

import org.pongmatcher.domain.Match;
import org.pongmatcher.domain.Utenti;
import org.pongmatcher.repositories.MatchRepository;
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

    @Autowired
    UtentiController(UtentiRepository userRepository) {
        this.usrRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/utenti/{id}")
    ResponseEntity <Utenti> show(@PathVariable String id) {
        
    	
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
    	
    	return new ResponseEntity<>(lista.get(1), HttpStatus.OK);
    	
    	//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
