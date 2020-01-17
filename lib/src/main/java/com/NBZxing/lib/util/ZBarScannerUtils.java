package com.NBZxing.lib.util;

/***
 *  Created by SWY
 *  DATE 2019/7/8
 *
 */
public class ZBarScannerUtils {

//    private static ImageScanner mImageScanner = new ImageScanner();
//
//    private ZBarScannerUtils() {
//        mImageScanner = new ImageScanner();
//
//        mImageScanner.setConfig(0, Config.X_DENSITY, 3);
//        mImageScanner.setConfig(0, Config.Y_DENSITY, 3);
//        mImageScanner.setConfig(Symbol.NONE, Config.ENABLE, 0);
//
//        for (BarcodeFormat format : BarcodeFormat.ALL_FORMAT_LIST) {
//            mImageScanner.setConfig(format.getId(), Config.ENABLE, 1);
//        }
//
//    }
//
//    private static class Holder {
//        static ZBarScannerUtils INSTANCE = new ZBarScannerUtils();
//    }
//
//    public static ZBarScannerUtils getInstance() {
//        return Holder.INSTANCE;
//    }
//
//    public String scanImage(Image barcode) {
//
//        if (mImageScanner.scanImage(barcode) == 0) {
//            return null;
//        }
//
//        String symData = null;
//        for (Symbol symbol : mImageScanner.getResults()) {
//            // 未能识别的格式继续遍历
//            if (symbol.getType() == Symbol.NONE) {
//                continue;
//            }
//
//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
//                symData = new String(symbol.getDataBytes(), StandardCharsets.UTF_8);
//            } else {
//                symData = symbol.getData();
//            }
//            // 空数据继续遍历
//            if (!TextUtils.isEmpty(symData)) {
//                return symData;
//            }
//        }
//        return symData;
//    }
//
//    public static class BarcodeFormat {
//        private int mId;
//        private String mName;
//
//        public static final  BarcodeFormat NONE = new  BarcodeFormat(Symbol.NONE, "NONE");
//        public static final  BarcodeFormat PARTIAL = new  BarcodeFormat(Symbol.PARTIAL, "PARTIAL");
//        public static final  BarcodeFormat EAN8 = new  BarcodeFormat(Symbol.EAN8, "EAN8");
//        public static final  BarcodeFormat UPCE = new  BarcodeFormat(Symbol.UPCE, "UPCE");
//        public static final  BarcodeFormat ISBN10 = new  BarcodeFormat(Symbol.ISBN10, "ISBN10");
//        public static final  BarcodeFormat UPCA = new  BarcodeFormat(Symbol.UPCA, "UPCA");
//        public static final  BarcodeFormat EAN13 = new  BarcodeFormat(Symbol.EAN13, "EAN13");
//        public static final  BarcodeFormat ISBN13 = new  BarcodeFormat(Symbol.ISBN13, "ISBN13");
//        public static final  BarcodeFormat I25 = new  BarcodeFormat(Symbol.I25, "I25");
//        public static final  BarcodeFormat DATABAR = new  BarcodeFormat(Symbol.DATABAR, "DATABAR");
//        public static final  BarcodeFormat DATABAR_EXP = new  BarcodeFormat(Symbol.DATABAR_EXP, "DATABAR_EXP");
//        public static final  BarcodeFormat CODABAR = new  BarcodeFormat(Symbol.CODABAR, "CODABAR");
//        public static final  BarcodeFormat CODE39 = new  BarcodeFormat(Symbol.CODE39, "CODE39");
//        public static final  BarcodeFormat PDF417 = new  BarcodeFormat(Symbol.PDF417, "PDF417");
//        public static final  BarcodeFormat QRCODE = new  BarcodeFormat(Symbol.QRCODE, "QRCODE");
//        public static final  BarcodeFormat CODE93 = new  BarcodeFormat(Symbol.CODE93, "CODE93");
//        public static final  BarcodeFormat CODE128 = new  BarcodeFormat(Symbol.CODE128, "CODE128");
//
//        static final List< BarcodeFormat> ALL_FORMAT_LIST = new ArrayList<>();
//
//        static {
//            ALL_FORMAT_LIST.add( BarcodeFormat.PARTIAL);
//            ALL_FORMAT_LIST.add( BarcodeFormat.EAN8);
//            ALL_FORMAT_LIST.add( BarcodeFormat.UPCE);
////        ALL_FORMAT_LIST.add(BarcodeFormat.ISBN10);
//            ALL_FORMAT_LIST.add( BarcodeFormat.UPCA);
//            ALL_FORMAT_LIST.add( BarcodeFormat.EAN13);
//            ALL_FORMAT_LIST.add( BarcodeFormat.ISBN13);
//            ALL_FORMAT_LIST.add( BarcodeFormat.I25);
////        ALL_FORMAT_LIST.add(BarcodeFormat.DATABAR);
//            ALL_FORMAT_LIST.add( BarcodeFormat.DATABAR_EXP);
//            ALL_FORMAT_LIST.add( BarcodeFormat.CODABAR);
//            ALL_FORMAT_LIST.add( BarcodeFormat.CODE39);
//            ALL_FORMAT_LIST.add( BarcodeFormat.PDF417);
//            ALL_FORMAT_LIST.add( BarcodeFormat.QRCODE);
//            ALL_FORMAT_LIST.add( BarcodeFormat.CODE93);
//            ALL_FORMAT_LIST.add( BarcodeFormat.CODE128);
//        }
//
//        static final List< BarcodeFormat> ONE_DIMENSION_FORMAT_LIST = new ArrayList<>();
//
//        static {
//            ONE_DIMENSION_FORMAT_LIST.add( BarcodeFormat.PARTIAL);
//            ONE_DIMENSION_FORMAT_LIST.add( BarcodeFormat.EAN8);
//            ONE_DIMENSION_FORMAT_LIST.add( BarcodeFormat.UPCE);
////        ONE_DIMENSION_FORMAT_LIST.add(BarcodeFormat.ISBN10);
//            ONE_DIMENSION_FORMAT_LIST.add( BarcodeFormat.UPCA);
//            ONE_DIMENSION_FORMAT_LIST.add( BarcodeFormat.EAN13);
//            ONE_DIMENSION_FORMAT_LIST.add( BarcodeFormat.ISBN13);
//            ONE_DIMENSION_FORMAT_LIST.add( BarcodeFormat.I25);
////        ONE_DIMENSION_FORMAT_LIST.add(BarcodeFormat.DATABAR);
//            ONE_DIMENSION_FORMAT_LIST.add( BarcodeFormat.DATABAR_EXP);
//            ONE_DIMENSION_FORMAT_LIST.add( BarcodeFormat.CODABAR);
//            ONE_DIMENSION_FORMAT_LIST.add( BarcodeFormat.CODE39);
//            ONE_DIMENSION_FORMAT_LIST.add( BarcodeFormat.PDF417);
//            ONE_DIMENSION_FORMAT_LIST.add( BarcodeFormat.CODE93);
//            ONE_DIMENSION_FORMAT_LIST.add( BarcodeFormat.CODE128);
//        }
//
//        static final List< BarcodeFormat> TWO_DIMENSION_FORMAT_LIST = new ArrayList<>();
//
//        static {
//            TWO_DIMENSION_FORMAT_LIST.add( BarcodeFormat.PDF417);
//            TWO_DIMENSION_FORMAT_LIST.add( BarcodeFormat.QRCODE);
//        }
//
//        static final List< BarcodeFormat> HIGH_FREQUENCY_FORMAT_LIST = new ArrayList<>();
//
//        static {
//            HIGH_FREQUENCY_FORMAT_LIST.add( BarcodeFormat.QRCODE);
//            HIGH_FREQUENCY_FORMAT_LIST.add( BarcodeFormat.ISBN13);
//            HIGH_FREQUENCY_FORMAT_LIST.add( BarcodeFormat.UPCA);
//            HIGH_FREQUENCY_FORMAT_LIST.add( BarcodeFormat.EAN13);
//            HIGH_FREQUENCY_FORMAT_LIST.add( BarcodeFormat.CODE128);
//        }
//
//        private BarcodeFormat(int id, String name) {
//            mId = id;
//            mName = name;
//        }
//
//        public int getId() {
//            return mId;
//        }
//
//        public String getName() {
//            return mName;
//        }
//
//        public static  BarcodeFormat getFormatById(int id) {
//            for ( BarcodeFormat format : ALL_FORMAT_LIST) {
//                if (format.getId() == id) {
//                    return format;
//                }
//            }
//            return  BarcodeFormat.NONE;
//        }
//    }

}