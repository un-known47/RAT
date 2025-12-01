package p1;

import java.io.IOException;
import kotlin.jvm.internal.o;
import o1.k0;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1031a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f1032b;
    public final /* synthetic */ k0 c;
    public final /* synthetic */ o d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ o f1033e;

    public /* synthetic */ l(o oVar, k0 k0Var, o oVar2, o oVar3) {
        this.f1032b = oVar;
        this.c = k0Var;
        this.d = oVar2;
        this.f1033e = oVar3;
    }

    @Override // y0.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        int i2 = this.f1031a;
        int iIntValue = ((Integer) obj).intValue();
        Long l2 = (Long) obj2;
        switch (i2) {
            case 0:
                long jLongValue = l2.longValue();
                if (iIntValue == 21589) {
                    if (jLongValue < 1) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    k0 k0Var = this.c;
                    byte b2 = k0Var.readByte();
                    boolean z2 = (b2 & 1) == 1;
                    boolean z3 = (b2 & 2) == 2;
                    boolean z4 = (b2 & 4) == 4;
                    long j = z2 ? 5L : 1L;
                    if (z3) {
                        j += 4;
                    }
                    if (z4) {
                        j += 4;
                    }
                    if (jLongValue < j) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    if (z2) {
                        this.f1032b.f789a = Integer.valueOf(k0Var.D());
                    }
                    if (z3) {
                        this.d.f789a = Integer.valueOf(k0Var.D());
                    }
                    if (z4) {
                        this.f1033e.f789a = Integer.valueOf(k0Var.D());
                    }
                }
                return l0.i.f856a;
            default:
                long jLongValue2 = l2.longValue();
                if (iIntValue == 1) {
                    o oVar = this.f1032b;
                    if (oVar.f789a != null) {
                        throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
                    }
                    if (jLongValue2 != 24) {
                        throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                    }
                    k0 k0Var2 = this.c;
                    oVar.f789a = Long.valueOf(k0Var2.E());
                    this.d.f789a = Long.valueOf(k0Var2.E());
                    this.f1033e.f789a = Long.valueOf(k0Var2.E());
                }
                return l0.i.f856a;
        }
    }

    public /* synthetic */ l(k0 k0Var, o oVar, o oVar2, o oVar3) {
        this.c = k0Var;
        this.f1032b = oVar;
        this.d = oVar2;
        this.f1033e = oVar3;
    }
}
