package android.system;

import java.io.FileDescriptor;

/* loaded from: classes.dex */
public final /* synthetic */ class Os {
    static {
        throw new NoClassDefFoundError();
    }

    public static native /* synthetic */ long lseek(FileDescriptor fileDescriptor, long j2, int i2) throws ErrnoException;

    public static native /* synthetic */ String readlink(String str) throws ErrnoException;

    public static native /* synthetic */ StructStat stat(String str) throws ErrnoException;
}
