package g;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.api.GoogleApiActivity;
import k.s;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f485b = new Object();
    public static final d c = new d();

    public static AlertDialog d(Activity activity, int i2, k.m mVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(k.l.b(activity, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        String string = i2 != 1 ? i2 != 2 ? i2 != 3 ? resources.getString(R.string.ok) : resources.getString(com.protect.download.R.string.common_google_play_services_enable_button) : resources.getString(com.protect.download.R.string.common_google_play_services_update_button) : resources.getString(com.protect.download.R.string.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, mVar);
        }
        String strC = k.l.c(activity, i2);
        if (strC != null) {
            builder.setTitle(strC);
        }
        new IllegalArgumentException();
        return builder.create();
    }

    public static void e(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                h hVar = new h();
                s.c(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                hVar.f491a = alertDialog;
                if (onCancelListener != null) {
                    hVar.f492b = onCancelListener;
                }
                hVar.show(supportFragmentManager, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        b bVar = new b();
        s.c(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        bVar.f481a = alertDialog;
        if (onCancelListener != null) {
            bVar.f482b = onCancelListener;
        }
        bVar.show(fragmentManager, str);
    }

    public final void c(GoogleApiActivity googleApiActivity, int i2, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogD = d(googleApiActivity, i2, new k.m(super.a(googleApiActivity, i2, "d"), googleApiActivity, 0), googleApiActivity2);
        if (alertDialogD == null) {
            return;
        }
        e(googleApiActivity, alertDialogD, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void f(Context context, int i2, PendingIntent pendingIntent) throws Resources.NotFoundException {
        int i3;
        new IllegalArgumentException();
        if (i2 == 18) {
            new i(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            return;
        }
        String strE = i2 == 6 ? k.l.e(context, "common_google_play_services_resolution_required_title") : k.l.c(context, i2);
        if (strE == null) {
            strE = context.getResources().getString(com.protect.download.R.string.common_google_play_services_notification_ticker);
        }
        String strD = (i2 == 6 || i2 == 19) ? k.l.d(context, "common_google_play_services_resolution_required_text", k.l.a(context)) : k.l.b(context, i2);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        s.b(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(strE).setStyle(new NotificationCompat.BigTextStyle().bigText(strD));
        PackageManager packageManager = context.getPackageManager();
        if (p.a.c == null) {
            p.a.c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (p.a.c.booleanValue()) {
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (p.a.E(context)) {
                style.addAction(com.protect.download.R.drawable.common_full_open_on_phone, resources.getString(com.protect.download.R.string.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(R.drawable.stat_sys_warning).setTicker(resources.getString(com.protect.download.R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(strD);
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            if (i4 < 26) {
                throw new IllegalStateException();
            }
            synchronized (f485b) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(com.protect.download.R.string.common_google_play_services_notification_channel_name);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(com.google.android.material.textfield.h.d(string));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            style.setChannelId("com.google.android.gms.availability");
        }
        Notification notificationBuild = style.build();
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            f.f487a.set(false);
            i3 = 10436;
        } else {
            i3 = 39789;
        }
        notificationManager.notify(i3, notificationBuild);
    }

    public final void g(Activity activity, i.e eVar, int i2, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogD = d(activity, i2, new k.m(super.a(activity, i2, "d"), eVar, 1), onCancelListener);
        if (alertDialogD == null) {
            return;
        }
        e(activity, alertDialogD, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
