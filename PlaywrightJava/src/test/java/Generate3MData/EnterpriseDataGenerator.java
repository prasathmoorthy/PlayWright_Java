package Generate3MData;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EnterpriseDataGenerator {

    static final int TOTAL_RECORDS = 3_000_000;
    static final double DUPLICATE_RATE = 0.15; // heavy duplicates
    static Random random = new Random();

    static String[] firstNames = {"Robert","James","David","John","Michael","Priya","Arun","Lakshmi","Sophia","Daniel"};
    static String[] lastNames = {"Smith","Johnson","Williams","Brown","Jones","Kumar","Sharma","Patel","Lee","Wilson"};

    static String[] cities = {"Miami","Orlando","Dallas","Austin","New York","Los Angeles","Chicago","Houston","Tampa","Jacksonville"};
    static String[] states = {"FL","TX","NY","CA","IL"};

    static String[] emailDomains = {"@gmail.com","@yahoo.com","@outlook.com","@alaska.net",".net",".org"};

    static String[] poBoxFormats = {
            "PO Box 123",
            "P.O. Box 456",
            "Post Office Box 789",
            "POBOX 321",
            "P O Box 654",
            "PO Box",
            "PO Box ABC",
            "Box 123",
            "P.O.Box#987",
            "123 PO Box Lane"
    };

    static String[] currencyFormats = {
            "$1,234.56",
            "£1,234.56",
            "¬1.234,56",
            "123456.78",
            "¥123456",
            "$1.234,56",
            "1234.56",
            "¹12,34,56.78",
            "($1,234.56)",
            "$123.4567",
            "$9,999,999,999.99",
            "-$1,234.56",
            "$$1234.56",
            "¬1.234.",
            "$1, 234.56",
            "A$1,234.56",
            "CHF 1,234.50",
            "$~4.9",
            "IN9.00",
            "8.89$"
    };

    public static void main(String[] args) throws Exception {

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\\\\\\\12.5Automation\\\\\\\\dc.test\\\\\\\\test.data\\\\\\\\SOURCES\\\\\\\\AsciiD\\\\\\\\3M_Enterprise_3M_Data.csv"));

        writer.write("\"Account Number\",\"Name\",\"Company\",\"Street\",\"City\",\"State\",\"Zip\",\"Email\","
                + "\"Birth Date\",\"Favorites\",\"Standard Payment\",\"Payments\",\"Balance\","
                + "\"TimestampDate\",\"Time\",\"PO BOX\",\"Currency\",\"Phone number\",\"TimeFormat\"");
        writer.newLine();

        List<String> duplicatePool = new ArrayList<>();

        for (int i = 1; i <= TOTAL_RECORDS; i++) {

            String row;

            if (!duplicatePool.isEmpty() && random.nextDouble() < DUPLICATE_RATE) {
                row = duplicatePool.get(random.nextInt(duplicatePool.size()));
            } else {
                row = generateRow();
                duplicatePool.add(row);
            }

            writer.write(row);
            writer.newLine();

            if (i % 100000 == 0) {
                System.out.println("Generated: " + i);
            }
        }

        writer.close();
        System.out.println("3 Million records generated successfully!");
    }

    private static String generateRow() {

        long account = 100000000000L + random.nextInt(900000000);

        String name = randomElement(firstNames) + " " + randomElement(lastNames);

        String company = randomElement(lastNames) + " Corp";

        String street = random.nextBoolean()
                ? "PO Box " + random.nextInt(999999)
                : (100 + random.nextInt(9999)) + " Seventh Avenue";

        String city = randomElement(cities);
        String state = randomElement(states);

        String zip = random.nextBoolean() ? String.valueOf(10000 + random.nextInt(89999)) : "";

        String email = randomElement(firstNames).toLowerCase()
                + random.nextInt(999)
                + randomElement(emailDomains);

        LocalDate birth = LocalDate.of(1950,1,1).plusDays(random.nextInt(20000));

        String favorite = random.nextBoolean() ? "Travel" : "";

        // ✅ PURE NUMERIC DECIMAL VALUES
        double standardPaymentVal = Math.round((random.nextDouble() * 10000) * 100.0) / 100.0;
        double paymentsVal = Math.round((random.nextDouble() * 5000) * 100.0) / 100.0;
        double balanceVal = Math.round(((random.nextDouble() * 20000) - 10000) * 100.0) / 100.0;

        String standardPayment = String.format("%.2f", standardPaymentVal);
        String payments = String.format("%.2f", paymentsVal);
        String balance = String.format("%.2f", balanceVal);

        LocalDateTime timestamp = LocalDateTime.of(2000,1,1,0,0)
                .plusDays(random.nextInt(8000))
                .plusSeconds(random.nextInt(86400));

        DateTimeFormatter fullFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        String ts = timestamp.format(fullFormatter);
        String time = timestamp.format(timeFormatter);

        String poBox = randomElement(poBoxFormats);

        String currency = randomElement(currencyFormats);

        String phone = random.nextBoolean()
                ? "+91" + (6000000000L + random.nextInt(399999999))
                : "+1" + (2000000000L + random.nextInt(699999999));

        // Random empty values
        if (random.nextDouble() < 0.05) name = "";
        if (random.nextDouble() < 0.05) email = "";
        if (random.nextDouble() < 0.05) phone = "";

        return "\"" + account + "\","
                + "\"" + name + "\","
                + "\"" + company + "\","
                + "\"" + street + "\","
                + "\"" + city + "\","
                + "\"" + state + "\","
                + "\"" + zip + "\","
                + "\"" + email + "\","
                + "\"" + birth + "\","
                + "\"" + favorite + "\","
                + "\"" + standardPayment + "\","
                + "\"" + payments + "\","
                + "\"" + balance + "\","
                + "\"" + ts + "\","
                + "\"" + time + "\","
                + "\"" + poBox + "\","
                + "\"" + currency + "\","
                + "\"" + phone + "\","
                + "\"" + time + "\"";
    }


    private static String randomElement(String[] arr) {
        return arr[random.nextInt(arr.length)];
    }
}
