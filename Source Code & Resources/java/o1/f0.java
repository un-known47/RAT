package o1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class f0 extends d0 {
    public static s D(Path path) throws IOException {
        h0 h0VarI;
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            Path symbolicLink = attributes.isSymbolicLink() ? Files.readSymbolicLink(path) : null;
            boolean zIsRegularFile = attributes.isRegularFile();
            boolean zIsDirectory = attributes.isDirectory();
            if (symbolicLink != null) {
                String str = h0.f899b;
                h0VarI = g.g.i(symbolicLink);
            } else {
                h0VarI = null;
            }
            Long lValueOf = Long.valueOf(attributes.size());
            FileTime fileTimeCreationTime = attributes.creationTime();
            Long lE = fileTimeCreationTime != null ? E(fileTimeCreationTime) : null;
            FileTime fileTimeLastModifiedTime = attributes.lastModifiedTime();
            Long lE2 = fileTimeLastModifiedTime != null ? E(fileTimeLastModifiedTime) : null;
            FileTime fileTimeLastAccessTime = attributes.lastAccessTime();
            return new s(zIsRegularFile, zIsDirectory, h0VarI, lValueOf, lE, lE2, fileTimeLastAccessTime != null ? E(fileTimeLastAccessTime) : null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }

    public static Long E(FileTime fileTime) {
        long millis = fileTime.toMillis();
        Long lValueOf = Long.valueOf(millis);
        if (millis != 0) {
            return lValueOf;
        }
        return null;
    }

    @Override // o1.d0, o1.u
    public void atomicMove(h0 source, h0 target) throws IOException {
        kotlin.jvm.internal.j.e(source, "source");
        kotlin.jvm.internal.j.e(target, "target");
        try {
            Files.move(source.f(), target.f(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e2) {
            throw new FileNotFoundException(e2.getMessage());
        }
    }

    @Override // o1.d0, o1.u
    public void createSymlink(h0 source, h0 target) throws IOException {
        kotlin.jvm.internal.j.e(source, "source");
        kotlin.jvm.internal.j.e(target, "target");
        Files.createSymbolicLink(source.f(), target.f(), new FileAttribute[0]);
    }

    @Override // o1.d0, o1.u
    public s metadataOrNull(h0 path) {
        kotlin.jvm.internal.j.e(path, "path");
        return D(path.f());
    }

    @Override // o1.d0
    public String toString() {
        return "NioSystemFileSystem";
    }
}
