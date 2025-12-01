package androidx.emoji2.text.flatbuffer;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte b2);

    void put(byte[] bArr, int i2, int i3);

    void putBoolean(boolean z2);

    void putDouble(double d);

    void putFloat(float f2);

    void putInt(int i2);

    void putLong(long j);

    void putShort(short s2);

    boolean requestCapacity(int i2);

    void set(int i2, byte b2);

    void set(int i2, byte[] bArr, int i3, int i4);

    void setBoolean(int i2, boolean z2);

    void setDouble(int i2, double d);

    void setFloat(int i2, float f2);

    void setInt(int i2, int i3);

    void setLong(int i2, long j);

    void setShort(int i2, short s2);

    int writePosition();
}
