package q1;

import java.util.Objects;
import okhttp3.FormBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class e0 extends b1 {
    public final /* synthetic */ int d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1070e;

    /* renamed from: f, reason: collision with root package name */
    public final a f1071f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f1072g;

    public e0(int i2, String str, boolean z2) {
        this.d = i2;
        switch (i2) {
            case 1:
                a aVar = a.f1048b;
                Objects.requireNonNull(str, "name == null");
                this.f1070e = str;
                this.f1071f = aVar;
                this.f1072g = z2;
                break;
            case 2:
                a aVar2 = a.f1048b;
                Objects.requireNonNull(str, "name == null");
                this.f1070e = str;
                this.f1071f = aVar2;
                this.f1072g = z2;
                break;
            default:
                a aVar3 = a.f1048b;
                Objects.requireNonNull(str, "name == null");
                this.f1070e = str;
                this.f1071f = aVar3;
                this.f1072g = z2;
                break;
        }
    }

    @Override // q1.b1
    public final void a(p0 p0Var, Object obj) {
        switch (this.d) {
            case 0:
                if (obj != null) {
                    this.f1071f.getClass();
                    String string = obj.toString();
                    if (string != null) {
                        FormBody.Builder builder = p0Var.j;
                        String str = this.f1070e;
                        if (!this.f1072g) {
                            builder.add(str, string);
                            break;
                        } else {
                            builder.addEncoded(str, string);
                            break;
                        }
                    }
                }
                break;
            case 1:
                if (obj != null) {
                    this.f1071f.getClass();
                    String string2 = obj.toString();
                    if (string2 != null) {
                        p0Var.a(this.f1070e, string2, this.f1072g);
                        break;
                    }
                }
                break;
            default:
                if (obj != null) {
                    this.f1071f.getClass();
                    String string3 = obj.toString();
                    if (string3 != null) {
                        p0Var.b(this.f1070e, string3, this.f1072g);
                        break;
                    }
                }
                break;
        }
    }
}
