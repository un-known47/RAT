package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final ContrastCurve contrastCurve;
    private final HashMap<DynamicScheme, Hct> hctCache;
    public final boolean isBackground;
    public final String name;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, TonalPalette> palette;
    public final Function<DynamicScheme, DynamicColor> secondBackground;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaPair> toneDeltaPair;

    public DynamicColor(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z2, @Nullable Function<DynamicScheme, DynamicColor> function3, @Nullable Function<DynamicScheme, DynamicColor> function4, @Nullable ContrastCurve contrastCurve, @Nullable Function<DynamicScheme, ToneDeltaPair> function5) {
        this.hctCache = new HashMap<>();
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z2;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve;
        this.toneDeltaPair = function5;
        this.opacity = null;
    }

    public static double enableLightForeground(double d) {
        if (!tonePrefersLightForeground(d) || toneAllowsLightForeground(d)) {
            return d;
        }
        return 49.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double foregroundTone(double r11, double r13) {
        /*
            double r0 = com.google.android.material.color.utilities.Contrast.lighterUnsafe(r11, r13)
            double r2 = com.google.android.material.color.utilities.Contrast.darkerUnsafe(r11, r13)
            double r4 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r0, r11)
            double r6 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r2, r11)
            boolean r11 = tonePrefersLightForeground(r11)
            if (r11 == 0) goto L3b
            double r11 = r4 - r6
            double r11 = java.lang.Math.abs(r11)
            r8 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r10 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r10 >= 0) goto L2f
            int r11 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r11 >= 0) goto L2f
            int r11 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r11 >= 0) goto L2f
            r11 = 1
            goto L30
        L2f:
            r11 = 0
        L30:
            int r12 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r12 >= 0) goto L44
            int r12 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r12 >= 0) goto L44
            if (r11 == 0) goto L45
            goto L44
        L3b:
            int r11 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r11 >= 0) goto L45
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 < 0) goto L44
            goto L45
        L44:
            return r0
        L45:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.DynamicColor.foregroundTone(double, double):double");
    }

    @NonNull
    public static DynamicColor fromArgb(@NonNull String str, int i2) {
        return fromPalette(str, new a(0, TonalPalette.fromInt(i2)), new a(1, Hct.fromInt(i2)));
    }

    @NonNull
    public static DynamicColor fromPalette(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2) {
        return new DynamicColor(str, function, function2, false, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$fromArgb$1(Hct hct, DynamicScheme dynamicScheme) {
        return Double.valueOf(hct.getTone());
    }

    public static boolean toneAllowsLightForeground(double d) {
        return Math.round(d) <= 49;
    }

    public static boolean tonePrefersLightForeground(double d) {
        return Math.round(d) < 60;
    }

    public int getArgb(@NonNull DynamicScheme dynamicScheme) {
        int i2 = getHct(dynamicScheme).toInt();
        Function<DynamicScheme, Double> function = this.opacity;
        if (function == null) {
            return i2;
        }
        return (MathUtils.clampInt(0, 255, (int) Math.round(((Double) function.apply(dynamicScheme)).doubleValue() * 255.0d)) << 24) | (i2 & ViewCompat.MEASURED_SIZE_MASK);
    }

    @NonNull
    public Hct getHct(@NonNull DynamicScheme dynamicScheme) {
        Hct hct = this.hctCache.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        Hct hct2 = ((TonalPalette) this.palette.apply(dynamicScheme)).getHct(getTone(dynamicScheme));
        if (this.hctCache.size() > 4) {
            this.hctCache.clear();
        }
        this.hctCache.put(dynamicScheme, hct2);
        return hct2;
    }

    public double getTone(@NonNull DynamicScheme dynamicScheme) {
        double dMax;
        double dMin;
        boolean z2 = false;
        boolean z3 = dynamicScheme.contrastLevel < 0.0d;
        Function<DynamicScheme, ToneDeltaPair> function = this.toneDeltaPair;
        if (function == null) {
            boolean z4 = z3;
            double dDoubleValue = ((Double) this.tone.apply(dynamicScheme)).doubleValue();
            Function<DynamicScheme, DynamicColor> function2 = this.background;
            if (function2 == null) {
                return dDoubleValue;
            }
            double tone = ((DynamicColor) function2.apply(dynamicScheme)).getTone(dynamicScheme);
            double d = this.contrastCurve.get(dynamicScheme.contrastLevel);
            if (Contrast.ratioOfTones(tone, dDoubleValue) < d) {
                dDoubleValue = foregroundTone(tone, d);
            }
            if (z4) {
                dDoubleValue = foregroundTone(tone, d);
            }
            if (this.isBackground && 50.0d <= dDoubleValue && dDoubleValue < 60.0d) {
                dDoubleValue = Contrast.ratioOfTones(49.0d, tone) >= d ? 49.0d : 60.0d;
            }
            if (this.secondBackground != null) {
                double tone2 = ((DynamicColor) this.background.apply(dynamicScheme)).getTone(dynamicScheme);
                double tone3 = ((DynamicColor) this.secondBackground.apply(dynamicScheme)).getTone(dynamicScheme);
                double dMax2 = Math.max(tone2, tone3);
                double dMin2 = Math.min(tone2, tone3);
                if (Contrast.ratioOfTones(dMax2, dDoubleValue) < d || Contrast.ratioOfTones(dMin2, dDoubleValue) < d) {
                    double dLighter = Contrast.lighter(dMax2, d);
                    double dDarker = Contrast.darker(dMin2, d);
                    ArrayList arrayList = new ArrayList();
                    if (dLighter != -1.0d) {
                        arrayList.add(Double.valueOf(dLighter));
                    }
                    if (dDarker != -1.0d) {
                        arrayList.add(Double.valueOf(dDarker));
                    }
                    if (tonePrefersLightForeground(tone2) || tonePrefersLightForeground(tone3)) {
                        if (dLighter == -1.0d) {
                            return 100.0d;
                        }
                        return dLighter;
                    }
                    if (arrayList.size() == 1) {
                        return ((Double) arrayList.get(0)).doubleValue();
                    }
                    if (dDarker == -1.0d) {
                        return 0.0d;
                    }
                    return dDarker;
                }
            }
            return dDoubleValue;
        }
        ToneDeltaPair toneDeltaPair = (ToneDeltaPair) function.apply(dynamicScheme);
        DynamicColor roleA = toneDeltaPair.getRoleA();
        DynamicColor roleB = toneDeltaPair.getRoleB();
        double delta = toneDeltaPair.getDelta();
        TonePolarity polarity = toneDeltaPair.getPolarity();
        boolean stayTogether = toneDeltaPair.getStayTogether();
        double tone4 = ((DynamicColor) this.background.apply(dynamicScheme)).getTone(dynamicScheme);
        if (polarity == TonePolarity.NEARER || ((polarity == TonePolarity.LIGHTER && !dynamicScheme.isDark) || (polarity == TonePolarity.DARKER && dynamicScheme.isDark))) {
            z2 = true;
        }
        DynamicColor dynamicColor = z2 ? roleA : roleB;
        DynamicColor dynamicColor2 = z2 ? roleB : roleA;
        boolean zEquals = this.name.equals(dynamicColor.name);
        double d2 = dynamicScheme.isDark ? 1.0d : -1.0d;
        double d3 = dynamicColor.contrastCurve.get(dynamicScheme.contrastLevel);
        double d4 = dynamicColor2.contrastCurve.get(dynamicScheme.contrastLevel);
        boolean z5 = z3;
        double dDoubleValue2 = ((Double) dynamicColor.tone.apply(dynamicScheme)).doubleValue();
        if (Contrast.ratioOfTones(tone4, dDoubleValue2) < d3) {
            dDoubleValue2 = foregroundTone(tone4, d3);
        }
        double dDoubleValue3 = ((Double) dynamicColor2.tone.apply(dynamicScheme)).doubleValue();
        if (Contrast.ratioOfTones(tone4, dDoubleValue3) < d4) {
            dDoubleValue3 = foregroundTone(tone4, d4);
        }
        if (z5) {
            dDoubleValue2 = foregroundTone(tone4, d3);
            dDoubleValue3 = foregroundTone(tone4, d4);
        }
        if ((dDoubleValue3 - dDoubleValue2) * d2 < delta) {
            double d5 = delta * d2;
            double dClampDouble = MathUtils.clampDouble(0.0d, 100.0d, dDoubleValue2 + d5);
            if ((dClampDouble - dDoubleValue2) * d2 < delta) {
                dDoubleValue2 = MathUtils.clampDouble(0.0d, 100.0d, dClampDouble - d5);
            }
            dDoubleValue3 = dClampDouble;
        }
        if (50.0d > dDoubleValue2 || dDoubleValue2 >= 60.0d) {
            if (50.0d > dDoubleValue3 || dDoubleValue3 >= 60.0d) {
                dMax = dDoubleValue3;
            } else if (!stayTogether) {
                dMax = d2 > 0.0d ? 60.0d : 49.0d;
            } else if (d2 > 0.0d) {
                dMax = Math.max(dDoubleValue3, (delta * d2) + 60.0d);
                dDoubleValue2 = 60.0d;
            } else {
                dMin = Math.min(dDoubleValue3, (delta * d2) + 49.0d);
                dMax = dMin;
                dDoubleValue2 = 49.0d;
            }
        } else if (d2 > 0.0d) {
            dMax = Math.max(dDoubleValue3, (delta * d2) + 60.0d);
            dDoubleValue2 = 60.0d;
        } else {
            dMin = Math.min(dDoubleValue3, (delta * d2) + 49.0d);
            dMax = dMin;
            dDoubleValue2 = 49.0d;
        }
        return zEquals ? dDoubleValue2 : dMax;
    }

    @NonNull
    public static DynamicColor fromPalette(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z2) {
        return new DynamicColor(str, function, function2, z2, null, null, null, null);
    }

    public DynamicColor(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z2, @Nullable Function<DynamicScheme, DynamicColor> function3, @Nullable Function<DynamicScheme, DynamicColor> function4, @Nullable ContrastCurve contrastCurve, @Nullable Function<DynamicScheme, ToneDeltaPair> function5, @Nullable Function<DynamicScheme, Double> function6) {
        this.hctCache = new HashMap<>();
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z2;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve;
        this.toneDeltaPair = function5;
        this.opacity = function6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TonalPalette lambda$fromArgb$0(TonalPalette tonalPalette, DynamicScheme dynamicScheme) {
        return tonalPalette;
    }
}
