package f1;

import java.util.regex.Matcher;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class e extends m0.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f470a;

    public e(h hVar) {
        this.f470a = hVar;
    }

    @Override // m0.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return super.contains((String) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        String strGroup = ((Matcher) this.f470a.f474a).group(i2);
        return strGroup == null ? "" : strGroup;
    }

    @Override // m0.a
    public final int getSize() {
        return ((Matcher) this.f470a.f474a).groupCount() + 1;
    }

    @Override // m0.e, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof String) {
            return super.indexOf((String) obj);
        }
        return -1;
    }

    @Override // m0.e, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return super.lastIndexOf((String) obj);
        }
        return -1;
    }
}
