package e1;

import f1.r;
import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class g implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f439a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f440b;
    public final l0.a c;

    public g(g gVar, o oVar) {
        this.f440b = gVar;
        this.c = oVar;
    }

    @Override // e1.i
    public final Iterator iterator() {
        switch (this.f439a) {
            case 0:
                return new f(this);
            case 1:
                return new h(this);
            case 2:
                return new q(this);
            default:
                return new f1.b(this);
        }
    }

    public g(i sequence, y0.l transformer) {
        kotlin.jvm.internal.j.e(sequence, "sequence");
        kotlin.jvm.internal.j.e(transformer, "transformer");
        this.f440b = sequence;
        this.c = transformer;
    }

    public g(n nVar, y0.l getNextValue) {
        kotlin.jvm.internal.j.e(getNextValue, "getNextValue");
        this.f440b = nVar;
        this.c = getNextValue;
    }

    public g(CharSequence input, r rVar) {
        kotlin.jvm.internal.j.e(input, "input");
        this.f440b = input;
        this.c = rVar;
    }
}
