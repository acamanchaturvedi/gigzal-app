package com.notabusiness.app.helper;

import java.util.Arrays;
import java.util.List;

public class GigzalUtils {

    public static List<Integer> getOffsetLimitFromRange(String range){
        String[] parts = range.split("-");
        int offset = Integer.parseInt(parts[0]);
        int end = Integer.parseInt(parts[1]);
        int limit = (end - offset) + 1;
        return Arrays.asList(offset, limit);
    }
}
