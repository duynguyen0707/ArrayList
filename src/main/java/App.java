import Entities.PhanSo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
// Xây dựng chương trình cho phép người dùng chọn
// các chức năng sau:
//– Nhập vào danh sách các phân số, sau đó cho phép
//– Xuất danh sách phân số
//– Thêm phân số
//– Xóa phân số tại vị trí thứ k
//– Cập nhật phân số tại vị trí thứ k
//– Tìm các phân số có giá trị lớn nhất
//– Xóa tất cả các phân số
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn muốn nhập bao nhiêu phân số: ");
        try {
            int n1 = sc.nextInt();
            System.out.println("Số phân số nhập từ bàn phím: " + n1);

            if (n1 <= 0) {
                System.out.println("Thông tin không chính xác");
                return;
            }
            //Tạo danh sách phân số
            ArrayList<PhanSo> list = new ArrayList<PhanSo>();
            for (int i = 0; i < n1; i++) {
                System.out.println("List size" + list.size());
                PhanSo ps = new PhanSo();
                System.out.println("Nhập vào phân số thứ " + (i + 1));
                ps.nhapPhanSo();
                System.out.println("Phân số đã nhập từ bàn phím: " + ps);
                list.add(ps);
                System.out.println("phân số nhập từ bàn phím" + list.get(i));
//                System.out.println("List size" + list.size());
//                list.get(i).printPs();
            }

//            for (int i = 0; i < listps.length; i++) {
//                System.out.println("Nhập vào phân số thứ " + (i + 1));
//                PhanSo ps = new PhanSo();
//                ps.nhapPhanSo();
//                listps[i] = ps;
//            }
            do {
                System.out.println("1. Xuất danh sach phân số");
                System.out.println("2. Thêm phân số");
                System.out.println("3. Xóa phân số");
                System.out.println("4. Cập nhật phân số");
                System.out.println("5. Tìm phân số có giá trị lớn nhất");
                System.out.println("6. Xóa phân số");
                System.out.println("0. Thoát");
                System.out.println("Nhập lựa chọn của bạn: ");
                int n = sc.nextInt();

                switch (n) {
                    case 1:
                        System.out.println("Danh sách phân số: ");
                        for (int i = 0; i < list.size(); i++) {
                            // In ra danh sách phân số
                            list.get(i).printPs();
                        }
                        break;

                    case 2:
                        System.out.println("Bạn muốn nhập thêm bao nhiêu phân số:");
                        int n3 = sc.nextInt();
                        for (int i = 0; i < n3; i++) {
                            PhanSo ps = new PhanSo();
                            ps.nhapPhanSo();
                            list.add(ps);
                        }
                        break;
                    case 3: // Xóa phân số
                        System.out.println("Bạn muốn xóa phân số thứ mấy trong mảng:");
                        int n4 = sc.nextInt();
                        if (n4 < list.size())
                            System.out.println("Thông tin không hợp lệ");
                        for (int i = 0; i < list.size(); i++) {
                            if (i == n4) {
                                list.remove(i);
                            }
                        }

                        break;
                    case 4: //Update phân số
                        System.out.println("Bạn muốn update phân số  thứ mấy trong mảng:");
                        int n5 = sc.nextInt();
                        if (n5 > list.size()) // out of list size
                            System.out.println("Thông tin không hợp lệ");
                        // chạy vòng lặp for để check đển phần tử cần update
                        for (int i = 0; i < list.size(); i++) {
                            if (i == n5) {
                                PhanSo ps = new PhanSo();
                                ps.nhapPhanSo();
                                list.set(i, ps);
                                list.get(i).printPs();
                            }
                        }
                        break;
                    case 5: // Tìm phân số lớn nhất
                        PhanSo max = new PhanSo();

                        for (int i = 1; i < list.size(); i++) {
                            // lấy phần tử thứ 1 làm số lớn nhất
                            max = list.get(0);
                            //quy đồng mẫu số
                            int c = max.getTuSo() * list.get(i).getMauSo();
                            int d = max.getMauSo() * list.get(i).getTuSo();
                            if (c < d) {
                                PhanSo tem = max;
                                PhanSo tem1 = list.get(i);
                                max = tem1;
                                tem1 = tem;

                            }

                        }
                        System.out.println("Phân số lớn nhất");
                        max.printPs();

                        break;
                    case 6:// xóa phân số
                        System.out.println("Bạn muốn xóa phần tử thứ mấy trong mảng");
                        int n6 = sc.nextInt();
                        System.out.println("Size ban đầu: " + list.size());
                        if (n6 > list.size())
                            System.out.println("Thông tin k hợp lệ");
                        for (int i = 0; i < list.size(); i++) {
                            if (i == n6) {
                                list.remove(i);
                            }

                        }
                        System.out.println("Size sau khi remove 1 phân số (phải giảm 1): " + list.size());
                        break;

                    case 0: // Exit
                        return;

                    default:
                        break;
                }

            } while (true);
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Thông tin không chính xác");
        }


    }
}
