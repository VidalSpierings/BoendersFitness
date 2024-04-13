package com.entecmedia.boendersfitness.models;

public abstract class DatabaseConstants {

    protected static final String DB_PATH = "https://boender-fitness-1686c-default-rtdb.europe-west1.firebasedatabase.app/.json";

    // DB Path

    /*

    * DB Tables

    */

    protected static final String DUTCH_LANGUAGE_TABLE = "Dutch";
    protected static final String ENGLISH_LANGUAGE_TABLE = "English";

    // language tables

    protected static final String EMAIL = "email";
    protected static final String PHONE_NUMBER = "phoneNumber";

    // contact value tables

    protected static final String ROZEMARIJNSTRAAT_TABLE = "rozemarijnstraatEstablishment";
    protected static final String STATIONSSTRAAT_ESTABLISHMENT = "stationsstraatEstablishment";

    // establishment specific-tables

    protected static final String OPENING_HOURS_TABLE = "openingHours";

    // tables with shared identifiers between establishments

    protected static final String MAIN_FRAGMENT_DESCRIPTION_TEXT = "mainScreenText";

    protected static final String MONDAY_TEXT = "monday";
    protected static final String TUESDAY_TEXT = "tuesday";
    protected static final String WEDNESDAY_TEXT = "wednesday";
    protected static final String THURSDAY_TEXT = "thursday";
    protected static final String FRIDAY_TEXT = "friday";
    protected static final String SATURDAY_TEXT = "saturday";
    protected static final String SUNDAY_TEXT = "sunday";

    // value tables with shared identifiers between establishments

    protected static final String SPECIAL_OPENING_HOURS = "specialOpeningHours";

    protected static final String NAMES = "names";

    protected static final String TIMES = "times";

    // tables with shared identifiers between languages

    protected static final String ASCENSION_DAY = "ascensionDay";
    protected static final String CARNIVAL = "carnival";
    protected static final String CHRISTMAS = "christmas";
    protected static final String DECEMBER24TH = "december24th";
    protected static final String DECEMBER5TH = "december5th";
    protected static final String EASTER = "ascensionDay";
    protected static final String LIBERATION_DAY = "liberationDay";
    protected static final String MONARCH_DAY = "monarchDay";
    protected static final String NEW_YEARS_DAY = "new_years_day";
    protected static final String NEW_YEARS_EVE = "new_years_eve";
    protected static final String PENTECOST = "pentecost";

    // value tables with shared identifiers between special opening hours table

}
