package ucak_bileti_fiyatı_hesaplama;

import java.util.Scanner;

public class ucak_bileti_fiyatı_hesaplama {

	public static void main(String[] args) {

		/*
		 * Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı,
		 * yolculuk tipi ise 1 veya 2) olmalıdır. Aksi takdirde kullanıcıya
		 * "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
		 */

		Scanner scan = new Scanner(System.in);

		System.out.print("Gideceğiniz mesafeyi KM cinsinden girin: ");
		int mesafe = scan.nextInt();

		if (mesafe <= 0) {
			System.out.println("Hatalı veri girdiniz.");
		}

		System.out.print("Yaşınızı giriniz: ");
		int yas = scan.nextInt();

		if (yas <= 0) {
			System.out.println("Hatalı veri girdiniz.");
		}

		System.out.print("Yolculuk tipini giriniz. Tek yön ise 1, gidiş-dönüş ise 2'yi tuşlayın: ");
		int tip = scan.nextInt();

		if (tip > 2 && tip < 1) {
			System.out.println("Hatalı veri girdiniz.");
		}

		/*
		 * Mesafe başına ücret 0,10 TL / km olarak alın. İlk olarak uçuşun toplam
		 * fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki
		 * indirimleri uygulayın
		 */

		double toplam = mesafe * 0.10;
		double yasindirimi = 0;
		double tipindirimi = 0;

		// Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.

		if (yas < 12) {
			yasindirimi = toplam * 0.50;
		}

		// Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.

		if (yas >= 12 && yas < 24) {
			yasindirimi = toplam * 0.10;
		}

		// Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.

		if (yas > 65) {
			yasindirimi = toplam * 0.30;
		}

		double indirimlifiyat = toplam - yasindirimi;

		// Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20
		// indirim uygulanır.

		if (tip == 2) {
			tipindirimi = indirimlifiyat * 0.20;
			double sontutar = (indirimlifiyat - tipindirimi) * 2;
			System.out.println("Toplam tutar: " + sontutar + " TL");
		} else {
			double sontutar = indirimlifiyat;
			System.out.println("Toplam tutar: " + sontutar + " TL");
		}

	}

}
