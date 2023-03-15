package models;

/**
 * Класс стран
 */
public enum Country {
    UNITED_KINGDOM,
    USA,
    GERMANY;

    /**
     * @return Названия стран
     */
    public static String names() {
        StringBuilder nameList = new StringBuilder();
        for (var forms : values()) {
            nameList.append(forms.name());
            nameList.append("\n");
        }
        return nameList.substring(0, nameList.length() - 1);
    }
}
