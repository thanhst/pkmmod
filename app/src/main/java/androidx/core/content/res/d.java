package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ComplexColorCompat.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Shader f1460a;

    /* renamed from: b, reason: collision with root package name */
    private final ColorStateList f1461b;

    /* renamed from: c, reason: collision with root package name */
    private int f1462c;

    private d(Shader shader, ColorStateList colorStateList, @ColorInt int i2) {
        this.f1460a = shader;
        this.f1461b = colorStateList;
        this.f1462c = i2;
    }

    @NonNull
    private static d a(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i2);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.hashCode();
        if (name.equals("gradient")) {
            return d(f.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return c(c.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    static d b(@ColorInt int i2) {
        return new d(null, null, i2);
    }

    static d c(@NonNull ColorStateList colorStateList) {
        return new d(null, colorStateList, colorStateList.getDefaultColor());
    }

    static d d(@NonNull Shader shader) {
        return new d(shader, null, 0);
    }

    @Nullable
    public static d g(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) {
        try {
            return a(resources, i2, theme);
        } catch (Exception e2) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e2);
            return null;
        }
    }

    @ColorInt
    public int e() {
        return this.f1462c;
    }

    @Nullable
    public Shader f() {
        return this.f1460a;
    }

    public boolean h() {
        return this.f1460a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f1460a == null && (colorStateList = this.f1461b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f1461b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f1462c) {
                this.f1462c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(@ColorInt int i2) {
        this.f1462c = i2;
    }

    public boolean l() {
        return h() || this.f1462c != 0;
    }
}
