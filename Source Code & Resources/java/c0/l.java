package c0;

import java.util.Comparator;
import o1.h0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class l implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f177a;

    public /* synthetic */ l(int i2) {
        this.f177a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f177a) {
            case 0:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            default:
                h0 h0Var = ((p1.k) obj).f1018a;
                h0 h0Var2 = ((p1.k) obj2).f1018a;
                if (h0Var == h0Var2) {
                    return 0;
                }
                if (h0Var == null) {
                    return -1;
                }
                if (h0Var2 == null) {
                    return 1;
                }
                return h0Var.compareTo(h0Var2);
        }
    }
}
