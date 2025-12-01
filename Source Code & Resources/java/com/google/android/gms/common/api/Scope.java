package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import l.a;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Scope extends a implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<Scope> CREATOR = new e.a(3);

    /* renamed from: a, reason: collision with root package name */
    public final int f221a;

    /* renamed from: b, reason: collision with root package name */
    public final String f222b;

    public Scope(int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("scopeUri must not be null or empty");
        }
        this.f221a = i2;
        this.f222b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f222b.equals(((Scope) obj).f222b);
    }

    public final int hashCode() {
        return this.f222b.hashCode();
    }

    public final String toString() {
        return this.f222b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.f0(parcel, 1, 4);
        parcel.writeInt(this.f221a);
        p.a.Z(parcel, 2, this.f222b);
        p.a.d0(parcel, iC0);
    }
}
