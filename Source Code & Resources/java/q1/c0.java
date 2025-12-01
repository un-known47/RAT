package q1;

import java.lang.reflect.Array;
import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c0 extends b1 {
    public final /* synthetic */ int d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ b1 f1067e;

    public /* synthetic */ c0(b1 b1Var, int i2) {
        this.d = i2;
        this.f1067e = b1Var;
    }

    @Override // q1.b1
    public final void a(p0 p0Var, Object obj) {
        switch (this.d) {
            case 0:
                Iterable iterable = (Iterable) obj;
                if (iterable != null) {
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        this.f1067e.a(p0Var, it.next());
                    }
                    break;
                }
                break;
            default:
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i2 = 0; i2 < length; i2++) {
                        this.f1067e.a(p0Var, Array.get(obj, i2));
                    }
                    break;
                }
                break;
        }
    }
}
