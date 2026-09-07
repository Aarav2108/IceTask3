
package com.mycompany.icetask3;


public class OrderMessages {
     public static final int ITEM_NOT_NUMERIC   = 0;
    public static final int ITEM_TOO_LOW       = 1;
    public static final int ITEM_TOO_HIGH      = 2;
    public static final int QUANTITY_NOT_NUMERIC = 3;
    public static final int QUANTITY_TOO_LOW   = 4;
    public static final int QUANTITY_TOO_HIGH  = 5;
    public static final int ITEM_NOT_FOUND     = 6;
 
    public static final String[] MESSAGES =
    {
        "Item number is not numeric.",
        "Item number is too low -- it must be at least 0.",
        "Item number is too high -- it must be no more than 9999.",
        "Quantity is not numeric.",
        "Quantity is too low -- it must be at least 1.",
        "Quantity is too high -- it must be no more than 12.",
        "Item number does not correspond to any currently valid item."
    };
}
