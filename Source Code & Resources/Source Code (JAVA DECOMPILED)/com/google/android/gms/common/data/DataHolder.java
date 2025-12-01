package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import l.a;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@KeepName
/* loaded from: classes.dex */
public final class DataHolder extends a implements Closeable {

    @NonNull
    public static final Parcelable.Creator<DataHolder> CREATOR = new e.a(5);

    /* renamed from: a, reason: collision with root package name */
    public final int f226a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f227b;
    public Bundle c;
    public final CursorWindow[] d;

    /* renamed from: e, reason: collision with root package name */
    public final int f228e;

    /* renamed from: f, reason: collision with root package name */
    public final Bundle f229f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f230g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f231h = false;

    static {
        new ArrayList();
        new HashMap();
    }

    public DataHolder(int i2, String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        this.f226a = i2;
        this.f227b = strArr;
        this.d = cursorWindowArr;
        this.f228e = i3;
        this.f229f = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            try {
                if (!this.f231h) {
                    this.f231h = true;
                    int i2 = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.d;
                        if (i2 >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i2].close();
                        i2++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void finalize() throws Throwable {
        boolean z2;
        try {
            if (this.d.length > 0) {
                synchronized (this) {
                    z2 = this.f231h;
                }
                if (!z2) {
                    close();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        String[] strArr = this.f227b;
        if (strArr != null) {
            int iC02 = p.a.c0(parcel, 1);
            parcel.writeStringArray(strArr);
            p.a.d0(parcel, iC02);
        }
        p.a.a0(parcel, 2, this.d, i2);
        p.a.f0(parcel, 3, 4);
        parcel.writeInt(this.f228e);
        p.a.X(parcel, 4, this.f229f);
        p.a.f0(parcel, 1000, 4);
        parcel.writeInt(this.f226a);
        p.a.d0(parcel, iC0);
        if ((i2 & 1) != 0) {
            close();
        }
    }
}
