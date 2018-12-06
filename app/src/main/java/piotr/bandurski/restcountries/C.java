package piotr.bandurski.restcountries;

/**
 * Created by Piotr Bandurski  on 30/11/2018.
 */

public interface C {

    interface Api {
        String API_URL = "https://restcountries.eu/rest/v2/";
    }

    interface Data {
        Long EXPIRY_TIME = 16 * 60 * 60 * 1000L;
    }

    interface Parcerable {
        String RECYCLER_VIEW_POSSITION = "RECYCLER_VIEW_POSSITION";
    }
}
