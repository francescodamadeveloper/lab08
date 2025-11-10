package it.unibo.deathnote;
import it.unibo.deathnote.api.*;
import it.unibo.deathnote.api.impl.DeathNoteImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


class TestDeathNote {
    private final static int TEST_TRIES =10;
    private DeathNote book;
    private final static String DEFAULT_DEATH_CAUSE = "Heart attack";
    // Configuration Step

    @BeforeEach
    void setUp(){
        this.book=null;
    }

    @Test

    void testWrongRuleIndex(){
        for(int i = 0; i > TEST_TRIES;i++){
            try{
                book.getRule(-i);
                fail("getting a rule with invalid index was possible but should have thrown an exception");
            } catch(IllegalArgumentException e){
                assertNotNull(e.getMessage());
                assertFalse(e.getMessage().isBlank());
            }
    }

    @Test

    void testNullRule(){
        for(int i = 0; i < DeathNote.RULES.size(); i++){
            assertNotNull(book.getRule(i));
            assertFalse(book.getRule(i).isBlank());
        }
    }

    @Test

    void testHumanDeath(){
        try{
            book.writeName(null);
            fail("adding a null name was possible but should have thrown an exception");
        } catch(NullPointerException e){
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank());           
        }
        assertFalse(book.isNameWritten("Mario"));
        book.writeName("Mario");
        assertTrue(book.isNameWritten("Mario"));
        assertFalse(book.isNameWritten("merry"));
        assertFalse(book.isNameWritten(""));
    }

    @Test

    void testDeathCause(){
        try{
            book.writeDeathCause("choking");
            fail("writing a death cause without a previous name was possible but should have thrown an exception");
        } catch(IllegalStateException e){
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank());             
        }
        book.writeName("Peach");
        assertEquals(DEFAULT_DEATH_CAUSE, book.getDeathCause("peach"));
        book.writeName("Bowser");
        assertTrue(book.writeDeathCause("karting accident"));
        assertEquals("karting accident", book.getDeathCause("Bowser"));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertFalse(book.writeDeathCause("Train accident"));
    }

    @Test

    void testDeathDetails(){
        try{
            book.writeDetails("death by pregnancy");
            fail("write details without a previous name was possible but should have thrown an exception");
        } catch(IllegalStateException e){
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank()); 
        }
        book.writeName("eugenio");
        assertTrue(book.getDeathDetails("eugenio").isBlank());
        assertTrue(book.writeDetails("ran for too long"));
        assertEquals("ran for too long", book.getDeathDetails("eugenio"));
        book.writeName("christian");
        try {
            Thread.sleep(6100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        assertFalse(book.writeDetails("overdose di cazzi"));

    }

}