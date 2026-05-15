package GenerateEnterprise3MData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GenerateEnterprise3MData {

    static final int TOTAL_RECORDS = 3_000_000;
    static final double DUPLICATE_PERCENT = 0.05;

    static Random random = new Random();

    static String[] firstNames = {"Robert","John","Michael","David","William","James","Mary","Patricia","Linda","Jennifer","Ravi","Arun","Karthik","Suresh"};
    static String[] lastNames = {"Smith","Johnson","Brown","Williams","Jones","Miller","Davis","Wilson","Anderson","Thomas","Kumar","Reddy","Sharma"};

    static String[] usCities = {"Miami","Orlando","Tampa","Jacksonville","New York","Los Angeles","Chicago","Houston","Phoenix"};
    static String[] streets = {"Seventh Avenue","Main Street","Park Avenue","Sunset Blvd","Lake View Road","Ocean Drive"};

    static String[] emailDomains = {"gmail.com","yahoo.com","alaska.net","hotmail.com","outlook.com"};

    static String[] currencyFormats = {
            "$1,234.56","£1,234.56","¬1.234,56","123456.78","¥123456",
            "$1.234,56","1234.56","¹12,34,56.78","($1,234.56)",
            "$123.4567","$9,999,999,999.99","-$1,234.56","1234.56",
            "$$1234.56","¬1.234.","$1, 234.56","$1.234,56",
            "A$1,234.56","CHF 1’234.50","$~4.9","IN9.00","8.89$",""
    };

    static String[] poBoxFormats = {
            "PO Box 123","P.O. Box 456","Post Office Box 789","POBOX 321",
            "P O Box 654","PO Box","PO Box ABC","Box 123",
            "P.O.Box#987","123 PO Box Lane",""
    };

    static String[] phoneFormats = {
            "+1-305-555-1234","+1 212 555 7890","+91-9876543210","+91 9123456789",
            "9876543210","(305)555-1234","12345",""
    };

    public static void main(String[] args) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\\\12.5Automation\\\\dc.test\\\\test.data\\\\SOURCES\\\\AsciiD\\\\3Million_Enterprise_Data.csv"));

        writer.write("\"Account Number\",\"Name\",\"Company\",\"Street\",\"City\",\"State\",\"Zip\",\"Email\","
                + "\"Birth Date\",\"Favorites\",\"Standard Payment\",\"Payments\",\"Balance\","
                + "\"TimestampDate\",\"Time\",\"PO BOX\",\"Currency\",\"Phone number\",\"TimeFormat\"");
        writer.newLine();

        List<String> duplicates = new ArrayList<>();

        for (int i = 1; i <= TOTAL_RECORDS; i++) {

            String row = generateRow();
            writer.write(row);
            writer.newLine();

            if (random.nextDouble() < DUPLICATE_PERCENT) {
                duplicates.add(row);
            }

            if (i % 100000 == 0 && !duplicates.isEmpty()) {
                for (String d : duplicates) {
                    writer.write(d);
                    writer.newLine();
                }
                duplicates.clear();
                System.out.println("Generated: " + i);
            }
        }

        writer.close();
        System.out.println("Finished generating file.");
    }

    private static String generateRow() {

        long accountNumber = 100000000000L + (long)(random.nextDouble() * 900000000000L);

        String name = randomName();
        String company = name.split(" ")[1] + " Holdings";

        String street = randomStreet();
        String city = usCities[random.nextInt(usCities.length)];
        String state = "FL";
        String zip = String.valueOf(10000 + random.nextInt(90000));

        String email = randomEmail(name);
        String birthDate = LocalDate.of(1950,1,1).plusDays(random.nextInt(20000)).toString();

        String favorite = random.nextBoolean() ? "Travel" : "";

        double stdPayment = round(random.nextDouble() * 5000);
        double payments = round(random.nextDouble() * 3000);
        double balance = round(-10000 + random.nextDouble() * 20000);

        LocalDateTime ts = LocalDateTime.now().minusDays(random.nextInt(1000));

        String poBox = poBoxFormats[random.nextInt(poBoxFormats.length)];
        String currency = currencyFormats[random.nextInt(currencyFormats.length)];
        String phone = phoneFormats[random.nextInt(phoneFormats.length)];

        return quote(accountNumber) + ","
                + quote(name) + ","
                + quote(company) + ","
                + quote(street) + ","
                + quote(city) + ","
                + quote(state) + ","
                + quote(zip) + ","
                + quote(email) + ","
                + quote(birthDate) + ","
                + quote(favorite) + ","
                + quote(stdPayment) + ","
                + quote(payments) + ","
                + quote(balance) + ","
                + quote(ts.toLocalDate()) + ","
                + quote(ts.toLocalTime()) + ","
                + quote(poBox) + ","
                + quote(currency) + ","
                + quote(phone) + ","
                + quote(ts.format(DateTimeFormatter.ofPattern("hh:mm a")));
    }

    private static String randomName() {
        return firstNames[random.nextInt(firstNames.length)] + " " +
                lastNames[random.nextInt(lastNames.length)];
    }

    private static String randomStreet() {
        if (random.nextBoolean()) {
            return "PO Box " + (100000 + random.nextInt(900000));
        } else {
            return (100 + random.nextInt(9900)) + " " +
                    streets[random.nextInt(streets.length)];
        }
    }

    private static String randomEmail(String name) {
        String clean = name.toLowerCase().replace(" ", "");
        return clean + "@" + emailDomains[random.nextInt(emailDomains.length)];
    }

    private static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    private static String quote(Object value) {
        return "\"" + value + "\"";
    }
}
