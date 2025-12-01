package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class b implements d1.b, Serializable {
    public static final Object NO_RECEIVER = a.f782a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient d1.b reflected;
    private final String signature;

    public b(Object obj, Class cls, String str, String str2, boolean z2) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z2;
    }

    @Override // d1.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // d1.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public d1.b compute() {
        d1.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        d1.b bVarComputeReflected = computeReflected();
        this.reflected = bVarComputeReflected;
        return bVarComputeReflected;
    }

    public abstract d1.b computeReflected();

    @Override // d1.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public d1.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (!this.isTopLevel) {
            return p.a(cls);
        }
        p.f790a.getClass();
        return new l(cls);
    }

    @Override // d1.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public abstract d1.b getReflected();

    @Override // d1.b
    public d1.g getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // d1.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // d1.b
    public d1.h getVisibility() {
        getReflected().getVisibility();
        return null;
    }

    @Override // d1.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // d1.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // d1.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }
}
