package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.g;
import com.google.android.gms.common.annotation.KeepName;
import g.a;
import g.d;
import i.c;
import k.s;
import r.e;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@KeepName
/* loaded from: classes.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f219b = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f220a = 0;

    @Override // android.app.Activity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f220a = 0;
            setResult(i3, intent);
            if (booleanExtra) {
                c cVarF = c.f(this);
                if (i3 == -1) {
                    e eVar = cVarF.f604n;
                    eVar.sendMessage(eVar.obtainMessage(3));
                } else if (i3 == 0) {
                    cVarF.g(new a(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i2 == 2) {
            this.f220a = 0;
            setResult(i3, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.f220a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) throws IntentSender.SendIntentException {
        GoogleApiActivity googleApiActivity;
        super.onCreate(bundle);
        if (bundle != null) {
            this.f220a = bundle.getInt("resolution");
        }
        if (this.f220a != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                finish();
                return;
            }
            if (pendingIntent == null) {
                s.b(num);
                d.c.c(this, num.intValue(), this);
                this.f220a = 1;
                return;
            }
            try {
                googleApiActivity = this;
            } catch (ActivityNotFoundException unused) {
                googleApiActivity = this;
            } catch (IntentSender.SendIntentException unused2) {
            }
            try {
                googleApiActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                googleApiActivity.f220a = 1;
            } catch (ActivityNotFoundException unused3) {
                if (extras.getBoolean("notify_manager", true)) {
                    c.f(this).g(new a(22, null), getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    String strI = g.i("Activity not found while launching ", pendingIntent.toString(), ".");
                    if (Build.FINGERPRINT.contains("generic")) {
                        strI.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                }
                googleApiActivity.f220a = 1;
                finish();
            } catch (IntentSender.SendIntentException unused4) {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f220a);
        super.onSaveInstanceState(bundle);
    }
}
