package banknotes;

class BankNotesOne {
    public static void main(String[] args) {
        System.out.println("total number: " + countNotes(6388));
    }

    public static int countNotes(int number) {
        int result = 0;
        int[] notes = new int[] {5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        int fit = 0;
        for (int note : notes) {
            fit = number / note;
            result += fit;
            number -= fit * note;
            if (fit != 0)
                System.out.println(note + " fits: " + fit + "x");
            fit = 0;
        }
        return result;
    }



}
