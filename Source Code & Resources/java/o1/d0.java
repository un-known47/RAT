package o1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class d0 extends u {
    public static ArrayList a(h0 h0Var, boolean z2) throws IOException {
        File file = h0Var.toFile();
        String[] list = file.list();
        if (list == null) {
            if (!z2) {
                return null;
            }
            if (file.exists()) {
                throw new IOException(androidx.appcompat.app.g.l(h0Var, "failed to list "));
            }
            throw new FileNotFoundException(androidx.appcompat.app.g.l(h0Var, "no such file: "));
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            kotlin.jvm.internal.j.b(str);
            arrayList.add(h0Var.d(str));
        }
        m0.o.l0(arrayList);
        return arrayList;
    }

    @Override // o1.u
    public o0 appendingSink(h0 file, boolean z2) throws IOException {
        kotlin.jvm.internal.j.e(file, "file");
        if (!z2 || exists(file)) {
            return new e(1, new FileOutputStream(file.toFile(), true), new s0());
        }
        throw new IOException(file + " doesn't exist.");
    }

    @Override // o1.u
    public void atomicMove(h0 source, h0 target) throws IOException {
        kotlin.jvm.internal.j.e(source, "source");
        kotlin.jvm.internal.j.e(target, "target");
        if (source.toFile().renameTo(target.toFile())) {
            return;
        }
        throw new IOException("failed to move " + source + " to " + target);
    }

    @Override // o1.u
    public h0 canonicalize(h0 path) throws IOException {
        kotlin.jvm.internal.j.e(path, "path");
        File canonicalFile = path.toFile().getCanonicalFile();
        if (!canonicalFile.exists()) {
            throw new FileNotFoundException("no such file");
        }
        String str = h0.f899b;
        return g.g.h(canonicalFile);
    }

    @Override // o1.u
    public void createDirectory(h0 dir, boolean z2) throws IOException {
        kotlin.jvm.internal.j.e(dir, "dir");
        if (dir.toFile().mkdir()) {
            return;
        }
        s sVarMetadataOrNull = metadataOrNull(dir);
        if (sVarMetadataOrNull == null || !sVarMetadataOrNull.f938b) {
            throw new IOException(androidx.appcompat.app.g.l(dir, "failed to create directory: "));
        }
        if (z2) {
            throw new IOException(dir + " already exists.");
        }
    }

    @Override // o1.u
    public void createSymlink(h0 source, h0 target) throws IOException {
        kotlin.jvm.internal.j.e(source, "source");
        kotlin.jvm.internal.j.e(target, "target");
        throw new IOException("unsupported");
    }

    @Override // o1.u
    public void delete(h0 path, boolean z2) throws IOException {
        kotlin.jvm.internal.j.e(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = path.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            throw new IOException(androidx.appcompat.app.g.l(path, "failed to delete "));
        }
        if (z2) {
            throw new FileNotFoundException(androidx.appcompat.app.g.l(path, "no such file: "));
        }
    }

    @Override // o1.u
    public List list(h0 dir) throws IOException {
        kotlin.jvm.internal.j.e(dir, "dir");
        ArrayList arrayListA = a(dir, true);
        kotlin.jvm.internal.j.b(arrayListA);
        return arrayListA;
    }

    @Override // o1.u
    public List listOrNull(h0 dir) {
        kotlin.jvm.internal.j.e(dir, "dir");
        return a(dir, false);
    }

    @Override // o1.u
    public s metadataOrNull(h0 path) {
        kotlin.jvm.internal.j.e(path, "path");
        File file = path.toFile();
        boolean zIsFile = file.isFile();
        boolean zIsDirectory = file.isDirectory();
        long jLastModified = file.lastModified();
        long length = file.length();
        if (zIsFile || zIsDirectory || jLastModified != 0 || length != 0 || file.exists()) {
            return new s(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null);
        }
        return null;
    }

    @Override // o1.u
    public r openReadOnly(h0 file) {
        kotlin.jvm.internal.j.e(file, "file");
        return new c0(new RandomAccessFile(file.toFile(), "r"), 0);
    }

    @Override // o1.u
    public r openReadWrite(h0 file, boolean z2, boolean z3) throws IOException {
        kotlin.jvm.internal.j.e(file, "file");
        if (z2 && z3) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        if (z2 && exists(file)) {
            throw new IOException(file + " already exists.");
        }
        if (!z3 || exists(file)) {
            return new c0(new RandomAccessFile(file.toFile(), "rw"), 0);
        }
        throw new IOException(file + " doesn't exist.");
    }

    @Override // o1.u
    public o0 sink(h0 file, boolean z2) throws IOException {
        kotlin.jvm.internal.j.e(file, "file");
        if (!z2 || !exists(file)) {
            return new e(1, new FileOutputStream(file.toFile(), false), new s0());
        }
        throw new IOException(file + " already exists.");
    }

    @Override // o1.u
    public p0 source(h0 file) {
        kotlin.jvm.internal.j.e(file, "file");
        return new f(new FileInputStream(file.toFile()), s0.NONE);
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
