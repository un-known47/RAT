package k;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class n extends l.a {
    public static final Parcelable.Creator<n> CREATOR = new e.a(8);

    /* renamed from: a, reason: collision with root package name */
    public final int f752a;

    /* renamed from: b, reason: collision with root package name */
    public final Account f753b;
    public final int c;
    public final GoogleSignInAccount d;

    public n(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.f752a = i2;
        this.f753b = account;
        this.c = i3;
        this.d = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.f0(parcel, 1, 4);
        parcel.writeInt(this.f752a);
        p.a.Y(parcel, 2, this.f753b, i2);
        p.a.f0(parcel, 3, 4);
        parcel.writeInt(this.c);
        p.a.Y(parcel, 4, this.d, i2);
        p.a.d0(parcel, iC0);
    }
}
