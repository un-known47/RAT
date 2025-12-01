package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class UnionVector extends BaseVector {
    public UnionVector __assign(int i2, int i3, ByteBuffer byteBuffer) {
        __reset(i2, i3, byteBuffer);
        return this;
    }

    public Table get(Table table, int i2) {
        return Table.__union(table, __element(i2), this.bb);
    }
}
