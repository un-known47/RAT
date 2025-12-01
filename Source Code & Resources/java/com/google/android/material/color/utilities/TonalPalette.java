package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class TonalPalette {
    Map<Integer, Integer> cache = new HashMap();
    double chroma;
    double hue;
    Hct keyColor;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class KeyColor {
        private static final double MAX_CHROMA_VALUE = 200.0d;
        private final Map<Integer, Double> chromaCache = new HashMap();
        private final double hue;
        private final double requestedChroma;

        public KeyColor(double d, double d2) {
            this.hue = d;
            this.requestedChroma = d2;
        }

        private double maxChroma(int i2) {
            if (this.chromaCache.get(Integer.valueOf(i2)) == null) {
                this.chromaCache.put(Integer.valueOf(i2), Double.valueOf(Hct.from(this.hue, MAX_CHROMA_VALUE, i2).getChroma()));
            }
            return this.chromaCache.get(Integer.valueOf(i2)).doubleValue();
        }

        public Hct create() {
            int i2 = 100;
            int i3 = 0;
            while (i3 < i2) {
                int i4 = (i3 + i2) / 2;
                int i5 = i4 + 1;
                boolean z2 = maxChroma(i4) < maxChroma(i5);
                if (maxChroma(i4) >= this.requestedChroma - 0.01d) {
                    if (Math.abs(i3 - 50) < Math.abs(i2 - 50)) {
                        i2 = i4;
                    } else {
                        if (i3 == i4) {
                            return Hct.from(this.hue, this.requestedChroma, i3);
                        }
                        i3 = i4;
                    }
                } else if (z2) {
                    i3 = i5;
                } else {
                    i2 = i4;
                }
            }
            return Hct.from(this.hue, this.requestedChroma, i3);
        }
    }

    private TonalPalette(double d, double d2, Hct hct) {
        this.hue = d;
        this.chroma = d2;
        this.keyColor = hct;
    }

    public static TonalPalette fromHct(Hct hct) {
        return new TonalPalette(hct.getHue(), hct.getChroma(), hct);
    }

    public static TonalPalette fromHueAndChroma(double d, double d2) {
        return new TonalPalette(d, d2, new KeyColor(d, d2).create());
    }

    public static TonalPalette fromInt(int i2) {
        return fromHct(Hct.fromInt(i2));
    }

    public double getChroma() {
        return this.chroma;
    }

    public Hct getHct(double d) {
        return Hct.from(this.hue, this.chroma, d);
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }

    public int tone(int i2) {
        Integer numValueOf = this.cache.get(Integer.valueOf(i2));
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(Hct.from(this.hue, this.chroma, i2).toInt());
            this.cache.put(Integer.valueOf(i2), numValueOf);
        }
        return numValueOf.intValue();
    }
}
