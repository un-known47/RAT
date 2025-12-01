package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class LongVector extends BaseVector {
    public LongVector __assign(int i2, ByteBuffer byteBuffer) {
        __reset(i2, 8, byteBuffer);
        return this;
    }

    public long get(int i2) {
        return this.bb.getLong(__element(i2));
    }
}
