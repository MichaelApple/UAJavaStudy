package notebook.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Miha on 28.07.2017.
 */
public class RegExpressions {

    private static final String NAME = "^[A-z'-]{1,20}$";
    private static final String COMMENT = "^.*$";
    private static final String PHONE = "^\\([0-9]{3}\\)[0-9]{3}-[0-9]{2}-[0-9]{2}$";
    private static final String EMAIL = "^([A-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
    private static final String SKYPE = "[a-z0-9_-]{3,20}$";
    private static final String ZIP = "^[0-9]{5}(?:-[0-9]{4})?$";
    private static final String FLAT = "^[0-9]{1,3}[A-z]?$";
    private static final String BUILDING_NUMBER = "^[0-9]{1,3}[A-z]?$";

    private static final String GROUP = "^sport|entertainment|anonymous_alcoholic$";

    final static HashMap<String, String> REG_EXPRSSION_MAP = new LinkedHashMap<>();

    static {
        REG_EXPRSSION_MAP.put("firstName", NAME);
        REG_EXPRSSION_MAP.put("lastName", NAME);
        REG_EXPRSSION_MAP.put("middleName", NAME);
        REG_EXPRSSION_MAP.put("nickName", NAME);
        REG_EXPRSSION_MAP.put("comment", COMMENT);
        REG_EXPRSSION_MAP.put("group", GROUP);
        REG_EXPRSSION_MAP.put("comment", COMMENT);
        REG_EXPRSSION_MAP.put("homePhone", PHONE);
        REG_EXPRSSION_MAP.put("cellPhonel", PHONE);
        REG_EXPRSSION_MAP.put("cellPhone2", "^.*$");
        REG_EXPRSSION_MAP.put("email", EMAIL);
        REG_EXPRSSION_MAP.put("skype", SKYPE);
        REG_EXPRSSION_MAP.put("zip", ZIP);
        REG_EXPRSSION_MAP.put("city", NAME);
        REG_EXPRSSION_MAP.put("street", NAME);
        REG_EXPRSSION_MAP.put("buildingNumber", BUILDING_NUMBER);
        REG_EXPRSSION_MAP.put("flat", FLAT);

    }
}
