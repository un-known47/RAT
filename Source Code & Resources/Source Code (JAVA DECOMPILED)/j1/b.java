package j1;

import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b implements a {
    private volatile /* synthetic */ Object _state;

    /* renamed from: a, reason: collision with root package name */
    public int f695a;

    public b(Object obj) {
        this._state = obj;
    }

    public final void a(Object obj) {
        int i2;
        if (obj == null) {
            obj = k1.a.f781a;
        }
        synchronized (this) {
            if (j.a(this._state, obj)) {
                return;
            }
            this._state = obj;
            int i3 = this.f695a;
            if ((i3 & 1) != 0) {
                this.f695a = i3 + 2;
                return;
            }
            int i4 = i3 + 1;
            this.f695a = i4;
            while (true) {
                synchronized (this) {
                    i2 = this.f695a;
                    if (i2 == i4) {
                        this.f695a = i4 + 1;
                        return;
                    }
                }
                i4 = i2;
            }
        }
    }
}
