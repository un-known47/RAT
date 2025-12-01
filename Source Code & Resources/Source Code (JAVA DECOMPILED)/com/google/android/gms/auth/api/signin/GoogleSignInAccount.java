package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import l.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@Deprecated
/* loaded from: classes.dex */
public class GoogleSignInAccount extends a implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new e.a(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f209a;

    /* renamed from: b, reason: collision with root package name */
    public final String f210b;
    public final String c;
    public final String d;

    /* renamed from: e, reason: collision with root package name */
    public final String f211e;

    /* renamed from: f, reason: collision with root package name */
    public final Uri f212f;

    /* renamed from: g, reason: collision with root package name */
    public String f213g;

    /* renamed from: h, reason: collision with root package name */
    public final long f214h;

    /* renamed from: i, reason: collision with root package name */
    public final String f215i;
    public final List j;

    /* renamed from: k, reason: collision with root package name */
    public final String f216k;

    /* renamed from: l, reason: collision with root package name */
    public final String f217l;

    /* renamed from: m, reason: collision with root package name */
    public final HashSet f218m = new HashSet();

    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, ArrayList arrayList, String str7, String str8) {
        this.f209a = i2;
        this.f210b = str;
        this.c = str2;
        this.d = str3;
        this.f211e = str4;
        this.f212f = uri;
        this.f213g = str5;
        this.f214h = j;
        this.f215i = str6;
        this.j = arrayList;
        this.f216k = str7;
        this.f217l = str8;
    }

    public static GoogleSignInAccount a(String str) throws JSONException, NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(1, jSONArray.getString(i2)));
        }
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has(NotificationCompat.CATEGORY_EMAIL) ? jSONObject.optString(NotificationCompat.CATEGORY_EMAIL) : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        if (TextUtils.isEmpty(string)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.f213g = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.f215i.equals(this.f215i)) {
            return false;
        }
        HashSet hashSet = new HashSet(googleSignInAccount.j);
        hashSet.addAll(googleSignInAccount.f218m);
        HashSet hashSet2 = new HashSet(this.j);
        hashSet2.addAll(this.f218m);
        return hashSet.equals(hashSet2);
    }

    public final int hashCode() {
        int iHashCode = this.f215i.hashCode() + 527;
        HashSet hashSet = new HashSet(this.j);
        hashSet.addAll(this.f218m);
        return (iHashCode * 31) + hashSet.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.f0(parcel, 1, 4);
        parcel.writeInt(this.f209a);
        p.a.Z(parcel, 2, this.f210b);
        p.a.Z(parcel, 3, this.c);
        p.a.Z(parcel, 4, this.d);
        p.a.Z(parcel, 5, this.f211e);
        p.a.Y(parcel, 6, this.f212f, i2);
        p.a.Z(parcel, 7, this.f213g);
        p.a.f0(parcel, 8, 8);
        parcel.writeLong(this.f214h);
        p.a.Z(parcel, 9, this.f215i);
        p.a.b0(parcel, 10, this.j);
        p.a.Z(parcel, 11, this.f216k);
        p.a.Z(parcel, 12, this.f217l);
        p.a.d0(parcel, iC0);
    }
}
