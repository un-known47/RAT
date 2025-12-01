package androidx.appcompat.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.job.JobWorkItem;
import android.content.Intent;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract /* synthetic */ class d {
    public static /* bridge */ /* synthetic */ NotificationChannel g(Object obj) {
        return (NotificationChannel) obj;
    }

    public static /* bridge */ /* synthetic */ NotificationChannelGroup h(Object obj) {
        return (NotificationChannelGroup) obj;
    }

    public static /* synthetic */ JobWorkItem j(Intent intent) {
        return new JobWorkItem(intent);
    }
}
