package okhttp3.internal.idn;

import kotlin.jvm.internal.j;
import o1.m;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class IdnaMappingTable {
    private final String mappings;
    private final String ranges;
    private final String sections;

    public IdnaMappingTable(String sections, String ranges, String mappings) {
        j.e(sections, "sections");
        j.e(ranges, "ranges");
        j.e(mappings, "mappings");
        this.sections = sections;
        this.ranges = ranges;
        this.mappings = mappings;
    }

    private final int findRangesOffset(int i2, int i3, int i4) {
        int i5;
        int i6 = i2 & 127;
        int i7 = i4 - 1;
        while (true) {
            if (i3 > i7) {
                i5 = (-i3) - 1;
                break;
            }
            i5 = (i3 + i7) / 2;
            int iF = j.f(i6, this.ranges.charAt(i5 * 4));
            if (iF >= 0) {
                if (iF <= 0) {
                    break;
                }
                i3 = i5 + 1;
            } else {
                i7 = i5 - 1;
            }
        }
        return i5 >= 0 ? i5 * 4 : ((-i5) - 2) * 4;
    }

    private final int findSectionsIndex(int i2) {
        int i3;
        int i4 = (i2 & 2097024) >> 7;
        int length = (this.sections.length() / 4) - 1;
        int i5 = 0;
        while (true) {
            if (i5 > length) {
                i3 = (-i5) - 1;
                break;
            }
            i3 = (i5 + length) / 2;
            int iF = j.f(i4, IdnaMappingTableKt.read14BitInt(this.sections, i3 * 4));
            if (iF >= 0) {
                if (iF <= 0) {
                    break;
                }
                i5 = i3 + 1;
            } else {
                length = i3 - 1;
            }
        }
        return i3 >= 0 ? i3 * 4 : ((-i3) - 2) * 4;
    }

    public final String getMappings() {
        return this.mappings;
    }

    public final String getRanges() {
        return this.ranges;
    }

    public final String getSections() {
        return this.sections;
    }

    public final boolean map(int i2, m sink) {
        j.e(sink, "sink");
        int iFindSectionsIndex = findSectionsIndex(i2);
        int iFindRangesOffset = findRangesOffset(i2, IdnaMappingTableKt.read14BitInt(this.sections, iFindSectionsIndex + 2), iFindSectionsIndex + 4 < this.sections.length() ? IdnaMappingTableKt.read14BitInt(this.sections, iFindSectionsIndex + 6) : this.ranges.length() / 4);
        char cCharAt = this.ranges.charAt(iFindRangesOffset + 1);
        if (cCharAt >= 0 && cCharAt < '@') {
            int i3 = IdnaMappingTableKt.read14BitInt(this.ranges, iFindRangesOffset + 2);
            sink.d(this.mappings, i3, cCharAt + i3);
            return true;
        }
        if ('@' <= cCharAt && cCharAt < 'P') {
            sink.l(i2 - (this.ranges.charAt(iFindRangesOffset + 3) | (((cCharAt & 15) << 14) | (this.ranges.charAt(iFindRangesOffset + 2) << 7))));
            return true;
        }
        if ('P' <= cCharAt && cCharAt < '`') {
            sink.l(i2 + (this.ranges.charAt(iFindRangesOffset + 3) | ((cCharAt & 15) << 14) | (this.ranges.charAt(iFindRangesOffset + 2) << 7)));
            return true;
        }
        if (cCharAt == 'w') {
            return true;
        }
        if (cCharAt == 'x') {
            sink.l(i2);
            return true;
        }
        if (cCharAt == 'y') {
            sink.l(i2);
            return false;
        }
        if (cCharAt == 'z') {
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 2));
            return true;
        }
        if (cCharAt == '{') {
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 2) | 128);
            return true;
        }
        if (cCharAt == '|') {
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 2));
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 3));
            return true;
        }
        if (cCharAt == '}') {
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 2) | 128);
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 3));
            return true;
        }
        if (cCharAt == '~') {
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 2));
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 3) | 128);
            return true;
        }
        if (cCharAt == 127) {
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 2) | 128);
            sink.writeByte(this.ranges.charAt(iFindRangesOffset + 3) | 128);
            return true;
        }
        throw new IllegalStateException(("unexpected rangesIndex for " + i2).toString());
    }
}
