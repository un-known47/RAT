package a1;

import java.util.Random;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: b, reason: collision with root package name */
    public final b f22b = new b();

    @Override // a1.a
    public final Random a() {
        Object obj = this.f22b.get();
        j.d(obj, "get(...)");
        return (Random) obj;
    }
}
