package kotlinx.coroutines.internal;

import h1.b1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class q extends kotlin.jvm.internal.k implements y0.p {

    /* renamed from: b, reason: collision with root package name */
    public static final q f816b;
    public static final q c;
    public static final q d;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f817a;

    static {
        int i2 = 2;
        f816b = new q(i2, 0);
        c = new q(i2, 1);
        d = new q(i2, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(int i2, int i3) {
        super(i2);
        this.f817a = i3;
    }

    @Override // y0.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f817a) {
            case 0:
                p0.g gVar = (p0.g) obj2;
                if (!(gVar instanceof b1)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? gVar : Integer.valueOf(iIntValue + 1);
            case 1:
                b1 b1Var = (b1) obj;
                p0.g gVar2 = (p0.g) obj2;
                if (b1Var != null) {
                    return b1Var;
                }
                if (gVar2 instanceof b1) {
                    return (b1) gVar2;
                }
                return null;
            default:
                return (r) obj;
        }
    }
}
