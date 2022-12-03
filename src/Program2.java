public class Program2 {
    public static void main(String[] args) {
        String myPhoneNumber = "052-8975647";
        System.out.println(phoneNumber(myPhoneNumber));
    }
    public static String phoneNumber(String userPhoneNumber) {
        String rightTemplate = "012-3456789";
        if (userPhoneNumber.startsWith("972") && userPhoneNumber.length() == rightTemplate.length() + 2) {
            userPhoneNumber=userPhoneNumber.substring(3);
            rightTemplate = userPhoneNumber.substring(0,3);
            rightTemplate += "-" + userPhoneNumber.substring(3, 10);
        } else {
            if (userPhoneNumber.length() == 10 && userPhoneNumber.startsWith("05")) {
                rightTemplate = userPhoneNumber.substring(0, 3);
                rightTemplate += "-" + userPhoneNumber.substring(3, 10);
            }else{
                if (userPhoneNumber.length()==11 && userPhoneNumber.contains("-")&&userPhoneNumber.startsWith("05")){
                    rightTemplate=userPhoneNumber;
                }else {
                    rightTemplate="";
                }
            }
        }
        return rightTemplate;
    }
}
