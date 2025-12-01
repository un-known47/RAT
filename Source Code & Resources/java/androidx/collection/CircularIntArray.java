package androidx.collection;

import kotlin.jvm.internal.e;
import m0.i;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class CircularIntArray {
    private int capacityBitmask;
    private int[] elements;
    private int head;
    private int tail;

    public CircularIntArray() {
        this(0, 1, null);
    }

    private final void doubleCapacity() {
        int[] iArr = this.elements;
        int length = iArr.length;
        int i2 = this.head;
        int i3 = length - i2;
        int i4 = length << 1;
        if (i4 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i4];
        i.i0(0, i2, iArr, iArr2, length);
        i.i0(i3, 0, this.elements, iArr2, this.head);
        this.elements = iArr2;
        this.head = 0;
        this.tail = length;
        this.capacityBitmask = i4 - 1;
    }

    public final void addFirst(int i2) {
        int i3 = (this.head - 1) & this.capacityBitmask;
        this.head = i3;
        this.elements[i3] = i2;
        if (i3 == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(int i2) {
        int[] iArr = this.elements;
        int i3 = this.tail;
        iArr[i3] = i2;
        int i4 = this.capacityBitmask & (i3 + 1);
        this.tail = i4;
        if (i4 == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        this.tail = this.head;
    }

    public final int get(int i2) {
        if (i2 < 0 || i2 >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.elements[this.capacityBitmask & (this.head + i2)];
    }

    public final int getFirst() {
        int i2 = this.head;
        if (i2 != this.tail) {
            return this.elements[i2];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int getLast() {
        int i2 = this.head;
        int i3 = this.tail;
        if (i2 != i3) {
            return this.elements[(i3 - 1) & this.capacityBitmask];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final int popFirst() {
        int i2 = this.head;
        if (i2 == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = this.elements[i2];
        this.head = (i2 + 1) & this.capacityBitmask;
        return i3;
    }

    public final int popLast() {
        int i2 = this.head;
        int i3 = this.tail;
        if (i2 == i3) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = this.capacityBitmask & (i3 - 1);
        int i5 = this.elements[i4];
        this.tail = i4;
        return i5;
    }

    public final void removeFromEnd(int i2) {
        if (i2 <= 0) {
            return;
        }
        if (i2 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        this.tail = this.capacityBitmask & (this.tail - i2);
    }

    public final void removeFromStart(int i2) {
        if (i2 <= 0) {
            return;
        }
        if (i2 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        this.head = this.capacityBitmask & (this.head + i2);
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public CircularIntArray(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i2 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i2 = Integer.bitCount(i2) != 1 ? Integer.highestOneBit(i2 - 1) << 1 : i2;
        this.capacityBitmask = i2 - 1;
        this.elements = new int[i2];
    }

    public /* synthetic */ CircularIntArray(int i2, int i3, e eVar) {
        this((i3 & 1) != 0 ? 8 : i2);
    }
}
