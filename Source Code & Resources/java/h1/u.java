package h1;

import androidx.lifecycle.LifecycleCoroutineScope;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final i.o f571a;

    /* renamed from: b, reason: collision with root package name */
    public static final i.o f572b;
    public static final i.o c;
    public static final i.o d;

    /* renamed from: e, reason: collision with root package name */
    public static final i.o f573e;

    /* renamed from: f, reason: collision with root package name */
    public static final i.o f574f;

    /* renamed from: g, reason: collision with root package name */
    public static final d0 f575g = new d0(false);

    /* renamed from: h, reason: collision with root package name */
    public static final d0 f576h = new d0(true);

    static {
        int i2 = 2;
        f571a = new i.o(i2, "CLOSED_EMPTY");
        f572b = new i.o(i2, "COMPLETING_ALREADY");
        c = new i.o(i2, "COMPLETING_WAITING_CHILDREN");
        d = new i.o(i2, "COMPLETING_RETRY");
        f573e = new i.o(i2, "TOO_LATE_TO_CANCEL");
        f574f = new i.o(i2, "SEALED");
    }

    public static void a(n0 n0Var) {
        u0 u0Var = (u0) n0Var;
        u0Var.getClass();
        u0Var.e(new o0(u0Var.g(), null, u0Var));
    }

    public static final p0.i b(p0.i iVar, p0.i iVar2, boolean z2) {
        Boolean bool = Boolean.FALSE;
        m mVar = m.c;
        boolean zBooleanValue = ((Boolean) iVar.fold(bool, mVar)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) iVar2.fold(bool, mVar)).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return iVar.plus(iVar2);
        }
        m mVar2 = new m(2, 2);
        p0.j jVar = p0.j.f989a;
        p0.i iVar3 = (p0.i) iVar.fold(jVar, mVar2);
        Object objFold = iVar2;
        if (zBooleanValue2) {
            objFold = iVar2.fold(jVar, m.f553b);
        }
        return iVar3.plus((p0.i) objFold);
    }

    public static final String c(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final void d(p0.i iVar, Throwable th) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            i1.b bVar = (i1.b) iVar.get(q.f561a);
            if (bVar != null) {
                bVar.D(th);
            } else {
                r.a(iVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                p.a.b(runtimeException, th);
                th = runtimeException;
            }
            r.a(iVar, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static h1.c0 e(h1.n0 r9, h1.q0 r10, int r11) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.u.e(h1.n0, h1.q0, int):h1.c0");
    }

    public static z0 f(LifecycleCoroutineScope lifecycleCoroutineScope, i1.c cVar, y0.p pVar, int i2) {
        p0.i iVar = cVar;
        if ((i2 & 1) != 0) {
            iVar = p0.j.f989a;
        }
        p0.i iVarB = b(lifecycleCoroutineScope.getCoroutineContext(), iVar, true);
        kotlinx.coroutines.scheduling.d dVar = b0.f530a;
        if (iVarB != dVar && iVarB.get(p0.e.f988a) == null) {
            iVarB = iVarB.plus(dVar);
        }
        z0 z0Var = new z0(iVarB, true);
        int iA = a0.u.a(1);
        if (iA == 0) {
            p.a.P(pVar, z0Var, z0Var);
            return z0Var;
        }
        if (iA != 1) {
            if (iA == 2) {
                p.a.C(p.a.o(z0Var, z0Var, pVar)).resumeWith(l0.i.f856a);
            } else {
                if (iA != 3) {
                    throw new a0.s();
                }
                try {
                    p0.i iVar2 = z0Var.f527b;
                    Object objG = kotlinx.coroutines.internal.b.g(iVar2, null);
                    try {
                        kotlin.jvm.internal.r.c(pVar);
                        Object objInvoke = pVar.invoke(z0Var, z0Var);
                        if (objInvoke != q0.a.f1043a) {
                            z0Var.resumeWith(objInvoke);
                            return z0Var;
                        }
                    } finally {
                        kotlinx.coroutines.internal.b.b(iVar2, objG);
                    }
                } catch (Throwable th) {
                    z0Var.resumeWith(p.a.p(th));
                    return z0Var;
                }
            }
        }
        return z0Var;
    }

    public static final Object g(Object obj) {
        return obj instanceof k ? p.a.p(((k) obj).f550a) : obj;
    }

    public static final void h(e eVar, p0.d dVar, boolean z2) {
        Object objF = eVar.f();
        Throwable thC = eVar.c(objF);
        Object objP = thC != null ? p.a.p(thC) : eVar.d(objF);
        if (!z2) {
            dVar.resumeWith(objP);
            return;
        }
        kotlinx.coroutines.internal.d dVar2 = (kotlinx.coroutines.internal.d) dVar;
        p0.d dVar3 = dVar2.f798e;
        Object obj = dVar2.f800g;
        p0.i context = dVar3.getContext();
        Object objG = kotlinx.coroutines.internal.b.g(context, obj);
        e1 e1VarJ = objG != kotlinx.coroutines.internal.b.f795e ? j(dVar3, context, objG) : null;
        try {
            dVar2.f798e.resumeWith(objP);
            if (e1VarJ == null || e1VarJ.B()) {
                kotlinx.coroutines.internal.b.b(context, objG);
            }
        } catch (Throwable th) {
            if (e1VarJ == null || e1VarJ.B()) {
                kotlinx.coroutines.internal.b.b(context, objG);
            }
            throw th;
        }
    }

    public static final String i(p0.d dVar) {
        Object objP;
        if (dVar instanceof kotlinx.coroutines.internal.d) {
            return dVar.toString();
        }
        try {
            objP = dVar + '@' + c(dVar);
        } catch (Throwable th) {
            objP = p.a.p(th);
        }
        if (l0.f.a(objP) != null) {
            objP = dVar.getClass().getName() + '@' + c(dVar);
        }
        return (String) objP;
    }

    public static final e1 j(p0.d dVar, p0.i iVar, Object obj) {
        e1 e1Var = null;
        if ((dVar instanceof r0.d) && iVar.get(f1.f540a) != null) {
            r0.d callerFrame = (r0.d) dVar;
            while (true) {
                if ((callerFrame instanceof z) || (callerFrame = callerFrame.getCallerFrame()) == null) {
                    break;
                }
                if (callerFrame instanceof e1) {
                    e1Var = (e1) callerFrame;
                    break;
                }
            }
            if (e1Var != null) {
                e1Var.d.set(new l0.d(iVar, obj));
            }
        }
        return e1Var;
    }

    public static final Object k(p pVar, y0.p pVar2, p0.d dVar) throws Throwable {
        Object objB;
        p0.i context = dVar.getContext();
        p0.i iVarPlus = !((Boolean) pVar.fold(Boolean.FALSE, m.c)).booleanValue() ? context.plus(pVar) : b(context, pVar, false);
        n0 n0Var = (n0) iVarPlus.get(q.f562b);
        if (n0Var != null && !n0Var.a()) {
            throw ((u0) n0Var).l();
        }
        if (iVarPlus == context) {
            kotlinx.coroutines.internal.o oVar = new kotlinx.coroutines.internal.o(dVar, iVarPlus);
            objB = p.a.Q(oVar, oVar, pVar2);
        } else {
            p0.e eVar = p0.e.f988a;
            if (kotlin.jvm.internal.j.a(iVarPlus.get(eVar), context.get(eVar))) {
                f1 f1Var = f1.f540a;
                e1 e1Var = new e1(dVar, iVarPlus.get(f1Var) == null ? iVarPlus.plus(f1Var) : iVarPlus);
                ThreadLocal threadLocal = new ThreadLocal();
                e1Var.d = threadLocal;
                if (!(dVar.getContext().get(eVar) instanceof p)) {
                    Object objG = kotlinx.coroutines.internal.b.g(iVarPlus, null);
                    kotlinx.coroutines.internal.b.b(iVarPlus, objG);
                    threadLocal.set(new l0.d(iVarPlus, objG));
                }
                Object objG2 = kotlinx.coroutines.internal.b.g(iVarPlus, null);
                try {
                    Object objQ = p.a.Q(e1Var, e1Var, pVar2);
                    kotlinx.coroutines.internal.b.b(iVarPlus, objG2);
                    objB = objQ;
                } catch (Throwable th) {
                    kotlinx.coroutines.internal.b.b(iVarPlus, objG2);
                    throw th;
                }
            } else {
                z zVar = new z(dVar, iVarPlus);
                p.a.P(pVar2, zVar, zVar);
                objB = zVar.B();
            }
        }
        q0.a aVar = q0.a.f1043a;
        return objB;
    }
}
