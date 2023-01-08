package main;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Program {

        public static void main(String[] args) {
                /*
                * Tipe data untuk menunjukan waktu waktu pada java berbagai macam, seperti Date, Calendar, Gregorian Calendar, dan lain-lain.
                * Sebagian dari tipe data ini sudah deprecated atau sudah usang dan tidak disarankan lagi, misalnya seperti Date.
                * Di sini kita akan menggunakan yang paling baik, main stream dan tidak deprecated.
                * */

                //LocalDate digunakan untuk me-record tanggalan. Bulan bisa diisi dengan menggunakan integer atau enum.
                LocalDate birthday = LocalDate.of(1988, Month.NOVEMBER, 27);
                LocalDate newYear = LocalDate.of(2001, 1, 1);

                //LocalTime digunakan untuk me-record kebutuhan jam, dimana setara dengan tipe data Time pada database.
                LocalTime deliveryTime = LocalTime.of(20, 37);
                LocalTime preciseTime = LocalTime.of(20, 37, 23, 200);

                //LocalDateTime adalah gabungan dari LocalDate dan LocalTime, dimana mencatat tanggal dan jam.
                LocalDateTime meetingTime = LocalDateTime.of(2018, Month.MAY, 21, 14, 30);
                LocalDateTime newYearDelivery = LocalDateTime.of(newYear, deliveryTime);

                //MonthDay digunakan utuk mencatat bulan dan tanggal saja.
                MonthDay hariValentine = MonthDay.of(2, 14);
                MonthDay hariKemerdekaan = MonthDay.of(Month.AUGUST, 17);

                //untuk memperoleh tanggal, jam atau waktu saat ini, kita bisa menggunakan method .now()
                System.out.println(LocalDate.now());
                System.out.println(LocalTime.now());
                System.out.println(LocalDateTime.now());
                System.out.println(MonthDay.now());

//                //Kalau kita mencoba print langsung tipe data penunjuk waktu, jadinya seperti ini.
//                System.out.println("Hari ulang tahun: " + birthday);
//                System.out.println("Delivery time: " + deliveryTime);
//                System.out.println("Precise time: " + preciseTime);
//
//                /* Kita akan melakukan formatting dengan menggunakan DateTimeFormatter yang berasal dari library java.time.formatter.
//                *  Format akan kita bentuk dengan menggunakan pattern ISO untuk tanggalan dan waktu:
//                *
//                *  d adalah tanggal:
//                *  d : 7, 12
//                *  dd : 07, 12
//                *
//                *  M adalah bulan:
//                *  M : 1
//                *  MM : 01
//                *  MMM : Jan
//                *  MMMM : January
//                *
//                *  y adalah tahun:
//                *  yy: 21
//                *  yyyy: 2021
//                *
//                *  H atau h adalah jam:
//                *  hh : 12 hour format 02
//                *  hh : 24 hour format 14
//                *
//                *  m: adalah menit
//                *  s: adalah detik
//                *
//                *  E adalah nama hari
//                *  E: Mon
//                *  EEEE: Monday
//                * */

                DateTimeFormatter europeanFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
                String hasilEUDate = europeanFormat.format(meetingTime);
                System.out.println(hasilEUDate);
//
//                //Local adalah class universal yang bisa digunakan untuk merubah format apapun ke dalam kebangsaannya.
//                //Disini kita akan menggunakan bahasa indonesia untuk hasil format tanggalan kita.
//                //untuk mencari language code dan country code dari ISO, silahkan browse: https://www.w3schools.com/tags/ref_language_codes.asp
                Locale indonesia = new Locale("id", "ID");
                DateTimeFormatter indoFormat = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm", indonesia);
                System.out.println(indoFormat.format(LocalDateTime.now()));
//
//                //DateTimeFormatter juga bisa membantu kita melakukan parsing dari string menjadi LocalDate, LocalTime, atau LocalDateTime
                String euDateString = "16/02/2017";
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(euDateString, format);
                System.out.println(date);
//
//                //Kita bisa menambahkan tahun, bulan, hari, jam dan lain sebagainya kepada variable waktu dengan menggunakan plus dan minus method.
                LocalDateTime deadline = LocalDateTime.of(2017, Month.MARCH, 13, 23, 59, 59);
                System.out.println("deadline "+deadline);
                deadline = deadline.plusMonths(1);
                System.out.println("deadline 2 "+deadline);
                deadline = deadline.plusDays(1);
                LocalTime actualDelivery = deliveryTime.plusMinutes(5);
                LocalTime earlyDelivery = deliveryTime.minusMinutes(5);
//
//                //Untuk melihat jarak antara 2 waktu, kita bisa mendapat pertolongan ChronoUnit, Period dan Duration
                LocalDate today = LocalDate.now();
                LocalDate tanggalLahir = LocalDate.of(1988, Month.NOVEMBER, 18);

                long daysPeriod = ChronoUnit.DAYS.between(tanggalLahir, today);
                System.out.println(daysPeriod + " days");
//
//                long monthsPeriod = ChronoUnit.MONTHS.between(tanggalLahir, today);
//                System.out.println(monthsPeriod + " months");
//
//                long yearsPeriod = ChronoUnit.YEARS.between(tanggalLahir, today);
//                System.out.println(yearsPeriod + " years");
//
//                /*
//                * Period adalah cara untuk mengukur waktu dari 2 tanggal, tetapi di dalam get months dan daysnya, nilai yang dikembalikan
//                * adalah left over dari periode 2 tanggalnya.
//                * */
                Period periode = Period.between(tanggalLahir, today);
                System.out.println("Periode tahun " + periode.getYears());
                System.out.println("Periode bulan " + periode.getMonths());
                System.out.println("Periode hari " + periode.getDays());
//
//                //Duration digunakan untuk mengukur durasi dari 2 time.
                LocalTime waktuBreakfast = LocalTime.of(8,30);
                LocalTime waktuLunch = LocalTime.of(12, 00);
                Duration durasi = Duration.between(waktuBreakfast, waktuLunch);
                System.out.println("Durasi detik " + durasi.getSeconds());
//
//                //Beberapa method yang bisa digunakan untuk membantu dalam peng-operasian tanggal adalah:
//
//                //Method yang menunjukan apakah sebuah tanggal sesudah atau sebelum, hasilnya berupa boolean true atau false.
//                tanggalLahir.isBefore(today);
//                tanggalLahir.isAfter(today);
//
//                //Method yang digunakan untuk mendapatkan tanggalan terakhir di dalam satu tanggalan.
                System.out.println(LocalDate.now().minusMonths(0).lengthOfMonth());
                System.out.println(LocalDate.now().minusMonths(1).lengthOfMonth());
//
//                //Method yang digunakan untuk menentukan apakah ini tahun kabisat atau bukan
                System.out.println(tanggalLahir);
                System.out.println(tanggalLahir.isLeapYear());
                System.out.println(LocalDate.now().isLeapYear());
        }




}
