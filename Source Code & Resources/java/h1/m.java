package h1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class m extends kotlin.jvm.internal.k implements y0.p {

    /* renamed from: b, reason: collision with root package name */
    public static final m f553b;
    public static final m c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f554a;

    static {
        int i2 = 2;
        f553b = new m(i2, 0);
        c = new m(i2, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(int i2, int i3) {
        super(i2);
        this.f554a = i3;
    }

    @Override // y0.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f554a) {
            case 0:
                return ((p0.i) obj).plus((p0.g) obj2);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            default:
                return ((p0.i) obj).plus((p0.g) obj2);
        }
    }
}
