package f1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements y0.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ char[] f477a;

    @Override // y0.p
    public final Object invoke(Object obj, Object obj2) {
        CharSequence DelimitedRangesSequence = (CharSequence) obj;
        int iIntValue = ((Integer) obj2).intValue();
        kotlin.jvm.internal.j.e(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int iW0 = j.w0(DelimitedRangesSequence, this.f477a, iIntValue, false);
        if (iW0 < 0) {
            return null;
        }
        return new l0.d(Integer.valueOf(iW0), 1);
    }
}
