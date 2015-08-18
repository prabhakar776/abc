package com.instructure.canvas.util;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Sten Martinez
 * Date: 3/28/13
 * Time: 10:51 AM
 */
public class CanvasTimeZoneInfo {

    public static String getJavaTZ(String railsTimeZone) {
        return railsTimeZone;
        // Canvas is now using IANA timezones, so no need to translate
        //return _rails_to_java.get(railsTimeZone);
    }

    public static String getRailsTZ(String javaTimeZone) {
        return javaTimeZone;
        // Canvas is now using IANA timezones, so no need to translate
        // return _java_to_rails.get(javaTimeZone);
    }

    private static Map<String, String> _java_to_rails = new HashMap<String, String>();

    private static Map<String, String> _rails_to_java = new HashMap<String, String>();

    static {

        _rails_to_java.put("International Date Line West" , "Pacific/Midway");
        _rails_to_java.put("Midway Island"                , "Pacific/Midway");
        _rails_to_java.put("American Samoa"               , "Pacific/Pago_Pago");
        _rails_to_java.put("Hawaii"                       , "Pacific/Honolulu");
        _rails_to_java.put("Alaska"                       , "America/Juneau");
        _rails_to_java.put("Pacific Time (US & Canada)"   , "America/Los_Angeles");
        _rails_to_java.put("Tijuana"                      , "America/Tijuana");
        _rails_to_java.put("Mountain Time (US & Canada)"  , "America/Denver");
        _rails_to_java.put("Arizona"                      , "US/Arizona");
        _rails_to_java.put("Chihuahua"                    , "America/Chihuahua");
        _rails_to_java.put("Mazatlan"                     , "America/Mazatlan");
        _rails_to_java.put("Central Time (US & Canada)"   , "US/Central");
        _rails_to_java.put("Saskatchewan"                 , "America/Regina");
        _rails_to_java.put("Guadalajara"                  , "America/Mexico_City");
        _rails_to_java.put("Mexico City"                  , "America/Mexico_City");
        _rails_to_java.put("Monterrey"                    , "America/Monterrey");
        _rails_to_java.put("Central America"              , "America/Guatemala");
        _rails_to_java.put("Eastern Time (US & Canada)"   , "America/New_York");
        _rails_to_java.put("Indiana (East)"               , "America/Indiana/Indianapolis");
        _rails_to_java.put("Bogota"                       , "America/Bogota");
        _rails_to_java.put("Lima"                         , "America/Lima");
        _rails_to_java.put("Quito"                        , "America/Lima");
        _rails_to_java.put("Atlantic Time (Canada)"       , "America/Halifax");
        _rails_to_java.put("Caracas"                      , "America/Caracas");
        _rails_to_java.put("La Paz"                       , "America/La_Paz");
        _rails_to_java.put("Santiago"                     , "America/Santiago");
        _rails_to_java.put("Newfoundland"                 , "America/St_Johns");
        _rails_to_java.put("Brasilia"                     , "America/Sao_Paulo");
        _rails_to_java.put("Buenos Aires"                 , "America/Argentina/Buenos_Aires");
        _rails_to_java.put("Georgetown"                   , "America/Guyana");
        _rails_to_java.put("Greenland"                    , "America/Godthab");
        _rails_to_java.put("Mid-Atlantic"                 , "Atlantic/South_Georgia");
        _rails_to_java.put("Azores"                       , "Atlantic/Azores");
        _rails_to_java.put("Cape Verde Is."               , "Atlantic/Cape_Verde");
        _rails_to_java.put("Dublin"                       , "Europe/Dublin");
        _rails_to_java.put("Edinburgh"                    , "Europe/London");
        _rails_to_java.put("Lisbon"                       , "Europe/Lisbon");
        _rails_to_java.put("London"                       , "Europe/London");
        _rails_to_java.put("Casablanca"                   , "Africa/Casablanca");
        _rails_to_java.put("Monrovia"                     , "Africa/Monrovia");
        _rails_to_java.put("UTC"                          , "UTC");
        _rails_to_java.put("Belgrade"                     , "Europe/Belgrade");
        _rails_to_java.put("Bratislava"                   , "Europe/Bratislava");
        _rails_to_java.put("Budapest"                     , "Europe/Budapest");
        _rails_to_java.put("Ljubljana"                    , "Europe/Ljubljana");
        _rails_to_java.put("Prague"                       , "Europe/Prague");
        _rails_to_java.put("Sarajevo"                     , "Europe/Sarajevo");
        _rails_to_java.put("Skopje"                       , "Europe/Skopje");
        _rails_to_java.put("Warsaw"                       , "Europe/Warsaw");
        _rails_to_java.put("Zagreb"                       , "Europe/Zagreb");
        _rails_to_java.put("Brussels"                     , "Europe/Brussels");
        _rails_to_java.put("Copenhagen"                   , "Europe/Copenhagen");
        _rails_to_java.put("Madrid"                       , "Europe/Madrid");
        _rails_to_java.put("Paris"                        , "Europe/Paris");
        _rails_to_java.put("Amsterdam"                    , "Europe/Amsterdam");
        _rails_to_java.put("Berlin"                       , "Europe/Berlin");
        _rails_to_java.put("Bern"                         , "Europe/Berlin");
        _rails_to_java.put("Rome"                         , "Europe/Rome");
        _rails_to_java.put("Stockholm"                    , "Europe/Stockholm");
        _rails_to_java.put("Vienna"                       , "Europe/Vienna");
        _rails_to_java.put("West Central Africa"          , "Africa/Algiers");
        _rails_to_java.put("Bucharest"                    , "Europe/Bucharest");
        _rails_to_java.put("Cairo"                        , "Africa/Cairo");
        _rails_to_java.put("Helsinki"                     , "Europe/Helsinki");
        _rails_to_java.put("Kyiv"                         , "Europe/Kiev");
        _rails_to_java.put("Riga"                         , "Europe/Riga");
        _rails_to_java.put("Sofia"                        , "Europe/Sofia");
        _rails_to_java.put("Tallinn"                      , "Europe/Tallinn");
        _rails_to_java.put("Vilnius"                      , "Europe/Vilnius");
        _rails_to_java.put("Athens"                       , "Europe/Athens");
        _rails_to_java.put("Istanbul"                     , "Europe/Istanbul");
        _rails_to_java.put("Minsk"                        , "Europe/Minsk");
        _rails_to_java.put("Jerusalem"                    , "Asia/Jerusalem");
        _rails_to_java.put("Harare"                       , "Africa/Harare");
        _rails_to_java.put("Pretoria"                     , "Africa/Johannesburg");
        _rails_to_java.put("Moscow"                       , "Europe/Moscow");
        _rails_to_java.put("St. Petersburg"               , "Europe/Moscow");
        _rails_to_java.put("Volgograd"                    , "Europe/Moscow");
        _rails_to_java.put("Kuwait"                       , "Asia/Kuwait");
        _rails_to_java.put("Riyadh"                       , "Asia/Riyadh");
        _rails_to_java.put("Nairobi"                      , "Africa/Nairobi");
        _rails_to_java.put("Baghdad"                      , "Asia/Baghdad");
        _rails_to_java.put("Tehran"                       , "Asia/Tehran");
        _rails_to_java.put("Abu Dhabi"                    , "Asia/Muscat");
        _rails_to_java.put("Muscat"                       , "Asia/Muscat");
        _rails_to_java.put("Baku"                         , "Asia/Baku");
        _rails_to_java.put("Tbilisi"                      , "Asia/Tbilisi");
        _rails_to_java.put("Yerevan"                      , "Asia/Yerevan");
        _rails_to_java.put("Kabul"                        , "Asia/Kabul");
        _rails_to_java.put("Ekaterinburg"                 , "Asia/Yekaterinburg");
        _rails_to_java.put("Islamabad"                    , "Asia/Karachi");
        _rails_to_java.put("Karachi"                      , "Asia/Karachi");
        _rails_to_java.put("Tashkent"                     , "Asia/Tashkent");
        _rails_to_java.put("Chennai"                      , "Asia/Kolkata");
        _rails_to_java.put("Kolkata"                      , "Asia/Kolkata");
        _rails_to_java.put("Mumbai"                       , "Asia/Kolkata");
        _rails_to_java.put("New Delhi"                    , "Asia/Kolkata");
        _rails_to_java.put("Kathmandu"                    , "Asia/Kathmandu");
        _rails_to_java.put("Astana"                       , "Asia/Dhaka");
        _rails_to_java.put("Dhaka"                        , "Asia/Dhaka");
        _rails_to_java.put("Sri Jayawardenepura"          , "Asia/Colombo");
        _rails_to_java.put("Almaty"                       , "Asia/Almaty");
        _rails_to_java.put("Novosibirsk"                  , "Asia/Novosibirsk");
        _rails_to_java.put("Rangoon"                      , "Asia/Rangoon");
        _rails_to_java.put("Bangkok"                      , "Asia/Bangkok");
        _rails_to_java.put("Hanoi"                        , "Asia/Bangkok");
        _rails_to_java.put("Jakarta"                      , "Asia/Jakarta");
        _rails_to_java.put("Krasnoyarsk"                  , "Asia/Krasnoyarsk");
        _rails_to_java.put("Beijing"                      , "Asia/Shanghai");
        _rails_to_java.put("Chongqing"                    , "Asia/Chongqing");
        _rails_to_java.put("Hong Kong"                    , "Asia/Hong_Kong");
        _rails_to_java.put("Urumqi"                       , "Asia/Urumqi");
        _rails_to_java.put("Kuala Lumpur"                 , "Asia/Kuala_Lumpur");
        _rails_to_java.put("Singapore"                    , "Asia/Singapore");
        _rails_to_java.put("Taipei"                       , "Asia/Taipei");
        _rails_to_java.put("Perth"                        , "Australia/Perth");
        _rails_to_java.put("Irkutsk"                      , "Asia/Irkutsk");
        _rails_to_java.put("Ulaan Bataar"                 , "Asia/Ulaanbaatar");
        _rails_to_java.put("Seoul"                        , "Asia/Seoul");
        _rails_to_java.put("Osaka"                        , "Asia/Tokyo");
        _rails_to_java.put("Sapporo"                      , "Asia/Tokyo");
        _rails_to_java.put("Tokyo"                        , "Asia/Tokyo");
        _rails_to_java.put("Yakutsk"                      , "Asia/Yakutsk");
        _rails_to_java.put("Darwin"                       , "Australia/Darwin");
        _rails_to_java.put("Adelaide"                     , "Australia/Adelaide");
        _rails_to_java.put("Canberra"                     , "Australia/Melbourne");
        _rails_to_java.put("Melbourne"                    , "Australia/Melbourne");
        _rails_to_java.put("Sydney"                       , "Australia/Sydney");
        _rails_to_java.put("Brisbane"                     , "Australia/Brisbane");
        _rails_to_java.put("Hobart"                       , "Australia/Hobart");
        _rails_to_java.put("Vladivostok"                  , "Asia/Vladivostok");
        _rails_to_java.put("Guam"                         , "Pacific/Guam");
        _rails_to_java.put("Port Moresby"                 , "Pacific/Port_Moresby");
        _rails_to_java.put("Magadan"                      , "Asia/Magadan");
        _rails_to_java.put("Solomon Is."                  , "Asia/Magadan");
        _rails_to_java.put("New Caledonia"                , "Pacific/Noumea");
        _rails_to_java.put("Fiji"                         , "Pacific/Fiji");
        _rails_to_java.put("Kamchatka"                    , "Asia/Kamchatka");
        _rails_to_java.put("Marshall Is."                 , "Pacific/Majuro");
        _rails_to_java.put("Auckland"                     , "Pacific/Auckland");
        _rails_to_java.put("Wellington"                   , "Pacific/Auckland");
        _rails_to_java.put("Nuku'alofa"                   , "Pacific/Tongatapu");
        _rails_to_java.put("Tokelau Is."                  , "Pacific/Fakaofo");
        _rails_to_java.put("Samoa"                        , "Pacific/Apia");

        for ( Map.Entry<String, String> entry : _rails_to_java.entrySet()) {
            _java_to_rails.put(entry.getValue(), entry.getKey());
        }
    }

}
