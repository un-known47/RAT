package j0;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Environment;
import android.view.View;
import com.protect.download.R;
import com.service.downloadapp.DownloadAPPActivity;
import java.io.File;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f691a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DownloadAPPActivity f692b;

    public /* synthetic */ f(DownloadAPPActivity downloadAPPActivity, int i2) {
        this.f691a = i2;
        this.f692b = downloadAPPActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f691a) {
            case 0:
                DownloadAPPActivity downloadAPPActivity = this.f692b;
                DownloadAPPActivity.i(downloadAPPActivity.getApplicationContext(), downloadAPPActivity.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + File.separator + "app.apk");
                break;
            default:
                Intent intent = new Intent();
                DownloadAPPActivity downloadAPPActivity2 = this.f692b;
                intent.setComponent(new ComponentName(downloadAPPActivity2.getString(R.string.name_package_app_main), "com.app.activity.FirstActivity"));
                try {
                    downloadAPPActivity2.startActivity(intent);
                    break;
                } catch (Exception unused) {
                    p.a.T(downloadAPPActivity2, "#13");
                }
        }
    }
}
