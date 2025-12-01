package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class DynamicScheme {
    public final double contrastLevel;
    public final TonalPalette errorPalette = TonalPalette.fromHueAndChroma(25.0d, 84.0d);
    public final boolean isDark;
    public final TonalPalette neutralPalette;
    public final TonalPalette neutralVariantPalette;
    public final TonalPalette primaryPalette;
    public final TonalPalette secondaryPalette;
    public final int sourceColorArgb;
    public final Hct sourceColorHct;
    public final TonalPalette tertiaryPalette;
    public final Variant variant;

    public DynamicScheme(Hct hct, Variant variant, boolean z2, double d, TonalPalette tonalPalette, TonalPalette tonalPalette2, TonalPalette tonalPalette3, TonalPalette tonalPalette4, TonalPalette tonalPalette5) {
        this.sourceColorArgb = hct.toInt();
        this.sourceColorHct = hct;
        this.variant = variant;
        this.isDark = z2;
        this.contrastLevel = d;
        this.primaryPalette = tonalPalette;
        this.secondaryPalette = tonalPalette2;
        this.tertiaryPalette = tonalPalette3;
        this.neutralPalette = tonalPalette4;
        this.neutralVariantPalette = tonalPalette5;
    }

    public static double getRotatedHue(Hct hct, double[] dArr, double[] dArr2) {
        double hue = hct.getHue();
        int i2 = 0;
        if (dArr2.length == 1) {
            return MathUtils.sanitizeDegreesDouble(hue + dArr2[0]);
        }
        int length = dArr.length;
        while (i2 <= length - 2) {
            double d = dArr[i2];
            int i3 = i2 + 1;
            double d2 = dArr[i3];
            if (d < hue && hue < d2) {
                return MathUtils.sanitizeDegreesDouble(hue + dArr2[i2]);
            }
            i2 = i3;
        }
        return hue;
    }

    public int getArgb(@NonNull DynamicColor dynamicColor) {
        return dynamicColor.getArgb(this);
    }

    public int getBackground() {
        return getArgb(new MaterialDynamicColors().background());
    }

    public int getControlActivated() {
        return getArgb(new MaterialDynamicColors().controlActivated());
    }

    public int getControlHighlight() {
        return getArgb(new MaterialDynamicColors().controlHighlight());
    }

    public int getControlNormal() {
        return getArgb(new MaterialDynamicColors().controlNormal());
    }

    public int getError() {
        return getArgb(new MaterialDynamicColors().error());
    }

    public int getErrorContainer() {
        return getArgb(new MaterialDynamicColors().errorContainer());
    }

    @NonNull
    public Hct getHct(@NonNull DynamicColor dynamicColor) {
        return dynamicColor.getHct(this);
    }

    public int getInverseOnSurface() {
        return getArgb(new MaterialDynamicColors().inverseOnSurface());
    }

    public int getInversePrimary() {
        return getArgb(new MaterialDynamicColors().inversePrimary());
    }

    public int getInverseSurface() {
        return getArgb(new MaterialDynamicColors().inverseSurface());
    }

    public int getNeutralPaletteKeyColor() {
        return getArgb(new MaterialDynamicColors().neutralPaletteKeyColor());
    }

    public int getNeutralVariantPaletteKeyColor() {
        return getArgb(new MaterialDynamicColors().neutralVariantPaletteKeyColor());
    }

    public int getOnBackground() {
        return getArgb(new MaterialDynamicColors().onBackground());
    }

    public int getOnError() {
        return getArgb(new MaterialDynamicColors().onError());
    }

    public int getOnErrorContainer() {
        return getArgb(new MaterialDynamicColors().onErrorContainer());
    }

    public int getOnPrimary() {
        return getArgb(new MaterialDynamicColors().onPrimary());
    }

    public int getOnPrimaryContainer() {
        return getArgb(new MaterialDynamicColors().onPrimaryContainer());
    }

    public int getOnPrimaryFixed() {
        return getArgb(new MaterialDynamicColors().onPrimaryFixed());
    }

    public int getOnPrimaryFixedVariant() {
        return getArgb(new MaterialDynamicColors().onPrimaryFixedVariant());
    }

    public int getOnSecondary() {
        return getArgb(new MaterialDynamicColors().onSecondary());
    }

    public int getOnSecondaryContainer() {
        return getArgb(new MaterialDynamicColors().onSecondaryContainer());
    }

    public int getOnSecondaryFixed() {
        return getArgb(new MaterialDynamicColors().onSecondaryFixed());
    }

    public int getOnSecondaryFixedVariant() {
        return getArgb(new MaterialDynamicColors().onSecondaryFixedVariant());
    }

    public int getOnSurface() {
        return getArgb(new MaterialDynamicColors().onSurface());
    }

    public int getOnSurfaceVariant() {
        return getArgb(new MaterialDynamicColors().onSurfaceVariant());
    }

    public int getOnTertiary() {
        return getArgb(new MaterialDynamicColors().onTertiary());
    }

    public int getOnTertiaryContainer() {
        return getArgb(new MaterialDynamicColors().onTertiaryContainer());
    }

    public int getOnTertiaryFixed() {
        return getArgb(new MaterialDynamicColors().onTertiaryFixed());
    }

    public int getOnTertiaryFixedVariant() {
        return getArgb(new MaterialDynamicColors().onTertiaryFixedVariant());
    }

    public int getOutline() {
        return getArgb(new MaterialDynamicColors().outline());
    }

    public int getOutlineVariant() {
        return getArgb(new MaterialDynamicColors().outlineVariant());
    }

    public int getPrimary() {
        return getArgb(new MaterialDynamicColors().primary());
    }

    public int getPrimaryContainer() {
        return getArgb(new MaterialDynamicColors().primaryContainer());
    }

    public int getPrimaryFixed() {
        return getArgb(new MaterialDynamicColors().primaryFixed());
    }

    public int getPrimaryFixedDim() {
        return getArgb(new MaterialDynamicColors().primaryFixedDim());
    }

    public int getPrimaryPaletteKeyColor() {
        return getArgb(new MaterialDynamicColors().primaryPaletteKeyColor());
    }

    public int getScrim() {
        return getArgb(new MaterialDynamicColors().scrim());
    }

    public int getSecondary() {
        return getArgb(new MaterialDynamicColors().secondary());
    }

    public int getSecondaryContainer() {
        return getArgb(new MaterialDynamicColors().secondaryContainer());
    }

    public int getSecondaryFixed() {
        return getArgb(new MaterialDynamicColors().secondaryFixed());
    }

    public int getSecondaryFixedDim() {
        return getArgb(new MaterialDynamicColors().secondaryFixedDim());
    }

    public int getSecondaryPaletteKeyColor() {
        return getArgb(new MaterialDynamicColors().secondaryPaletteKeyColor());
    }

    public int getShadow() {
        return getArgb(new MaterialDynamicColors().shadow());
    }

    public int getSurface() {
        return getArgb(new MaterialDynamicColors().surface());
    }

    public int getSurfaceBright() {
        return getArgb(new MaterialDynamicColors().surfaceBright());
    }

    public int getSurfaceContainer() {
        return getArgb(new MaterialDynamicColors().surfaceContainer());
    }

    public int getSurfaceContainerHigh() {
        return getArgb(new MaterialDynamicColors().surfaceContainerHigh());
    }

    public int getSurfaceContainerHighest() {
        return getArgb(new MaterialDynamicColors().surfaceContainerHighest());
    }

    public int getSurfaceContainerLow() {
        return getArgb(new MaterialDynamicColors().surfaceContainerLow());
    }

    public int getSurfaceContainerLowest() {
        return getArgb(new MaterialDynamicColors().surfaceContainerLowest());
    }

    public int getSurfaceDim() {
        return getArgb(new MaterialDynamicColors().surfaceDim());
    }

    public int getSurfaceTint() {
        return getArgb(new MaterialDynamicColors().surfaceTint());
    }

    public int getSurfaceVariant() {
        return getArgb(new MaterialDynamicColors().surfaceVariant());
    }

    public int getTertiary() {
        return getArgb(new MaterialDynamicColors().tertiary());
    }

    public int getTertiaryContainer() {
        return getArgb(new MaterialDynamicColors().tertiaryContainer());
    }

    public int getTertiaryFixed() {
        return getArgb(new MaterialDynamicColors().tertiaryFixed());
    }

    public int getTertiaryFixedDim() {
        return getArgb(new MaterialDynamicColors().tertiaryFixedDim());
    }

    public int getTertiaryPaletteKeyColor() {
        return getArgb(new MaterialDynamicColors().tertiaryPaletteKeyColor());
    }

    public int getTextHintInverse() {
        return getArgb(new MaterialDynamicColors().textHintInverse());
    }

    public int getTextPrimaryInverse() {
        return getArgb(new MaterialDynamicColors().textPrimaryInverse());
    }

    public int getTextPrimaryInverseDisableOnly() {
        return getArgb(new MaterialDynamicColors().textPrimaryInverseDisableOnly());
    }

    public int getTextSecondaryAndTertiaryInverse() {
        return getArgb(new MaterialDynamicColors().textSecondaryAndTertiaryInverse());
    }

    public int getTextSecondaryAndTertiaryInverseDisabled() {
        return getArgb(new MaterialDynamicColors().textSecondaryAndTertiaryInverseDisabled());
    }
}
