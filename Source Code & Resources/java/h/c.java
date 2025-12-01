package h;

import android.util.SparseIntArray;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import q1.b0;
import q1.b1;
import q1.n;
import q1.o;
import q1.s0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c implements y.b, q1.f, q1.g, Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f513a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f514b;
    public final Object c;

    public /* synthetic */ c(int i2, Object obj, Object obj2) {
        this.f513a = i2;
        this.c = obj;
        this.f514b = obj2;
    }

    @Override // y.b
    public void a(y.g gVar) {
        ((Map) ((c) this.c).c).remove((y.c) this.f514b);
    }

    @Override // q1.g
    public void b(q1.d dVar, s0 s0Var) {
        ((o) this.c).f1096a.execute(new n(this, (q1.g) this.f514b, s0Var, 0));
    }

    @Override // q1.f
    public Object c(b0 b0Var) {
        Executor executor = (Executor) this.c;
        return executor == null ? b0Var : new o(executor, b0Var);
    }

    @Override // q1.f
    public Type d() {
        return (Type) this.f514b;
    }

    @Override // q1.g
    public void e(q1.d dVar, Throwable th) {
        ((o) this.c).f1096a.execute(new n(this, (q1.g) this.f514b, th, 1));
    }

    public void f(Object obj, String str) {
        ((ArrayList) this.f514b).add(str + "=" + String.valueOf(obj));
    }

    public void g(boolean z2, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.f514b)) {
            map = new HashMap((Map) this.f514b);
        }
        synchronized (((Map) this.c)) {
            map2 = new HashMap((Map) this.c);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z2 || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                throw new ClassCastException();
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z2 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((y.c) entry2.getKey()).b(new d(status));
            }
        }
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        try {
            ((q1.g) this.f514b).e((b0) this.c, iOException);
        } catch (Throwable th) {
            b1.r(th);
            th.printStackTrace();
        }
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        q1.g gVar = (q1.g) this.f514b;
        b0 b0Var = (b0) this.c;
        try {
            try {
                gVar.b(b0Var, b0Var.c(response));
            } catch (Throwable th) {
                b1.r(th);
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            b1.r(th2);
            try {
                gVar.e(b0Var, th2);
            } catch (Throwable th3) {
                b1.r(th3);
                th3.printStackTrace();
            }
        }
    }

    public String toString() {
        switch (this.f513a) {
            case 4:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.c.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.f514b;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append((String) arrayList.get(i2));
                    if (i2 < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public c(int i2) {
        this.f513a = i2;
        switch (i2) {
            case 5:
                g.d dVar = g.d.c;
                this.f514b = new SparseIntArray();
                this.c = dVar;
                break;
            default:
                this.f514b = Collections.synchronizedMap(new WeakHashMap());
                this.c = Collections.synchronizedMap(new WeakHashMap());
                break;
        }
    }

    public /* synthetic */ c(Object obj) {
        this.f513a = 4;
        this.c = obj;
        this.f514b = new ArrayList();
    }

    public c(String str, p.a aVar, g.g gVar) {
        this.f513a = 0;
        this.c = str;
        this.f514b = aVar;
    }

    public c(Type type, Executor executor) {
        this.f513a = 6;
        this.f514b = type;
        this.c = executor;
    }
}
