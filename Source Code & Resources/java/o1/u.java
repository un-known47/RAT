package o1;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.FileSystem;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class u implements Closeable {
    public static final t Companion = new t();
    public static final u RESOURCES;
    public static final u SYSTEM;
    public static final h0 SYSTEM_TEMPORARY_DIRECTORY;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, y0.l] */
    /* renamed from: -write$default, reason: not valid java name */
    public static /* synthetic */ Object m81write$default(u uVar, h0 file, boolean z2, y0.l writerAction, int i2, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ?? r3;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        kotlin.jvm.internal.j.e(file, "file");
        kotlin.jvm.internal.j.e(writerAction, "writerAction");
        j0 j0VarB = b.b(uVar.sink(file, z2));
        Object th = null;
        try {
            Object objInvoke = writerAction.invoke(j0VarB);
            try {
                j0VarB.close();
            } catch (Throwable th2) {
                th = th2;
            }
            r3 = th;
            th = objInvoke;
        } catch (Throwable th3) {
            try {
                j0VarB.close();
                r3 = th3;
            } catch (Throwable th4) {
                p.a.b(th3, th4);
                r3 = th3;
            }
        }
        if (r3 == 0) {
            return th;
        }
        throw r3;
    }

    static {
        u d0Var;
        try {
            Class.forName("java.nio.file.Files");
            d0Var = new f0();
        } catch (ClassNotFoundException unused) {
            d0Var = new d0();
        }
        SYSTEM = d0Var;
        String str = h0.f899b;
        String property = System.getProperty("java.io.tmpdir");
        kotlin.jvm.internal.j.d(property, "getProperty(...)");
        SYSTEM_TEMPORARY_DIRECTORY = g.g.g(property);
        ClassLoader classLoader = p1.i.class.getClassLoader();
        kotlin.jvm.internal.j.d(classLoader, "getClassLoader(...)");
        RESOURCES = new p1.i(classLoader);
    }

    public static /* synthetic */ o0 appendingSink$default(u uVar, h0 h0Var, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return uVar.appendingSink(h0Var, z2);
    }

    public static /* synthetic */ void createDirectories$default(u uVar, h0 h0Var, boolean z2, int i2, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        uVar.createDirectories(h0Var, z2);
    }

    public static /* synthetic */ void createDirectory$default(u uVar, h0 h0Var, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        uVar.createDirectory(h0Var, z2);
    }

    public static /* synthetic */ void delete$default(u uVar, h0 h0Var, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        uVar.delete(h0Var, z2);
    }

    public static /* synthetic */ void deleteRecursively$default(u uVar, h0 h0Var, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        uVar.deleteRecursively(h0Var, z2);
    }

    public static final u get(FileSystem fileSystem) {
        Companion.getClass();
        kotlin.jvm.internal.j.e(fileSystem, "<this>");
        return new e0(fileSystem);
    }

    public static /* synthetic */ e1.i listRecursively$default(u uVar, h0 h0Var, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return uVar.listRecursively(h0Var, z2);
    }

    public static /* synthetic */ r openReadWrite$default(u uVar, h0 h0Var, boolean z2, boolean z3, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            z3 = false;
        }
        return uVar.openReadWrite(h0Var, z2, z3);
    }

    public static /* synthetic */ o0 sink$default(u uVar, h0 h0Var, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return uVar.sink(h0Var, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, y0.l] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* renamed from: -read, reason: not valid java name */
    public final <T> T m82read(h0 file, y0.l readerAction) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ?? r4;
        kotlin.jvm.internal.j.e(file, "file");
        kotlin.jvm.internal.j.e(readerAction, "readerAction");
        k0 k0VarC = b.c(source(file));
        T th = null;
        try {
            ?? Invoke = readerAction.invoke(k0VarC);
            try {
                k0VarC.close();
            } catch (Throwable th2) {
                th = th2;
            }
            T t2 = th;
            th = Invoke;
            r4 = t2;
        } catch (Throwable th3) {
            try {
                k0VarC.close();
                r4 = th3;
            } catch (Throwable th4) {
                p.a.b(th3, th4);
                r4 = th3;
            }
        }
        if (r4 == 0) {
            return th;
        }
        throw r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, y0.l] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* renamed from: -write, reason: not valid java name */
    public final <T> T m83write(h0 file, boolean z2, y0.l writerAction) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ?? r5;
        kotlin.jvm.internal.j.e(file, "file");
        kotlin.jvm.internal.j.e(writerAction, "writerAction");
        j0 j0VarB = b.b(sink(file, z2));
        T th = null;
        try {
            ?? Invoke = writerAction.invoke(j0VarB);
            try {
                j0VarB.close();
            } catch (Throwable th2) {
                th = th2;
            }
            r5 = th;
            th = Invoke;
        } catch (Throwable th3) {
            try {
                j0VarB.close();
                r5 = th3;
            } catch (Throwable th4) {
                p.a.b(th3, th4);
                r5 = th3;
            }
        }
        if (r5 == 0) {
            return th;
        }
        throw r5;
    }

    public final o0 appendingSink(h0 file) {
        kotlin.jvm.internal.j.e(file, "file");
        return appendingSink(file, false);
    }

    public abstract o0 appendingSink(h0 h0Var, boolean z2);

    public abstract void atomicMove(h0 h0Var, h0 h0Var2);

    public abstract h0 canonicalize(h0 h0Var);

    public void copy(h0 source, h0 target) throws Throwable {
        Throwable th;
        Long lValueOf;
        kotlin.jvm.internal.j.e(source, "source");
        kotlin.jvm.internal.j.e(target, "target");
        p0 p0VarSource = source(source);
        Throwable th2 = null;
        try {
            j0 j0VarB = b.b(sink$default(this, target, false, 2, null));
            try {
                lValueOf = Long.valueOf(j0VarB.f(p0VarSource));
                try {
                    j0VarB.close();
                    th = null;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                try {
                    j0VarB.close();
                } catch (Throwable th5) {
                    p.a.b(th4, th5);
                }
                th = th4;
                lValueOf = null;
            }
        } catch (Throwable th6) {
            th2 = th6;
            if (p0VarSource != null) {
                try {
                    p0VarSource.close();
                } catch (Throwable th7) {
                    p.a.b(th2, th7);
                }
            }
        }
        if (th != null) {
            throw th;
        }
        lValueOf.getClass();
        if (p0VarSource != null) {
            try {
                p0VarSource.close();
            } catch (Throwable th8) {
                th2 = th8;
            }
        }
        if (th2 != null) {
            throw th2;
        }
    }

    public final void createDirectories(h0 dir, boolean z2) throws IOException {
        kotlin.jvm.internal.j.e(dir, "dir");
        m0.h hVar = new m0.h();
        for (h0 h0VarB = dir; h0VarB != null && !exists(h0VarB); h0VarB = h0VarB.b()) {
            hVar.addFirst(h0VarB);
        }
        if (z2 && hVar.isEmpty()) {
            throw new IOException(dir + " already exists.");
        }
        Iterator<E> it = hVar.iterator();
        while (it.hasNext()) {
            createDirectory$default(this, (h0) it.next(), false, 2, null);
        }
    }

    public final void createDirectory(h0 dir) {
        kotlin.jvm.internal.j.e(dir, "dir");
        createDirectory(dir, false);
    }

    public abstract void createDirectory(h0 h0Var, boolean z2);

    public abstract void createSymlink(h0 h0Var, h0 h0Var2);

    public final void delete(h0 path) {
        kotlin.jvm.internal.j.e(path, "path");
        delete(path, false);
    }

    public abstract void delete(h0 h0Var, boolean z2);

    public void deleteRecursively(h0 fileOrDirectory, boolean z2) {
        kotlin.jvm.internal.j.e(fileOrDirectory, "fileOrDirectory");
        e1.j jVarF = p.a.F(new p1.d(this, fileOrDirectory, null));
        while (jVarF.hasNext()) {
            delete((h0) jVarF.next(), z2 && !jVarF.hasNext());
        }
    }

    public final boolean exists(h0 path) {
        kotlin.jvm.internal.j.e(path, "path");
        return metadataOrNull(path) != null;
    }

    public abstract List list(h0 h0Var);

    public abstract List listOrNull(h0 h0Var);

    public final e1.i listRecursively(h0 dir) {
        kotlin.jvm.internal.j.e(dir, "dir");
        return listRecursively(dir, false);
    }

    public final s metadata(h0 path) throws FileNotFoundException {
        kotlin.jvm.internal.j.e(path, "path");
        s sVarMetadataOrNull = metadataOrNull(path);
        if (sVarMetadataOrNull != null) {
            return sVarMetadataOrNull;
        }
        throw new FileNotFoundException(androidx.appcompat.app.g.l(path, "no such file: "));
    }

    public abstract s metadataOrNull(h0 h0Var);

    public abstract r openReadOnly(h0 h0Var);

    public final r openReadWrite(h0 file) {
        kotlin.jvm.internal.j.e(file, "file");
        return openReadWrite(file, false, false);
    }

    public abstract r openReadWrite(h0 h0Var, boolean z2, boolean z3);

    public final o0 sink(h0 file) {
        kotlin.jvm.internal.j.e(file, "file");
        return sink(file, false);
    }

    public abstract o0 sink(h0 h0Var, boolean z2);

    public abstract p0 source(h0 h0Var);

    public e1.i listRecursively(h0 dir, boolean z2) {
        kotlin.jvm.internal.j.e(dir, "dir");
        return new e1.m(new p1.e(dir, this, z2, null));
    }

    public final void deleteRecursively(h0 fileOrDirectory) {
        kotlin.jvm.internal.j.e(fileOrDirectory, "fileOrDirectory");
        deleteRecursively(fileOrDirectory, false);
    }

    public final void createDirectories(h0 dir) throws IOException {
        kotlin.jvm.internal.j.e(dir, "dir");
        createDirectories(dir, false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
