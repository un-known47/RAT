package a0;

import java.io.IOException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class j extends b0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4a;

    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        switch (this.f4a) {
            case 0:
                if (aVar.X() != 9) {
                    return Double.valueOf(aVar.O());
                }
                aVar.T();
                return null;
            case 1:
                if (aVar.X() != 9) {
                    return Float.valueOf((float) aVar.O());
                }
                aVar.T();
                return null;
            default:
                aVar.d0();
                return null;
        }
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        switch (this.f4a) {
            case 0:
                Number number = (Number) obj;
                if (number != null) {
                    double dDoubleValue = number.doubleValue();
                    m.a(dDoubleValue);
                    bVar.O(dDoubleValue);
                    break;
                } else {
                    bVar.K();
                    break;
                }
            case 1:
                Number numberValueOf = (Number) obj;
                if (numberValueOf != null) {
                    float fFloatValue = numberValueOf.floatValue();
                    m.a(fFloatValue);
                    if (!(numberValueOf instanceof Float)) {
                        numberValueOf = Float.valueOf(fFloatValue);
                    }
                    bVar.Q(numberValueOf);
                    break;
                } else {
                    bVar.K();
                    break;
                }
            default:
                bVar.K();
                break;
        }
    }

    public String toString() {
        switch (this.f4a) {
            case 2:
                return "AnonymousOrNonStaticLocalClassAdapter";
            default:
                return super.toString();
        }
    }
}
