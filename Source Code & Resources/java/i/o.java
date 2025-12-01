package i;

import android.os.Parcel;
import java.util.Optional;
import okhttp3.ResponseBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class o implements h, q1.m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f622a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f623b;

    public /* synthetic */ o(int i2, Object obj) {
        this.f622a = i2;
        this.f623b = obj;
    }

    @Override // q1.m
    public Object a(Object obj) {
        switch (this.f622a) {
            case 5:
                return Optional.ofNullable(((q1.m) this.f623b).a((ResponseBody) obj));
            default:
                ResponseBody responseBody = (ResponseBody) obj;
                i0.a aVar = new i0.a(responseBody.charStream());
                aVar.o = 2;
                try {
                    Object objB = ((a0.b0) this.f623b).b(aVar);
                    if (aVar.X() == 10) {
                        return objB;
                    }
                    throw new a0.p("JSON document was not fully consumed.");
                } finally {
                    responseBody.close();
                }
        }
    }

    @Override // i.h
    public void accept(Object obj, Object obj2) {
        y.c cVar = (y.c) obj2;
        m.a aVar = (m.a) ((m.d) obj).q();
        k.j jVar = (k.j) this.f623b;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(aVar.f1166b);
        int i2 = r.b.f1167a;
        if (jVar == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            jVar.writeToParcel(parcelObtain, 0);
        }
        try {
            aVar.f1165a.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            cVar.a(null);
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    public String toString() {
        switch (this.f622a) {
            case 2:
                return "<" + ((String) this.f623b) + '>';
            default:
                return super.toString();
        }
    }

    public o(a0.m mVar, a0.b0 b0Var) {
        this.f622a = 6;
        this.f623b = b0Var;
    }
}
