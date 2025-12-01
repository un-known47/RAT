package f1;

import java.io.IOException;
import o1.h0;
import o1.v;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements y0.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f471a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f472b;

    public /* synthetic */ f(int i2, Object obj) {
        this.f471a = i2;
        this.f472b = obj;
    }

    @Override // y0.l
    public final Object invoke(Object obj) {
        switch (this.f471a) {
            case 0:
                return ((g) this.f472b).a(((Integer) obj).intValue());
            case 1:
                return obj == ((m0.a) this.f472b) ? "(this Collection)" : String.valueOf(obj);
            case 2:
                v vVar = (v) this.f472b;
                h0 it = (h0) obj;
                kotlin.jvm.internal.j.e(it, "it");
                return vVar.onPathResult(it, "listRecursively");
            default:
                return DiskLruCache.newJournalWriter$lambda$3((DiskLruCache) this.f472b, (IOException) obj);
        }
    }
}
