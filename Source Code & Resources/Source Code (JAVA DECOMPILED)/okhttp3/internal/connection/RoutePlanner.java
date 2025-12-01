package okhttp3.internal.connection;

import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import m0.h;
import okhttp3.Address;
import okhttp3.HttpUrl;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public interface RoutePlanner {

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class DefaultImpls {
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public interface Plan {
        /* renamed from: cancel */
        void mo230cancel();

        /* renamed from: connectTcp */
        ConnectResult mo234connectTcp();

        /* renamed from: connectTlsEtc */
        ConnectResult mo235connectTlsEtc();

        /* renamed from: handleSuccess */
        RealConnection mo231handleSuccess();

        boolean isReady();

        /* renamed from: retry */
        Plan mo232retry();
    }

    Address getAddress();

    h getDeferredPlans();

    boolean hasNext(RealConnection realConnection);

    boolean isCanceled();

    Plan plan();

    boolean sameHostAndPort(HttpUrl httpUrl);

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class ConnectResult {
        private final Plan nextPlan;
        private final Plan plan;
        private final Throwable throwable;

        public ConnectResult(Plan plan, Plan plan2, Throwable th) {
            j.e(plan, "plan");
            this.plan = plan;
            this.nextPlan = plan2;
            this.throwable = th;
        }

        public static /* synthetic */ ConnectResult copy$default(ConnectResult connectResult, Plan plan, Plan plan2, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                plan = connectResult.plan;
            }
            if ((i2 & 2) != 0) {
                plan2 = connectResult.nextPlan;
            }
            if ((i2 & 4) != 0) {
                th = connectResult.throwable;
            }
            return connectResult.copy(plan, plan2, th);
        }

        public final Plan component1() {
            return this.plan;
        }

        public final Plan component2() {
            return this.nextPlan;
        }

        public final Throwable component3() {
            return this.throwable;
        }

        public final ConnectResult copy(Plan plan, Plan plan2, Throwable th) {
            j.e(plan, "plan");
            return new ConnectResult(plan, plan2, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConnectResult)) {
                return false;
            }
            ConnectResult connectResult = (ConnectResult) obj;
            return j.a(this.plan, connectResult.plan) && j.a(this.nextPlan, connectResult.nextPlan) && j.a(this.throwable, connectResult.throwable);
        }

        public final Plan getNextPlan() {
            return this.nextPlan;
        }

        public final Plan getPlan() {
            return this.plan;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public int hashCode() {
            int iHashCode = this.plan.hashCode() * 31;
            Plan plan = this.nextPlan;
            int iHashCode2 = (iHashCode + (plan == null ? 0 : plan.hashCode())) * 31;
            Throwable th = this.throwable;
            return iHashCode2 + (th != null ? th.hashCode() : 0);
        }

        public final boolean isSuccess() {
            return this.nextPlan == null && this.throwable == null;
        }

        public String toString() {
            return "ConnectResult(plan=" + this.plan + ", nextPlan=" + this.nextPlan + ", throwable=" + this.throwable + ')';
        }

        public /* synthetic */ ConnectResult(Plan plan, Plan plan2, Throwable th, int i2, e eVar) {
            this(plan, (i2 & 2) != 0 ? null : plan2, (i2 & 4) != 0 ? null : th);
        }
    }
}
