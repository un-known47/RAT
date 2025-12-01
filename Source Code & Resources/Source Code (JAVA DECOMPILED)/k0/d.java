package k0;

import android.app.ProgressDialog;
import com.service.downloadapp.DownloadAPPActivity;
import i.o;
import o1.l;
import o1.n;
import o1.x;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d extends x {

    /* renamed from: a, reason: collision with root package name */
    public long f777a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f778b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, n nVar) {
        super(nVar);
        this.f778b = eVar;
        this.f777a = 0L;
    }

    @Override // o1.x, o1.p0
    public final long read(l lVar, long j) {
        long j2 = super.read(lVar, j);
        long j3 = this.f777a + (j2 != -1 ? j2 : 0L);
        this.f777a = j3;
        e eVar = this.f778b;
        o oVar = eVar.f780b;
        long jContentLength = eVar.f779a.contentLength();
        ProgressDialog progressDialog = ((DownloadAPPActivity) oVar.f623b).f365a;
        if (progressDialog != null) {
            progressDialog.setProgress((int) ((j3 * 100) / jContentLength));
        }
        return j2;
    }
}
