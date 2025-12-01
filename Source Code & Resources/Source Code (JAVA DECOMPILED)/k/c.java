package k;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Set f703a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f704b;
    public final String c;
    public final String d;

    /* renamed from: e, reason: collision with root package name */
    public final w.a f705e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f706f;

    public c(Set set, String str, String str2) {
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f703a = setUnmodifiableSet;
        Map map = Collections.EMPTY_MAP;
        this.c = str;
        this.d = str2;
        this.f705e = w.a.f1200a;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.f704b = Collections.unmodifiableSet(hashSet);
    }
}
