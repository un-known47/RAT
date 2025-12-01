package r;

import android.os.Handler;
import android.os.Looper;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class e extends Handler {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Looper looper, int i2) {
        super(looper);
        switch (i2) {
            case 1:
                super(looper);
                Looper.getMainLooper();
                break;
            default:
                Looper.getMainLooper();
                break;
        }
    }
}
