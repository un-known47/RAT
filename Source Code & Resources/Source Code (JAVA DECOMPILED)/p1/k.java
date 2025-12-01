package p1;

import java.util.ArrayList;
import o1.h0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final h0 f1018a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1019b;
    public final String c;
    public final long d;

    /* renamed from: e, reason: collision with root package name */
    public final long f1020e;

    /* renamed from: f, reason: collision with root package name */
    public final long f1021f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1022g;

    /* renamed from: h, reason: collision with root package name */
    public final long f1023h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1024i;
    public final int j;

    /* renamed from: k, reason: collision with root package name */
    public final Long f1025k;

    /* renamed from: l, reason: collision with root package name */
    public final Long f1026l;

    /* renamed from: m, reason: collision with root package name */
    public final Long f1027m;

    /* renamed from: n, reason: collision with root package name */
    public final Integer f1028n;
    public final Integer o;

    /* renamed from: p, reason: collision with root package name */
    public final Integer f1029p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f1030q;

    public k(h0 canonicalPath, boolean z2, String comment, long j, long j2, long j3, int i2, long j4, int i3, int i4, Long l2, Long l3, Long l4, Integer num, Integer num2, Integer num3) {
        kotlin.jvm.internal.j.e(canonicalPath, "canonicalPath");
        kotlin.jvm.internal.j.e(comment, "comment");
        this.f1018a = canonicalPath;
        this.f1019b = z2;
        this.c = comment;
        this.d = j;
        this.f1020e = j2;
        this.f1021f = j3;
        this.f1022g = i2;
        this.f1023h = j4;
        this.f1024i = i3;
        this.j = i4;
        this.f1025k = l2;
        this.f1026l = l3;
        this.f1027m = l4;
        this.f1028n = num;
        this.o = num2;
        this.f1029p = num3;
        this.f1030q = new ArrayList();
    }

    public /* synthetic */ k(h0 h0Var, boolean z2, String str, long j, long j2, long j3, int i2, long j4, int i3, int i4, Long l2, Long l3, Long l4, int i5) {
        this(h0Var, z2, (i5 & 4) != 0 ? "" : str, (i5 & 8) != 0 ? -1L : j, (i5 & 16) != 0 ? -1L : j2, (i5 & 32) != 0 ? -1L : j3, (i5 & 64) != 0 ? -1 : i2, (i5 & 128) != 0 ? -1L : j4, (i5 & 256) != 0 ? -1 : i3, (i5 & 512) != 0 ? -1 : i4, (i5 & 1024) != 0 ? null : l2, (i5 & 2048) != 0 ? null : l3, (i5 & 4096) != 0 ? null : l4, null, null, null);
    }
}
