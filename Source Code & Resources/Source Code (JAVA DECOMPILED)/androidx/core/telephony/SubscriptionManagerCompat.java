package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.content.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RequiresApi(22)
/* loaded from: classes.dex */
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static int getSlotIndex(int i2) {
            return SubscriptionManager.getSlotIndex(i2);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int i2) throws SecurityException {
        if (i2 != -1) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                return Api29Impl.getSlotIndex(i2);
            }
            try {
                if (sGetSlotIndexMethod == null) {
                    Class<?> cls = Integer.TYPE;
                    if (i3 >= 26) {
                        sGetSlotIndexMethod = a.c().getDeclaredMethod("getSlotIndex", cls);
                    } else {
                        sGetSlotIndexMethod = a.c().getDeclaredMethod("getSlotId", cls);
                    }
                    sGetSlotIndexMethod.setAccessible(true);
                }
                Integer num = (Integer) sGetSlotIndexMethod.invoke(null, Integer.valueOf(i2));
                if (num != null) {
                    return num.intValue();
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return -1;
    }
}
