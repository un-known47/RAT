package e;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import g.c;
import java.util.ArrayList;
import k.d;
import k.e;
import k.g;
import k.i;
import k.j;
import k.n;
import k.o;
import k.y;
import v.b;
import v.f;
import v.h;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f429a;

    public /* synthetic */ a(int i2) {
        this.f429a = i2;
    }

    public static void a(e eVar, Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        int i3 = eVar.f721a;
        p.a.f0(parcel, 1, 4);
        parcel.writeInt(i3);
        int i4 = eVar.f722b;
        p.a.f0(parcel, 2, 4);
        parcel.writeInt(i4);
        int i5 = eVar.c;
        p.a.f0(parcel, 3, 4);
        parcel.writeInt(i5);
        p.a.Z(parcel, 4, eVar.d);
        IBinder iBinder = eVar.f723e;
        if (iBinder != null) {
            int iC02 = p.a.c0(parcel, 5);
            parcel.writeStrongBinder(iBinder);
            p.a.d0(parcel, iC02);
        }
        p.a.a0(parcel, 6, eVar.f724f, i2);
        p.a.X(parcel, 7, eVar.f725g);
        p.a.Y(parcel, 8, eVar.f726h, i2);
        p.a.a0(parcel, 10, eVar.f727i, i2);
        p.a.a0(parcel, 11, eVar.j, i2);
        boolean z2 = eVar.f728k;
        p.a.f0(parcel, 12, 4);
        parcel.writeInt(z2 ? 1 : 0);
        int i6 = eVar.f729l;
        p.a.f0(parcel, 13, 4);
        parcel.writeInt(i6);
        boolean z3 = eVar.f730m;
        p.a.f0(parcel, 14, 4);
        parcel.writeInt(z3 ? 1 : 0);
        p.a.Z(parcel, 15, eVar.f731n);
        p.a.d0(parcel, iC0);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f429a) {
            case 0:
                int iW = p.a.W(parcel);
                String strS = null;
                String strS2 = null;
                String strS3 = null;
                String strS4 = null;
                Uri uri = null;
                String strS5 = null;
                String strS6 = null;
                ArrayList arrayList = null;
                String strS7 = null;
                String strS8 = null;
                long jM = 0;
                int iL = 0;
                while (parcel.dataPosition() < iW) {
                    int i2 = parcel.readInt();
                    switch ((char) i2) {
                        case 1:
                            iL = p.a.L(parcel, i2);
                            break;
                        case 2:
                            strS = p.a.s(parcel, i2);
                            break;
                        case 3:
                            strS2 = p.a.s(parcel, i2);
                            break;
                        case 4:
                            strS3 = p.a.s(parcel, i2);
                            break;
                        case 5:
                            strS4 = p.a.s(parcel, i2);
                            break;
                        case 6:
                            uri = (Uri) p.a.r(parcel, i2, Uri.CREATOR);
                            break;
                        case 7:
                            strS5 = p.a.s(parcel, i2);
                            break;
                        case '\b':
                            jM = p.a.M(parcel, i2);
                            break;
                        case '\t':
                            strS6 = p.a.s(parcel, i2);
                            break;
                        case '\n':
                            Parcelable.Creator<Scope> creator = Scope.CREATOR;
                            int iN = p.a.N(parcel, i2);
                            int iDataPosition = parcel.dataPosition();
                            if (iN == 0) {
                                arrayList = null;
                                break;
                            } else {
                                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
                                parcel.setDataPosition(iDataPosition + iN);
                                arrayList = arrayListCreateTypedArrayList;
                                break;
                            }
                        case 11:
                            strS7 = p.a.s(parcel, i2);
                            break;
                        case '\f':
                            strS8 = p.a.s(parcel, i2);
                            break;
                        default:
                            p.a.O(parcel, i2);
                            break;
                    }
                }
                p.a.u(parcel, iW);
                return new GoogleSignInAccount(iL, strS, strS2, strS3, strS4, uri, strS5, jM, strS6, arrayList, strS7, strS8);
            case 1:
                int iW2 = p.a.W(parcel);
                PendingIntent pendingIntent = null;
                String strS9 = null;
                int iL2 = 0;
                int iL3 = 0;
                while (parcel.dataPosition() < iW2) {
                    int i3 = parcel.readInt();
                    char c = (char) i3;
                    if (c == 1) {
                        iL2 = p.a.L(parcel, i3);
                    } else if (c == 2) {
                        iL3 = p.a.L(parcel, i3);
                    } else if (c == 3) {
                        pendingIntent = (PendingIntent) p.a.r(parcel, i3, PendingIntent.CREATOR);
                    } else if (c != 4) {
                        p.a.O(parcel, i3);
                    } else {
                        strS9 = p.a.s(parcel, i3);
                    }
                }
                p.a.u(parcel, iW2);
                return new g.a(iL2, iL3, pendingIntent, strS9);
            case 2:
                int iW3 = p.a.W(parcel);
                long jM2 = -1;
                int iL4 = 0;
                String strS10 = null;
                while (parcel.dataPosition() < iW3) {
                    int i4 = parcel.readInt();
                    char c2 = (char) i4;
                    if (c2 == 1) {
                        strS10 = p.a.s(parcel, i4);
                    } else if (c2 == 2) {
                        iL4 = p.a.L(parcel, i4);
                    } else if (c2 != 3) {
                        p.a.O(parcel, i4);
                    } else {
                        jM2 = p.a.M(parcel, i4);
                    }
                }
                p.a.u(parcel, iW3);
                return new c(strS10, iL4, jM2);
            case 3:
                int iW4 = p.a.W(parcel);
                String strS11 = null;
                int iL5 = 0;
                while (parcel.dataPosition() < iW4) {
                    int i5 = parcel.readInt();
                    char c3 = (char) i5;
                    if (c3 == 1) {
                        iL5 = p.a.L(parcel, i5);
                    } else if (c3 != 2) {
                        p.a.O(parcel, i5);
                    } else {
                        strS11 = p.a.s(parcel, i5);
                    }
                }
                p.a.u(parcel, iW4);
                return new Scope(iL5, strS11);
            case 4:
                int iW5 = p.a.W(parcel);
                String strS12 = null;
                PendingIntent pendingIntent2 = null;
                g.a aVar = null;
                int iL6 = 0;
                while (parcel.dataPosition() < iW5) {
                    int i6 = parcel.readInt();
                    char c4 = (char) i6;
                    if (c4 == 1) {
                        iL6 = p.a.L(parcel, i6);
                    } else if (c4 == 2) {
                        strS12 = p.a.s(parcel, i6);
                    } else if (c4 == 3) {
                        pendingIntent2 = (PendingIntent) p.a.r(parcel, i6, PendingIntent.CREATOR);
                    } else if (c4 != 4) {
                        p.a.O(parcel, i6);
                    } else {
                        aVar = (g.a) p.a.r(parcel, i6, g.a.CREATOR);
                    }
                }
                p.a.u(parcel, iW5);
                return new Status(iL6, strS12, pendingIntent2, aVar);
            case 5:
                int iW6 = p.a.W(parcel);
                String[] strArr = null;
                CursorWindow[] cursorWindowArr = null;
                Bundle bundleN = null;
                int iL7 = 0;
                int iL8 = 0;
                while (parcel.dataPosition() < iW6) {
                    int i7 = parcel.readInt();
                    char c5 = (char) i7;
                    if (c5 == 1) {
                        int iN2 = p.a.N(parcel, i7);
                        int iDataPosition2 = parcel.dataPosition();
                        if (iN2 == 0) {
                            strArr = null;
                        } else {
                            String[] strArrCreateStringArray = parcel.createStringArray();
                            parcel.setDataPosition(iDataPosition2 + iN2);
                            strArr = strArrCreateStringArray;
                        }
                    } else if (c5 == 2) {
                        cursorWindowArr = (CursorWindow[]) p.a.t(parcel, i7, CursorWindow.CREATOR);
                    } else if (c5 == 3) {
                        iL8 = p.a.L(parcel, i7);
                    } else if (c5 == 4) {
                        bundleN = p.a.n(parcel, i7);
                    } else if (c5 != 1000) {
                        p.a.O(parcel, i7);
                    } else {
                        iL7 = p.a.L(parcel, i7);
                    }
                }
                p.a.u(parcel, iW6);
                DataHolder dataHolder = new DataHolder(iL7, strArr, cursorWindowArr, iL8, bundleN);
                dataHolder.c = new Bundle();
                int i8 = 0;
                while (true) {
                    String[] strArr2 = dataHolder.f227b;
                    if (i8 >= strArr2.length) {
                        CursorWindow[] cursorWindowArr2 = dataHolder.d;
                        dataHolder.f230g = new int[cursorWindowArr2.length];
                        int numRows = 0;
                        for (int i9 = 0; i9 < cursorWindowArr2.length; i9++) {
                            dataHolder.f230g[i9] = numRows;
                            numRows += cursorWindowArr2[i9].getNumRows() - (numRows - cursorWindowArr2[i9].getStartPosition());
                        }
                        return dataHolder;
                    }
                    dataHolder.c.putInt(strArr2[i8], i8);
                    i8++;
                }
            case 6:
                int iW7 = p.a.W(parcel);
                int iL9 = 0;
                while (true) {
                    ArrayList arrayListCreateTypedArrayList2 = null;
                    while (parcel.dataPosition() < iW7) {
                        int i10 = parcel.readInt();
                        char c6 = (char) i10;
                        if (c6 == 1) {
                            iL9 = p.a.L(parcel, i10);
                        } else if (c6 != 2) {
                            p.a.O(parcel, i10);
                        } else {
                            Parcelable.Creator<g> creator2 = g.CREATOR;
                            int iN3 = p.a.N(parcel, i10);
                            int iDataPosition3 = parcel.dataPosition();
                            if (iN3 == 0) {
                                break;
                            }
                            arrayListCreateTypedArrayList2 = parcel.createTypedArrayList(creator2);
                            parcel.setDataPosition(iDataPosition3 + iN3);
                        }
                    }
                    p.a.u(parcel, iW7);
                    return new j(iL9, arrayListCreateTypedArrayList2);
                    break;
                }
            case 7:
                int iW8 = p.a.W(parcel);
                String strS13 = null;
                String strS14 = null;
                long jM3 = 0;
                long jM4 = 0;
                int iL10 = 0;
                int iL11 = 0;
                int iL12 = 0;
                int iL13 = 0;
                int iL14 = -1;
                while (parcel.dataPosition() < iW8) {
                    int i11 = parcel.readInt();
                    switch ((char) i11) {
                        case 1:
                            iL10 = p.a.L(parcel, i11);
                            break;
                        case 2:
                            iL11 = p.a.L(parcel, i11);
                            break;
                        case 3:
                            iL12 = p.a.L(parcel, i11);
                            break;
                        case 4:
                            jM3 = p.a.M(parcel, i11);
                            break;
                        case 5:
                            jM4 = p.a.M(parcel, i11);
                            break;
                        case 6:
                            strS13 = p.a.s(parcel, i11);
                            break;
                        case 7:
                            strS14 = p.a.s(parcel, i11);
                            break;
                        case '\b':
                            iL13 = p.a.L(parcel, i11);
                            break;
                        case '\t':
                            iL14 = p.a.L(parcel, i11);
                            break;
                        default:
                            p.a.O(parcel, i11);
                            break;
                    }
                }
                p.a.u(parcel, iW8);
                return new g(iL10, iL11, iL12, jM3, jM4, strS13, strS14, iL13, iL14);
            case 8:
                int iW9 = p.a.W(parcel);
                Account account = null;
                GoogleSignInAccount googleSignInAccount = null;
                int iL15 = 0;
                int iL16 = 0;
                while (parcel.dataPosition() < iW9) {
                    int i12 = parcel.readInt();
                    char c7 = (char) i12;
                    if (c7 == 1) {
                        iL15 = p.a.L(parcel, i12);
                    } else if (c7 == 2) {
                        account = (Account) p.a.r(parcel, i12, Account.CREATOR);
                    } else if (c7 == 3) {
                        iL16 = p.a.L(parcel, i12);
                    } else if (c7 != 4) {
                        p.a.O(parcel, i12);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) p.a.r(parcel, i12, GoogleSignInAccount.CREATOR);
                    }
                }
                p.a.u(parcel, iW9);
                return new n(iL15, account, iL16, googleSignInAccount);
            case 9:
                int iW10 = p.a.W(parcel);
                IBinder strongBinder = null;
                g.a aVar2 = null;
                int iL17 = 0;
                boolean zK = false;
                boolean zK2 = false;
                while (parcel.dataPosition() < iW10) {
                    int i13 = parcel.readInt();
                    char c8 = (char) i13;
                    if (c8 == 1) {
                        iL17 = p.a.L(parcel, i13);
                    } else if (c8 == 2) {
                        int iN4 = p.a.N(parcel, i13);
                        int iDataPosition4 = parcel.dataPosition();
                        if (iN4 == 0) {
                            strongBinder = null;
                        } else {
                            strongBinder = parcel.readStrongBinder();
                            parcel.setDataPosition(iDataPosition4 + iN4);
                        }
                    } else if (c8 == 3) {
                        aVar2 = (g.a) p.a.r(parcel, i13, g.a.CREATOR);
                    } else if (c8 == 4) {
                        zK = p.a.K(parcel, i13);
                    } else if (c8 != 5) {
                        p.a.O(parcel, i13);
                    } else {
                        zK2 = p.a.K(parcel, i13);
                    }
                }
                p.a.u(parcel, iW10);
                return new o(iL17, strongBinder, aVar2, zK, zK2);
            case 10:
                int iW11 = p.a.W(parcel);
                int iL18 = 0;
                boolean zK3 = false;
                boolean zK4 = false;
                int iL19 = 0;
                int iL20 = 0;
                while (parcel.dataPosition() < iW11) {
                    int i14 = parcel.readInt();
                    char c9 = (char) i14;
                    if (c9 == 1) {
                        iL18 = p.a.L(parcel, i14);
                    } else if (c9 == 2) {
                        zK3 = p.a.K(parcel, i14);
                    } else if (c9 == 3) {
                        zK4 = p.a.K(parcel, i14);
                    } else if (c9 == 4) {
                        iL19 = p.a.L(parcel, i14);
                    } else if (c9 != 5) {
                        p.a.O(parcel, i14);
                    } else {
                        iL20 = p.a.L(parcel, i14);
                    }
                }
                p.a.u(parcel, iW11);
                return new i(iL18, zK3, zK4, iL19, iL20);
            case 11:
                int iW12 = p.a.W(parcel);
                Bundle bundleN2 = null;
                c[] cVarArr = null;
                d dVar = null;
                int iL21 = 0;
                while (parcel.dataPosition() < iW12) {
                    int i15 = parcel.readInt();
                    char c10 = (char) i15;
                    if (c10 == 1) {
                        bundleN2 = p.a.n(parcel, i15);
                    } else if (c10 == 2) {
                        cVarArr = (c[]) p.a.t(parcel, i15, c.CREATOR);
                    } else if (c10 == 3) {
                        iL21 = p.a.L(parcel, i15);
                    } else if (c10 != 4) {
                        p.a.O(parcel, i15);
                    } else {
                        dVar = (d) p.a.r(parcel, i15, d.CREATOR);
                    }
                }
                p.a.u(parcel, iW12);
                y yVar = new y();
                yVar.f771a = bundleN2;
                yVar.f772b = cVarArr;
                yVar.c = iL21;
                yVar.d = dVar;
                return yVar;
            case 12:
                int iW13 = p.a.W(parcel);
                i iVar = null;
                int[] iArrCreateIntArray = null;
                int[] iArrCreateIntArray2 = null;
                boolean zK5 = false;
                boolean zK6 = false;
                int iL22 = 0;
                while (parcel.dataPosition() < iW13) {
                    int i16 = parcel.readInt();
                    switch ((char) i16) {
                        case 1:
                            iVar = (i) p.a.r(parcel, i16, i.CREATOR);
                            break;
                        case 2:
                            zK5 = p.a.K(parcel, i16);
                            break;
                        case 3:
                            zK6 = p.a.K(parcel, i16);
                            break;
                        case 4:
                            int iN5 = p.a.N(parcel, i16);
                            int iDataPosition5 = parcel.dataPosition();
                            if (iN5 == 0) {
                                iArrCreateIntArray = null;
                                break;
                            } else {
                                iArrCreateIntArray = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition5 + iN5);
                                break;
                            }
                        case 5:
                            iL22 = p.a.L(parcel, i16);
                            break;
                        case 6:
                            int iN6 = p.a.N(parcel, i16);
                            int iDataPosition6 = parcel.dataPosition();
                            if (iN6 == 0) {
                                iArrCreateIntArray2 = null;
                                break;
                            } else {
                                iArrCreateIntArray2 = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition6 + iN6);
                                break;
                            }
                        default:
                            p.a.O(parcel, i16);
                            break;
                    }
                }
                p.a.u(parcel, iW13);
                return new d(iVar, zK5, zK6, iArrCreateIntArray, iL22, iArrCreateIntArray2);
            case 13:
                int iW14 = p.a.W(parcel);
                Bundle bundle = new Bundle();
                Scope[] scopeArr = e.o;
                String strS15 = null;
                IBinder iBinder = null;
                Account account2 = null;
                String strS16 = null;
                c[] cVarArr2 = e.f720p;
                c[] cVarArr3 = cVarArr2;
                int iL23 = 0;
                int iL24 = 0;
                int iL25 = 0;
                boolean zK7 = false;
                int iL26 = 0;
                boolean zK8 = false;
                while (parcel.dataPosition() < iW14) {
                    int i17 = parcel.readInt();
                    switch ((char) i17) {
                        case 1:
                            iL23 = p.a.L(parcel, i17);
                            break;
                        case 2:
                            iL24 = p.a.L(parcel, i17);
                            break;
                        case 3:
                            iL25 = p.a.L(parcel, i17);
                            break;
                        case 4:
                            strS15 = p.a.s(parcel, i17);
                            break;
                        case 5:
                            int iN7 = p.a.N(parcel, i17);
                            int iDataPosition7 = parcel.dataPosition();
                            if (iN7 == 0) {
                                iBinder = null;
                                break;
                            } else {
                                IBinder strongBinder2 = parcel.readStrongBinder();
                                parcel.setDataPosition(iDataPosition7 + iN7);
                                iBinder = strongBinder2;
                                break;
                            }
                        case 6:
                            scopeArr = (Scope[]) p.a.t(parcel, i17, Scope.CREATOR);
                            break;
                        case 7:
                            bundle = p.a.n(parcel, i17);
                            break;
                        case '\b':
                            account2 = (Account) p.a.r(parcel, i17, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            p.a.O(parcel, i17);
                            break;
                        case '\n':
                            cVarArr2 = (c[]) p.a.t(parcel, i17, c.CREATOR);
                            break;
                        case 11:
                            cVarArr3 = (c[]) p.a.t(parcel, i17, c.CREATOR);
                            break;
                        case '\f':
                            zK7 = p.a.K(parcel, i17);
                            break;
                        case '\r':
                            iL26 = p.a.L(parcel, i17);
                            break;
                        case 14:
                            zK8 = p.a.K(parcel, i17);
                            break;
                        case 15:
                            strS16 = p.a.s(parcel, i17);
                            break;
                    }
                }
                p.a.u(parcel, iW14);
                return new e(iL23, iL24, iL25, strS15, iBinder, scopeArr, bundle, account2, cVarArr2, cVarArr3, zK7, iL26, zK8, strS16);
            case 14:
                int iW15 = p.a.W(parcel);
                String strS17 = null;
                while (parcel.dataPosition() < iW15) {
                    int i18 = parcel.readInt();
                    if (((char) i18) != 2) {
                        p.a.O(parcel, i18);
                    } else {
                        strS17 = p.a.s(parcel, i18);
                    }
                }
                p.a.u(parcel, iW15);
                return new f(strS17);
            case 15:
                int iW16 = p.a.W(parcel);
                int iL27 = 0;
                String strS18 = null;
                byte[] bArr = null;
                while (parcel.dataPosition() < iW16) {
                    int i19 = parcel.readInt();
                    char c11 = (char) i19;
                    if (c11 == 2) {
                        strS18 = p.a.s(parcel, i19);
                    } else if (c11 == 3) {
                        int iN8 = p.a.N(parcel, i19);
                        int iDataPosition8 = parcel.dataPosition();
                        if (iN8 == 0) {
                            bArr = null;
                        } else {
                            byte[] bArrCreateByteArray = parcel.createByteArray();
                            parcel.setDataPosition(iDataPosition8 + iN8);
                            bArr = bArrCreateByteArray;
                        }
                    } else if (c11 != 4) {
                        p.a.O(parcel, i19);
                    } else {
                        iL27 = p.a.L(parcel, i19);
                    }
                }
                p.a.u(parcel, iW16);
                return new v.a(strS18, bArr, iL27);
            case 16:
                int iW17 = p.a.W(parcel);
                long jM5 = 0;
                v.a[] aVarArr = null;
                int iL28 = 0;
                boolean zK9 = false;
                while (parcel.dataPosition() < iW17) {
                    int i20 = parcel.readInt();
                    char c12 = (char) i20;
                    if (c12 == 2) {
                        jM5 = p.a.M(parcel, i20);
                    } else if (c12 == 3) {
                        aVarArr = (v.a[]) p.a.t(parcel, i20, v.a.CREATOR);
                    } else if (c12 == 4) {
                        iL28 = p.a.L(parcel, i20);
                    } else if (c12 != 5) {
                        p.a.O(parcel, i20);
                    } else {
                        zK9 = p.a.K(parcel, i20);
                    }
                }
                p.a.u(parcel, iW17);
                return new v.g(jM5, aVarArr, iL28, zK9);
            case 17:
                int iW18 = p.a.W(parcel);
                String strS19 = null;
                while (parcel.dataPosition() < iW18) {
                    int i21 = parcel.readInt();
                    if (((char) i21) != 2) {
                        p.a.O(parcel, i21);
                    } else {
                        strS19 = p.a.s(parcel, i21);
                    }
                }
                p.a.u(parcel, iW18);
                return new h(strS19);
            case 18:
                int iW19 = p.a.W(parcel);
                int iL29 = 0;
                boolean zK10 = false;
                while (parcel.dataPosition() < iW19) {
                    int i22 = parcel.readInt();
                    char c13 = (char) i22;
                    if (c13 == 2) {
                        iL29 = p.a.L(parcel, i22);
                    } else if (c13 != 3) {
                        p.a.O(parcel, i22);
                    } else {
                        zK10 = p.a.K(parcel, i22);
                    }
                }
                p.a.u(parcel, iW19);
                return new v.i(iL29, zK10);
            case 19:
                int iW20 = p.a.W(parcel);
                long jM6 = 0;
                String strS20 = null;
                DataHolder dataHolder2 = null;
                ParcelFileDescriptor parcelFileDescriptor = null;
                byte[] bArr2 = null;
                while (parcel.dataPosition() < iW20) {
                    int i23 = parcel.readInt();
                    char c14 = (char) i23;
                    if (c14 == 2) {
                        strS20 = p.a.s(parcel, i23);
                    } else if (c14 == 3) {
                        dataHolder2 = (DataHolder) p.a.r(parcel, i23, DataHolder.CREATOR);
                    } else if (c14 == 4) {
                        parcelFileDescriptor = (ParcelFileDescriptor) p.a.r(parcel, i23, ParcelFileDescriptor.CREATOR);
                    } else if (c14 == 5) {
                        jM6 = p.a.M(parcel, i23);
                    } else if (c14 != 6) {
                        p.a.O(parcel, i23);
                    } else {
                        int iN9 = p.a.N(parcel, i23);
                        int iDataPosition9 = parcel.dataPosition();
                        if (iN9 == 0) {
                            bArr2 = null;
                        } else {
                            byte[] bArrCreateByteArray2 = parcel.createByteArray();
                            parcel.setDataPosition(iDataPosition9 + iN9);
                            bArr2 = bArrCreateByteArray2;
                        }
                    }
                }
                p.a.u(parcel, iW20);
                b bVar = new b();
                bVar.f1187a = strS20;
                bVar.f1188b = dataHolder2;
                bVar.c = parcelFileDescriptor;
                bVar.d = jM6;
                bVar.f1189e = bArr2;
                return bVar;
            case 20:
                int iW21 = p.a.W(parcel);
                Intent intent = null;
                int iL30 = 0;
                int iL31 = 0;
                while (parcel.dataPosition() < iW21) {
                    int i24 = parcel.readInt();
                    char c15 = (char) i24;
                    if (c15 == 1) {
                        iL30 = p.a.L(parcel, i24);
                    } else if (c15 == 2) {
                        iL31 = p.a.L(parcel, i24);
                    } else if (c15 != 3) {
                        p.a.O(parcel, i24);
                    } else {
                        intent = (Intent) p.a.r(parcel, i24, Intent.CREATOR);
                    }
                }
                p.a.u(parcel, iW21);
                return new x.b(iL30, iL31, intent);
            case 21:
                int iW22 = p.a.W(parcel);
                ArrayList<String> arrayList2 = null;
                String strS21 = null;
                while (parcel.dataPosition() < iW22) {
                    int i25 = parcel.readInt();
                    char c16 = (char) i25;
                    if (c16 == 1) {
                        int iN10 = p.a.N(parcel, i25);
                        int iDataPosition10 = parcel.dataPosition();
                        if (iN10 == 0) {
                            arrayList2 = null;
                        } else {
                            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                            parcel.setDataPosition(iDataPosition10 + iN10);
                            arrayList2 = arrayListCreateStringArrayList;
                        }
                    } else if (c16 != 2) {
                        p.a.O(parcel, i25);
                    } else {
                        strS21 = p.a.s(parcel, i25);
                    }
                }
                p.a.u(parcel, iW22);
                return new x.d(strS21, arrayList2);
            default:
                int iW23 = p.a.W(parcel);
                g.a aVar3 = null;
                o oVar = null;
                int iL32 = 0;
                while (parcel.dataPosition() < iW23) {
                    int i26 = parcel.readInt();
                    char c17 = (char) i26;
                    if (c17 == 1) {
                        iL32 = p.a.L(parcel, i26);
                    } else if (c17 == 2) {
                        aVar3 = (g.a) p.a.r(parcel, i26, g.a.CREATOR);
                    } else if (c17 != 3) {
                        p.a.O(parcel, i26);
                    } else {
                        oVar = (o) p.a.r(parcel, i26, o.CREATOR);
                    }
                }
                p.a.u(parcel, iW23);
                return new x.e(iL32, aVar3, oVar);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        switch (this.f429a) {
            case 0:
                return new GoogleSignInAccount[i2];
            case 1:
                return new g.a[i2];
            case 2:
                return new c[i2];
            case 3:
                return new Scope[i2];
            case 4:
                return new Status[i2];
            case 5:
                return new DataHolder[i2];
            case 6:
                return new j[i2];
            case 7:
                return new g[i2];
            case 8:
                return new n[i2];
            case 9:
                return new o[i2];
            case 10:
                return new i[i2];
            case 11:
                return new y[i2];
            case 12:
                return new d[i2];
            case 13:
                return new e[i2];
            case 14:
                return new f[i2];
            case 15:
                return new v.a[i2];
            case 16:
                return new v.g[i2];
            case 17:
                return new h[i2];
            case 18:
                return new v.i[i2];
            case 19:
                return new b[i2];
            case 20:
                return new x.b[i2];
            case 21:
                return new x.d[i2];
            default:
                return new x.e[i2];
        }
    }
}
