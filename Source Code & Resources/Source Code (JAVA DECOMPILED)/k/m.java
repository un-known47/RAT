package k;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import com.google.android.gms.common.api.GoogleApiActivity;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class m implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f750a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f751b;
    public final /* synthetic */ Object c;

    public /* synthetic */ m(Intent intent, Object obj, int i2) {
        this.f750a = i2;
        this.f751b = intent;
        this.c = obj;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [i.e, java.lang.Object] */
    public final void a() {
        switch (this.f750a) {
            case 0:
                Intent intent = this.f751b;
                if (intent != null) {
                    ((GoogleApiActivity) this.c).startActivityForResult(intent, 2);
                    break;
                }
                break;
            default:
                Intent intent2 = this.f751b;
                if (intent2 != null) {
                    this.c.startActivityForResult(intent2, 2);
                    break;
                }
                break;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException unused) {
                Build.FINGERPRINT.contains("generic");
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
