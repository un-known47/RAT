package androidx.constraintlayout.core.parser;

import java.util.ArrayList;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        String json = toJSON();
        if (i3 > 0 || json.length() + i2 >= CLElement.MAX_LINE) {
            sb.append("[\n");
            ArrayList<CLElement> arrayList = this.mElements;
            int size = arrayList.size();
            boolean z2 = true;
            int i4 = 0;
            while (i4 < size) {
                CLElement cLElement = arrayList.get(i4);
                i4++;
                CLElement cLElement2 = cLElement;
                if (z2) {
                    z2 = false;
                } else {
                    sb.append(",\n");
                }
                addIndent(sb, CLElement.BASE_INDENT + i2);
                sb.append(cLElement2.toFormattedJSON(CLElement.BASE_INDENT + i2, i3 - 1));
            }
            sb.append("\n");
            addIndent(sb, i2);
            sb.append("]");
        } else {
            sb.append(json);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "[");
        boolean z2 = true;
        for (int i2 = 0; i2 < this.mElements.size(); i2++) {
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append(this.mElements.get(i2).toJSON());
        }
        return ((Object) sb) + "]";
    }
}
