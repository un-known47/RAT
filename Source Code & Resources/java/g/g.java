package g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Parcel;
import f1.q;
import java.io.File;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import k.s;
import o1.h0;
import o1.o;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class g implements j1.a, i.h {

    /* renamed from: b, reason: collision with root package name */
    public static g f489b;
    public static volatile g c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f490a;

    public /* synthetic */ g(int i2) {
        this.f490a = i2;
    }

    public static final boolean a(h0 h0Var) {
        h0 h0Var2 = p1.i.d;
        o oVarP = h0Var.f900a;
        int iK = o.k(oVarP, p1.f.f1008a);
        if (iK == -1) {
            iK = o.k(h0Var.f900a, p1.f.f1009b);
        }
        if (iK != -1) {
            oVarP = o.p(oVarP, iK + 1, 0, 2);
        } else if (h0Var.g() != null && oVarP.d() == 2) {
            oVarP = o.d;
        }
        return !q.h0(oVarP.r(), ".class", true);
    }

    public static String b(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("r8-abstract-class");
    }

    public static o c(String str) {
        int i2;
        char cCharAt;
        kotlin.jvm.internal.j.e(str, "<this>");
        byte[] bArr = o1.a.f884a;
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i3 = (int) ((length * 6) / 8);
        byte[] bArrCopyOf = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i4 < length) {
                char cCharAt2 = str.charAt(i4);
                if ('A' <= cCharAt2 && cCharAt2 < '[') {
                    i2 = cCharAt2 - 'A';
                } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                    i2 = cCharAt2 - 'G';
                } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                    i2 = cCharAt2 + 4;
                } else if (cCharAt2 != '+' && cCharAt2 != '-') {
                    if (cCharAt2 != '/' && cCharAt2 != '_') {
                        if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                            break;
                        }
                        i4++;
                    } else {
                        i2 = 63;
                    }
                } else {
                    i2 = 62;
                }
                i6 = (i6 << 6) | i2;
                i5++;
                if (i5 % 4 == 0) {
                    bArrCopyOf[i7] = (byte) (i6 >> 16);
                    int i8 = i7 + 2;
                    bArrCopyOf[i7 + 1] = (byte) (i6 >> 8);
                    i7 += 3;
                    bArrCopyOf[i8] = (byte) i6;
                }
                i4++;
            } else {
                int i9 = i5 % 4;
                if (i9 != 1) {
                    if (i9 == 2) {
                        bArrCopyOf[i7] = (byte) ((i6 << 12) >> 16);
                        i7++;
                    } else if (i9 == 3) {
                        int i10 = i6 << 6;
                        int i11 = i7 + 1;
                        bArrCopyOf[i7] = (byte) (i10 >> 16);
                        i7 += 2;
                        bArrCopyOf[i11] = (byte) (i10 >> 8);
                    }
                    if (i7 != i3) {
                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, i7);
                        kotlin.jvm.internal.j.d(bArrCopyOf, "copyOf(...)");
                    }
                }
            }
        }
        bArrCopyOf = null;
        if (bArrCopyOf != null) {
            return new o(bArrCopyOf);
        }
        return null;
    }

    public static o d(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (p1.b.a(str.charAt(i3 + 1)) + (p1.b.a(str.charAt(i3)) << 4));
        }
        return new o(bArr);
    }

    public static o e(String str) {
        kotlin.jvm.internal.j.e(str, "<this>");
        byte[] bytes = str.getBytes(f1.a.f458a);
        kotlin.jvm.internal.j.d(bytes, "getBytes(...)");
        o oVar = new o(bytes);
        oVar.c = str;
        return oVar;
    }

    public static h0 g(String str) {
        kotlin.jvm.internal.j.e(str, "<this>");
        o oVar = p1.f.f1008a;
        o1.l lVar = new o1.l();
        lVar.b0(str);
        return p1.f.d(lVar, false);
    }

    public static h0 h(File file) {
        String str = h0.f899b;
        String string = file.toString();
        kotlin.jvm.internal.j.d(string, "toString(...)");
        return g(string);
    }

    public static h0 i(Path path) {
        String str = h0.f899b;
        kotlin.jvm.internal.j.e(path, "<this>");
        return g(path.toString());
    }

    public static void j(Context context) {
        s.b(context);
        synchronized (g.class) {
            try {
                if (f489b == null) {
                    n.a(context);
                    g gVar = new g(0);
                    context.getApplicationContext();
                    f489b = gVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static o k(byte[] bArr) {
        o oVar = o.d;
        int length = bArr.length;
        o1.b.e(bArr.length, 0, length);
        return new o(m0.i.o0(bArr, 0, length));
    }

    public static h0 l(h0 h0Var, h0 base) {
        kotlin.jvm.internal.j.e(h0Var, "<this>");
        kotlin.jvm.internal.j.e(base, "base");
        return p1.i.d.d(q.l0(f1.j.z0(h0Var.f900a.r(), base.f900a.r()), '\\', '/'));
    }

    public static final k m(PackageInfo packageInfo, k... kVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        l lVar = new l(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < kVarArr.length; i2++) {
            if (kVarArr[i2].equals(lVar)) {
                return kVarArr[i2];
            }
        }
        return null;
    }

    public static final boolean n(PackageInfo packageInfo) {
        PackageInfo packageInfo2;
        boolean z2;
        if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z2 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            } else {
                z2 = true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
            z2 = true;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z2 ? m(packageInfo2, m.f497a) : m(packageInfo2, m.f497a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // i.h
    public void accept(Object obj, Object obj2) {
        v.j jVar = new v.j((y.c) obj2);
        t.c cVar = (t.c) ((t.a) obj).q();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
        int i2 = t.b.f1181a;
        parcelObtain.writeStrongBinder(jVar);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            cVar.f1182a.transact(14, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c0.q f(h0.a r9, boolean r10) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g.g.f(h0.a, boolean):c0.q");
    }

    public String toString() {
        switch (this.f490a) {
            case 1:
                return Collections.EMPTY_MAP.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ g(v.e eVar) {
        this.f490a = 9;
    }
}
