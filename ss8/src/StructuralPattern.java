public class StructuralPattern {
    // Adapter & Facade

    // -- Adaptee (Hệ thống cũ)

    class OldCalculator{
        public int[] calculateRevenue(){
            System.out.println("OldCalculator: Tính toán doanh thu, trả về mảng int[]");
            return new int[]{100, 200, 300}; // Doanh thu các tháng
        }
    }

    class OldReporter{
        public void exportToTxt(int[] data, String fileName){
            System.out.println("OldReporter: Xuất dữ liệu ra file "+fileName+".txt");
            // code xuất file...
        }
    }

    // --- Target Interface (Hệ thống mới mong đợi) ---
    class ReportData{
        String format;
        String content;
        // constructor, getter, setter, ...
    }

    interface IModernReporter{
        ReportData generateReport(String reportType);
    }

    // Adapter Pattern
    class CalculateAdapter implements IModernReporter{
        private OldCalculator oldCalculator;

        public CalculateAdapter(OldCalculator oldCalculator){
            this.oldCalculator = oldCalculator;
        }

        @Override
        public ReportData generateReport(String reportType) {
            // 1. gọi phương thức cũ
            int[] oldData = oldCalculator.calculateRevenue();

            // 2. Chuyển đổi dữ liệu (int -> ReportData)
            ReportData data = new ReportData();
            StringBuilder sb = new StringBuilder();

            for (int num : oldData) {
                sb.append(num).append(", ");
            }
//            for (int i = 0; i < oldData.length; i++){
//                sb.append(oldData[i]).append(", ");
//            }

            data.content = sb.toString();
            data.format = "CSV-like";
            System.out.println("Adapter: Đã chuyển đổi dữ liệu từ int[] sang ReportData");



            return null;
        }
    }




}
