package g;

import android.os.Parcel;
import android.os.RemoteException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import k.q;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class k extends s.a implements q {

    /* renamed from: b, reason: collision with root package name */
    public final int f496b;

    public k(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        if (bArr.length != 25) {
            throw new IllegalArgumentException();
        }
        this.f496b = Arrays.hashCode(bArr);
    }

    public static byte[] e(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // s.a
    public final boolean d(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(this.f496b);
            return true;
        }
        q.a aVar = new q.a(f());
        parcel2.writeNoException();
        int i3 = s.b.f1178a;
        parcel2.writeStrongBinder(aVar);
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof q)) {
            return false;
        }
        try {
            q qVar = (q) obj;
            if (((k) qVar).f496b != this.f496b) {
                return false;
            }
            return Arrays.equals(f(), (byte[]) new q.a(((k) qVar).f()).f1042b);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public abstract byte[] f();

    public final int hashCode() {
        return this.f496b;
    }
}
