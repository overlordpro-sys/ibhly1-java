public class HashDriver
{
    public static void main(String[] args)
    {
        Hashing hasher = new Hashing();
        hasher.loadFile();
        hasher.printTable();
        hasher.stats();
        hasher.search();
    }
}
