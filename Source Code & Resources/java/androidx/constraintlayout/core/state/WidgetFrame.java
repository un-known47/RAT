package androidx.constraintlayout.core.state;

import androidx.appcompat.app.g;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Set;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class WidgetFrame {
    private static final boolean OLD_SYSTEM = true;
    public static float phone_orientation = Float.NaN;
    public float alpha;
    public int bottom;
    public float interpolatedPos;
    public int left;
    public final HashMap<String, CustomVariable> mCustom;
    public String name;
    public float pivotX;
    public float pivotY;
    public int right;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public int top;
    public float translationX;
    public float translationY;
    public float translationZ;
    public int visibility;
    public ConstraintWidget widget;

    public WidgetFrame() {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
    }

    private static void add(StringBuilder sb, String str, int i2) {
        sb.append(str);
        sb.append(": ");
        sb.append(i2);
        sb.append(",\n");
    }

    public static void interpolate(int i2, int i3, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f2) {
        int i4;
        int i5;
        int i6;
        int i7;
        float f3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        float f4 = 100.0f * f2;
        int i14 = (int) f4;
        int i15 = widgetFrame2.left;
        int i16 = widgetFrame2.top;
        int i17 = widgetFrame3.left;
        int i18 = widgetFrame3.top;
        int i19 = widgetFrame2.right - i15;
        int i20 = widgetFrame2.bottom - i16;
        int i21 = widgetFrame3.right - i17;
        int i22 = widgetFrame3.bottom - i18;
        float f5 = widgetFrame2.alpha;
        float f6 = widgetFrame3.alpha;
        if (widgetFrame2.visibility == 8) {
            i16 = (int) (i16 - (i22 / 2.0f));
            i5 = i22;
            i6 = (int) (i15 - (i21 / 2.0f));
            if (Float.isNaN(f5)) {
                i4 = i21;
                f5 = 0.0f;
            } else {
                i4 = i21;
            }
        } else {
            i4 = i19;
            i5 = i22;
            i22 = i20;
            i6 = i15;
        }
        if (widgetFrame3.visibility == 8) {
            i17 = (int) (i17 - (i4 / 2.0f));
            i18 = (int) (i18 - (i22 / 2.0f));
            if (Float.isNaN(f6)) {
                i7 = i22;
                i21 = i4;
                f6 = 0.0f;
            } else {
                i7 = i22;
                i21 = i4;
            }
        } else {
            i7 = i5;
        }
        int i23 = i16;
        float f7 = (!Float.isNaN(f5) || Float.isNaN(f6)) ? f5 : 1.0f;
        float f8 = (Float.isNaN(f7) || !Float.isNaN(f6)) ? f6 : 1.0f;
        if (widgetFrame.widget == null || !transition.hasPositionKeyframes()) {
            f3 = f2;
            i8 = i23;
            i9 = i17;
            i10 = i6;
        } else {
            Transition.KeyPosition keyPositionFindPreviousPosition = transition.findPreviousPosition(widgetFrame.widget.stringId, i14);
            int i24 = i17;
            Transition.KeyPosition keyPositionFindNextPosition = transition.findNextPosition(widgetFrame.widget.stringId, i14);
            if (keyPositionFindPreviousPosition == keyPositionFindNextPosition) {
                keyPositionFindNextPosition = null;
            }
            if (keyPositionFindPreviousPosition != null) {
                i11 = (int) (keyPositionFindPreviousPosition.f48x * i2);
                int i25 = (int) (keyPositionFindPreviousPosition.f49y * i3);
                int i26 = keyPositionFindPreviousPosition.frame;
                i8 = i25;
                i12 = i26;
            } else {
                i8 = i23;
                i11 = i6;
                i12 = 0;
            }
            if (keyPositionFindNextPosition != null) {
                i9 = (int) (keyPositionFindNextPosition.f48x * i2);
                i18 = (int) (keyPositionFindNextPosition.f49y * i3);
                i13 = keyPositionFindNextPosition.frame;
            } else {
                i13 = 100;
                i9 = i24;
            }
            f3 = (f4 - i12) / (i13 - i12);
            i10 = i11;
        }
        widgetFrame.widget = widgetFrame2.widget;
        int i27 = (int) (((i9 - i10) * f3) + i10);
        widgetFrame.left = i27;
        int i28 = (int) ((f3 * (i18 - i8)) + i8);
        widgetFrame.top = i28;
        float f9 = 1.0f - f2;
        widgetFrame.right = i27 + ((int) ((i21 * f2) + (i4 * f9)));
        widgetFrame.bottom = i28 + ((int) ((i7 * f2) + (f9 * i22)));
        widgetFrame.pivotX = interpolate(widgetFrame2.pivotX, widgetFrame3.pivotX, 0.5f, f2);
        widgetFrame.pivotY = interpolate(widgetFrame2.pivotY, widgetFrame3.pivotY, 0.5f, f2);
        widgetFrame.rotationX = interpolate(widgetFrame2.rotationX, widgetFrame3.rotationX, 0.0f, f2);
        widgetFrame.rotationY = interpolate(widgetFrame2.rotationY, widgetFrame3.rotationY, 0.0f, f2);
        widgetFrame.rotationZ = interpolate(widgetFrame2.rotationZ, widgetFrame3.rotationZ, 0.0f, f2);
        widgetFrame.scaleX = interpolate(widgetFrame2.scaleX, widgetFrame3.scaleX, 1.0f, f2);
        widgetFrame.scaleY = interpolate(widgetFrame2.scaleY, widgetFrame3.scaleY, 1.0f, f2);
        widgetFrame.translationX = interpolate(widgetFrame2.translationX, widgetFrame3.translationX, 0.0f, f2);
        widgetFrame.translationY = interpolate(widgetFrame2.translationY, widgetFrame3.translationY, 0.0f, f2);
        widgetFrame.translationZ = interpolate(widgetFrame2.translationZ, widgetFrame3.translationZ, 0.0f, f2);
        widgetFrame.alpha = interpolate(f7, f8, 1.0f, f2);
    }

    public void addCustomColor(String str, int i2) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_COLOR, i2);
    }

    public void addCustomFloat(String str, float f2) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_FLOAT, f2);
    }

    public float centerX() {
        return ((this.right - r0) / 2.0f) + this.left;
    }

    public float centerY() {
        return ((this.bottom - r0) / 2.0f) + this.top;
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mCustom.get(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mCustom.keySet();
    }

    public int getCustomColor(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getColorValue();
        }
        return -21880;
    }

    public float getCustomFloat(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getFloatValue();
        }
        return Float.NaN;
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public boolean isDefaultTransform() {
        return Float.isNaN(this.rotationX) && Float.isNaN(this.rotationY) && Float.isNaN(this.rotationZ) && Float.isNaN(this.translationX) && Float.isNaN(this.translationY) && Float.isNaN(this.translationZ) && Float.isNaN(this.scaleX) && Float.isNaN(this.scaleY) && Float.isNaN(this.alpha);
    }

    public void logv(String str) {
        String strH;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbR = g.r(".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName(), " ");
        sbR.append(hashCode() % 1000);
        String string = sbR.toString();
        if (this.widget != null) {
            StringBuilder sbR2 = g.r(string, "/");
            sbR2.append(this.widget.hashCode() % 1000);
            strH = sbR2.toString();
        } else {
            strH = g.h(string, "/NULL");
        }
        System.out.println(strH + " " + str);
    }

    public void parseCustom(CLElement cLElement) throws NumberFormatException {
        CLObject cLObject = (CLObject) cLElement;
        int size = cLObject.size();
        for (int i2 = 0; i2 < size; i2++) {
            CLKey cLKey = (CLKey) cLObject.get(i2);
            cLKey.content();
            CLElement value = cLKey.getValue();
            String strContent = value.content();
            if (strContent.matches("#[0-9a-fA-F]+")) {
                setCustomAttribute(cLKey.content(), TypedValues.Custom.TYPE_COLOR, Integer.parseInt(strContent.substring(1), 16));
            } else if (value instanceof CLNumber) {
                setCustomAttribute(cLKey.content(), TypedValues.Custom.TYPE_FLOAT, value.getFloat());
            } else {
                setCustomAttribute(cLKey.content(), TypedValues.Custom.TYPE_STRING, strContent);
            }
        }
    }

    public void printCustomAttributes() {
        String strH;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sbR = g.r(".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName(), " ");
        sbR.append(hashCode() % 1000);
        String string = sbR.toString();
        if (this.widget != null) {
            StringBuilder sbR2 = g.r(string, "/");
            sbR2.append(this.widget.hashCode() % 1000);
            sbR2.append(" ");
            strH = sbR2.toString();
        } else {
            strH = g.h(string, "/NULL ");
        }
        HashMap<String, CustomVariable> map = this.mCustom;
        if (map != null) {
            for (String str : map.keySet()) {
                PrintStream printStream = System.out;
                StringBuilder sbP = g.p(strH);
                sbP.append(this.mCustom.get(str).toString());
                printStream.println(sbP.toString());
            }
        }
    }

    public StringBuilder serialize(StringBuilder sb) {
        return serialize(sb, false);
    }

    public void setCustomAttribute(String str, int i2, float f2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setFloatValue(f2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i2, f2));
        }
    }

    public boolean setValue(String str, CLElement cLElement) throws NumberFormatException {
        str.getClass();
        switch (str) {
            case "phone_orientation":
                phone_orientation = cLElement.getFloat();
                return true;
            case "bottom":
                this.bottom = cLElement.getInt();
                return true;
            case "custom":
                parseCustom(cLElement);
                return true;
            case "rotationX":
                this.rotationX = cLElement.getFloat();
                return true;
            case "rotationY":
                this.rotationY = cLElement.getFloat();
                return true;
            case "rotationZ":
                this.rotationZ = cLElement.getFloat();
                return true;
            case "translationX":
                this.translationX = cLElement.getFloat();
                return true;
            case "translationY":
                this.translationY = cLElement.getFloat();
                return true;
            case "translationZ":
                this.translationZ = cLElement.getFloat();
                return true;
            case "pivotX":
                this.pivotX = cLElement.getFloat();
                return true;
            case "pivotY":
                this.pivotY = cLElement.getFloat();
                return true;
            case "scaleX":
                this.scaleX = cLElement.getFloat();
                return true;
            case "scaleY":
                this.scaleY = cLElement.getFloat();
                return true;
            case "top":
                this.top = cLElement.getInt();
                return true;
            case "left":
                this.left = cLElement.getInt();
                return true;
            case "alpha":
                this.alpha = cLElement.getFloat();
                return true;
            case "right":
                this.right = cLElement.getInt();
                return true;
            case "interpolatedPos":
                this.interpolatedPos = cLElement.getFloat();
                return true;
            default:
                return false;
        }
    }

    public WidgetFrame update() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            this.left = constraintWidget.getLeft();
            this.top = this.widget.getTop();
            this.right = this.widget.getRight();
            this.bottom = this.widget.getBottom();
            updateAttributes(this.widget.frame);
        }
        return this;
    }

    public void updateAttributes(WidgetFrame widgetFrame) {
        this.pivotX = widgetFrame.pivotX;
        this.pivotY = widgetFrame.pivotY;
        this.rotationX = widgetFrame.rotationX;
        this.rotationY = widgetFrame.rotationY;
        this.rotationZ = widgetFrame.rotationZ;
        this.translationX = widgetFrame.translationX;
        this.translationY = widgetFrame.translationY;
        this.translationZ = widgetFrame.translationZ;
        this.scaleX = widgetFrame.scaleX;
        this.scaleY = widgetFrame.scaleY;
        this.alpha = widgetFrame.alpha;
        this.visibility = widgetFrame.visibility;
        this.mCustom.clear();
        for (CustomVariable customVariable : widgetFrame.mCustom.values()) {
            this.mCustom.put(customVariable.getName(), customVariable.copy());
        }
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }

    public StringBuilder serialize(StringBuilder sb, boolean z2) {
        sb.append("{\n");
        add(sb, "left", this.left);
        add(sb, "top", this.top);
        add(sb, "right", this.right);
        add(sb, "bottom", this.bottom);
        add(sb, "pivotX", this.pivotX);
        add(sb, "pivotY", this.pivotY);
        add(sb, "rotationX", this.rotationX);
        add(sb, "rotationY", this.rotationY);
        add(sb, "rotationZ", this.rotationZ);
        add(sb, "translationX", this.translationX);
        add(sb, "translationY", this.translationY);
        add(sb, "translationZ", this.translationZ);
        add(sb, "scaleX", this.scaleX);
        add(sb, "scaleY", this.scaleY);
        add(sb, "alpha", this.alpha);
        add(sb, "visibility", this.left);
        add(sb, "interpolatedPos", this.interpolatedPos);
        if (z2) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (z2) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (this.mCustom.size() != 0) {
            sb.append("custom : {\n");
            for (String str : this.mCustom.keySet()) {
                CustomVariable customVariable = this.mCustom.get(str);
                sb.append(str);
                sb.append(": ");
                switch (customVariable.getType()) {
                    case TypedValues.Custom.TYPE_INT /* 900 */:
                        sb.append(customVariable.getIntegerValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                    case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                        sb.append(customVariable.getFloatValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_COLOR /* 902 */:
                        sb.append("'");
                        sb.append(CustomVariable.colorString(customVariable.getIntegerValue()));
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_STRING /* 903 */:
                        sb.append("'");
                        sb.append(customVariable.getStringValue());
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                        sb.append("'");
                        sb.append(customVariable.getBooleanValue());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    public void setCustomAttribute(String str, int i2, int i3) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setIntValue(i3);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i2, i3));
        }
    }

    private static void add(StringBuilder sb, String str, float f2) {
        if (Float.isNaN(f2)) {
            return;
        }
        sb.append(str);
        sb.append(": ");
        sb.append(f2);
        sb.append(",\n");
    }

    public void setCustomAttribute(String str, int i2, boolean z2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setBooleanValue(z2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i2, z2));
        }
    }

    public WidgetFrame update(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.widget = constraintWidget;
        update();
        return this;
    }

    public void setCustomAttribute(String str, int i2, String str2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setStringValue(str2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i2, str2));
        }
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = constraintWidget;
    }

    private static float interpolate(float f2, float f3, float f4, float f5) {
        boolean zIsNaN = Float.isNaN(f2);
        boolean zIsNaN2 = Float.isNaN(f3);
        if (zIsNaN && zIsNaN2) {
            return Float.NaN;
        }
        if (zIsNaN) {
            f2 = f4;
        }
        if (zIsNaN2) {
            f3 = f4;
        }
        return g.b(f3, f2, f5, f2);
    }

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = widgetFrame.widget;
        this.left = widgetFrame.left;
        this.top = widgetFrame.top;
        this.right = widgetFrame.right;
        this.bottom = widgetFrame.bottom;
        updateAttributes(widgetFrame);
    }
}
