package vn.tphan.jhipster.neutron.models.utils;

import java.util.Random;

public class RandomStringGenerator {
    // function to generate a random string of length n
    private Random generator;

    public RandomStringGenerator() {
        this.generator = new Random();
    }

    public String getAlphaNumericString(int n)
    {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = generator.nextInt(AlphaNumericString.length());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                .charAt(index));
        }

        return sb.toString();
    }
}
