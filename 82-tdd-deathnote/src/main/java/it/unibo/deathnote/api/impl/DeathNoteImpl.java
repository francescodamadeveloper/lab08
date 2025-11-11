package it.unibo.deathnote.api.impl;
import java.util.ArrayList;
import java.util.List;
import java.lang.System;
import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImpl implements DeathNote {
    private List<DeathNoteSubject> subjects = new ArrayList<>();
    private long time;
    private final static int DEATH_CAUSE_TIME_LIMIT = 40;
    private static final int DETAILS_TIME_LIMIT = 6040; 

    /**
     * {@inheritDoc}
    */

    @Override
    public String getRule(int ruleNumber) {
        if(ruleNumber < 1 || ruleNumber > RULES.size()){
            throw new IllegalArgumentException("Rule index out of range,should be beetwen 1 and  " + RULES.size());
        }
        return RULES.get(ruleNumber - 1); 
    }

    /**
     * {@inheritDoc}
    */

    @Override
    public void writeName(String name) {
        if(name == null){
            throw new NullPointerException("the name given was null");
        }
        subjects.add(new DeathnoteSubjectImpl(name));
        this.time=System.currentTimeMillis();
    }

    /**
     * {@inheritDoc}
    */

    @Override
    public boolean writeDeathCause(String cause) {
        if(this.subjects.isEmpty() || cause == null){
            throw new IllegalStateException("there was no name in the book or the specified death cause was null");
        }
        if(System.currentTimeMillis() - this.time > DEATH_CAUSE_TIME_LIMIT ){
            return false;
        } 
        subjects.getLast().setDeathCause(cause);
        return true;
    }

    /**
     * {@inheritDoc}
    */

    @Override
    public boolean writeDetails(String details) {
        if(subjects.isEmpty() || details == null){
            throw new IllegalStateException("there was no name in the book or the specified details were null"); 
        }
        if(System.currentTimeMillis() - this.time > (DETAILS_TIME_LIMIT + DEATH_CAUSE_TIME_LIMIT)){
            return false;
        }
        subjects.getLast().setDeathDetails(details);
        return true;
    }

    /**
     * {@inheritDoc}
    */

    @Override
    public String getDeathCause(String name) {
        if(!isNameWritten(name)){
            throw new IllegalArgumentException("no such name found in the book");
        }
        return subjects.get(subjects.indexOf(new DeathnoteSubjectImpl(name))).getCause();
    }

    /**
     * {@inheritDoc}
    */

    @Override
    public String getDeathDetails(String name) {
        if(!isNameWritten(name)){
            throw new IllegalArgumentException("no such name found in the book");
        }
        return subjects.get(subjects.indexOf(new DeathnoteSubjectImpl(name))).getDetails();
    }

    /**
     * {@inheritDoc}
    */

    @Override
    public boolean isNameWritten(String name) {
        for(final DeathNoteSubject person : subjects){
            if(person.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
