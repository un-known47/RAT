package androidx.appcompat.app;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.j;
import o1.h0;
import y0.l;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract /* synthetic */ class g {
    public static double a(double d, double d2, double d3) {
        return (Math.sin(d) * d2) + d3;
    }

    public static float b(float f2, float f3, float f4, float f5) {
        return ((f2 - f3) * f4) + f5;
    }

    public static String c(int i2, String str) {
        return str + i2;
    }

    public static String d(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String e(String str, int i2, String str2) {
        return str + i2 + str2;
    }

    public static String f(String str, long j) {
        return str + j;
    }

    public static String g(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String h(String str, String str2) {
        return str + str2;
    }

    public static String i(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String j(StringBuilder sb, char c, String str) {
        sb.append(c);
        String string = sb.toString();
        j.d(string, str);
        return string;
    }

    public static String k(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String l(h0 h0Var, String str) {
        return str + h0Var;
    }

    public static StringBuilder m(CharSequence charSequence, String str, CharSequence charSequence2, String str2, CharSequence charSequence3) {
        j.e(charSequence, str);
        j.e(charSequence2, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence3);
        return sb;
    }

    public static StringBuilder n(CharSequence charSequence, String str, l lVar, String str2, CharSequence charSequence2) {
        j.e(charSequence, str);
        j.e(lVar, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    public static StringBuilder o(CharSequence charSequence, String str, p pVar, String str2, CharSequence charSequence2) {
        j.e(charSequence, str);
        j.e(pVar, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    public static StringBuilder p(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder q(String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i2);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder r(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder s(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void t(int i2, int i3, l lVar) {
        lVar.invoke(Integer.valueOf(i2 + i3));
    }

    public static /* synthetic */ void u(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static String v(String str, String str2) {
        return str + str2;
    }

    public static /* synthetic */ String w(int i2) {
        switch (i2) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return "STRING";
            case 7:
                return "NUMBER";
            case 8:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }
}
