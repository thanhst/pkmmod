package com.sfyvctwaqbjhki.uwmpqfh.blfwuhtozemk;

import android.util.SparseIntArray;
import com.sfyvctwaqbjhki.uwmpqfh.R;
import com.sfyvctwaqbjhki.uwmpqfh.ovlfuarnk.PluginNXUfldNktBOT;

/* loaded from: classes.dex */
public class ErrorUtil {
    private static SparseIntArray codeSpArray;

    public static int getIdByCode(int i2) {
        if (codeSpArray == null) {
            regServerCodeFromRes();
        }
        return codeSpArray.get(i2, R.string.net_error_0);
    }

    private static void regServerCodeFromRes() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        codeSpArray = sparseIntArray;
        sparseIntArray.put(0, R.string.net_error_0);
        codeSpArray.put(1, R.string.net_error_001);
        codeSpArray.put(2, R.string.net_error_002);
        codeSpArray.put(3, R.string.net_error_003);
        codeSpArray.put(4, R.string.net_error_004);
        codeSpArray.put(5, R.string.net_error_005);
        codeSpArray.put(6, R.string.net_error_006);
        codeSpArray.put(7, R.string.net_error_007);
        codeSpArray.put(101, R.string.net_error_101);
        codeSpArray.put(102, R.string.net_error_102);
        codeSpArray.put(103, R.string.net_error_103);
        codeSpArray.put(105, R.string.net_error_105);
        codeSpArray.put(106, R.string.net_error_106);
        codeSpArray.put(107, R.string.net_error_107);
        codeSpArray.put(108, R.string.net_error_108);
        codeSpArray.put(115, R.string.net_error_115);
        codeSpArray.put(116, R.string.net_error_116);
        codeSpArray.put(118, R.string.net_error_118);
        codeSpArray.put(119, R.string.net_error_119);
        codeSpArray.put(200, R.string.net_error_200);
        codeSpArray.put(201, R.string.net_error_201);
        codeSpArray.put(202, R.string.net_error_202);
        codeSpArray.put(203, R.string.net_error_203);
        codeSpArray.put(204, R.string.net_error_204);
        codeSpArray.put(205, R.string.net_error_205);
        codeSpArray.put(206, R.string.net_error_206);
        codeSpArray.put(207, R.string.net_error_207);
        codeSpArray.put(209, R.string.net_error_209);
        codeSpArray.put(210, R.string.net_error_210);
        codeSpArray.put(222, R.string.net_error_222);
        codeSpArray.put(223, R.string.net_error_223);
        codeSpArray.put(224, R.string.net_error_224);
        codeSpArray.put(225, R.string.net_error_225);
        codeSpArray.put(226, R.string.net_error_226);
        codeSpArray.put(227, R.string.net_error_227);
        codeSpArray.put(228, R.string.net_error_228);
        codeSpArray.put(229, R.string.net_error_229);
        codeSpArray.put(230, R.string.net_error_230);
        codeSpArray.put(235, R.string.net_error_235);
        codeSpArray.put(236, R.string.net_error_236);
        codeSpArray.put(500, R.string.net_error_500);
        codeSpArray.put(501, R.string.net_error_501);
        codeSpArray.put(502, R.string.net_error_502);
        codeSpArray.put(503, R.string.net_error_503);
        codeSpArray.put(1001, R.string.net_error_1001);
        codeSpArray.put(1002, R.string.net_error_1002);
        codeSpArray.put(1003, R.string.net_error_1003);
        codeSpArray.put(1004, R.string.net_error_1004);
        codeSpArray.put(1005, R.string.net_error_1005);
        codeSpArray.put(1006, R.string.net_error_1006);
        codeSpArray.put(1007, R.string.net_error_1007);
        codeSpArray.put(1008, R.string.net_error_1008);
        codeSpArray.put(1009, R.string.net_error_1009);
        codeSpArray.put(1010, R.string.net_error_1010);
        codeSpArray.put(1011, R.string.net_error_1011);
        codeSpArray.put(1022, R.string.net_error_1022);
        codeSpArray.put(2001, R.string.net_error_2001);
        codeSpArray.put(PluginNXUfldNktBOT.ERROR_CONSUME_OR_PAY, R.string.net_error_2002);
        codeSpArray.put(2003, R.string.net_error_2003);
        codeSpArray.put(3000, R.string.net_error_3000);
        codeSpArray.put(3001, R.string.net_error_3001);
        codeSpArray.put(3002, R.string.net_error_3002);
        codeSpArray.put(3003, R.string.net_error_3003);
        codeSpArray.put(3004, R.string.net_error_3004);
        codeSpArray.put(3005, R.string.net_error_3005);
        codeSpArray.put(3006, R.string.net_error_3006);
        codeSpArray.put(3007, R.string.net_error_3007);
        codeSpArray.put(3008, R.string.net_error_3008);
        codeSpArray.put(3009, R.string.net_error_3009);
        codeSpArray.put(4000, R.string.net_error_4000);
        codeSpArray.put(4001, R.string.net_error_4001);
        codeSpArray.put(4002, R.string.net_error_4002);
        codeSpArray.put(4003, R.string.net_error_4003);
        codeSpArray.put(4004, R.string.net_error_4004);
        codeSpArray.put(5000, R.string.net_error_5000);
        codeSpArray.put(5001, R.string.net_error_5001);
        codeSpArray.put(5002, R.string.net_error_5002);
        codeSpArray.put(5003, R.string.net_error_5003);
        codeSpArray.put(5004, R.string.net_error_5004);
        codeSpArray.put(111111, R.string.net_error_111111);
    }
}
