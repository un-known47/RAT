package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f357a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f358b;

    public /* synthetic */ c(int i2, Object obj) {
        this.f357a = i2;
        this.f358b = obj;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z2) {
        switch (this.f357a) {
            case 0:
                ((TimePickerTextInputPresenter) this.f358b).lambda$setupPeriodToggle$0(materialButtonToggleGroup, i2, z2);
                break;
            default:
                ((TimePickerView) this.f358b).lambda$new$0(materialButtonToggleGroup, i2, z2);
                break;
        }
    }
}
