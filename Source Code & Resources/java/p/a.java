package p;

import a0.s;
import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.internal.view.SupportMenu;
import com.service.downloadapp.AppMain;
import h1.j0;
import h1.k0;
import h1.u;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.internal.o;
import l0.e;
import m0.f;
import m0.k;
import m0.v;
import okhttp3.ResponseBody;
import p0.d;
import p0.g;
import p0.h;
import p0.i;
import q1.s0;
import r0.c;
import y0.l;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Context f979a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f980b;
    public static Boolean c;
    public static Boolean d;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f981e;

    /* renamed from: f, reason: collision with root package name */
    public static Boolean f982f;

    public static final int A(int i2, int i3, int i4) {
        if (i4 > 0) {
            if (i2 < i3) {
                int i5 = i3 % i4;
                if (i5 < 0) {
                    i5 += i4;
                }
                int i6 = i2 % i4;
                if (i6 < 0) {
                    i6 += i4;
                }
                int i7 = (i5 - i6) % i4;
                if (i7 < 0) {
                    i7 += i4;
                }
                return i3 - i7;
            }
        } else {
            if (i4 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i2 > i3) {
                int i8 = -i4;
                int i9 = i2 % i8;
                if (i9 < 0) {
                    i9 += i8;
                }
                int i10 = i3 % i8;
                if (i10 < 0) {
                    i10 += i8;
                }
                int i11 = (i9 - i10) % i8;
                if (i11 < 0) {
                    i11 += i8;
                }
                return i11 + i3;
            }
        }
        return i3;
    }

    public static d C(d dVar) {
        d<Object> dVarIntercepted;
        j.e(dVar, "<this>");
        c cVar = dVar instanceof c ? (c) dVar : null;
        return (cVar == null || (dVarIntercepted = cVar.intercepted()) == null) ? dVar : dVarIntercepted;
    }

    public static boolean E(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (c == null) {
            c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (c.booleanValue() && Build.VERSION.SDK_INT < 24) {
            return true;
        }
        if (d == null) {
            d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        if (!d.booleanValue()) {
            return false;
        }
        int i2 = Build.VERSION.SDK_INT;
        return i2 < 26 || i2 >= 30;
    }

    public static e1.j F(p pVar) {
        e1.j jVar = new e1.j();
        jVar.d = o(jVar, jVar, pVar);
        return jVar;
    }

    public static List G(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        j.d(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static i H(g gVar, h key) {
        j.e(key, "key");
        return j.a(gVar.getKey(), key) ? p0.j.f989a : gVar;
    }

    public static LinkedHashSet I(Set set, Set elements) {
        j.e(set, "<this>");
        j.e(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(v.g0(set.size() + Integer.valueOf(elements.size()).intValue()));
        linkedHashSet.addAll(set);
        k.m0(linkedHashSet, elements);
        return linkedHashSet;
    }

    public static i J(i iVar, i context) {
        j.e(context, "context");
        return context == p0.j.f989a ? iVar : (i) context.fold(iVar, new p0.b(1));
    }

    public static boolean K(Parcel parcel, int i2) {
        e0(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static int L(Parcel parcel, int i2) {
        e0(parcel, i2, 4);
        return parcel.readInt();
    }

    public static long M(Parcel parcel, int i2) {
        e0(parcel, i2, 8);
        return parcel.readLong();
    }

    public static int N(Parcel parcel, int i2) {
        return (i2 & SupportMenu.CATEGORY_MASK) != -65536 ? (char) (i2 >> 16) : parcel.readInt();
    }

    public static void O(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + N(parcel, i2));
    }

    public static void P(p pVar, h1.a aVar, h1.a aVar2) {
        try {
            kotlinx.coroutines.internal.b.c(l0.i.f856a, C(o(aVar, aVar2, pVar)));
        } catch (Throwable th) {
            aVar2.resumeWith(p(th));
            throw th;
        }
    }

    public static final Object Q(o oVar, o oVar2, p pVar) throws Throwable {
        Object kVar;
        Object objU;
        j0 j0Var;
        try {
            r.c(pVar);
            kVar = pVar.invoke(oVar2, oVar);
        } catch (Throwable th) {
            kVar = new h1.k(false, th);
        }
        q0.a aVar = q0.a.f1043a;
        if (kVar == aVar || (objU = oVar.u(kVar)) == u.c) {
            return aVar;
        }
        if (objU instanceof h1.k) {
            throw ((h1.k) objU).f550a;
        }
        k0 k0Var = objU instanceof k0 ? (k0) objU : null;
        return (k0Var == null || (j0Var = k0Var.f551a) == null) ? objU : j0Var;
    }

    public static c1.b R(c1.d dVar, int i2) {
        j.e(dVar, "<this>");
        boolean z2 = i2 > 0;
        Integer numValueOf = Integer.valueOf(i2);
        if (!z2) {
            throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
        }
        int i3 = dVar.f205a;
        int i4 = dVar.f206b;
        if (dVar.c <= 0) {
            i2 = -i2;
        }
        return new c1.b(i3, i4, i2);
    }

    public static final void S(Object obj) throws Throwable {
        if (obj instanceof e) {
            throw ((e) obj).f852a;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:
    
        if (r0.hasTransport(1) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void T(androidx.appcompat.app.AppCompatActivity r4, java.lang.String r5) {
        /*
            android.content.Context r0 = r4.getApplicationContext()
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Exception -> L2e
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Exception -> L2e
            if (r0 == 0) goto L54
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L2e
            r2 = 23
            r3 = 1
            if (r1 >= r2) goto L30
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L2e
            if (r0 == 0) goto L54
            boolean r1 = r0.isConnected()     // Catch: java.lang.Exception -> L2e
            if (r1 == 0) goto L54
            int r1 = r0.getType()     // Catch: java.lang.Exception -> L2e
            if (r1 == r3) goto L47
            int r0 = r0.getType()     // Catch: java.lang.Exception -> L2e
            if (r0 != 0) goto L54
            goto L47
        L2e:
            r5 = move-exception
            goto L51
        L30:
            android.net.Network r1 = com.google.android.material.internal.b.b(r0)     // Catch: java.lang.Exception -> L2e
            if (r1 == 0) goto L54
            android.net.NetworkCapabilities r0 = r0.getNetworkCapabilities(r1)     // Catch: java.lang.Exception -> L2e
            r1 = 0
            boolean r1 = r0.hasTransport(r1)     // Catch: java.lang.Exception -> L2e
            if (r1 != 0) goto L47
            boolean r0 = r0.hasTransport(r3)     // Catch: java.lang.Exception -> L2e
            if (r0 == 0) goto L54
        L47:
            i.r r0 = new i.r
            r1 = 6
            r0.<init>(r4, r5, r1)
            r4.runOnUiThread(r0)
            return
        L51:
            r5.getStackTrace()
        L54:
            i.m r5 = new i.m
            r0 = 4
            r5.<init>(r0, r4)
            r4.runOnUiThread(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p.a.T(androidx.appcompat.app.AppCompatActivity, java.lang.String):void");
    }

    public static void U(Context context, String str) {
        Intent intent = new Intent("android.intent.action.UNINSTALL_PACKAGE");
        intent.addFlags(268435456);
        intent.setData(Uri.parse("package:" + str));
        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
        context.startActivity(intent);
    }

    public static c1.d V(int i2, int i3) {
        if (i3 > Integer.MIN_VALUE) {
            return new c1.d(i2, i3 - 1, 1);
        }
        c1.d dVar = c1.d.d;
        return c1.d.d;
    }

    public static int W(Parcel parcel) {
        int i2 = parcel.readInt();
        int iN = N(parcel, i2);
        char c2 = (char) i2;
        int iDataPosition = parcel.dataPosition();
        if (c2 != 20293) {
            throw new s("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i2))), parcel);
        }
        int i3 = iN + iDataPosition;
        if (i3 >= iDataPosition && i3 <= parcel.dataSize()) {
            return i3;
        }
        throw new s("Size read is invalid start=" + iDataPosition + " end=" + i3, parcel);
    }

    public static void X(Parcel parcel, int i2, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int iC0 = c0(parcel, i2);
        parcel.writeBundle(bundle);
        d0(parcel, iC0);
    }

    public static void Y(Parcel parcel, int i2, Parcelable parcelable, int i3) {
        if (parcelable == null) {
            return;
        }
        int iC0 = c0(parcel, i2);
        parcelable.writeToParcel(parcel, i3);
        d0(parcel, iC0);
    }

    public static void Z(Parcel parcel, int i2, String str) {
        if (str == null) {
            return;
        }
        int iC0 = c0(parcel, i2);
        parcel.writeString(str);
        d0(parcel, iC0);
    }

    public static final String a(Object[] objArr, int i2, int i3, f fVar) {
        StringBuilder sb = new StringBuilder((i3 * 3) + 2);
        sb.append("[");
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i2 + i4];
            if (obj == fVar) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String string = sb.toString();
        j.d(string, "toString(...)");
        return string;
    }

    public static void a0(Parcel parcel, int i2, Parcelable[] parcelableArr, int i3) {
        if (parcelableArr == null) {
            return;
        }
        int iC0 = c0(parcel, i2);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i3);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        d0(parcel, iC0);
    }

    public static void b(Throwable th, Throwable exception) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        j.e(th, "<this>");
        j.e(exception, "exception");
        if (th != exception) {
            Integer num = u0.a.f1184a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(exception);
                return;
            }
            Method method = t0.a.f1183a;
            if (method != null) {
                method.invoke(th, exception);
            }
        }
    }

    public static void b0(Parcel parcel, int i2, List list) {
        if (list == null) {
            return;
        }
        int iC0 = c0(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            Parcelable parcelable = (Parcelable) list.get(i3);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        d0(parcel, iC0);
    }

    public static void c(Context context, String str) throws PackageManager.NameNotFoundException {
        String str2;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str2 = packageInfo.versionName + " (" + packageInfo.versionCode + ")";
        } catch (Exception e2) {
            e2.getStackTrace();
            str2 = "";
        }
        try {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(context).create();
            alertDialogCreate.setMessage(str + " - " + str2);
            alertDialogCreate.setCancelable(false);
            alertDialogCreate.setButton(-1, context.getString(R.string.ok), new j0.h());
            alertDialogCreate.show();
        } catch (Exception e3) {
            e3.getStackTrace();
        }
    }

    public static int c0(Parcel parcel, int i2) {
        parcel.writeInt(i2 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void d(StringBuilder sb, Object obj, l lVar) {
        if (lVar != null) {
            sb.append((CharSequence) lVar.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static void d0(Parcel parcel, int i2) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(iDataPosition - i2);
        parcel.setDataPosition(iDataPosition);
    }

    public static n0.c e(n0.c cVar) {
        cVar.f();
        cVar.c = true;
        return cVar.f881b > 0 ? cVar : n0.c.d;
    }

    public static void e0(Parcel parcel, int i2, int i3) {
        int iN = N(parcel, i2);
        if (iN == i3) {
            return;
        }
        String hexString = Integer.toHexString(iN);
        StringBuilder sb = new StringBuilder("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(iN);
        sb.append(" (0x");
        throw new s(androidx.appcompat.app.g.k(sb, hexString, ")"), parcel);
    }

    public static void f0(Parcel parcel, int i2, int i3) {
        parcel.writeInt(i2 | (i3 << 16));
    }

    public static String h(Context context) throws PackageManager.NameNotFoundException {
        for (String str : Arrays.asList("mobile.parental2025", "com.protect2025", "phone.child2024", "phone.child2020", "mobile.monitor.child2022")) {
            try {
                context.getPackageManager().getPackageInfo(str, 1);
                return str;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static String i() {
        Object obj;
        try {
            s0 s0VarExecute = new k0.b(AppMain.f361a.getString(com.protect.download.R.string.my_url), null).f776a.a("getVersionApp.php", new HashMap()).execute();
            if (s0VarExecute.f1140a.isSuccessful() && (obj = s0VarExecute.f1141b) != null) {
                return ((ResponseBody) obj).string();
            }
        } catch (Exception e2) {
            e2.getStackTrace();
        }
        return null;
    }

    public static void j(int i2) {
        if (2 > i2 || i2 >= 37) {
            StringBuilder sbQ = androidx.appcompat.app.g.q("radix ", i2, " was not in valid range ");
            sbQ.append(new c1.d(2, 36, 1));
            throw new IllegalArgumentException(sbQ.toString());
        }
    }

    public static final void k(Closeable closeable, Throwable th) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                b(th, th2);
            }
        }
    }

    public static final long l(long j, g1.c sourceUnit, g1.c targetUnit) {
        j.e(sourceUnit, "sourceUnit");
        j.e(targetUnit, "targetUnit");
        return targetUnit.f512a.convert(j, sourceUnit.f512a);
    }

    public static final void m(int i2, int i3) {
        if (i2 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + i3 + ").");
    }

    public static Bundle n(Parcel parcel, int i2) {
        int iN = N(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iN == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iN);
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static d o(d dVar, d dVar2, p pVar) {
        j.e(pVar, "<this>");
        if (pVar instanceof r0.a) {
            return ((r0.a) pVar).create(dVar, dVar2);
        }
        i context = dVar2.getContext();
        return context == p0.j.f989a ? new q0.b(dVar2, dVar, pVar) : new q0.c(dVar2, context, pVar, dVar);
    }

    public static final e p(Throwable exception) {
        j.e(exception, "exception");
        return new e(exception);
    }

    public static n0.c q() {
        return new n0.c(10);
    }

    public static Parcelable r(Parcel parcel, int i2, Parcelable.Creator creator) {
        int iN = N(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iN == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iN);
        return parcelable;
    }

    public static String s(Parcel parcel, int i2) {
        int iN = N(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iN == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iN);
        return string;
    }

    public static Object[] t(Parcel parcel, int i2, Parcelable.Creator creator) {
        int iN = N(parcel, i2);
        int iDataPosition = parcel.dataPosition();
        if (iN == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iN);
        return objArrCreateTypedArray;
    }

    public static void u(Parcel parcel, int i2) {
        if (parcel.dataPosition() != i2) {
            throw new s(androidx.appcompat.app.g.c(i2, "Overread allowed size end="), parcel);
        }
    }

    public static final s0.b v(Enum[] entries) {
        j.e(entries, "entries");
        return new s0.b(entries);
    }

    public static final boolean w(char c2, char c3, boolean z2) {
        if (c2 == c3) {
            return true;
        }
        if (!z2) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class z(d1.c cVar) {
        j.e(cVar, "<this>");
        Class clsA = ((kotlin.jvm.internal.c) cVar).a();
        if (clsA.isPrimitive()) {
            String name = clsA.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals(TypedValues.Custom.S_FLOAT)) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return clsA;
    }

    public abstract String[] B(Class cls);

    public abstract boolean D(Class cls);

    public h.b f(Context context, Looper looper, k.c cVar, Object obj, h.g gVar, h.h hVar) {
        return g(context, looper, cVar, obj, (i.p) gVar, (i.p) hVar);
    }

    public h.b g(Context context, Looper looper, k.c cVar, Object obj, i.p pVar, i.p pVar2) {
        throw new UnsupportedOperationException("buildClient must be implemented");
    }

    public abstract Method x(Class cls, Field field);

    public abstract Constructor y(Class cls);
}
