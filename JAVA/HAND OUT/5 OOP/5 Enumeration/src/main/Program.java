package main;

public class Program {

	public static void main(String[] args) {

        /* Enumeration adalah sebuah tipe data special dimana kita bisa membatasi developer yang menggunakan class ini
        *  untuk memilih value dari field dalam multiple choice atau pilihan ganda.
        * */
        UserAccount anthony = new UserAccount("anthony", "jackal89", Privileges.MANAGER, Religion.CHRISTIAN, EmployementStatus.PER);
        System.out.println(anthony.getPrivilageLabel());
        System.out.println(anthony.getReligion().getLabelDalamIndonesia());
        System.out.println(anthony.getStatus().getLabel());
        System.out.println(anthony.getStatus().isEmployee());


        UserAccount budi = new UserAccount("Budi", "budi123", Privileges.MODERATOR, Religion.CATHOLIC, EmployementStatus.CAN, Gender.MALE);
        System.out.println(budi.getPrivilageLabel());
        System.out.println(budi.getReligion().getInisial());
        System.out.println(budi.getStatus().getLabel());
        System.out.println(budi.getStatus().isEmployee());
        System.out.println(budi.getGender());
        System.out.println(budi.getPrivilageLabel());
	}
}
