package com.khtn.hang.exercise2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhyml on 3/9/2018.
 */

public class Utils {
    public static final int REQUEST_CODE = 1;

    public static final int RESULT_TITLE = 222;
    public static final int RESULT_BACKGROUND = RESULT_TITLE + 1;

    public static final String INTENT_TITLE = "title";
    public static final String INTENT_COLOR = "color";
    public static final String INTENT_BACKGROUND = "background";

    public static List<Integer> getListImage() {
        List<Integer> imgArrayList = new ArrayList<>();
        imgArrayList.add(R.drawable.shutterstock_316465280_huge);
        imgArrayList.add(R.drawable.shutterstock_130125752_huge);
        imgArrayList.add(R.drawable.shutterstock_248651677_supersize);
        imgArrayList.add(R.drawable.shutterstock_280897220_huge);
        imgArrayList.add(R.drawable.shutterstock_390660301_huge);
        imgArrayList.add(R.drawable.shutterstock_333376544_huge);
        return imgArrayList;
    }
}
