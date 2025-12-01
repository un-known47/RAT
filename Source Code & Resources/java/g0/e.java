package g0;

import g0.a;
import g0.b;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f506a;

    /* renamed from: b, reason: collision with root package name */
    public static final a.C0004a f507b;
    public static final b.a c;
    public static final c d;

    static {
        boolean z2;
        try {
            Class.forName("java.sql.Date");
            z2 = true;
        } catch (ClassNotFoundException unused) {
            z2 = false;
        }
        f506a = z2;
        if (z2) {
            f507b = a.f500b;
            c = b.f502b;
            d = d.f504b;
        } else {
            f507b = null;
            c = null;
            d = null;
        }
    }
}
