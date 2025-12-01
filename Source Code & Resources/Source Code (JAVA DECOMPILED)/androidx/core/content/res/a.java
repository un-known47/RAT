package androidx.core.content.res;

import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f71a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f72b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(Object obj, int i2, int i3) {
        this.f71a = i3;
        this.c = obj;
        this.f72b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f71a) {
            case 0:
                ((ResourcesCompat.FontCallback) this.c).lambda$callbackFailAsync$1(this.f72b);
                break;
            default:
                ((SideSheetBehavior) this.c).lambda$setState$0(this.f72b);
                break;
        }
    }
}
