package com.graphhopper.routing.profiles;

import com.graphhopper.storage.IntsRef;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


public class BooleanEncodedValueTest {

    @Test
    public void testBit() {
        EncodedValue.InitializerConfig config = new EncodedValue.InitializerConfig();
        IntEncodedValue intProp = new IntEncodedValue("somevalue", 5);
        intProp.init(config);

        BooleanEncodedValue bool = new BooleanEncodedValue("access", false);
        bool.init(config);
        IntsRef ref = new IntsRef(1);
        bool.setBool(false, ref, false);
        assertFalse(bool.getBool(false, ref));
        bool.setBool(false, ref, true);
        assertTrue(bool.getBool(false, ref));
    }

    @Test
    public void testBitDirected() {
        EncodedValue.InitializerConfig config = new EncodedValue.InitializerConfig();
        BooleanEncodedValue bool = new BooleanEncodedValue("access", true);
        bool.init(config);
        IntsRef ref = new IntsRef(1);
        bool.setBool(false, ref, false);
        bool.setBool(true, ref, true);

        assertFalse(bool.getBool(false, ref));
        assertTrue(bool.getBool(true, ref));
    }
}