package Entities;

import java.util.InputMismatchException;
import java.util.Scanner;


public class PhanSo {
    private int mauSo;
    private int tuSo;

    //Ham constructor:
    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    // Ham constructor rong
    public PhanSo() {

    }

    public int getMauSo() {
        return mauSo;
    }

    public int getTuSo() {
        return tuSo;
    }

    public void nhapPhanSo() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập vào phân số format a/b: ");
            String ps = sc.nextLine();
            System.out.println("input từ user: " + ps);
            parseFromString(ps);
        } catch (Exception e) {
            if (e instanceof ArrayIndexOutOfBoundsException)
                System.out.println("Phân số không hợp lệ!");
            if (e instanceof NumberFormatException)
                System.out.println("Phân số không hợp lệ!");
        }

    }

    public void parseFromString(String str) {

        String[] arr = str.split("/");
        this.tuSo = Integer.parseInt(arr[0]);
        this.mauSo = Integer.parseInt(arr[1]);
        if (this.mauSo == 0)
            System.out.println("Phân số không hợp lệ!");
        return;

    }


    public void printPs() {
        System.out.format("%d/%d\n", this.tuSo, this.mauSo);

    }
}
