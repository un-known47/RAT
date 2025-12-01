package com.google.android.material.color.utilities;

import java.util.function.Function;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f277a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f278b;

    public /* synthetic */ a(int i2, Object obj) {
        this.f277a = i2;
        this.f278b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f277a) {
            case 0:
                return DynamicColor.lambda$fromArgb$0((TonalPalette) this.f278b, (DynamicScheme) obj);
            case 1:
                return DynamicColor.lambda$fromArgb$1((Hct) this.f278b, (DynamicScheme) obj);
            default:
                return ((TemperatureCache) this.f278b).lambda$getHctsByTemp$0((Hct) obj);
        }
    }
}
