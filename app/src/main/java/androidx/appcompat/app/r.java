package androidx.appcompat.app;

/* compiled from: TwilightCalculator.java */
/* loaded from: classes.dex */
class r {

    /* renamed from: d, reason: collision with root package name */
    private static r f286d;

    /* renamed from: a, reason: collision with root package name */
    public long f287a;

    /* renamed from: b, reason: collision with root package name */
    public long f288b;

    /* renamed from: c, reason: collision with root package name */
    public int f289c;

    r() {
    }

    static r b() {
        if (f286d == null) {
            f286d = new r();
        }
        return f286d;
    }

    public void a(long j2, double d2, double d3) {
        float f2 = (j2 - 946728000000L) / 8.64E7f;
        double d4 = (0.01720197f * f2) + 6.24006f;
        double dSin = Math.sin(d4) * 0.03341960161924362d;
        Double.isNaN(d4);
        double dSin2 = dSin + d4 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        Double.isNaN(f2 - 9.0E-4f);
        double dRound = Math.round(r11 - r9) + 9.0E-4f;
        Double.isNaN(dRound);
        double dSin3 = dRound + ((-d3) / 360.0d) + (Math.sin(d4) * 0.0053d) + (Math.sin(2.0d * dSin2) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin2) * Math.sin(0.4092797040939331d));
        double d5 = 0.01745329238474369d * d2;
        double dSin4 = (Math.sin(-0.10471975803375244d) - (Math.sin(d5) * Math.sin(dAsin))) / (Math.cos(d5) * Math.cos(dAsin));
        if (dSin4 >= 1.0d) {
            this.f289c = 1;
            this.f287a = -1L;
            this.f288b = -1L;
            return;
        }
        if (dSin4 <= -1.0d) {
            this.f289c = 0;
            this.f287a = -1L;
            this.f288b = -1L;
            return;
        }
        double dAcos = (float) (Math.acos(dSin4) / 6.283185307179586d);
        Double.isNaN(dAcos);
        this.f287a = Math.round((dSin3 + dAcos) * 8.64E7d) + 946728000000L;
        Double.isNaN(dAcos);
        long jRound = Math.round((dSin3 - dAcos) * 8.64E7d) + 946728000000L;
        this.f288b = jRound;
        if (jRound >= j2 || this.f287a <= j2) {
            this.f289c = 1;
        } else {
            this.f289c = 0;
        }
    }
}
