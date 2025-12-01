package j0;

import android.content.res.Resources;
import com.protect.download.R;
import com.service.downloadapp.AppMainActivity;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f684a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f685b;

    public /* synthetic */ b(c cVar, int i2) {
        this.f684a = i2;
        this.f685b = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Resources.NotFoundException {
        switch (this.f684a) {
            case 0:
                AppMainActivity appMainActivity = this.f685b.f687b;
                AppMainActivity.h(appMainActivity.f362a, appMainActivity.getString(R.string.settings_google_verifier_title), appMainActivity.getString(R.string.settings_google_verifier_info));
                appMainActivity.f362a.setOnCheckedChangeListener(new a(2, this));
                appMainActivity.f362a.setVisibility(0);
                break;
            default:
                AppMainActivity appMainActivity2 = this.f685b.f687b;
                AppMainActivity.h(appMainActivity2.f362a, appMainActivity2.getString(R.string.settings_google_verifier_title), appMainActivity2.getString(R.string.settings_google_verifier_info));
                appMainActivity2.f362a.setChecked(true);
                appMainActivity2.f362a.setVisibility(0);
                break;
        }
    }
}
