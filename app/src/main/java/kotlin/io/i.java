package kotlin.io;

import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReadWrite.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Ljava/io/Reader;", "", "c", "Ljava/io/Writer;", "out", "", "bufferSize", "", "a", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "TextStreamsKt")
/* loaded from: classes.dex */
public final class i {
    public static final long a(@NotNull Reader reader, @NotNull Writer out, int i2) throws IOException {
        s.e(reader, "<this>");
        s.e(out, "out");
        char[] cArr = new char[i2];
        int i3 = reader.read(cArr);
        long j2 = 0;
        while (i3 >= 0) {
            out.write(cArr, 0, i3);
            j2 += i3;
            i3 = reader.read(cArr);
        }
        return j2;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        return a(reader, writer, i2);
    }

    @NotNull
    public static final String c(@NotNull Reader reader) {
        s.e(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        s.d(string, "buffer.toString()");
        return string;
    }
}
