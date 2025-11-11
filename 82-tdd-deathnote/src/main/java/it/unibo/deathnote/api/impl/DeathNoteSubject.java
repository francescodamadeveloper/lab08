package it.unibo.deathnote.api.impl;

public interface DeathNoteSubject {

    String getName();

    String getCause();

    String getDetails();

    void setDeathCause(String deathcause);

    void setDeathDetails(String deathdetails);
}
