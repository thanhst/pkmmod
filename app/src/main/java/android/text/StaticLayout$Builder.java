package android.text;

import android.annotation.NonNull;
import android.text.Layout;

/* loaded from: classes.dex */
public final /* synthetic */ class StaticLayout$Builder {
    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public static native /* synthetic */ StaticLayout$Builder obtain(@NonNull CharSequence charSequence, int i2, int i3, @NonNull TextPaint textPaint, int i4);

    @NonNull
    public native /* synthetic */ StaticLayout build();

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setAlignment(@NonNull Layout.Alignment alignment);

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setBreakStrategy(int i2);

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setHyphenationFrequency(int i2);

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setIncludePad(boolean z2);

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setLineSpacing(float f2, float f3);

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setMaxLines(int i2);

    @NonNull
    public native /* synthetic */ StaticLayout$Builder setTextDirection(@NonNull TextDirectionHeuristic textDirectionHeuristic);
}
