package it.unibo.deathnote.api.impl;

public interface DeathNoteSubject {
    String getName();

    String getCause();

    String getDetails();

    void setDeathCause(final String deathcause);

    void setDeathDetails(final String deathdetails);
}
