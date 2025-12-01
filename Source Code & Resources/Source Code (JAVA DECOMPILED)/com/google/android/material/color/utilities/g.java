package com.google.android.material.color.utilities;

import java.util.function.Function;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f285a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialDynamicColors f286b;

    public /* synthetic */ g(MaterialDynamicColors materialDynamicColors, int i2) {
        this.f285a = i2;
        this.f286b = materialDynamicColors;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f285a) {
            case 0:
                return this.f286b.lambda$secondaryFixed$119((DynamicScheme) obj);
            case 1:
                return this.f286b.lambda$onPrimaryFixedVariant$115((DynamicScheme) obj);
            case 2:
                return this.f286b.lambda$onPrimaryFixedVariant$116((DynamicScheme) obj);
            case 3:
                return this.f286b.lambda$tertiaryFixedDim$136((DynamicScheme) obj);
            case 4:
                return this.f286b.lambda$onTertiary$84((DynamicScheme) obj);
            case 5:
                return this.f286b.lambda$onError$96((DynamicScheme) obj);
            case 6:
                return this.f286b.lambda$onPrimaryContainer$62((DynamicScheme) obj);
            case 7:
                return this.f286b.lambda$onPrimaryContainer$63((DynamicScheme) obj);
            case 8:
                return this.f286b.lambda$secondaryFixedDim$122((DynamicScheme) obj);
            case 9:
                return this.f286b.lambda$primaryFixed$105((DynamicScheme) obj);
            case 10:
                return this.f286b.lambda$primaryFixedDim$108((DynamicScheme) obj);
            case 11:
                return this.f286b.lambda$tertiaryContainer$86((DynamicScheme) obj);
            case 12:
                return this.f286b.lambda$tertiaryContainer$87((DynamicScheme) obj);
            default:
                return this.f286b.highestSurface((DynamicScheme) obj);
        }
    }
}
