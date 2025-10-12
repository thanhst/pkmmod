package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class ExifInterface {
    private static final c[] D;
    private static final c[] E;
    private static final c[] F;
    private static final c[] G;
    private static final c[] H;
    private static final c I;
    private static final c[] J;
    private static final c[] K;
    private static final c[] L;
    private static final c[] M;
    static final c[][] N;
    private static final c[] O;
    private static final c P;
    private static final c Q;
    private static final HashMap<Integer, c>[] R;
    private static final HashMap<String, c>[] S;
    private static final HashSet<String> T;
    private static final HashMap<Integer, Integer> U;
    static final Charset V;
    static final byte[] W;
    private static final Pattern X;
    private static final Pattern Y;

    /* renamed from: z, reason: collision with root package name */
    private static SimpleDateFormat f1985z;

    /* renamed from: a, reason: collision with root package name */
    private final String f1986a;

    /* renamed from: b, reason: collision with root package name */
    private final AssetManager.AssetInputStream f1987b;

    /* renamed from: c, reason: collision with root package name */
    private int f1988c;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, b>[] f1989d;

    /* renamed from: e, reason: collision with root package name */
    private Set<Integer> f1990e;

    /* renamed from: f, reason: collision with root package name */
    private ByteOrder f1991f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1992g;

    /* renamed from: h, reason: collision with root package name */
    private int f1993h;

    /* renamed from: i, reason: collision with root package name */
    private int f1994i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f1995j;

    /* renamed from: k, reason: collision with root package name */
    private int f1996k;

    /* renamed from: l, reason: collision with root package name */
    private int f1997l;

    /* renamed from: m, reason: collision with root package name */
    private int f1998m;

    /* renamed from: n, reason: collision with root package name */
    private int f1999n;

    /* renamed from: o, reason: collision with root package name */
    private int f2000o;

    /* renamed from: p, reason: collision with root package name */
    private int f2001p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2002q;

    /* renamed from: r, reason: collision with root package name */
    private static final List<Integer> f1977r = Arrays.asList(1, 6, 3, 8);

    /* renamed from: s, reason: collision with root package name */
    private static final List<Integer> f1978s = Arrays.asList(2, 7, 4, 5);

    /* renamed from: t, reason: collision with root package name */
    public static final int[] f1979t = {8, 8, 8};

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f1980u = {4};

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f1981v = {8};

    /* renamed from: w, reason: collision with root package name */
    static final byte[] f1982w = {-1, -40, -1};

    /* renamed from: x, reason: collision with root package name */
    private static final byte[] f1983x = {79, 76, 89, 77, 80, 0};

    /* renamed from: y, reason: collision with root package name */
    private static final byte[] f1984y = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    static final String[] A = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    static final int[] B = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] C = {65, 83, 67, 73, 73, 0, 0, 0};

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface IfdType {
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f2009a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2010b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f2011c;

        b(int i2, int i3, byte[] bArr) {
            this.f2009a = i2;
            this.f2010b = i3;
            this.f2011c = bArr;
        }

        public static b a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(ExifInterface.V);
            return new b(2, bytes.length, bytes);
        }

        public static b b(long j2, ByteOrder byteOrder) {
            return c(new long[]{j2}, byteOrder);
        }

        public static b c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.B[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j2 : jArr) {
                byteBufferWrap.putInt((int) j2);
            }
            return new b(4, jArr.length, byteBufferWrap.array());
        }

        public static b d(d dVar, ByteOrder byteOrder) {
            return e(new d[]{dVar}, byteOrder);
        }

        public static b e(d[] dVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.B[5] * dVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (d dVar : dVarArr) {
                byteBufferWrap.putInt((int) dVar.f2016a);
                byteBufferWrap.putInt((int) dVar.f2017b);
            }
            return new b(5, dVarArr.length, byteBufferWrap.array());
        }

        public static b f(int i2, ByteOrder byteOrder) {
            return g(new int[]{i2}, byteOrder);
        }

        public static b g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.B[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i2 : iArr) {
                byteBufferWrap.putShort((short) i2);
            }
            return new b(3, iArr.length, byteBufferWrap.array());
        }

        public double h(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objK instanceof String) {
                return Double.parseDouble((String) objK);
            }
            if (objK instanceof long[]) {
                if (((long[]) objK).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objK instanceof int[]) {
                if (((int[]) objK).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objK instanceof double[]) {
                double[] dArr = (double[]) objK;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objK instanceof d[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            d[] dVarArr = (d[]) objK;
            if (dVarArr.length == 1) {
                return dVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int i(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objK instanceof String) {
                return Integer.parseInt((String) objK);
            }
            if (objK instanceof long[]) {
                long[] jArr = (long[]) objK;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objK instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objK;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String j(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                return null;
            }
            if (objK instanceof String) {
                return (String) objK;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (objK instanceof long[]) {
                long[] jArr = (long[]) objK;
                while (i2 < jArr.length) {
                    sb.append(jArr[i2]);
                    i2++;
                    if (i2 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objK instanceof int[]) {
                int[] iArr = (int[]) objK;
                while (i2 < iArr.length) {
                    sb.append(iArr[i2]);
                    i2++;
                    if (i2 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objK instanceof double[]) {
                double[] dArr = (double[]) objK;
                while (i2 < dArr.length) {
                    sb.append(dArr[i2]);
                    i2++;
                    if (i2 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(objK instanceof d[])) {
                return null;
            }
            d[] dVarArr = (d[]) objK;
            while (i2 < dVarArr.length) {
                sb.append(dVarArr[i2].f2016a);
                sb.append('/');
                sb.append(dVarArr[i2].f2017b);
                i2++;
                if (i2 != dVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x0198: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:409), block:B:151:0x0198 */
        /* JADX WARN: Removed duplicated region for block: B:184:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object k(java.nio.ByteOrder r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 450
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.b.k(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            return "(" + ExifInterface.A[this.f2009a] + ", data length:" + this.f2011c.length + ")";
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        public final long f2016a;

        /* renamed from: b, reason: collision with root package name */
        public final long f2017b;

        d(long j2, long j3) {
            if (j3 == 0) {
                this.f2016a = 0L;
                this.f2017b = 1L;
            } else {
                this.f2016a = j2;
                this.f2017b = j3;
            }
        }

        public double a() {
            double d2 = this.f2016a;
            double d3 = this.f2017b;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return d2 / d3;
        }

        public String toString() {
            return this.f2016a + "/" + this.f2017b;
        }
    }

    static {
        c[] cVarArr = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
        D = cVarArr;
        c[] cVarArr2 = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        E = cVarArr2;
        c[] cVarArr3 = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
        F = cVarArr3;
        c[] cVarArr4 = {new c("InteroperabilityIndex", 1, 2)};
        G = cVarArr4;
        c[] cVarArr5 = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        H = cVarArr5;
        I = new c("StripOffsets", 273, 3);
        c[] cVarArr6 = {new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
        J = cVarArr6;
        c[] cVarArr7 = {new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
        K = cVarArr7;
        c[] cVarArr8 = {new c("AspectFrame", 4371, 3)};
        L = cVarArr8;
        c[] cVarArr9 = {new c("ColorSpace", 55, 3)};
        M = cVarArr9;
        c[][] cVarArr10 = {cVarArr, cVarArr2, cVarArr3, cVarArr4, cVarArr5, cVarArr, cVarArr6, cVarArr7, cVarArr8, cVarArr9};
        N = cVarArr10;
        O = new c[]{new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
        P = new c("JPEGInterchangeFormat", 513, 4);
        Q = new c("JPEGInterchangeFormatLength", 514, 4);
        R = new HashMap[cVarArr10.length];
        S = new HashMap[cVarArr10.length];
        T = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        U = new HashMap<>();
        Charset charsetForName = Charset.forName("US-ASCII");
        V = charsetForName;
        W = "Exif\u0000\u0000".getBytes(charsetForName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        f1985z = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i2 = 0;
        while (true) {
            c[][] cVarArr11 = N;
            if (i2 >= cVarArr11.length) {
                HashMap<Integer, Integer> map = U;
                c[] cVarArr12 = O;
                map.put(Integer.valueOf(cVarArr12[0].f2012a), 5);
                map.put(Integer.valueOf(cVarArr12[1].f2012a), 1);
                map.put(Integer.valueOf(cVarArr12[2].f2012a), 2);
                map.put(Integer.valueOf(cVarArr12[3].f2012a), 3);
                map.put(Integer.valueOf(cVarArr12[4].f2012a), 7);
                map.put(Integer.valueOf(cVarArr12[5].f2012a), 8);
                X = Pattern.compile(".*[1-9].*");
                Y = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            R[i2] = new HashMap<>();
            S[i2] = new HashMap<>();
            for (c cVar : cVarArr11[i2]) {
                R[i2].put(Integer.valueOf(cVar.f2012a), cVar);
                S[i2].put(cVar.f2013b, cVar);
            }
            i2++;
        }
    }

    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        c[][] cVarArr = N;
        this.f1989d = new HashMap[cVarArr.length];
        this.f1990e = new HashSet(cVarArr.length);
        this.f1991f = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null");
        }
        this.f1986a = null;
        if (inputStream instanceof AssetManager.AssetInputStream) {
            this.f1987b = (AssetManager.AssetInputStream) inputStream;
        } else {
            this.f1987b = null;
        }
        t(inputStream);
    }

    private void A(int i2, int i3) throws Throwable {
        if (this.f1989d[i2].isEmpty() || this.f1989d[i3].isEmpty()) {
            return;
        }
        b bVar = this.f1989d[i2].get("ImageLength");
        b bVar2 = this.f1989d[i2].get("ImageWidth");
        b bVar3 = this.f1989d[i3].get("ImageLength");
        b bVar4 = this.f1989d[i3].get("ImageWidth");
        if (bVar == null || bVar2 == null || bVar3 == null || bVar4 == null) {
            return;
        }
        int i4 = bVar.i(this.f1991f);
        int i5 = bVar2.i(this.f1991f);
        int i6 = bVar3.i(this.f1991f);
        int i7 = bVar4.i(this.f1991f);
        if (i4 >= i6 || i5 >= i7) {
            return;
        }
        HashMap<String, b>[] mapArr = this.f1989d;
        HashMap<String, b> map = mapArr[i2];
        mapArr[i2] = mapArr[i3];
        mapArr[i3] = map;
    }

    private void B(a aVar, int i2) throws Throwable {
        b bVarF;
        b bVarF2;
        b bVar = this.f1989d[i2].get("DefaultCropSize");
        b bVar2 = this.f1989d[i2].get("SensorTopBorder");
        b bVar3 = this.f1989d[i2].get("SensorLeftBorder");
        b bVar4 = this.f1989d[i2].get("SensorBottomBorder");
        b bVar5 = this.f1989d[i2].get("SensorRightBorder");
        if (bVar == null) {
            if (bVar2 == null || bVar3 == null || bVar4 == null || bVar5 == null) {
                y(aVar, i2);
                return;
            }
            int i3 = bVar2.i(this.f1991f);
            int i4 = bVar4.i(this.f1991f);
            int i5 = bVar5.i(this.f1991f);
            int i6 = bVar3.i(this.f1991f);
            if (i4 <= i3 || i5 <= i6) {
                return;
            }
            b bVarF3 = b.f(i4 - i3, this.f1991f);
            b bVarF4 = b.f(i5 - i6, this.f1991f);
            this.f1989d[i2].put("ImageLength", bVarF3);
            this.f1989d[i2].put("ImageWidth", bVarF4);
            return;
        }
        if (bVar.f2009a == 5) {
            d[] dVarArr = (d[]) bVar.k(this.f1991f);
            if (dVarArr == null || dVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(dVarArr));
                return;
            }
            bVarF = b.d(dVarArr[0], this.f1991f);
            bVarF2 = b.d(dVarArr[1], this.f1991f);
        } else {
            int[] iArr = (int[]) bVar.k(this.f1991f);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            bVarF = b.f(iArr[0], this.f1991f);
            bVarF2 = b.f(iArr[1], this.f1991f);
        }
        this.f1989d[i2].put("ImageWidth", bVarF);
        this.f1989d[i2].put("ImageLength", bVarF2);
    }

    private void C(InputStream inputStream) throws Throwable {
        A(0, 5);
        A(0, 4);
        A(5, 4);
        b bVar = this.f1989d[1].get("PixelXDimension");
        b bVar2 = this.f1989d[1].get("PixelYDimension");
        if (bVar != null && bVar2 != null) {
            this.f1989d[0].put("ImageWidth", bVar);
            this.f1989d[0].put("ImageLength", bVar2);
        }
        if (this.f1989d[4].isEmpty() && s(this.f1989d[5])) {
            HashMap<String, b>[] mapArr = this.f1989d;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap<>();
        }
        if (s(this.f1989d[4])) {
            return;
        }
        Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
    }

    private void a() {
        String strC = c("DateTimeOriginal");
        if (strC != null && c("DateTime") == null) {
            this.f1989d[0].put("DateTime", b.a(strC));
        }
        if (c("ImageWidth") == null) {
            this.f1989d[0].put("ImageWidth", b.b(0L, this.f1991f));
        }
        if (c("ImageLength") == null) {
            this.f1989d[0].put("ImageLength", b.b(0L, this.f1991f));
        }
        if (c("Orientation") == null) {
            this.f1989d[0].put("Orientation", b.b(0L, this.f1991f));
        }
        if (c("LightSource") == null) {
            this.f1989d[1].put("LightSource", b.b(0L, this.f1991f));
        }
    }

    private static long[] b(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            jArr[i2] = iArr[i2];
        }
        return jArr;
    }

    @Nullable
    private b e(@NonNull String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i2 = 0; i2 < N.length; i2++) {
            b bVar = this.f1989d[i2].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0115, code lost:
    
        r10.d(r9.f1991f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011a, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f(androidx.exifinterface.media.ExifInterface.a r10, int r11, int r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.f(androidx.exifinterface.media.ExifInterface$a, int, int):void");
    }

    private int g(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (n(bArr)) {
            return 4;
        }
        if (p(bArr)) {
            return 9;
        }
        if (o(bArr)) {
            return 7;
        }
        return q(bArr) ? 10 : 0;
    }

    private void h(a aVar) throws Throwable {
        int i2;
        int i3;
        j(aVar);
        b bVar = this.f1989d[1].get("MakerNote");
        if (bVar != null) {
            a aVar2 = new a(bVar.f2011c);
            aVar2.d(this.f1991f);
            byte[] bArr = f1983x;
            byte[] bArr2 = new byte[bArr.length];
            aVar2.readFully(bArr2);
            aVar2.c(0L);
            byte[] bArr3 = f1984y;
            byte[] bArr4 = new byte[bArr3.length];
            aVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                aVar2.c(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                aVar2.c(12L);
            }
            x(aVar2, 6);
            b bVar2 = this.f1989d[7].get("PreviewImageStart");
            b bVar3 = this.f1989d[7].get("PreviewImageLength");
            if (bVar2 != null && bVar3 != null) {
                this.f1989d[5].put("JPEGInterchangeFormat", bVar2);
                this.f1989d[5].put("JPEGInterchangeFormatLength", bVar3);
            }
            b bVar4 = this.f1989d[8].get("AspectFrame");
            if (bVar4 != null) {
                int[] iArr = (int[]) bVar4.k(this.f1991f);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i4 = iArr[2];
                int i5 = iArr[0];
                if (i4 <= i5 || (i2 = iArr[3]) <= (i3 = iArr[1])) {
                    return;
                }
                int i6 = (i4 - i5) + 1;
                int i7 = (i2 - i3) + 1;
                if (i6 < i7) {
                    int i8 = i6 + i7;
                    i7 = i8 - i7;
                    i6 = i8 - i7;
                }
                b bVarF = b.f(i6, this.f1991f);
                b bVarF2 = b.f(i7, this.f1991f);
                this.f1989d[0].put("ImageWidth", bVarF);
                this.f1989d[0].put("ImageLength", bVarF2);
            }
        }
    }

    private void i(a aVar) throws IOException {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        f(aVar, i2, 5);
        aVar.c(i3);
        aVar.d(ByteOrder.BIG_ENDIAN);
        int i4 = aVar.readInt();
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = aVar.readUnsignedShort();
            int unsignedShort2 = aVar.readUnsignedShort();
            if (unsignedShort == I.f2012a) {
                short s2 = aVar.readShort();
                short s3 = aVar.readShort();
                b bVarF = b.f(s2, this.f1991f);
                b bVarF2 = b.f(s3, this.f1991f);
                this.f1989d[0].put("ImageLength", bVarF);
                this.f1989d[0].put("ImageWidth", bVarF2);
                return;
            }
            aVar.skipBytes(unsignedShort2);
        }
    }

    private void j(a aVar) throws Throwable {
        b bVar;
        u(aVar, aVar.available());
        x(aVar, 0);
        B(aVar, 0);
        B(aVar, 5);
        B(aVar, 4);
        C(aVar);
        if (this.f1988c != 8 || (bVar = this.f1989d[1].get("MakerNote")) == null) {
            return;
        }
        a aVar2 = new a(bVar.f2011c);
        aVar2.d(this.f1991f);
        aVar2.c(6L);
        x(aVar2, 9);
        b bVar2 = this.f1989d[9].get("ColorSpace");
        if (bVar2 != null) {
            this.f1989d[1].put("ColorSpace", bVar2);
        }
    }

    private void k(a aVar) throws Throwable {
        j(aVar);
        if (this.f1989d[0].get("JpgFromRaw") != null) {
            f(aVar, this.f2001p, 5);
        }
        b bVar = this.f1989d[0].get("ISO");
        b bVar2 = this.f1989d[1].get("PhotographicSensitivity");
        if (bVar == null || bVar2 != null) {
            return;
        }
        this.f1989d[1].put("PhotographicSensitivity", bVar);
    }

    private void l(a aVar, HashMap map) throws Throwable {
        int i2;
        b bVar = (b) map.get("JPEGInterchangeFormat");
        b bVar2 = (b) map.get("JPEGInterchangeFormatLength");
        if (bVar == null || bVar2 == null) {
            return;
        }
        int i3 = bVar.i(this.f1991f);
        int iMin = Math.min(bVar2.i(this.f1991f), aVar.available() - i3);
        int i4 = this.f1988c;
        if (i4 != 4 && i4 != 9 && i4 != 10) {
            if (i4 == 7) {
                i2 = this.f1998m;
            }
            if (i3 > 0 || iMin <= 0) {
            }
            this.f1992g = true;
            this.f1993h = i3;
            this.f1994i = iMin;
            if (this.f1986a == null && this.f1987b == null) {
                byte[] bArr = new byte[iMin];
                aVar.c(i3);
                aVar.readFully(bArr);
                this.f1995j = bArr;
                return;
            }
            return;
        }
        i2 = this.f1997l;
        i3 += i2;
        if (i3 > 0) {
        }
    }

    private void m(a aVar, HashMap map) throws IOException {
        b bVar = (b) map.get("StripOffsets");
        b bVar2 = (b) map.get("StripByteCounts");
        if (bVar == null || bVar2 == null) {
            return;
        }
        long[] jArrB = b(bVar.k(this.f1991f));
        long[] jArrB2 = b(bVar2.k(this.f1991f));
        if (jArrB == null) {
            Log.w("ExifInterface", "stripOffsets should not be null.");
            return;
        }
        if (jArrB2 == null) {
            Log.w("ExifInterface", "stripByteCounts should not be null.");
            return;
        }
        long j2 = 0;
        for (long j3 : jArrB2) {
            j2 += j3;
        }
        int i2 = (int) j2;
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < jArrB.length; i5++) {
            int i6 = (int) jArrB[i5];
            int i7 = (int) jArrB2[i5];
            int i8 = i6 - i3;
            if (i8 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
            }
            aVar.c(i8);
            int i9 = i3 + i8;
            byte[] bArr2 = new byte[i7];
            aVar.read(bArr2);
            i3 = i9 + i7;
            System.arraycopy(bArr2, 0, bArr, i4, i7);
            i4 += i7;
        }
        this.f1992g = true;
        this.f1995j = bArr;
        this.f1994i = i2;
    }

    private static boolean n(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f1982w;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private boolean o(byte[] bArr) throws IOException {
        a aVar = new a(bArr);
        ByteOrder byteOrderV = v(aVar);
        this.f1991f = byteOrderV;
        aVar.d(byteOrderV);
        short s2 = aVar.readShort();
        aVar.close();
        return s2 == 20306 || s2 == 21330;
    }

    private boolean p(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean q(byte[] bArr) throws IOException {
        a aVar = new a(bArr);
        ByteOrder byteOrderV = v(aVar);
        this.f1991f = byteOrderV;
        aVar.d(byteOrderV);
        short s2 = aVar.readShort();
        aVar.close();
        return s2 == 85;
    }

    private boolean r(HashMap map) throws Throwable {
        b bVar;
        b bVar2 = (b) map.get("BitsPerSample");
        if (bVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) bVar2.k(this.f1991f);
        int[] iArr2 = f1979t;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.f1988c != 3 || (bVar = (b) map.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int i2 = bVar.i(this.f1991f);
        return (i2 == 1 && Arrays.equals(iArr, f1981v)) || (i2 == 6 && Arrays.equals(iArr, iArr2));
    }

    private boolean s(HashMap map) throws IOException {
        b bVar = (b) map.get("ImageLength");
        b bVar2 = (b) map.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.i(this.f1991f) <= 512 && bVar2.i(this.f1991f) <= 512;
    }

    private void t(@NonNull InputStream inputStream) throws IOException {
        for (int i2 = 0; i2 < N.length; i2++) {
            try {
                try {
                    this.f1989d[i2] = new HashMap<>();
                } catch (IOException unused) {
                    this.f2002q = false;
                }
            } finally {
                a();
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.f1988c = g(bufferedInputStream);
        a aVar = new a(bufferedInputStream);
        switch (this.f1988c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                j(aVar);
                break;
            case 4:
                f(aVar, 0, 0);
                break;
            case 7:
                h(aVar);
                break;
            case 9:
                i(aVar);
                break;
            case 10:
                k(aVar);
                break;
        }
        z(aVar);
        this.f2002q = true;
    }

    private void u(a aVar, int i2) throws IOException {
        ByteOrder byteOrderV = v(aVar);
        this.f1991f = byteOrderV;
        aVar.d(byteOrderV);
        int unsignedShort = aVar.readUnsignedShort();
        int i3 = this.f1988c;
        if (i3 != 7 && i3 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i4 = aVar.readInt();
        if (i4 < 8 || i4 >= i2) {
            throw new IOException("Invalid first Ifd offset: " + i4);
        }
        int i5 = i4 - 8;
        if (i5 <= 0 || aVar.skipBytes(i5) == i5) {
            return;
        }
        throw new IOException("Couldn't jump to first Ifd: " + i5);
    }

    private ByteOrder v(a aVar) throws IOException {
        short s2 = aVar.readShort();
        if (s2 == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s2 == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s2));
    }

    private void w(byte[] bArr, int i2) throws IOException {
        a aVar = new a(bArr);
        u(aVar, bArr.length);
        x(aVar, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0230  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void x(androidx.exifinterface.media.ExifInterface.a r25, int r26) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 808
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.x(androidx.exifinterface.media.ExifInterface$a, int):void");
    }

    private void y(a aVar, int i2) throws IOException {
        b bVar;
        b bVar2 = this.f1989d[i2].get("ImageLength");
        b bVar3 = this.f1989d[i2].get("ImageWidth");
        if ((bVar2 == null || bVar3 == null) && (bVar = this.f1989d[i2].get("JPEGInterchangeFormat")) != null) {
            f(aVar, bVar.i(this.f1991f), i2);
        }
    }

    private void z(a aVar) throws Throwable {
        HashMap<String, b> map = this.f1989d[4];
        b bVar = map.get("Compression");
        if (bVar == null) {
            this.f1996k = 6;
            l(aVar, map);
            return;
        }
        int i2 = bVar.i(this.f1991f);
        this.f1996k = i2;
        if (i2 != 1) {
            if (i2 == 6) {
                l(aVar, map);
                return;
            } else if (i2 != 7) {
                return;
            }
        }
        if (r(map)) {
            m(aVar, map);
        }
    }

    @Nullable
    public String c(@NonNull String str) {
        b bVarE = e(str);
        if (bVarE != null) {
            if (!T.contains(str)) {
                return bVarE.j(this.f1991f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i2 = bVarE.f2009a;
                if (i2 != 5 && i2 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + bVarE.f2009a);
                    return null;
                }
                d[] dVarArr = (d[]) bVarE.k(this.f1991f);
                if (dVarArr != null && dVarArr.length == 3) {
                    d dVar = dVarArr[0];
                    d dVar2 = dVarArr[1];
                    d dVar3 = dVarArr[2];
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (dVar.f2016a / dVar.f2017b)), Integer.valueOf((int) (dVar2.f2016a / dVar2.f2017b)), Integer.valueOf((int) (dVar3.f2016a / dVar3.f2017b)));
                }
                Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(dVarArr));
                return null;
            }
            try {
                return Double.toString(bVarE.h(this.f1991f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int d(@NonNull String str, int i2) {
        b bVarE = e(str);
        if (bVarE == null) {
            return i2;
        }
        try {
            return bVarE.i(this.f1991f);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    private static class a extends InputStream implements DataInput {

        /* renamed from: i, reason: collision with root package name */
        private static final ByteOrder f2003i = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: j, reason: collision with root package name */
        private static final ByteOrder f2004j = ByteOrder.BIG_ENDIAN;

        /* renamed from: e, reason: collision with root package name */
        private DataInputStream f2005e;

        /* renamed from: f, reason: collision with root package name */
        private ByteOrder f2006f;

        /* renamed from: g, reason: collision with root package name */
        final int f2007g;

        /* renamed from: h, reason: collision with root package name */
        int f2008h;

        public a(InputStream inputStream) throws IOException {
            this.f2006f = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f2005e = dataInputStream;
            int iAvailable = dataInputStream.available();
            this.f2007g = iAvailable;
            this.f2008h = 0;
            this.f2005e.mark(iAvailable);
        }

        public int a() {
            return this.f2008h;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f2005e.available();
        }

        public long b() throws IOException {
            return readInt() & 4294967295L;
        }

        public void c(long j2) throws IOException {
            int i2 = this.f2008h;
            if (i2 > j2) {
                this.f2008h = 0;
                this.f2005e.reset();
                this.f2005e.mark(this.f2007g);
            } else {
                j2 -= i2;
            }
            int i3 = (int) j2;
            if (skipBytes(i3) != i3) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public void d(ByteOrder byteOrder) {
            this.f2006f = byteOrder;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.f2008h++;
            return this.f2005e.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.f2008h++;
            return this.f2005e.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i2 = this.f2008h + 1;
            this.f2008h = i2;
            if (i2 > this.f2007g) {
                throw new EOFException();
            }
            int i3 = this.f2005e.read();
            if (i3 >= 0) {
                return (byte) i3;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.f2008h += 2;
            return this.f2005e.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = this.f2008h + i3;
            this.f2008h = i4;
            if (i4 > this.f2007g) {
                throw new EOFException();
            }
            if (this.f2005e.read(bArr, i2, i3) != i3) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i2 = this.f2008h + 4;
            this.f2008h = i2;
            if (i2 > this.f2007g) {
                throw new EOFException();
            }
            int i3 = this.f2005e.read();
            int i4 = this.f2005e.read();
            int i5 = this.f2005e.read();
            int i6 = this.f2005e.read();
            if ((i3 | i4 | i5 | i6) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f2006f;
            if (byteOrder == f2003i) {
                return (i6 << 24) + (i5 << 16) + (i4 << 8) + i3;
            }
            if (byteOrder == f2004j) {
                return (i3 << 24) + (i4 << 16) + (i5 << 8) + i6;
            }
            throw new IOException("Invalid byte order: " + this.f2006f);
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i2 = this.f2008h + 8;
            this.f2008h = i2;
            if (i2 > this.f2007g) {
                throw new EOFException();
            }
            int i3 = this.f2005e.read();
            int i4 = this.f2005e.read();
            int i5 = this.f2005e.read();
            int i6 = this.f2005e.read();
            int i7 = this.f2005e.read();
            int i8 = this.f2005e.read();
            int i9 = this.f2005e.read();
            int i10 = this.f2005e.read();
            if ((i3 | i4 | i5 | i6 | i7 | i8 | i9 | i10) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f2006f;
            if (byteOrder == f2003i) {
                return (i10 << 56) + (i9 << 48) + (i8 << 40) + (i7 << 32) + (i6 << 24) + (i5 << 16) + (i4 << 8) + i3;
            }
            if (byteOrder == f2004j) {
                return (i3 << 56) + (i4 << 48) + (i5 << 40) + (i6 << 32) + (i7 << 24) + (i8 << 16) + (i9 << 8) + i10;
            }
            throw new IOException("Invalid byte order: " + this.f2006f);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i2 = this.f2008h + 2;
            this.f2008h = i2;
            if (i2 > this.f2007g) {
                throw new EOFException();
            }
            int i3 = this.f2005e.read();
            int i4 = this.f2005e.read();
            if ((i3 | i4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f2006f;
            if (byteOrder == f2003i) {
                return (short) ((i4 << 8) + i3);
            }
            if (byteOrder == f2004j) {
                return (short) ((i3 << 8) + i4);
            }
            throw new IOException("Invalid byte order: " + this.f2006f);
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.f2008h += 2;
            return this.f2005e.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.f2008h++;
            return this.f2005e.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i2 = this.f2008h + 2;
            this.f2008h = i2;
            if (i2 > this.f2007g) {
                throw new EOFException();
            }
            int i3 = this.f2005e.read();
            int i4 = this.f2005e.read();
            if ((i3 | i4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f2006f;
            if (byteOrder == f2003i) {
                return (i4 << 8) + i3;
            }
            if (byteOrder == f2004j) {
                return (i3 << 8) + i4;
            }
            throw new IOException("Invalid byte order: " + this.f2006f);
        }

        @Override // java.io.DataInput
        public int skipBytes(int i2) throws IOException {
            int iMin = Math.min(i2, this.f2007g - this.f2008h);
            int iSkipBytes = 0;
            while (iSkipBytes < iMin) {
                iSkipBytes += this.f2005e.skipBytes(iMin - iSkipBytes);
            }
            this.f2008h += iSkipBytes;
            return iSkipBytes;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = this.f2005e.read(bArr, i2, i3);
            this.f2008h += i4;
            return i4;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.f2008h + bArr.length;
            this.f2008h = length;
            if (length <= this.f2007g) {
                if (this.f2005e.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        public a(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f2012a;

        /* renamed from: b, reason: collision with root package name */
        public final String f2013b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2014c;

        /* renamed from: d, reason: collision with root package name */
        public final int f2015d;

        c(String str, int i2, int i3) {
            this.f2013b = str;
            this.f2012a = i2;
            this.f2014c = i3;
            this.f2015d = -1;
        }

        boolean a(int i2) {
            int i3;
            int i4 = this.f2014c;
            if (i4 == 7 || i2 == 7 || i4 == i2 || (i3 = this.f2015d) == i2) {
                return true;
            }
            if ((i4 == 4 || i3 == 4) && i2 == 3) {
                return true;
            }
            if ((i4 == 9 || i3 == 9) && i2 == 8) {
                return true;
            }
            return (i4 == 12 || i3 == 12) && i2 == 11;
        }

        c(String str, int i2, int i3, int i4) {
            this.f2013b = str;
            this.f2012a = i2;
            this.f2014c = i3;
            this.f2015d = i4;
        }
    }
}
