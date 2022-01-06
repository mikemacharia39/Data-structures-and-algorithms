package leettests.string_manipulation;

import java.util.Arrays;

public class TestGorrilla {
    public static String[] sorted( String[] events ) {
        final java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
        final java.time.LocalDate now = java.time.LocalDate.of(2000, 1, 1);

        java.util.List<String> listOfEvents = new java.util.ArrayList<String>();
        for(String event: events) {
            java.util.Optional<java.time.LocalDate> date = findDateInLine(event, formatter);
            //if(!date.isPresent()) continue;

            java.time.Period yearsLeft = java.time.Period.between(date.get(),now);

            int dateIndex = event.indexOf(date.get().format(formatter));
            String title = event.substring(0, dateIndex).trim();
            StringBuilder sb = new StringBuilder();
            sb.append(yearsLeft.getYears()).append("years;");
            sb.append(yearsLeft.getMonths()).append("months;");
            sb.append(yearsLeft.getDays()).append("days;").append("-").append(title);

            listOfEvents.add(sb.toString());
        }
        listOfEvents.sort((String e1, String e2)->e1.compareTo(e2));

        return listOfEvents.toArray(new String[listOfEvents.size()]);
    }
    private static java.util.Optional<java.time.LocalDate> findDateInLine(String line,
                                                                          java.time.format.DateTimeFormatter formatter) {
        String regex = "\\d{1,2}-\\d{1,2}-\\d{4}";
        java.util.regex.Matcher m = java.util.regex.Pattern.compile(regex).matcher(line);
        if (m.find()) {
            java.time.LocalDate date = java.time.LocalDate.parse(m.group(), formatter);
            return java.util.Optional.of(date);
        }
        return java.util.Optional.empty();
    }

    public static void main(String[] args) {

        String[] events = {"The date is 30-12-1963", "We have celebrated new year, back to work 01-02-2020"};
        System.out.println(Arrays.toString(TestGorrilla.sorted(events)));
    }
}
