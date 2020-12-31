package com.github.tridimensionaal.finalreality.controller.phases;

import com.github.tridimensionaal.finalreality.controller.phases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * A class that tests the FinalPhase class.
 *
 * @author Matías Salim Seda Auil
 * @see FinalPhase 
 */
class FinalPhaseTest extends PhaseTest {
    /**
     * Setup method.
     */
    @BeforeEach
    void setUp() {
        super.setUp();
        controller.setPhase(new FinalPhase(true));
        phase = controller.getPhase();

    }

}




