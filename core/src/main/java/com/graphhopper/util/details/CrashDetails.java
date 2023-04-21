package com.graphhopper.util.details;

import com.graphhopper.routing.profiles.IntEncodedValue;
import com.graphhopper.util.EdgeIteratorState;

import static com.graphhopper.util.Parameters.DETAILS.CRASH;

public class CrashDetails extends AbstractPathDetailsBuilder {

    private double crashes = -1;
    private final IntEncodedValue crashEnc;

    public CrashDetails(IntEncodedValue crashEnc) {
        super(CRASH);
        this.crashEnc = crashEnc;
    }

    @Override
    public boolean isEdgeDifferentToLastEdge(EdgeIteratorState edge) {
        double tmpCrashes = edge.get(crashEnc);
        if (tmpCrashes != crashes) {
            crashes = tmpCrashes;
            return true;
        }
        return false;
    }

    @Override
    public Object getCurrentValue() {
        return this.crashes;
    }
}
