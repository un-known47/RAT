package androidx.constraintlayout.core.motion;

import androidx.appcompat.app.g;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class CustomAttribute {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    private boolean mMethod;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    /* renamed from: androidx.constraintlayout.core.motion.CustomAttribute$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType;

        static {
            int[] iArr = new int[AttributeType.values().length];
            $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType = iArr;
            try {
                iArr[AttributeType.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[AttributeType.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public CustomAttribute(String str, AttributeType attributeType) {
        this.mMethod = false;
        this.mName = str;
        this.mType = attributeType;
    }

    private static int clamp(int i2) {
        int i3 = (i2 & (~(i2 >> 31))) - 255;
        return (i3 & (i3 >> 31)) + 255;
    }

    public static HashMap<String, CustomAttribute> extractAttributes(HashMap<String, CustomAttribute> map, Object obj) {
        HashMap<String, CustomAttribute> map2 = new HashMap<>();
        Class<?> cls = obj.getClass();
        for (String str : map.keySet()) {
            try {
                map2.put(str, new CustomAttribute(map.get(str), cls.getMethod("getMap" + str, null).invoke(obj, null)));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        return map2;
    }

    public static int hsvToRgb(float f2, float f3, float f4) {
        float f5 = f2 * 6.0f;
        int i2 = (int) f5;
        float f6 = f5 - i2;
        float f7 = f4 * 255.0f;
        int iB = (int) g.b(1.0f, f3, f7, 0.5f);
        int i3 = (int) (((1.0f - (f6 * f3)) * f7) + 0.5f);
        int i4 = (int) (((1.0f - ((1.0f - f6) * f3)) * f7) + 0.5f);
        int i5 = (int) (f7 + 0.5f);
        if (i2 == 0) {
            return ((i5 << 16) + (i4 << 8) + iB) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i2 == 1) {
            return ((i3 << 16) + (i5 << 8) + iB) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i2 == 2) {
            return ((iB << 16) + (i5 << 8) + i4) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i2 == 3) {
            return ((iB << 16) + (i3 << 8) + i5) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i2 == 4) {
            return ((i4 << 16) + (iB << 8) + i5) | ViewCompat.MEASURED_STATE_MASK;
        }
        if (i2 != 5) {
            return 0;
        }
        return ((i5 << 16) + (iB << 8) + i3) | ViewCompat.MEASURED_STATE_MASK;
    }

    public static void setAttributes(Object obj, HashMap<String, CustomAttribute> map) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = obj.getClass();
        for (String str : map.keySet()) {
            CustomAttribute customAttribute = map.get(str);
            String strV = !customAttribute.mMethod ? g.v("set", str) : str;
            try {
                int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[customAttribute.mType.ordinal()];
                Class<?> cls2 = Float.TYPE;
                Class<?> cls3 = Integer.TYPE;
                switch (i2) {
                    case 1:
                        cls.getMethod(strV, cls3).invoke(obj, Integer.valueOf(customAttribute.mIntegerValue));
                        break;
                    case 2:
                        cls.getMethod(strV, Boolean.TYPE).invoke(obj, Boolean.valueOf(customAttribute.mBooleanValue));
                        break;
                    case 3:
                        cls.getMethod(strV, CharSequence.class).invoke(obj, customAttribute.mStringValue);
                        break;
                    case 4:
                        cls.getMethod(strV, cls3).invoke(obj, Integer.valueOf(customAttribute.mColorValue));
                        break;
                    case 6:
                        cls.getMethod(strV, cls3).invoke(obj, Integer.valueOf(customAttribute.mIntegerValue));
                        break;
                    case 7:
                        cls.getMethod(strV, cls2).invoke(obj, Float.valueOf(customAttribute.mFloatValue));
                        break;
                    case 8:
                        cls.getMethod(strV, cls2).invoke(obj, Float.valueOf(customAttribute.mFloatValue));
                        break;
                }
            } catch (IllegalAccessException e2) {
                StringBuilder sbS = g.s(" Custom Attribute \"", str, "\" not found on ");
                sbS.append(cls.getName());
                Utils.loge(TAG, sbS.toString());
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                Utils.loge(TAG, e3.getMessage());
                Utils.loge(TAG, " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                Utils.loge(TAG, cls.getName() + " must have a method " + strV);
            } catch (InvocationTargetException e4) {
                StringBuilder sbS2 = g.s(" Custom Attribute \"", str, "\" not found on ");
                sbS2.append(cls.getName());
                Utils.loge(TAG, sbS2.toString());
                e4.printStackTrace();
            }
        }
    }

    public void applyCustom(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = obj.getClass();
        String str = this.mName;
        String strV = !this.mMethod ? g.v("set", str) : str;
        try {
            int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()];
            Class<?> cls2 = Integer.TYPE;
            Class<?> cls3 = Float.TYPE;
            switch (i2) {
                case 1:
                case 6:
                    cls.getMethod(strV, cls2).invoke(obj, Integer.valueOf(this.mIntegerValue));
                    break;
                case 2:
                    cls.getMethod(strV, Boolean.TYPE).invoke(obj, Boolean.valueOf(this.mBooleanValue));
                    break;
                case 3:
                    cls.getMethod(strV, CharSequence.class).invoke(obj, this.mStringValue);
                    break;
                case 4:
                    cls.getMethod(strV, cls2).invoke(obj, Integer.valueOf(this.mColorValue));
                    break;
                case 7:
                    cls.getMethod(strV, cls3).invoke(obj, Float.valueOf(this.mFloatValue));
                    break;
                case 8:
                    cls.getMethod(strV, cls3).invoke(obj, Float.valueOf(this.mFloatValue));
                    break;
            }
        } catch (IllegalAccessException e2) {
            StringBuilder sbS = g.s(" Custom Attribute \"", str, "\" not found on ");
            sbS.append(cls.getName());
            Utils.loge(TAG, sbS.toString());
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            Utils.loge(TAG, e3.getMessage());
            Utils.loge(TAG, " Custom Attribute \"" + str + "\" not found on " + cls.getName());
            Utils.loge(TAG, cls.getName() + " must have a method " + strV);
        } catch (InvocationTargetException e4) {
            StringBuilder sbS2 = g.s(" Custom Attribute \"", str, "\" not found on ");
            sbS2.append(cls.getName());
            Utils.loge(TAG, sbS2.toString());
            e4.printStackTrace();
        }
    }

    public boolean diff(CustomAttribute customAttribute) {
        AttributeType attributeType;
        if (customAttribute != null && (attributeType = this.mType) == customAttribute.mType) {
            switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[attributeType.ordinal()]) {
                case 1:
                case 6:
                    if (this.mIntegerValue == customAttribute.mIntegerValue) {
                        return true;
                    }
                    break;
                case 2:
                    return this.mBooleanValue == customAttribute.mBooleanValue;
                case 3:
                    return this.mIntegerValue == customAttribute.mIntegerValue;
                case 4:
                case 5:
                    return this.mColorValue == customAttribute.mColorValue;
                case 7:
                    return this.mFloatValue == customAttribute.mFloatValue;
                case 8:
                    return this.mFloatValue == customAttribute.mFloatValue;
                default:
                    return false;
            }
        }
        return false;
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()]) {
            case 2:
                return this.mBooleanValue ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return this.mIntegerValue;
            case 7:
                return this.mFloatValue;
            case 8:
                return this.mFloatValue;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()]) {
            case 2:
                fArr[0] = this.mBooleanValue ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i2 = (this.mColorValue >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i2 / 255.0f;
                return;
            case 6:
                fArr[0] = this.mIntegerValue;
                return;
            case 7:
                fArr[0] = this.mFloatValue;
                return;
            case 8:
                fArr[0] = this.mFloatValue;
                return;
            default:
                return;
        }
    }

    public boolean isContinuous() {
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()];
        return (i2 == 1 || i2 == 2 || i2 == 3) ? false : true;
    }

    public int numberOfInterpolatedValues() {
        int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()];
        return (i2 == 4 || i2 == 5) ? 4 : 1;
    }

    public void setColorValue(int i2) {
        this.mColorValue = i2;
    }

    public void setFloatValue(float f2) {
        this.mFloatValue = f2;
    }

    public void setIntValue(int i2) {
        this.mIntegerValue = i2;
    }

    public void setInterpolatedValue(Object obj, float[] fArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = obj.getClass();
        String str = "set" + this.mName;
        try {
            int i2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()];
            if (i2 == 2) {
                cls.getMethod(str, Boolean.TYPE).invoke(obj, Boolean.valueOf(fArr[0] > 0.5f));
                return;
            }
            if (i2 == 3) {
                throw new RuntimeException("unable to interpolate strings " + this.mName);
            }
            Class<?> cls2 = Integer.TYPE;
            if (i2 == 4) {
                cls.getMethod(str, cls2).invoke(obj, Integer.valueOf((clamp((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (fArr[3] * 255.0f)) << 24) | (clamp((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | clamp((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                return;
            }
            if (i2 == 6) {
                cls.getMethod(str, cls2).invoke(obj, Integer.valueOf((int) fArr[0]));
                return;
            }
            Class<?> cls3 = Float.TYPE;
            if (i2 == 7) {
                cls.getMethod(str, cls3).invoke(obj, Float.valueOf(fArr[0]));
            } else {
                if (i2 != 8) {
                    return;
                }
                cls.getMethod(str, cls3).invoke(obj, Float.valueOf(fArr[0]));
            }
        } catch (IllegalAccessException e2) {
            StringBuilder sbS = g.s("cannot access method ", str, " on View \"");
            sbS.append(obj.getClass().getName());
            sbS.append("\"");
            Utils.loge(TAG, sbS.toString());
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            StringBuilder sbS2 = g.s("no method ", str, " on View \"");
            sbS2.append(obj.getClass().getName());
            sbS2.append("\"");
            Utils.loge(TAG, sbS2.toString());
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public void setValue(float[] fArr) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()]) {
            case 1:
            case 6:
                this.mIntegerValue = (int) fArr[0];
                return;
            case 2:
                this.mBooleanValue = ((double) fArr[0]) > 0.5d;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int iHsvToRgb = hsvToRgb(fArr[0], fArr[1], fArr[2]);
                this.mColorValue = iHsvToRgb;
                this.mColorValue = (clamp((int) (fArr[3] * 255.0f)) << 24) | (iHsvToRgb & ViewCompat.MEASURED_SIZE_MASK);
                return;
            case 7:
                this.mFloatValue = fArr[0];
                return;
            case 8:
                this.mFloatValue = fArr[0];
                return;
            default:
                return;
        }
    }

    public CustomAttribute(String str, AttributeType attributeType, Object obj, boolean z2) {
        this.mName = str;
        this.mType = attributeType;
        this.mMethod = z2;
        setValue(obj);
    }

    public void setValue(Object obj) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$motion$CustomAttribute$AttributeType[this.mType.ordinal()]) {
            case 1:
            case 6:
                this.mIntegerValue = ((Integer) obj).intValue();
                break;
            case 2:
                this.mBooleanValue = ((Boolean) obj).booleanValue();
                break;
            case 3:
                this.mStringValue = (String) obj;
                break;
            case 4:
            case 5:
                this.mColorValue = ((Integer) obj).intValue();
                break;
            case 7:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
            case 8:
                this.mFloatValue = ((Float) obj).floatValue();
                break;
        }
    }

    public CustomAttribute(CustomAttribute customAttribute, Object obj) {
        this.mMethod = false;
        this.mName = customAttribute.mName;
        this.mType = customAttribute.mType;
        setValue(obj);
    }
}
