package it.unibo.deathnote.api.impl;

public class DeathnoteSubjectImpl implements DeathNoteSubject {
    private final String name;
    private String deathCause;
    private String deathDetails;
    private final static String DEFAULT_DEATH_CAUSE = "Heart attack";
    public DeathnoteSubjectImpl(final String name){
        this.name = name;
        this.deathCause = DEFAULT_DEATH_CAUSE;
        this.deathDetails= new String();
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
    
    /**
     * {@inheritDoc}
     */

    public boolean equals(final Object o){
        if(this == o){
            return true;
        } else if(o != null && o.getClass().equals(this.getClass())){
            final DeathnoteSubjectImpl a = (DeathnoteSubjectImpl)o;
            return this.name.equals(a.getName());
        }
        return false;
    }
    
}
