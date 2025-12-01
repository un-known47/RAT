package q1;

import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class n0 extends a {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f1095h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n0(int i2) {
        super(7);
        this.f1095h = i2;
    }

    @Override // q1.a
    public String d(Method method, int i2) {
        switch (this.f1095h) {
            case 1:
                Parameter parameter = method.getParameters()[i2];
                if (!parameter.isNamePresent()) {
                    break;
                } else {
                    break;
                }
        }
        return super.d(method, i2);
    }

    @Override // q1.a
    public final Object e(Object obj, Method method, Object[] objArr) {
        switch (this.f1095h) {
            case 0:
                if (Build.VERSION.SDK_INT >= 26) {
                    return b1.k(obj, method, objArr);
                }
                throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
            default:
                return b1.k(obj, method, objArr);
        }
    }

    @Override // q1.a
    public final boolean f(Method method) {
        switch (this.f1095h) {
        }
        return method.isDefault();
    }
}
