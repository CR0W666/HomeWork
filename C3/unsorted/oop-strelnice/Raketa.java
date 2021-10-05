class Raketa {

    int dolet, rozsah;
    String model;
    public Raketa(int dolet, int rozsah, String model) {
        this.dolet = dolet;
        this.rozsah = rozsah;
        this.model = model;
    }

    public void setDolet(int newDolet) {
        this.dolet = newDolet;
    }

    public void setRozsah(int newRozsah) {
        this.rozsah = newRozsah;
    }

    public int getSpec(String spec) {

        switch (spec) {
            case "dolet":
                return this.dolet;
                
            case "rozsah":
                return this.rozsah;
                
            default:
                System.err.print("error420: cant get value");
                return 420;
                
        }
    }

    public void vystrel() {
        try {
            

            System.out.print("\n");
            for(int i = 0; i < this.dolet; i++) {
                Thread.sleep(100);
                System.out.print("\r");
                for(int y = 0; y < i; y++) {
                    System.out.print(" ");
                }
                System.out.print(model);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}