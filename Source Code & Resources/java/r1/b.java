package r1;

import a0.b0;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import o1.l;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import q1.m;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b implements m {
    public static final MediaType c = MediaType.get("application/json; charset=UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final a0.m f1175a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f1176b;

    public b(a0.m mVar, b0 b0Var) {
        this.f1175a = mVar;
        this.f1176b = b0Var;
    }

    @Override // q1.m
    public final Object a(Object obj) throws IOException {
        l lVar = new l();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(lVar.z(), StandardCharsets.UTF_8);
        a0.m mVar = this.f1175a;
        mVar.getClass();
        i0.b bVar = new i0.b(outputStreamWriter);
        bVar.M(mVar.f15g);
        bVar.f678i = mVar.f14f;
        bVar.f677h = 2;
        bVar.f679k = false;
        this.f1176b.c(bVar, obj);
        bVar.close();
        return RequestBody.create(c, lVar.h(lVar.f919b));
    }
}
