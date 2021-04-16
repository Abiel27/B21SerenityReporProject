package b21.spartan_util;

import com.github.javafaker.Faker;

import java.util.LinkedHashMap;
import java.util.Map;

public class SpartanUtil {

    private static Faker faker = new Faker();

    /**
     * Used to get valid Map object to represent post body for POST /spartans Request
     * @return Map object with Random name , gender , phone(5_000_000_000L - 10_000_000_000L)
     */
    public static Map<String,Object> getRandomSpartanMap(){

        Map<String,Object> bodyMap = new LinkedHashMap<>();
        bodyMap.put("name", faker.name().firstName()   );
        bodyMap.put("gender", faker.demographic().sex()  );
        bodyMap.put("phone", faker.number().numberBetween(5_000_000_000L, 10_000_000_000L  ) ) ;

        return bodyMap ;
    }

}
