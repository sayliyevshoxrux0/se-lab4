package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        boolean result = store.fire(1);

        assertTrue(result);
    }

    @Test
    void fire_FailureRateOne() {
        TorpedoStore store = new TorpedoStore(10, 1.0);

        boolean result = store.fire(1);

        assertFalse(result);
    }

    @Test
    void fire_DecreasesTorpedoCount() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        store.fire(3);

        assertEquals(7, store.getTorpedoCount());
    }

    @Test
    void fire_ThrowsWhenZeroRequested() {
        TorpedoStore store = new TorpedoStore(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> store.fire(0));
    }

    @Test
    void fire_ThrowsWhenNegativeRequested() {
        TorpedoStore store = new TorpedoStore(10);

        assertThrows(
                IllegalArgumentException.class,
                () -> store.fire(-1));
    }

    @Test
    void fire_ThrowsWhenTooManyRequested() {
        TorpedoStore store = new TorpedoStore(1);

        assertThrows(
                IllegalArgumentException.class,
                () -> store.fire(2));
    }

    @Test
    void empty_True() {
        TorpedoStore store = new TorpedoStore(0);

        assertTrue(store.isEmpty());
    }

    @Test
    void empty_False() {
        TorpedoStore store = new TorpedoStore(1);

        assertFalse(store.isEmpty());
    }

    @Test
    void getTorpedoCount_ReturnsValue() {
        TorpedoStore store = new TorpedoStore(10);

        assertEquals(10, store.getTorpedoCount());
    }
}