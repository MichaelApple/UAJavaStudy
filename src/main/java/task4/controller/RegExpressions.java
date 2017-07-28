package task4.controller;

import java.util.HashMap;

/**
 * Created by Miha on 28.07.2017.
 */
public class RegExpressions {

    public static final String NAME = "^[A-z'-]{1,20}$";
    public static final String COMMENT = "^.*$";
    private static final String PHONE = "^\\([0-9]{3}\\) [0-9]{3}-[0-9]{2}-[0-9]{2}$";
    public static final String EMAIL = "^([A-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
    public static final String SKYPE = "[a-z0-9_-]{3,20}$";
    public static final String ZIP = "^[0-9]{5}(?:-[0-9]{4})?$";
    public static final String FLAT = "^[0-9]{1,3}[A-z]?$";
    public static final String BUILDING_NUMBER = "^[0-9]{1,3}[A-z]?$";

    private static final String GROUP = "^sport|entertainment|anonymous_alcoholic$";

    public final static HashMap<String, String> REG_EXPRSSION_MAP = new HashMap<>();

    static {
        REG_EXPRSSION_MAP.put("firstName", NAME);
        REG_EXPRSSION_MAP.put("secondName", NAME);
        REG_EXPRSSION_MAP.put("middleName", NAME);
        REG_EXPRSSION_MAP.put("nickName", NAME);
        REG_EXPRSSION_MAP.put("comment", COMMENT);
        REG_EXPRSSION_MAP.put("group", GROUP);
        REG_EXPRSSION_MAP.put("comment", COMMENT);
        REG_EXPRSSION_MAP.put("homePhone", PHONE);
        REG_EXPRSSION_MAP.put("mobilePhone1", PHONE);
        REG_EXPRSSION_MAP.put("mobilePhone2", "^.*$");
        REG_EXPRSSION_MAP.put("email", EMAIL);
        REG_EXPRSSION_MAP.put("skype", SKYPE);
        REG_EXPRSSION_MAP.put("zip", ZIP);
        REG_EXPRSSION_MAP.put("city", NAME);
        REG_EXPRSSION_MAP.put("street", NAME);
        REG_EXPRSSION_MAP.put("building", BUILDING_NUMBER);
        REG_EXPRSSION_MAP.put("flat", FLAT);

    }
}
