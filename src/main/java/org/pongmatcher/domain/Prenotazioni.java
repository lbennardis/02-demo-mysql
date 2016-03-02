package org.pongmatcher.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "prenotazioni")
public class Prenotazioni {

	@Id
    @GeneratedValue
    private Long id = (Long.valueOf(UUID.randomUUID().toString()));

    public Long getId() {
        return id;
    }
    @JsonProperty("codice")
    private volatile String codice;

    @JsonProperty("stazione")
    private volatile String stazione;
    
    @JsonProperty("citta")
    private volatile String citta;

    @JsonProperty("latitudine")
    private long latitudine;

    @JsonProperty("longitudine")
    private long longitudine;

    Prenotazioni() {
    }

    public Prenotazioni(String codice, String stazione, String citta, long latitudine, long longitudine) {
        this.codice = codice;
        this.stazione = stazione;
        this.citta = citta;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
         
        
    }

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getStazione() {
		return stazione;
	}

	public void setStazione(String stazione) {
		this.stazione = stazione;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public long getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(long latitudine) {
		this.latitudine = latitudine;
	}

	public long getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(long longitudine) {
		this.longitudine = longitudine;
	}

	 
    
}

 

