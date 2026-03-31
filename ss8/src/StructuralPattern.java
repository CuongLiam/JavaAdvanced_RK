public class StructuralPattern {
    // Adapter & Facade

    // -- Adaptee (Hệ thống cũ)

    class OldCalculator{
        public int[] calculateRevenue(){
            System.out.println("OldCalculator: Tính toán doanh thu, trả về mảng int[]");
            return new int[]{100, 200, 300};
        }
    }




}
