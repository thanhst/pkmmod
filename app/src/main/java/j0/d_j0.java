package j0;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.util.regex.PatternSyntaxException;

/* compiled from: GameTextInputWraper.java */
/* loaded from: classes.dex */
public class d_j0 implements TextWatcher {

    /* renamed from: e, reason: collision with root package name */
    private EditText f3315e;

    /* renamed from: f, reason: collision with root package name */
    private String f3316f;

    /* renamed from: g, reason: collision with root package name */
    private int f3317g;

    /* renamed from: h, reason: collision with root package name */
    private int f3318h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f3319i = 0;

    public d_j0(EditText editText, String str, int i2) {
        this.f3315e = editText;
        this.f3316f = str;
        this.f3317g = i2 < 1 ? 60 : i2;
    }

    public String a(String str) {
        int i2;
        char c2;
        int i3;
        char c3;
        char[] charArray = str.toCharArray();
        String str2 = "";
        int i4 = 0;
        while (i4 < charArray.length) {
            char c4 = charArray[i4];
            if ((c4 < 57344 || c4 > 63743) && ((c4 < 9723 || c4 > 9726) && ((c4 < 9800 || c4 > 9811) && ((c4 < 9824 || c4 > 9832) && ((c4 < 9888 || c4 > 9978) && ((c4 < 9994 || c4 > 10084) && c4 != 8482 && c4 != 9664 && c4 != 9786 && c4 != 9851 && c4 != 9855 && c4 != 9875 && c4 != 9757 && c4 != 9728 && c4 != 9203 && c4 != 25525)))))) {
                if (c4 == 55356 && i4 < charArray.length - 1 && (c3 = charArray[(i3 = i4 + 1)]) >= 56576 && c3 <= 57343) {
                    i4 = i3;
                } else if (c4 != 55357 || i4 >= charArray.length - 1 || (c2 = charArray[(i2 = i4 + 1)]) < 56320 || c2 > 57343) {
                    str2 = str2 + charArray[i4];
                } else {
                    i4 = i2;
                }
            }
            i4++;
        }
        return str2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    public String b(String str) throws PatternSyntaxException {
        boolean z2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.f3316f.length()) {
                    z2 = false;
                    break;
                }
                if (this.f3316f.charAt(i3) == str.charAt(i2)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (!z2) {
                stringBuffer.append(str.charAt(i2));
            }
        }
        return stringBuffer.toString();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) throws PatternSyntaxException {
        this.f3318h = i3 + i4;
        String string = this.f3315e.getText().toString();
        String strB = b(string);
        if (!string.equals(strB)) {
            this.f3315e.setText(strB);
        }
        String string2 = this.f3315e.getText().toString();
        String strA = a(string2);
        if (!string2.equals(strA)) {
            this.f3315e.setText(strA);
        }
        EditText editText = this.f3315e;
        editText.setSelection(editText.length());
        this.f3318h = this.f3315e.length();
    }
}
