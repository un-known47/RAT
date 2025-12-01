package d0;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class n implements a0.c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f405a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f406b;

    public /* synthetic */ n(int i2, Object obj) {
        this.f405a = i2;
        this.f406b = obj;
    }

    @Override // a0.c0
    public final a0.b0 a(a0.m mVar, h0.a aVar) {
        switch (this.f405a) {
            case 0:
                if (aVar.f525a == Number.class) {
                    return (o) this.f406b;
                }
                return null;
            case 1:
                if (aVar.f525a == Object.class) {
                    return new p(mVar, (a0.z) this.f406b);
                }
                return null;
            default:
                Class cls = aVar.f525a;
                if (cls == Calendar.class || cls == GregorianCalendar.class) {
                    return (o0) this.f406b;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f405a) {
            case 2:
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + ((o0) this.f406b) + "]";
            default:
                return super.toString();
        }
    }
}
