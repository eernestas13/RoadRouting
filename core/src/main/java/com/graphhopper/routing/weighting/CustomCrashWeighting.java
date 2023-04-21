package com.graphhopper.routing.weighting;

import com.graphhopper.routing.profiles.IntEncodedValue;
import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.util.EdgeIteratorState;
import com.graphhopper.util.PMap;

public class CustomCrashWeighting extends FastestWeighting {

    private final double crashFactor;
    private IntEncodedValue crashEnc;

    public CustomCrashWeighting(FlagEncoder encoder, PMap map) {
        super(encoder, map);
        crashEnc = encoder.getIntEncodedValue("crash");
        crashFactor = convert(map.getDouble("crash", -2));
    }

    double convert(double val) {
        val = Math.min(10, Math.max(-10, val));
        return 1 + val / 10;
    }

    double max = 0;

    @Override
    public double calcWeight(EdgeIteratorState edgeState, boolean reverse, int prevOrNextEdgeId) {
        double weight = super.calcWeight(edgeState, reverse, prevOrNextEdgeId);

        // TODO take into account: count/distance and combine with factor
        // crash density is between 0.01 and 0.15  => 1
//        double density = edgeState.get(crashEnc) / edgeState.getDistance();
//        if (density > max)
//            max = density;


        if (edgeState.get(crashEnc) == 0)
            weight = weight * crashFactor;
        else
            weight = weight / crashFactor;

        return weight;
    }

    @Override
    public String getName() {
        return "wales";
    }
}
