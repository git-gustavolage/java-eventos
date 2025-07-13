package support;

import java.time.LocalDate;
import java.time.LocalTime;

import exceptions.TimeParserException;

public class TimeParser {

    public static LocalDate parseDate(String dataStr) throws TimeParserException {
        //formato dd/mm/aaaa
        String regex = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
        try {
            return LocalDate.parse(dataStr);
        } catch (Exception e) {
            try {
                if (!dataStr.matches(regex)) {
                    throw new TimeParserException("Data inválida!");
                }
                String[] dataTratada = dataStr.split("/");
                return LocalDate.of(Integer.parseInt(dataTratada[2]), Integer.parseInt(dataTratada[1]), Integer.parseInt(dataTratada[0]));
            } catch (Exception ex) {
                System.err.println("Erro ao tratar data: " + ex.getMessage());
                throw new TimeParserException("Data inválida!");
            }
        }
    }

    public static LocalDate parseDateOrFail(String dataStr) {
        try {
            return parseDate(dataStr);
        } catch (TimeParserException e) {
            System.err.println("Erro ao tratar data: " + e.getMessage());
            return null;
        }
    }

    public static LocalTime parseTime(String horaStr) throws TimeParserException {
        String regex = "^[0-9]{2}:[0-9]{2}$";
        try {
            return LocalTime.parse(horaStr);
        } catch (Exception e) {
            try {
                if (!horaStr.matches(regex)) {
                    throw new TimeParserException("Hora inválida!");
                }
                String[] horaTratada = horaStr.split(":");
                return LocalTime.of(Integer.parseInt(horaTratada[0]), Integer.parseInt(horaTratada[1]));
            } catch (Exception ex) {
                System.err.println("Erro ao tratar hora: " + ex.getMessage());
                throw new TimeParserException("Hora inválida!");
            }
        }
    }

    public static LocalTime parseTimeOrFail(String horaStr) {
        try {
            return parseTime(horaStr);
        } catch (TimeParserException e) {
            return null;
        }
    }

}
