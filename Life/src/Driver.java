
public class Driver {

	public static void main(String[] args) {
		Life life = new Life("life100.txt");
		life.output();
		for (int i = 1; i <= 5; i++) {
			System.out.println("--------------------------------------");
			life.nextGeneration();
			life.output();
		}
		System.out.println("\nNumber in Row 10 ---> " + life.countRow(10));
		System.out.println("\nNumber in Column 10 ---> " + life.countCol(10));
		System.out.println("\nNumber of living organisms ---> " + life.countLiving());
	}
}
