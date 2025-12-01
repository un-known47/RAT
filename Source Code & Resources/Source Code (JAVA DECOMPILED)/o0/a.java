package o0;

import java.util.Comparator;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public static final a f882b = new a(0);
    public static final a c = new a(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f883a;

    public /* synthetic */ a(int i2) {
        this.f883a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f883a) {
            case 0:
                Comparable a2 = (Comparable) obj;
                Comparable b2 = (Comparable) obj2;
                j.e(a2, "a");
                j.e(b2, "b");
                return a2.compareTo(b2);
            default:
                Comparable a3 = (Comparable) obj;
                Comparable b3 = (Comparable) obj2;
                j.e(a3, "a");
                j.e(b3, "b");
                return b3.compareTo(a3);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f883a) {
            case 0:
                return c;
            default:
                return f882b;
        }
    }
}
