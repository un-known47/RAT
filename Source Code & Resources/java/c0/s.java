package c0;

import java.io.Writer;
import java.util.Objects;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class s extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f199a;

    /* renamed from: b, reason: collision with root package name */
    public final r f200b = new r();

    public s(StringBuilder sb) {
        this.f199a = sb;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) {
        this.f199a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public final void write(int i2) {
        this.f199a.append((char) i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        this.f199a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str, int i2, int i3) {
        Objects.requireNonNull(str);
        this.f199a.append((CharSequence) str, i2, i3 + i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i2, int i3) {
        this.f199a.append(charSequence, i2, i3);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i2, int i3) {
        this.f199a.append(charSequence, i2, i3);
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i2, int i3) {
        r rVar = this.f200b;
        rVar.f197a = cArr;
        rVar.f198b = null;
        this.f199a.append((CharSequence) rVar, i2, i3 + i2);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }
}
