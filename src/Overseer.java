public class Overseer {

    public static void main(String[] args) {


//        for (int i = 0; i < 10; i++) {
            Inventory tester = new Inventory();
          for (int i = 0; i < 20; i++) {
                  tester.pickUp();
          }
            System.out.println(tester.getItemCategoryList().getQuantityItemCategories());
            System.out.println(tester.getItemCategoryList().getQuantityItems());
            System.out.println(tester);
            tester.dropLow();
            tester.dropLow();
            System.out.println(tester.getItemCategoryList().getQuantityItemCategories());
            System.out.println(tester.getItemCategoryList().getQuantityItems());
            System.out.println(tester);

//        }

    }



}