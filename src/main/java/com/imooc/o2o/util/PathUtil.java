package com.imooc.o2o.util;

public class PathUtil {

    private static String seperator = System.getProperty("file.seperator");

    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "G:/Java/o2oImg";
        } else {
            basePath = "G:/Java/o2oImg";
        }
        //basePath = basePath.replace("/", seperator);
        return basePath;
    }

    public static String getShopImagePath(long shopId) {
        String imagePath = "upload/item/shop/" + shopId + "/";
        //String test = imagePath.replace("/", seperator);
        //System.out.println(test);

        return imagePath;
    }
}
