package j0;

import android.content.DialogInterface;
import com.service.downloadapp.AppMainActivity;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class e implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppMainActivity f690a;

    public e(AppMainActivity appMainActivity) {
        this.f690a = appMainActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.f690a.finish();
    }
}
