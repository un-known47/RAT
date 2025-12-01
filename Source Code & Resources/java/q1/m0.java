package q1;

import android.os.Build;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static final i.k f1091a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f1092b;
    public static final a c;

    static {
        String property = System.getProperty("java.vm.name");
        property.getClass();
        if (property.equals("RoboVM")) {
            f1091a = null;
            f1092b = new a(7);
            c = new a(6);
        } else {
            if (!property.equals("Dalvik")) {
                f1091a = null;
                f1092b = new n0(1);
                c = new c(6);
                return;
            }
            f1091a = new i.k(1);
            if (Build.VERSION.SDK_INT >= 24) {
                f1092b = new n0(0);
                c = new c(6);
            } else {
                f1092b = new a(7);
                c = new a(6);
            }
        }
    }
}
