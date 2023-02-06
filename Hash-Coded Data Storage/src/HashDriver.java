public class HashDriver
{
    public static void main(String[] args)
    {
//        double percent = 100;
//        while (percent > 46)
//        {
//            double scalar1 = Math.random()*600;
//            double exponent = Math.random()*10;
//            Hashing hasher = new Hashing();
//            hasher.loadFile(scalar1, exponent);
////            hasher.printTable();
//            hasher.stats();
////        hasher.search();
//            System.out.print(scalar1 + " " + exponent);
//            percent = hasher.percent();
//        }
        Hashing hasher = new Hashing();
        hasher.loadFile();
        hasher.printTable();
        hasher.stats();
        hasher.search();
    }
}
//571: Id= 15460,Inv= 98 | Id= 16337,Inv= 20 | Id= 5970,Inv= 40 |