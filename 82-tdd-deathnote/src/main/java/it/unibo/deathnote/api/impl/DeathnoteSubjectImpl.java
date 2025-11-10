package it.unibo.deathnote.api.impl;

public class DeathnoteSubjectImpl implements DeathNoteSubject {
    private final String name;
    private String deathCause;
    private String deathDetails;

    public DeathnoteSubjectImpl(final String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCause() {
        return this.deathCause;
    }

    @Override
    public String getDetails() {
        return this.deathDetails;
    }

    @Override
    public void setDeathCause(final String deathcause) {
        this.deathCause=deathcause;
    }

    @Override
    public void setDeathDetails(final String details) {
        this.deathDetails=details;
    }
    
}
